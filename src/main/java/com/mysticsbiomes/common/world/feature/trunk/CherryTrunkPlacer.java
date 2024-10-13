package com.mysticsbiomes.common.world.feature.trunk;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import com.mysticsbiomes.init.MysticFeatures;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PillarBlock;
import net.minecraft.util.dynamic.Codecs;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.IntProvider;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.TestableWorld;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.foliage.FoliagePlacer;
import net.minecraft.world.gen.trunk.TrunkPlacer;
import net.minecraft.world.gen.trunk.TrunkPlacerType;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;

public class CherryTrunkPlacer extends TrunkPlacer {
    private static final Codec<UniformIntProvider> BRANCH_START_CODEC = Codecs.validate(UniformIntProvider.CODEC, i -> (i.getMax() - i.getMin() < 1) ? DataResult.error(() -> "Need at least 2 blocks variation for the branch starts to fit both branches") : DataResult.success(i));
    public static final Codec<CherryTrunkPlacer> CODEC = RecordCodecBuilder.create(instance -> fillTrunkPlacerFields(instance).and(instance.group(IntProvider.createValidatingCodec(1, 3).fieldOf("branch_count").forGetter(placer -> placer.branchCount), IntProvider.createValidatingCodec(2, 16).fieldOf("branch_horizontal_length").forGetter(placer -> placer.branchHorizontalLength), IntProvider.createValidatingCodec(-16, 0, BRANCH_START_CODEC).fieldOf("branch_start_offset_from_top").forGetter(placer -> placer.branchStartOffsetFromTop), IntProvider.createValidatingCodec(-16, 16).fieldOf("branch_end_offset_from_top").forGetter(placer -> placer.branchEndOffsetFromTop))).apply(instance, CherryTrunkPlacer::new));
    private final IntProvider branchCount;
    private final IntProvider branchHorizontalLength;
    private final UniformIntProvider branchStartOffsetFromTop;
    private final UniformIntProvider thirdBranchStartOffsetFromTop;
    private final IntProvider branchEndOffsetFromTop;

    public CherryTrunkPlacer(int height, int randomHeightA, int randomHeightB, IntProvider branchCount, IntProvider branchLength, UniformIntProvider startOffset, IntProvider endOffset) {
        super(height, randomHeightA, randomHeightB);
        this.branchCount = branchCount;
        this.branchHorizontalLength = branchLength;
        this.branchStartOffsetFromTop = startOffset;
        this.thirdBranchStartOffsetFromTop = UniformIntProvider.create(startOffset.getMin(), startOffset.getMax() - 1);
        this.branchEndOffsetFromTop = endOffset;
    }

    @Override
    protected TrunkPlacerType<?> getType() {
        return MysticFeatures.CHERRY_TRUNK_PLACER;
    }

    @Override
    public List<FoliagePlacer.TreeNode> generate(TestableWorld reader, BiConsumer<BlockPos, BlockState> consumer, Random random, int height, BlockPos pos, TreeFeatureConfig config) {
        if (hasPodzolNearby(reader, pos)) {
            return Collections.emptyList();
        }

        setToDirt(reader, consumer, random, pos.down(), config);
        int i = Math.max(0, height - 1 + this.branchStartOffsetFromTop.get(random));
        int j = Math.max(0, height - 1 + this.thirdBranchStartOffsetFromTop.get(random));
        int k = Math.max(0, height - 1 + this.thirdBranchStartOffsetFromTop.get(random));
        if (j >= i) {
            ++j;
        }
        if (k >= i && k >= j) {
            ++k;
        }

        int l = this.branchCount.get(random);
        boolean flag = l == 3;
        boolean flag1 = l >= 2;
        int m = flag ? height : (flag1 ? Math.max(Math.max(i, j), k) + 1 : i + 1);

        for (int n = 0; n < m; ++n) {
            getAndSetState(reader, consumer, random, pos.up(n), config);
        }

        List<FoliagePlacer.TreeNode> list = new ArrayList<>();
        if (flag) {
            list.add(new FoliagePlacer.TreeNode(pos.up(m), 0, false));
        }

        BlockPos.Mutable mutablePos = new BlockPos.Mutable();
        Direction direction = Direction.Type.HORIZONTAL.random(random);
        Function<BlockState, BlockState> logRotation = state -> state.with(PillarBlock.AXIS, direction.getAxis());

        list.add(generateBranch(reader, consumer, random, height, pos, config, logRotation, direction, i, i < m - 1, mutablePos));
        if (flag1) {
            list.add(generateBranch(reader, consumer, random, height, pos, config, logRotation, direction.getOpposite(), j, j < m - 1, mutablePos));
            list.add(generateBranch(reader, consumer, random, height, pos, config, logRotation, direction, k, k < m - 1, mutablePos));
        }
        return list;
    }

    private FoliagePlacer.TreeNode generateBranch(TestableWorld reader, BiConsumer<BlockPos, BlockState> consumer, Random random, int integer, BlockPos pos, TreeFeatureConfig configuration, Function<BlockState, BlockState> logRotation, Direction direction, int integer2, boolean valid, BlockPos.Mutable mutablePos) {
        mutablePos.set(pos).move(Direction.UP, integer2);

        int i = integer - 1 + this.branchEndOffsetFromTop.get(random);
        boolean flag = valid || i < integer2;
        int j = this.branchHorizontalLength.get(random) + (flag ? 1 : 0);
        BlockPos abovePos = pos.offset(direction, j).up(i);
        int k = flag ? 2 : 1;

        for (int l = 0; l < k; ++l) {
            BlockPos logPos = mutablePos.move(direction);
            Direction logRotationDir = direction.getAxis().isHorizontal() ? direction : Direction.UP;

            if (reader.testBlockState(mutablePos, AbstractBlock.AbstractBlockState::isReplaceable) && !hasPodzolNearby(reader, logPos)) {
                getAndSetState(reader, consumer, random, logPos, configuration, state -> state.with(PillarBlock.AXIS, logRotationDir.getAxis()));
            } else {
                return new FoliagePlacer.TreeNode(logPos.up(), 0, false);
            }
        }

        Direction direction2 = abovePos.getY() > mutablePos.getY() ? Direction.UP : Direction.DOWN;
        while (true) {
            int i1 = mutablePos.getManhattanDistance(abovePos);
            if (i1 == 0) {
                return new FoliagePlacer.TreeNode(abovePos.up(), 0, false);
            }

            float f = (float) Math.abs(abovePos.getY() - mutablePos.getY()) / (float) i1;
            boolean flag1 = random.nextFloat() < f;
            mutablePos.move(flag1 ? direction2 : direction);
            Direction logRotationDir = flag1 ? direction2 : direction;

            if (reader.testBlockState(mutablePos, AbstractBlock.AbstractBlockState::isReplaceable) && !hasPodzolNearby(reader, mutablePos)) {
                getAndSetState(reader, consumer, random, mutablePos, configuration, state -> state.with(PillarBlock.AXIS, logRotationDir.getAxis()));
            } else {
                return new FoliagePlacer.TreeNode(mutablePos.up(), 0, false);
            }
        }
    }

    private static boolean hasPodzolNearby(TestableWorld reader, BlockPos pos) {
        BlockPos.Mutable checkPos = new BlockPos.Mutable();

        for (int dx = -2; dx <= 2; ++dx) {
            for (int dy = -2; dy <= 2; ++dy) {
                for (int dz = -2; dz <= 2; ++dz) {
                    checkPos.set(pos).move(dx, dy, dz);

                    if (reader.testBlockState(checkPos, state -> state.getBlock() == Blocks.PODZOL)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}