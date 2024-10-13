package com.mysticsbiomes.common.world.feature.trunk;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.BiConsumer;

public class TropicalTrunkPlacer extends TrunkPlacer {
    public static final Codec<TropicalTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> fillTrunkPlacerFields(instance).apply(instance, TropicalTrunkPlacer::new));

    public TropicalTrunkPlacer(int height, int heightRandomA, int randomHeightB) {
        super(height, heightRandomA, randomHeightB);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return MysticFeatures.TROPICAL_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld level, BiConsumer<BlockPos, BlockState> consumer, Random random, int trunkHeight, BlockPos initialPos, TreeFeatureConfig config) {
        setToDirt(level, consumer, random, initialPos.down(), config);

        List<FoliagePlacer.TreeNode> foliageAttachments = new ArrayList<>();
        Direction mainBranchDirection = Direction.Type.HORIZONTAL.random(random);
        int branchHeightLimit = trunkHeight - random.nextInt(4) - 1;
        int branchLengthLimit = 3 - random.nextInt(3);

        BlockPos.Mutable mutablePos = new BlockPos.Mutable();
        int currentX = initialPos.getX();
        int currentZ = initialPos.getZ();

        OptionalInt highestLog = OptionalInt.empty();
        for (int currentHeight = 0; currentHeight < trunkHeight; ++currentHeight) {
            int currentY = initialPos.getY() + currentHeight;
            if (currentHeight >= branchHeightLimit && branchLengthLimit > 0) {
                currentX += mainBranchDirection.getOffsetX();
                currentZ += mainBranchDirection.getOffsetZ();
                --branchLengthLimit;
            }

            if (this.getAndSetState(level, consumer, random, mutablePos.set(currentX, currentY, currentZ), config)) {
                highestLog = OptionalInt.of(currentY + 1);
            }
        }

        if (highestLog.isPresent()) {
            foliageAttachments.add(new FoliagePlacer.TreeNode(new BlockPos(currentX, highestLog.getAsInt(), currentZ), 1, false));
        }

        if (trunkHeight > 7) {
            Direction secondaryBranchDirection = Direction.Type.HORIZONTAL.random(random);
            if (secondaryBranchDirection != mainBranchDirection) {
                int secondaryBranchStartHeight = (branchHeightLimit - 3) - random.nextInt(2);

                BlockPos lowBranchPos = initialPos.up(secondaryBranchStartHeight).offset(secondaryBranchDirection);
                foliageAttachments.add(this.generateBranch(level, consumer, random, lowBranchPos, secondaryBranchDirection, config));
            }
        }
        return foliageAttachments;
    }

    private FoliagePlacer.TreeNode generateBranch(TestableWorld level, BiConsumer<BlockPos, BlockState> consumer, Random random, BlockPos pos, Direction direction, TreeFeatureConfig config) {
        BlockPos.Mutable mutablePos = new BlockPos.Mutable();
        int currentX = pos.getX();
        int currentZ = pos.getZ();

        this.getAndSetState(level, consumer, random, pos, config, state -> state.with(PillarBlock.AXIS, direction.getAxis()));
        for (int height = 1; height < 3 + random.nextInt(1); ++height) {
            currentX += direction.getOffsetX();
            currentZ += direction.getOffsetZ();

            this.getAndSetState(level, consumer, random, mutablePos.set(currentX, pos.getY() + height, currentZ), config, state -> state.with(PillarBlock.AXIS, direction.getAxis()));
        }
        return new FoliagePlacer.TreeNode(mutablePos, 0, false);
    }

}