package com.mysticsbiomes.common.worldgen.feature.decorator;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.block.VanillaOrchidBlock;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.List;

public class VanillaOrchidDecorator extends TreeDecorator {
    public static final Codec<VanillaOrchidDecorator> CODEC = Codec.doubleRange(0.0F, 1.0F).fieldOf("probability").xmap(VanillaOrchidDecorator::new, (decorator) -> decorator.probability).codec();
    private final double probability;

    public VanillaOrchidDecorator(double probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return MysticFeatures.VANILLA_ORCHID.get();
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();

        if (!(random.nextDouble() >= this.probability)) {
            List<BlockPos> logs = context.logs();

            if (!logs.isEmpty()) {
                int i = logs.get(0).getY();
                logs.stream().filter((pos) -> pos.getY() - i <= 1).forEach((logPos) -> {
                    for (Direction direction : Direction.Plane.HORIZONTAL) {
                        if (random.nextDouble() <= 0.25F) { /// 25% chance of placing a vanilla orchid.
                            BlockPos vanillaPos = logPos.offset(direction.getOpposite().getStepX(), 0, direction.getOpposite().getStepZ());

                            if (context.isAir(vanillaPos)) {
                                context.setBlock(vanillaPos, MysticBlocks.VANILLA_ORCHID.get().defaultBlockState().setValue(VanillaOrchidBlock.FACING, direction));

                                int randomHeight = random.nextInt(3);
                                for (int h = 0; h < 3 + randomHeight; h++) {
                                    if (context.isAir(vanillaPos.above(h)) && context.level().isStateAtPosition(vanillaPos.above(h).offset(direction.getStepX(), 0, direction.getStepZ()), state -> !state.isAir())) {
                                        context.setBlock(vanillaPos.above(h), MysticBlocks.VANILLA_ORCHID.get().defaultBlockState().setValue(VanillaOrchidBlock.FACING, direction));
                                    }
                                }
                            }
                        }
                    }
                });
            }
        }
    }

}