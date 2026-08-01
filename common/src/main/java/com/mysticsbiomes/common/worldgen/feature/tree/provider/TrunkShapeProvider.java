package com.mysticsbiomes.common.worldgen.feature.tree.provider;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;

public class TrunkShapeProvider {
    public static final Codec<TrunkShapeProvider> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Codec.intRange(0, 32).fieldOf("base_height").forGetter(config -> config.baseHeight),
            Codec.intRange(0, 24).fieldOf("rand_height").forGetter(config -> config.randHeight),
            Codec.BOOL.fieldOf("double_trunk").forGetter(config -> config.doubleTrunk)
    ).apply(instance, TrunkShapeProvider::new));
    public final int baseHeight;
    public final int randHeight;
    public final boolean doubleTrunk;

    public TrunkShapeProvider(int baseHeight) {
        this(baseHeight, 0);
    }

    public TrunkShapeProvider(int baseHeight, int randHeight) {
        this(baseHeight, randHeight, false);
    }

    public TrunkShapeProvider(int baseHeight, int randHeight, boolean doubleTrunk) {
        this.baseHeight = baseHeight;
        this.randHeight = randHeight;
        this.doubleTrunk = doubleTrunk;
    }

    public int getTrunkHeight(RandomSource random) {
        int height = this.baseHeight;
        if (this.randHeight > 0) {
            height += random.nextInt(this.randHeight + 1);
        }
        return height;
    }

}