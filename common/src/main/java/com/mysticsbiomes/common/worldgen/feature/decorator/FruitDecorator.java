package com.mysticsbiomes.common.worldgen.feature.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mysticsbiomes.common.block.FruitPlantBlock;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

public class FruitDecorator extends TreeDecorator {
    public static final Codec<FruitDecorator> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            BlockStateProvider.CODEC.fieldOf("plant_provider").forGetter(decorator -> decorator.plantProvider),
            Codec.doubleRange(0.0D, 1.0D).fieldOf("probability").forGetter(decorator -> decorator.probability)
    ).apply(instance, FruitDecorator::new));
    private final BlockStateProvider plantProvider;
    private final double probability;

    public FruitDecorator(BlockStateProvider plantProvider, double probability) {
        this.plantProvider = plantProvider;
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return MysticFeatures.FRUIT.get();
    }

    @Override
    public void place(Context context) {
        LevelAccessor level = (LevelAccessor)context.level();
        RandomSource random = context.random();

        for (BlockPos leavesPos : context.leaves()) {
            BlockPos belowPos = leavesPos.below();
            BlockState belowBelowState = level.getBlockState(belowPos.below());

            if (context.isAir(belowPos) && (belowBelowState.isAir() || belowBelowState.canBeReplaced() || belowBelowState.is(BlockTags.LEAVES))) {
                BlockState state = this.plantProvider.getState(random, belowPos);

                context.setBlock(belowPos, state.setValue(FruitPlantBlock.AGE, context.random().nextBoolean() ? 4 : 2));
            }
        }
    }

}