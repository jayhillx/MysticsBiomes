package com.mysticsbiomes.common.world.feature.trunk;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.List;
import java.util.function.BiConsumer;

public class ShrubTrunkPlacer extends TrunkPlacer {
    public static final Codec<ShrubTrunkPlacer> CODEC = RecordCodecBuilder.create((instance) -> fillTrunkPlacerFields(instance).apply(instance, ShrubTrunkPlacer::new));

    public ShrubTrunkPlacer(int height, int heightRandomA, int randomHeightB) {
        super(height, heightRandomA, randomHeightB);
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return TrunkPlacerType.STRAIGHT_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld reader, BiConsumer<BlockPos, BlockState> consumer, Random random, int height, BlockPos pos, TreeFeatureConfig config) {
        setToDirt(reader, consumer, random, pos.down(), config);

        for (int i = 0; i < height; ++i) {
            this.getAndSetState(reader, consumer, random, pos.up(i), config);
        }
        return ImmutableList.of(new FoliagePlacer.TreeNode(pos.down().down().down().down(), 0, false));
    }

}