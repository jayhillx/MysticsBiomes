package com.mysticsbiomes.common.world.feature.decorator;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.init.MysticBlockEntities;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
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
    public static final Codec<ButterflyNestDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(ButterflyNestDecorator::new, (decorator) -> decorator.probability).codec();
    private static final Direction WORLDGEN_FACING = Direction.SOUTH;
    private static final Direction[] SPAWN_DIRECTIONS = Direction.Plane.HORIZONTAL.stream().filter((direction) -> direction != WORLDGEN_FACING.getOpposite()).toArray(Direction[]::new);
    private final float probability;

    public ButterflyNestDecorator(float probability) {
        this.probability = probability;
    }

    protected TreeDecoratorType<?> type() {
        return MysticFeatures.BUTTERFLY_NEST.get();
    }

    public void place(TreeDecorator.Context context) {
        RandomSource random = context.random();

        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> leaves = context.leaves();
            List<BlockPos> logs = context.logs();
            int i = !leaves.isEmpty() ? Math.max(leaves.get(0).getY() - 1, logs.get(0).getY() + 1) : Math.min(logs.get(0).getY() + 1 + random.nextInt(3), logs.get(logs.size() - 1).getY());
            List<BlockPos> list = leaves.stream().filter((pos) -> pos.getY() == i).flatMap((pos) -> Stream.of(SPAWN_DIRECTIONS).map(pos::relative)).collect(Collectors.toList());

            if (!list.isEmpty()) {
                Collections.shuffle(list);
                Optional<BlockPos> optional = list.stream().filter((pos) -> context.isAir(pos) && context.isAir(pos.relative(WORLDGEN_FACING))).findFirst();

                if (optional.isPresent()) {
                    context.setBlock(optional.get(), MysticBlocks.BUTTERFLY_NEST.get().defaultBlockState().setValue(BeehiveBlock.FACING, WORLDGEN_FACING));
                    context.level().getBlockEntity(optional.get(), MysticBlockEntities.BUTTERFLY_NEST.get()).ifPresent((blockEntity) -> {
                        int j = 2 + random.nextInt(2);

                        for (int k = 0; k < j; ++k) {
                            CompoundTag tag = new CompoundTag();
                            tag.putString("id", BuiltInRegistries.ENTITY_TYPE.getKey(MysticEntities.BUTTERFLY.get()).toString());
                            blockEntity.storeButterfly(tag, random.nextInt(599), false);
                        }
                    });
                }
            }
        }
    }

}