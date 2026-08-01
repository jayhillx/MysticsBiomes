package com.mysticsbiomes.common.worldgen.feature.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mysticsbiomes.common.block.MapleLeafLitterBlock;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class FallenLeavesDecorator extends TreeDecorator {
    public static final Codec<FallenLeavesDecorator> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("leaf_pile_provider").forGetter(decorator -> decorator.leafPileProvider),
            BlockStateProvider.CODEC.fieldOf("leaf_litter_provider").forGetter(decorator -> decorator.leafLitterProvider),
            Codec.doubleRange(0.0D, 1.0D).fieldOf("probability").forGetter(decorator -> decorator.probability)
    ).apply(instance, FallenLeavesDecorator::new));
    private final BlockStateProvider leafPileProvider;
    private final BlockStateProvider leafLitterProvider;
    private final double probability;

    public FallenLeavesDecorator(BlockStateProvider leafPileProvider, BlockStateProvider leafLitterProvider, double probability) {
        this.leafPileProvider = leafPileProvider;
        this.leafLitterProvider = leafLitterProvider;
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return MysticFeatures.FALLEN_LEAVES.get();
    }

    @Override
    public void place(Context context) {
        LevelAccessor level = (LevelAccessor)context.level();
        RandomSource random = context.random();

        for (BlockPos leavesPos : context.leaves()) {
            if (random.nextDouble() > this.probability) continue;

            BlockPos.MutableBlockPos groundPos = leavesPos.mutable().move(Direction.DOWN);
            while (groundPos.getY() > level.getMinBuildHeight() && (level.getBlockState(groundPos).isAir() || level.getBlockState(groundPos).canBeReplaced())) {
                groundPos.move(Direction.DOWN);
            }
            groundPos.move(Direction.UP);

            BlockState belowState = level.getBlockState(groundPos.below());
            if (!belowState.isFaceSturdy(level, groundPos.below(), Direction.UP)) {
                continue;
            }

            BlockState groundState = level.getBlockState(groundPos);
            if (groundState.isAir() || groundState.canBeReplaced()) {
                BlockState state = this.getRandomBlock(random, groundPos);
                BlockState pileState = this.leafPileProvider.getState(random, leavesPos);
                BlockState litterState = this.leafLitterProvider.getState(random, leavesPos);

                if (state.is(pileState.getBlock())) {
                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        BlockPos relativePos = groundPos.relative(direction);

                        if (level.isEmptyBlock(relativePos)) {
                            if (level.getBlockState(relativePos.below()).isFaceSturdy(level, relativePos.below(), Direction.UP)) {
                                level.setBlock(relativePos, litterState.setValue(MapleLeafLitterBlock.FACING, direction).setValue(MapleLeafLitterBlock.AMOUNT, 4), 19);
                            }
                        }
                    }
                }

                if (state.is(litterState.getBlock())) {
                    Direction direction = Direction.Plane.HORIZONTAL.getRandomDirection(random);
                    int amount = random.nextIntBetweenInclusive(2, 4);
                    state = state.setValue(MapleLeafLitterBlock.FACING, direction).setValue(MapleLeafLitterBlock.AMOUNT, amount);
                }
                level.setBlock(groundPos, state, 19);
            }
        }
    }

    private BlockState getRandomBlock(RandomSource random, BlockPos pos) {
        return (random.nextDouble() < 0.33 ? this.leafPileProvider : this.leafLitterProvider).getState(random, pos);
    }

}