package com.mysticsbiomes.common.worldgen.feature.tree;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.worldgen.feature.config.MysticTreeConfiguration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.TreeFeature;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplate;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.shapes.BitSetDiscreteVoxelShape;
import net.minecraft.world.phys.shapes.DiscreteVoxelShape;

import java.util.Iterator;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.function.BiConsumer;

public abstract class MysticTreeFeature extends Feature<MysticTreeConfiguration> {

    public MysticTreeFeature(Codec<MysticTreeConfiguration> codec) {
        super(codec);
    }

    public abstract boolean placeTree(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, MysticTreeConfiguration config);

    @Override
    public boolean place(FeaturePlaceContext<MysticTreeConfiguration> context) {
        final WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos initialPos = context.origin();
        MysticTreeConfiguration config = context.config();

        Set<BlockPos> trunkPositions = Sets.newHashSet();
        Set<BlockPos> branchPositions = Sets.newHashSet();
        final Set<BlockPos> foliagePositions = Sets.newHashSet();
        Set<BlockPos> decoratorPositions = Sets.newHashSet();

        BiConsumer<BlockPos, BlockState> trunkSetter = setter(level, trunkPositions);
        BiConsumer<BlockPos, BlockState> branchSetter = setter(level, branchPositions);
        BiConsumer<BlockPos, BlockState> foliageSetter = setter(level, foliagePositions);
        BiConsumer<BlockPos, BlockState> decoratorSetter = setter(level, decoratorPositions);

        boolean flag = this.doPlace(level, random, initialPos, trunkSetter, branchSetter, foliageSetter, config);
        if (flag && (!branchPositions.isEmpty() || !foliagePositions.isEmpty())) {
            if (!config.decorators.isEmpty()) {
                config.decorators.forEach((decorator) -> decorator.place(new TreeDecorator.Context(level, decoratorSetter, random, branchPositions, foliagePositions, trunkPositions)));
            }
            return BoundingBox.encapsulatingPositions(Iterables.concat(trunkPositions, branchPositions, foliagePositions, decoratorPositions)).map((box) -> {
                StructureTemplate.updateShapeAtEdge(level, 3, updateLeaves(level, box, branchPositions, decoratorPositions, trunkPositions), box.minX(), box.minY(), box.minZ());
                return true;
            }).orElse(false);
        } else {
            return false;
        }
    }

    private static BiConsumer<BlockPos, BlockState> setter(LevelAccessor level, Set<BlockPos> set) {
        return (pos, state) -> {
            set.add(pos.immutable());
            level.setBlock(pos, state, 19);
        };
    }

    private boolean doPlace(WorldGenLevel level, RandomSource random, BlockPos initialPos, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> branchSetter, BiConsumer<BlockPos, BlockState> foliageSetter, MysticTreeConfiguration config) {
        int trunkHeight = config.trunkShape.getTrunkHeight(random);
        int y = initialPos.getY();
        if (y >= level.getMinBuildHeight() + 1 && y + trunkHeight + 1 <= level.getMaxBuildHeight()) {
            if (this.getMaxFreeTreeHeight(level, initialPos, trunkHeight, config) >= trunkHeight) {
                return this.placeTree(level, random, initialPos, trunkSetter, branchSetter, foliageSetter, config);
            }
            return false;
        }
        return false;
    }

