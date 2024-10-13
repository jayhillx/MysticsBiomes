package com.mysticsbiomes.common.world.feature.decorator;

import com.mojang.serialization.Codec;
import com.mysticsbiomes.common.block.ButterflyNestBlock;
import com.mysticsbiomes.common.entity.animal.Butterfly;
import com.mysticsbiomes.init.MysticBlockEntities;
import com.mysticsbiomes.init.MysticBlocks;
import com.mysticsbiomes.init.MysticEntities;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.registry.Registries;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.treedecorator.TreeDecorator;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ButterflyNestDecorator extends TreeDecorator {
    public static final Codec<ButterflyNestDecorator> CODEC = Codec.floatRange(0.0F, 1.0F).fieldOf("probability").xmap(ButterflyNestDecorator::new, (decorator) -> decorator.probability).codec();
    private static final Direction WORLDGEN_FACING = Direction.SOUTH;
    private static final Direction[] SPAWN_DIRECTIONS = Direction.Type.HORIZONTAL.stream().filter((direction) -> direction != WORLDGEN_FACING.getOpposite()).toArray(Direction[]::new);
    private final float probability;

    public ButterflyNestDecorator(float probability) {
        this.probability = probability;
    }

    @Override
    protected TreeDecoratorType<?> getType() {
        return MysticFeatures.BUTTERFLY_NEST;
    }

    @Override
    public void generate(TreeDecorator.Generator context) {
        Random random = context.getRandom();
        if (!(random.nextFloat() >= this.probability)) {
            List<BlockPos> leaves = context.getLeavesPositions();
            List<BlockPos> logs = context.getLogPositions();

            int i = !leaves.isEmpty() ? Math.max(leaves.get(0).getY() - 1, logs.get(0).getY() + 1) : Math.min(logs.get(0).getY() + 1 + random.nextInt(3), logs.get(logs.size() - 1).getY());
            List<BlockPos> list = leaves.stream().filter((pos) -> pos.getY() == i).flatMap((pos) -> Stream.of(SPAWN_DIRECTIONS).map(pos::offset)).collect(Collectors.toList());
            if (!list.isEmpty()) {
                Collections.shuffle(list);
                Optional<BlockPos> optional = list.stream().filter((pos) -> {
                    BlockPos belowPos = pos.down();
                    return context.isAir(pos) && context.isAir(pos.offset(WORLDGEN_FACING)) && (context.isAir(belowPos));
                }).findFirst();

                if (optional.isPresent()) {
                    context.replace(optional.get(), MysticBlocks.BUTTERFLY_NEST.getDefaultState().with(ButterflyNestBlock.FACING, WORLDGEN_FACING));
                    context.getWorld().getBlockEntity(optional.get(), MysticBlockEntities.BUTTERFLY_NEST).ifPresent((blockEntity) -> {
                        int j = 2 + random.nextInt(2);

                        for (int k = 0; k < j; ++k) {
                            NbtCompound tag = new NbtCompound();
                            int c = random.nextInt(Butterfly.Type.values().length);

                            tag.putInt("TypeId", c);
                            tag.putString("id", Registries.ENTITY_TYPE.getKey(MysticEntities.BUTTERFLY).toString());
                            blockEntity.storeButterfly(tag, random.nextInt(599), false);
                        }
                    });
                }
            }
        }
    }

}