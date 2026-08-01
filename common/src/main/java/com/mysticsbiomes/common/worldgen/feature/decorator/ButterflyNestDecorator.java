package com.mysticsbiomes.common.worldgen.feature.decorator;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.block.entity.ButterflyNestBlockEntity;
import com.mysticsbiomes.init.MysticBlockEntities;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.BeehiveBlock;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecorator;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ButterflyNestDecorator extends TreeDecorator {
    public static final Codec<ButterflyNestDecorator> CODEC = Codec.doubleRange(0.0F, 1.0F).fieldOf("probability").xmap(ButterflyNestDecorator::new, (decorator) -> decorator.probability).codec();
    private static final Direction FACING_DIRECTION = Direction.SOUTH;
    private static final Direction[] VALID_DIRECTIONS = Direction.Plane.HORIZONTAL.stream().filter((direction) -> direction != FACING_DIRECTION.getOpposite()).toArray(Direction[]::new);
    private final double probability;

    public ButterflyNestDecorator(double probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> type() {
        return MysticFeatures.BUTTERFLY_NEST.get();
    }

    @Override
    public void place(Context context) {
        RandomSource random = context.random();

        if (!(random.nextDouble() >= this.probability)) {
            List<BlockPos> leaves = context.leaves();
            List<BlockPos> logs = context.logs();
            int y = !leaves.isEmpty() ? Math.max(leaves.get(0).getY() - 1, logs.get(0).getY() + 1) : Math.min(logs.get(0).getY() + 1 + random.nextInt(3), logs.get(logs.size() - 1).getY());

            List<BlockPos> possiblePositions = logs.stream().filter(pos -> pos.getY() == y).flatMap(pos -> Stream.of(VALID_DIRECTIONS).map(pos::relative)).collect(Collectors.toList());
            if (!possiblePositions.isEmpty()) {
                Collections.shuffle(possiblePositions);
                Optional<BlockPos> nestPos = possiblePositions.stream().filter(pos -> context.isAir(pos) && context.isAir(pos.relative(FACING_DIRECTION))).findFirst();
                if (nestPos.isPresent()) {
                    context.setBlock(nestPos.get(), MysticBlocks.BUTTERFLY_NEST.get().defaultBlockState().setValue(BeehiveBlock.FACING, FACING_DIRECTION));
                    context.level().getBlockEntity(nestPos.get(),  MysticBlockEntities.BUTTERFLY_NEST.get()).ifPresent((nest) -> {
                        int amount = 1 + random.nextInt(2);
                        for (int i = 0; i < amount; i++) {
                            nest.storeButterfly(ButterflyNestBlockEntity.Occupant.create(random.nextInt(599), random));
                        }
                    });
                }
            }
        }
    }

}