    private int getMaxFreeTreeHeight(LevelSimulatedReader level, BlockPos initialPos, int trunkHeight, MysticTreeConfiguration config) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int y = 0; y <= trunkHeight + 1; y++) {
            int radius = config.minimumSize.getSizeAtHeight(trunkHeight, y);

            for (int dx = -radius; dx <= radius; dx++) {
                for (int dz = -radius; dz <= radius; dz++) {
                    mutablePos.setWithOffset(initialPos, dx, y, dz);
                    if (!(TreeFeature.validTreePos(level, mutablePos) || level.isStateAtPosition(mutablePos, state -> state.is(BlockTags.LOGS)))) {
                        return y - 2;
                    }
                }
            }
        }
        return trunkHeight;
    }

    private static DiscreteVoxelShape updateLeaves(LevelAccessor level, BoundingBox box, Set<BlockPos> logs, Set<BlockPos> leaves, Set<BlockPos> persistentLeaves) {
        DiscreteVoxelShape shape = new BitSetDiscreteVoxelShape(box.getXSpan(), box.getYSpan(), box.getZSpan());
        List<Set<BlockPos>> list = Lists.newArrayList();

        for (int i = 0; i < 7; i++) {
            list.add(Sets.newHashSet());
        }

        for (BlockPos pos : Lists.newArrayList(Sets.union(leaves, persistentLeaves))) {
            if (box.isInside(pos)) {
                shape.fill(pos.getX() - box.minX(), pos.getY() - box.minY(), pos.getZ() - box.minZ());
            }
        }

        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        int currentDistance = 0;
        list.get(0).addAll(logs);

        while (true) {
            while (currentDistance >= 7 || !list.get(currentDistance).isEmpty()) {
                if (currentDistance >= 7) return shape;

                Iterator<BlockPos> iterator = list.get(currentDistance).iterator();
                BlockPos currentPos = iterator.next();
                iterator.remove();

                if (box.isInside(currentPos)) {
                    if (currentDistance != 0) {
                        BlockState state = level.getBlockState(currentPos);
                        level.setBlock(currentPos, state.setValue(BlockStateProperties.DISTANCE, 1), 19);
                    }

                    shape.fill(currentPos.getX() - box.minX(), currentPos.getY() - box.minY(), currentPos.getZ() - box.minZ());

                    for (Direction direction : Direction.values()) {
                        mutablePos.setWithOffset(currentPos, direction);
                        if (box.isInside(mutablePos)) {
                            int dx = mutablePos.getX() - box.minX();
                            int dy = mutablePos.getY() - box.minY();
                            int dz = mutablePos.getZ() - box.minZ();

                            if (!shape.isFull(dx, dy, dz)) {
                                OptionalInt distance = LeavesBlock.getOptionalDistanceAt(level.getBlockState(mutablePos));
                                if (distance.isPresent()) {
                                    int nextDistance = Math.min(distance.getAsInt(), currentDistance + 1);
                                    if (nextDistance < 7) {
                                        list.get(nextDistance).add(mutablePos.immutable());
                                        currentDistance = Math.min(currentDistance, nextDistance);
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ++currentDistance;
        }
    }

    protected static void setDirtAt(LevelSimulatedReader level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> trunkSetter) {
        if (!level.isStateAtPosition(pos, state -> Feature.isDirt(state) && !state.is(Blocks.GRASS_BLOCK) && !state.is(Blocks.MYCELIUM))) {
            trunkSetter.accept(pos, config.dirtProvider.getState(random, pos));
        }
    }

    protected void placeLogWithSurroundingLeaves(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, Direction.Axis axis, BiConsumer<BlockPos, BlockState> trunkSetter, BiConsumer<BlockPos, BlockState> foliageSetter, int foliageRadius) {
        this.placeLog(level, random, pos, config, axis, trunkSetter);
        this.placeLeaves(level, random, pos.above(), config, foliageSetter);
        this.placeLeaves(level, random, pos.above().above(), config, foliageSetter);
        if (random.nextBoolean()) this.placeLeaves(level, random, pos.below(), config, foliageSetter);

        for (Direction direction : Direction.Plane.HORIZONTAL) {
            BlockPos relativePos = pos.relative(direction);
            this.placeLeavesRow(level, random, relativePos, config, foliageSetter, foliageRadius);
            this.placeLeaves(level, random, relativePos.above(), config, foliageSetter);
            if (random.nextBoolean()) this.placeLeaves(level, random, relativePos.relative(random.nextBoolean() ? direction.getClockWise() : direction.getCounterClockWise()), config, foliageSetter);
        }
    }

    protected void placeLog(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, Direction.Axis axis, BiConsumer<BlockPos, BlockState> trunkSetter) {
        if (TreeFeature.validTreePos(level, pos)) {
            trunkSetter.accept(pos, config.trunkProvider.getState(random, pos).setValue(RotatedPillarBlock.AXIS, axis));
        }
    }

    /**
     * @param doubleTrunk determines if the branchPos should be offset on a double sized trunk.
     * branches on large trunks will be randomly placed on the left/right side of each side of the trunk.
     */
    protected BlockPos getBranchPos(BlockPos branchPos, Direction direction, RandomSource random, boolean doubleTrunk) {
        if (doubleTrunk) {
            return switch (direction) {
                case NORTH -> random.nextBoolean() ? branchPos.east() : branchPos;
                case EAST -> random.nextBoolean() ? branchPos.east().south() : branchPos.east();
                case SOUTH -> random.nextBoolean() ? branchPos.south().east() : branchPos.south();
                case WEST -> random.nextBoolean() ? branchPos.south() : branchPos;
                default -> branchPos;
            };
        } else {
            return branchPos;
        }
    }

    protected boolean canPlaceBranch(LevelAccessor level, BlockPos branchPos, Direction direction, int checkHeight) {
        for (int y = -checkHeight; y <= checkHeight; y++) {
            if (!level.isEmptyBlock(branchPos.relative(direction).above(y))) {
                return false;
            }
        }
        return true;
    }

    protected boolean canGenerateBranch(LevelAccessor level, BlockPos branchPos, Direction direction, int branchLength) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        for (int i = 0; i <= branchLength; i++) {
            mutablePos.set(branchPos).move(direction, 1);
            if (!TreeFeature.isAirOrLeaves(level, mutablePos)) return false;
        }
        return true;
    }

    protected void placeLeafShape(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, Direction direction, BiConsumer<BlockPos, BlockState> foliageSetter) {
        for (Direction directions : Direction.Plane.HORIZONTAL) {
            BlockPos relativePos = pos.relative(directions);
            this.placeLeaves(level, random, relativePos, config, foliageSetter);
            this.placeLeaves(level, random, pos.above(), config, foliageSetter);
            this.placeLeaves(level, random, pos.relative(direction).above(), config, foliageSetter);
        }

        Direction flag = direction.getClockWise();
        this.placeLeaves(level, random, pos.relative(flag).above(), config, foliageSetter);
        this.placeLeaves(level, random, pos.relative(direction).relative(flag), config, foliageSetter);
    }

    /// an improved similar shape to mystic's biomes old foliage shape.
    protected void placeBushyFoliage(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter, int foliageRadius, int foliageHeight) {
        BlockPos.MutableBlockPos mutablePos = pos.mutable();

        for (int y = -foliageHeight; y <= foliageHeight; y++) {
            for (int x = -foliageRadius; x < foliageRadius; x++) {
                for (int z = -foliageRadius; z < foliageRadius; z++) {
                    mutablePos.setWithOffset(pos, x, y, z);
                    this.placeLeaves(level, random, mutablePos, config, foliageSetter);

                    for (Direction direction : Direction.values()) {
                        if (random.nextInt() < 0.5D) {
                            if (level.getBlockState(mutablePos.relative(direction)).isAir()) {
                                this.placeLeaves(level, random, mutablePos.relative(direction), config, foliageSetter);
                            }
                        }
                    }
                }
            }
        }
    }

    protected void placeLeavesRow(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter, int foliageRadius) {
        this.placeLeavesRow(level, random, pos, config, foliageSetter, foliageRadius, false);
    }

    protected void placeLeavesRow(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter, int foliageRadius, boolean doubleTrunk) {
        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();

        int extraRange = doubleTrunk ? 1 : 0;
        for (int x = -foliageRadius; x <= foliageRadius + extraRange; x++) {
            for (int z = -foliageRadius; z <= foliageRadius + extraRange; z++) {
                if (!this.shouldSkipLocationSigned(random, x, 0, z, foliageRadius, doubleTrunk)) {
                    mutablePos.setWithOffset(pos, x, 0, z);
                    this.placeLeaves(level, random, mutablePos, config, foliageSetter);
                    this.placeRandomLeaves(level, random, mutablePos, config, foliageSetter);
                }
            }
        }
    }

    protected void placeRandomLeaves(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter) {
        for (Direction direction : Direction.values()) {
            if (random.nextInt() < 0.4D) {
                if (level.getBlockState(pos.relative(direction)).isAir()) {
                    this.placeLeaves(level, random, pos.relative(direction), config, foliageSetter);
                }
            }
        }
    }

    protected void placeLeaves(LevelAccessor level, RandomSource random, BlockPos pos, MysticTreeConfiguration config, BiConsumer<BlockPos, BlockState> foliageSetter) {
        if (TreeFeature.validTreePos(level, pos)) {
            BlockState state = config.foliageProvider.getState(random, pos);
            if (state.hasProperty(BlockStateProperties.WATERLOGGED)) {
                state = state.setValue(BlockStateProperties.WATERLOGGED, level.isFluidAtPosition(pos, fluidState -> fluidState.isSourceOfType(Fluids.WATER)));
            }
            foliageSetter.accept(pos, state);
        }
    }

    protected boolean shouldSkipLocationSigned(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk) {
        int absX, absZ;
        if (doubleTrunk) {
            absX = Math.min(Math.abs(x), Math.abs(x - 1));
            absZ = Math.min(Math.abs(z), Math.abs(z - 1));
        } else {
            absX = Math.abs(x);
            absZ = Math.abs(z);
        }
        return this.shouldSkipLocation(random, absX, y, absZ, radius, doubleTrunk);
    }

    protected abstract boolean shouldSkipLocation(RandomSource random, int x, int y, int z, int radius, boolean doubleTrunk);

}