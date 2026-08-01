package com.mysticsbiomes.datagen;

import com.google.common.collect.Maps;
import api.mystanica.registry.RegistryEntry;
import net.minecraft.util.StringUtil;
import net.minecraft.world.level.block.Block;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

public class MysticBlockFamily {
    private final RegistryEntry<Block> baseBlock;
    private final Map<Variant, RegistryEntry<Block>> variants = Maps.newHashMap();
    private boolean generateModel = true;
    ///private boolean generateRecipe = true;
    private boolean flammable = false;
    private String recipeGroupPrefix;
    private String recipeUnlockedBy;

    public MysticBlockFamily(RegistryEntry<Block> block) {
        this.baseBlock = block;
    }

    public RegistryEntry<Block> getBaseBlock() {
        return this.baseBlock;
    }

    public Map<Variant, RegistryEntry<Block>> getVariants() {
        return Collections.unmodifiableMap(this.variants);
    }

    public RegistryEntry<Block> get(Variant variant) {
        return this.variants.get(variant);
    }

    public boolean shouldGenerateModel() {
        return this.generateModel;
    }

    ///public boolean shouldGenerateRecipe() {
    ///    return this.generateRecipe;
    ///}

    /**
     * @return determine whether the blocks will be sorted into the wooden tags or not. (i.e. wooden_stairs or stairs.)
     */
    public boolean isFlammable() {
        return this.flammable;
    }

    public Optional<String> getRecipeGroupPrefix() {
        return StringUtil.isNullOrEmpty(this.recipeGroupPrefix) ? Optional.empty() : Optional.of(this.recipeGroupPrefix);
    }

    public Optional<String> getRecipeUnlockedBy() {
        return StringUtil.isNullOrEmpty(this.recipeUnlockedBy) ? Optional.empty() : Optional.of(this.recipeUnlockedBy);
    }

    public static class Builder {
        private final MysticBlockFamily family;

        public Builder(RegistryEntry<Block> block) {
            this.family = new MysticBlockFamily(block);
        }

        public MysticBlockFamily build() {
            return this.family;
        }

        public Builder log(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.LOG, block);
            return this;
        }

        public Builder wood(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.WOOD, block);
            return this;
        }

        public Builder secondaryLog(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.SECONDARY_LOG, block);
            return this;
        }

        public Builder secondaryWood(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.SECONDARY_WOOD, block);
            return this;
        }

        public Builder strippedLog(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.STRIPPED_LOG, block);
            return this;
        }

        public Builder strippedWood(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.STRIPPED_WOOD, block);
            return this;
        }

        public Builder planks(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.PLANKS, block);
            return this;
        }

        public Builder stairs(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.STAIRS, block);
            return this;
        }

        public Builder slab(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.SLAB, block);
            return this;
        }

        public Builder fence(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.FENCE, block);
            return this;
        }

        public Builder fenceGate(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.FENCE_GATE, block);
            return this;
        }

        public Builder button(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.BUTTON, block);
            return this;
        }

        public Builder pressurePlate(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.PRESSURE_PLATE, block);
            return this;
        }

        public Builder trapdoor(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.TRAPDOOR, block);
            return this;
        }

        public Builder door(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.DOOR, block);
            return this;
        }

        public Builder sign(RegistryEntry<Block> standingSign, RegistryEntry<Block> wallSign) {
            this.family.variants.put(Variant.SIGN, standingSign);
            this.family.variants.put(Variant.WALL_SIGN, wallSign);
            return this;
        }

        public Builder hangingSign(RegistryEntry<Block> hangingSign, RegistryEntry<Block> wallHangingSign) {
            this.family.variants.put(Variant.HANGING_SIGN, hangingSign);
            this.family.variants.put(Variant.WALL_HANGING_SIGN, wallHangingSign);
            return this;
        }

        public Builder wall(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.WALL, block);
            return this;
        }

        public Builder full(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.FULL, block);
            return this;
        }

        public Builder chiseled(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.CHISELED, block);
            return this;
        }

        public Builder cut(RegistryEntry<Block> block) {
            this.family.variants.put(Variant.CUT, block);
            return this;
        }

        public Builder dontGenerateModel() {
            this.family.generateModel = false;
            return this;
        }

        ///public Builder dontGenerateRecipe() {
        ///    this.family.generateRecipe = false;
        ///    return this;
        ///}

        public Builder flammable() {
            this.family.flammable = true;
            return this;
        }

        public Builder recipeGroupPrefix(String recipeGroupPrefix) {
            this.family.recipeGroupPrefix = recipeGroupPrefix;
            return this;
        }

        public Builder recipeUnlockedBy(String recipeUnlockedBy) {
            this.family.recipeUnlockedBy = recipeUnlockedBy;
            return this;
        }
    }

    public enum Variant {
        LOG("log"),
        WOOD("wood"),
        SECONDARY_LOG("secondary_log"),
        SECONDARY_WOOD("secondary_wood"),
        STRIPPED_LOG("stripped_log"),
        STRIPPED_WOOD("stripped_wood"),
        PLANKS("planks"),
        STAIRS("stairs"),
        SLAB("slab"),
        FENCE("fence"),
        FENCE_GATE("fence_gate"),
        BUTTON("button"),
        PRESSURE_PLATE("pressure_plate"),
        TRAPDOOR("trapdoor"),
        DOOR("door"),
        SIGN("sign"),
        WALL_SIGN("wall_sign"),
        HANGING_SIGN("hanging_sign"),
        WALL_HANGING_SIGN("wall_hanging_sign"),
        WALL("wall"),
        FULL("full"),
        CHISELED("chiseled"),
        CUT("cut");

        private final String recipeGroup;

        Variant(String variantName) {
            this.recipeGroup = variantName;
        }

        public String getRecipeGroup() {
            return this.recipeGroup;
        }

        /**
         * @return the block that would need to be gotten, like if this current variant is wood, it will need the log block name.
         */
        public Variant source() {
            return switch (this) {
                case WOOD -> LOG;
                case SECONDARY_WOOD -> SECONDARY_LOG;
                case STRIPPED_WOOD -> STRIPPED_LOG;
                case HANGING_SIGN -> WALL_HANGING_SIGN;
                case SIGN -> WALL_SIGN;
                default -> this;
            };
        }
    }

}