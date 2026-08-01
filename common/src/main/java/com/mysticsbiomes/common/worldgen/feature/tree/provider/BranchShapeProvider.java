package com.mysticsbiomes.common.worldgen.feature.tree.provider;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.IntProvider;

public class BranchShapeProvider {
    public static final Codec<BranchShapeProvider> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            IntProvider.codec(0, 16).fieldOf("branch_count").forGetter(config -> config.branchCount),
            IntProvider.codec(0, 16).fieldOf("branch_y_start").forGetter(config -> config.branchYStart),
            IntProvider.codec(0, 16).fieldOf("branch_length").forGetter(config -> config.branchLength),
            IntProvider.codec(0, 16).fieldOf("extend_amount").forGetter(config -> config.extendAmount),
            Codec.INT.fieldOf("forward_interval").forGetter(config -> config.forwardInterval),
            Codec.INT.fieldOf("upward_interval").forGetter(config -> config.upwardInterval)
    ).apply(instance, BranchShapeProvider::new));
    public final IntProvider branchCount;
    public final IntProvider branchYStart;
    public final IntProvider branchLength;
    public final IntProvider extendAmount;
    public final int forwardInterval;
    public final int upwardInterval;

    /**
     * @param branchCount ------------ how many branches the tree will generate.
     * @param forwardInterval -------- the amount the branch will move forward before moving upward.
     * @param upwardInterval --------- the amount the branch will move upward before moving forward.
     */
    protected BranchShapeProvider(IntProvider branchCount,
                                  IntProvider branchYStart,
                                  IntProvider branchLength,
                                  IntProvider extendAmount,
                                  int forwardInterval,
                                  int upwardInterval) {
        this.branchCount = branchCount;
        this.branchYStart = branchYStart;
        this.branchLength = branchLength;
        this.extendAmount = extendAmount;
        this.forwardInterval = forwardInterval;
        this.upwardInterval = upwardInterval;
    }

    public static class Builder {
        public IntProvider branchCount;
        public IntProvider branchYStart;
        public IntProvider branchLength;
        public IntProvider extendAmount;
        public int forwardInterval;
        public int upwardInterval;

        public Builder() {
            this.branchCount = ConstantInt.of(1);
            this.branchYStart = ConstantInt.of(3);
            this.branchLength = ConstantInt.of(3);
            this.extendAmount = ConstantInt.of(1);
            this.forwardInterval = 1;
            this.upwardInterval = 1;
        }

        public Builder branchCount(IntProvider count) {
            this.branchCount = count;
            return this;
        }

        public Builder branchYStart(IntProvider yStart) {
            this.branchYStart = yStart;
            return this;
        }

        public Builder branchLength(IntProvider length) {
            this.branchLength = length;
            return this;
        }

        public Builder extendAmount(IntProvider amount) {
            this.extendAmount = amount;
            return this;
        }

        public Builder forwardInterval(int interval) {
            this.forwardInterval = interval;
            return this;
        }

        public Builder upwardInterval(int interval) {
            this.upwardInterval = interval;
            return this;
        }

        public BranchShapeProvider build() {
            return new BranchShapeProvider(
                    this.branchCount,
                    this.branchYStart,
                    this.branchLength,
                    this.extendAmount,
                    this.forwardInterval,
                    this.upwardInterval
            );
        }
    }

}