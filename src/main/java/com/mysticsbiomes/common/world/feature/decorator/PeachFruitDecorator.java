package com.mysticsbiomes.common.world.feature.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mysticsbiomes.common.block.FruitPlantBlock;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.registry.Registries;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;
import java.util.function.Supplier;

public class PeachFruitDecorator extends TreeDecorator {
    public static final Codec<PeachFruitDecorator> CODEC = RecordCodecBuilder.create((instance) -> instance.group(Codec.DOUBLE.fieldOf("probability").forGetter((decorator) -> decorator.probability), Registries.BLOCK.getCodec().fieldOf("block").forGetter((decorator) -> decorator.block.get())).apply(instance, (probability, block) -> new PeachFruitDecorator(() -> block, probability)));
    private final Supplier<Block> block;
    private final double probability;

    public PeachFruitDecorator(Supplier<Block> block, double probability) {
        this.block = block;
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return MysticFeatures.PEACHES;
    }

    @Override
    public void generate(TreeDecorator.Generator context) {
        WorldAccess level = (WorldAccess)context.getWorld();
        List<BlockPos> leaves = context.getLeavesPositions();

        for (BlockPos leavesPos : leaves) {
            BlockPos belowLeavesPos = leavesPos.down();
            BlockState belowFruitState = level.getBlockState(belowLeavesPos.down());
            if (context.isAir(belowLeavesPos) && (belowFruitState.isAir() || belowFruitState.isReplaceable() || belowFruitState.isIn(BlockTags.LEAVES))) { // below leaves and below the fruit.
                if (this.block.get() instanceof FruitPlantBlock) {
                    context.replace(belowLeavesPos, this.block.get().getDefaultState().with(FruitPlantBlock.AGE, context.getRandom().nextBoolean() ? 4 : 2));
                }
            }
        }
    }

}