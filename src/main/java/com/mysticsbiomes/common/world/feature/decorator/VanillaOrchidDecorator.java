package com.mysticsbiomes.common.world.feature.decorator;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mysticsbiomes.common.block.VanillaOrchidBlock;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.List;

public class VanillaOrchidDecorator extends TreeDecorator {
    public static final Codec<VanillaOrchidDecorator> CODEC = RecordCodecBuilder.create((instance) -> instance.group(Codec.DOUBLE.fieldOf("probability").forGetter((decorator) -> decorator.probability)).apply(instance, VanillaOrchidDecorator::new));
    private final double probability;

    public VanillaOrchidDecorator(double probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return MysticFeatures.VANILLA_ORCHID;
    }

    @Override
    public void generate(TreeDecorator.Generator context) {
        Random random = context.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> logs = context.getLogPositions();

            int i = logs.get(0).getY();
            logs.stream().filter((pos) -> pos.getY() - i <= 1).forEach((logPos) -> {
                for (Direction direction : Direction.Type.HORIZONTAL) {
                    if (random.nextFloat() <= 0.25F) { // 25% chance of placing a vanilla orchid.
                        Direction opposite = direction.getOpposite();
                        BlockPos vanillaPos = logPos.add(opposite.getOffsetX(), 0, opposite.getOffsetZ());

                        if (context.isAir(vanillaPos)) {
                            context.replace(vanillaPos, MysticBlocks.VANILLA_ORCHID.getDefaultState().with(VanillaOrchidBlock.FACING, direction));

                            int randomHeight = random.nextInt(3);
                            for (int h = 0; h < 3 + randomHeight; h++) {
                                if (context.isAir(vanillaPos.up(h)) && context.getWorld().testBlockState(vanillaPos.up(h).add(opposite.getOffsetX(), 0, opposite.getOffsetZ()), state -> !state.isAir())) {
                                    context.replace(vanillaPos.up(h), MysticBlocks.VANILLA_ORCHID.getDefaultState().with(VanillaOrchidBlock.FACING, direction));
                                }
                            }
                        }
                    }
                }
            });
        }
    }

}