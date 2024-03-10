package com.mysticsbiomes.common.world.feature.trunk;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.util.RandomSource;
import net.minecraft.util.valueproviders.IntProvider;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.LevelSimulatedReader;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CherryTrunkPlacer extends TrunkPlacer {
    private static final Codec<UniformInt> BRANCH_START_CODEC = ExtraCodecs.validate(UniformInt.CODEC, i -> (i.getMaxValue() - i.getMinValue() < 1) ? DataResult.error(() -> "Need at least 2 blocks variation for the branch starts to fit both branches") : DataResult.success(i));
    public static final Codec<CherryTrunkPlacer> CODEC = RecordCodecBuilder.create(instance -> trunkPlacerParts(instance).and(instance.group(IntProvider.codec(1, 3).fieldOf("branch_count").forGetter(placer -> placer.branchCount), IntProvider.codec(2, 16).fieldOf("branch_horizontal_length").forGetter(placer -> placer.branchHorizontalLength), IntProvider.codec(-16, 0, BRANCH_START_CODEC).fieldOf("branch_start_offset_from_top").forGetter(placer -> placer.branchStartOffsetFromTop), IntProvider.codec(-16, 16).fieldOf("branch_end_offset_from_top").forGetter(placer -> placer.branchEndOffsetFromTop))).apply(instance, CherryTrunkPlacer::new));
    private final IntProvider branchCount;
    private final IntProvider branchHorizontalLength;
    private final UniformInt branchStartOffsetFromTop;
    private final UniformInt thirdBranchStartOffsetFromTop;
    private final IntProvider branchEndOffsetFromTop;

    public CherryTrunkPlacer(int height, int randomHeightA, int randomHeightB, IntProvider branchCount, IntProvider branchLength, UniformInt startOffset, IntProvider endOffset) {
        super(height, randomHeightA, randomHeightB);
        this.branchCount = branchCount;
        this.branchHorizontalLength = branchLength;
        this.branchStartOffsetFromTop = startOffset;
        this.thirdBranchStartOffsetFromTop = UniformInt.of(startOffset.getMinValue(), startOffset.getMaxValue() - 1);
        this.branchEndOffsetFromTop = endOffset;
    }

    @Override
    protected TrunkPlacerType<?> type() {
        return MysticFeatures.CHERRY_TRUNK_PLACER.get();
    }

    @Override
    public List<FoliagePlacer.FoliageAttachment> placeTrunk(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, RandomSource random, int integer, BlockPos pos, TreeConfiguration configuration) {
        if (hasPodzolNearby(reader, pos)) {
            return Collections.emptyList();
        }

        setDirtAt(reader, consumer, random, pos.below(), configuration);
        int i = Math.max(0, integer - 1 + this.branchStartOffsetFromTop.sample(random));
        int j = Math.max(0, integer - 1 + this.thirdBranchStartOffsetFromTop.sample(random));
        int k = Math.max(0, integer - 1 + this.thirdBranchStartOffsetFromTop.sample(random));
        if (j >= i) {
            ++j;
        }
        if (k >= i && k >= j) {
            ++k;
        }

        int l = this.branchCount.sample(random);
        boolean flag = l == 3;
        boolean flag1 = l >= 2;
        int m = flag ? integer : (flag1 ? Math.max(Math.max(i, j), k) + 1 : i + 1);

        for (int n = 0; n < m; ++n) {
            placeLog(reader, consumer, random, pos.above(n), configuration);
        }

        List<FoliagePlacer.FoliageAttachment> list = new ArrayList<>();
        if (flag) {
            list.add(new FoliagePlacer.FoliageAttachment(pos.above(m), 0, false));
        }

        BlockPos.MutableBlockPos mutablePos = new BlockPos.MutableBlockPos();
        Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
        Function<BlockState, BlockState> logRotation = state -> state.setValue(RotatedPillarBlock.AXIS, direction.getAxis());

        list.add(generateBranch(reader, consumer, random, integer, pos, configuration, logRotation, direction, i, i < m - 1, mutablePos));
        if (flag1) {
            list.add(generateBranch(reader, consumer, random, integer, pos, configuration, logRotation, direction.getOpposite(), j, j < m - 1, mutablePos));
            list.add(generateBranch(reader, consumer, random, integer, pos, configuration, logRotation, direction.getClockWise(), k, k < m - 1, mutablePos));
        }
        return list;
    }

    private FoliagePlacer.FoliageAttachment generateBranch(LevelSimulatedReader reader, BiConsumer<BlockPos, BlockState> consumer, RandomSource random, int integer, BlockPos pos, TreeConfiguration configuration, Function<BlockState, BlockState> logRotation, Direction direction, int integer2, boolean valid, BlockPos.MutableBlockPos mutablePos) {
        mutablePos.set(pos).move(Direction.UP, integer2);

        int i = integer - 1 + this.branchEndOffsetFromTop.sample(random);
        boolean flag = valid || i < integer2;
        int j = this.branchHorizontalLength.sample(random) + (flag ? 1 : 0);
        BlockPos abovePos = pos.relative(direction, j).above(i);
        int k = flag ? 2 : 1;

        for (int l = 0; l < k; ++l) {
            BlockPos logPos = mutablePos.move(direction);
            Direction logRotationDir = direction.getAxis().isHorizontal() ? direction : Direction.UP;

            if (reader.isStateAtPosition(logPos, BlockBehaviour.BlockStateBase::canBeReplaced) && !hasPodzolNearby(reader, logPos)) {
                placeLog(reader, consumer, random, logPos, configuration, state -> state.setValue(RotatedPillarBlock.AXIS, logRotationDir.getAxis()));
            } else {
                return new FoliagePlacer.FoliageAttachment(logPos.above(), 0, false);
            }
        }

        Direction direction2 = abovePos.getY() > mutablePos.getY() ? Direction.UP : Direction.DOWN;
        while (true) {
            int i1 = mutablePos.distManhattan(abovePos);
            if (i1 == 0) {
                return new FoliagePlacer.FoliageAttachment(abovePos.above(), 0, false);
            }

            float f = (float) Math.abs(abovePos.getY() - mutablePos.getY()) / (float) i1;
            boolean flag1 = random.nextFloat() < f;
            mutablePos.move(flag1 ? direction2 : direction);
            Direction logRotationDir = flag1 ? direction2 : direction;

            if (reader.isStateAtPosition(mutablePos, BlockBehaviour.BlockStateBase::canBeReplaced) && !hasPodzolNearby(reader, mutablePos)) {
                placeLog(reader, consumer, random, mutablePos, configuration, state -> state.setValue(RotatedPillarBlock.AXIS, logRotationDir.getAxis()));
            } else {
                return new FoliagePlacer.FoliageAttachment(mutablePos.above(), 0, false);
            }
        }
    }

    private static boolean hasPodzolNearby(LevelSimulatedReader reader, BlockPos pos) {
        BlockPos.MutableBlockPos checkPos = new BlockPos.MutableBlockPos();

        for (int dx = -2; dx <= 2; ++dx) {
            for (int dy = -2; dy <= 2; ++dy) {
                for (int dz = -2; dz <= 2; ++dz) {
                    checkPos.set(pos).move(dx, dy, dz);

                    if (reader.isStateAtPosition(checkPos, state -> state.getBlock() == Blocks.PODZOL)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}