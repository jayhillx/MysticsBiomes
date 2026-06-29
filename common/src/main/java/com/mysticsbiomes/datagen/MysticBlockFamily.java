package com.mysticsbiomes.datagen;

import com.google.common.collect.Maps;
import com.mysticsbiomes.core.registry.RegistryObject;
import net.minecraft.util.StringUtil;
import net.minecraft.world.level.block.Block;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MysticBlockFamily {
    private final RegistryObject<Block> baseBlock;
    private final Map<Variant, RegistryObject<Block>> variants = Maps.newHashMap();
    private boolean generateModel = true;
    private boolean generateRecipe = true;
    private boolean flammable = false;
    private String recipeGroupPrefix;
    private String recipeUnlockedBy;

    public MysticBlockFamily(RegistryObject<Block> block) {
        this.baseBlock = block;
    }

    public RegistryObject<Block> getBaseBlock() {
        return this.baseBlock;
    }

    public Map<Variant, Block> getVariants() {
        Map<Variant, Block> result = new HashMap<>();

        for (var entry : this.variants.entrySet()) {
            result.put(entry.getKey(), entry.getValue().get());
        }

        return result;
    }

    public RegistryObject<Block> get(Variant variant) {
        return this.variants.get(variant);
    }
    
    public boolean shouldGenerateModel() {
        return this.generateModel;
    }

    public boolean shouldGenerateRecipe() {
        return this.generateRecipe;
    }

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

        public Builder(RegistryObject<Block> block) {
            this.family = new MysticBlockFamily(block);
        }

        public MysticBlockFamily build() {
            return this.family;
        }

        public Builder log(RegistryObject<Block> block) {
            this.family.variants.put(Variant.LOG, block);
            return this;
        }

        public Builder wood(RegistryObject<Block> block) {
            this.family.variants.put(Variant.WOOD, block);
            return this;
        }

        public Builder secondaryLog(RegistryObject<Block> block) {
            this.family.variants.put(Variant.SECONDARY_LOG, block);
            return this;
        }

        public Builder secondaryWood(RegistryObject<Block> block) {
            this.family.variants.put(Variant.SECONDARY_WOOD, block);
            return this;
        }

        public Builder strippedLog(RegistryObject<Block> block) {
            this.family.variants.put(Variant.STRIPPED_LOG, block);
            return this;
        }

        public Builder strippedWood(RegistryObject<Block> block) {
            this.family.variants.put(Variant.STRIPPED_WOOD, block);
            return this;
        }

        public Builder planks(RegistryObject<Block> block) {
            this.family.variants.put(Variant.PLANKS, block);
            return this;
        }

        public Builder stairs(RegistryObject<Block> block) {
            this.family.variants.put(Variant.STAIRS, block);
            return this;
        }

        public Builder slab(RegistryObject<Block> block) {
            this.family.variants.put(Variant.SLAB, block);
            return this;
        }

        public Builder fence(RegistryObject<Block> block) {
            this.family.variants.put(Variant.FENCE, block);
            return this;
        }

        public Builder fenceGate(RegistryObject<Block> block) {
            this.family.variants.put(Variant.FENCE_GATE, block);
            return this;
        }

        public Builder button(RegistryObject<Block> block) {
            this.family.variants.put(Variant.BUTTON, block);
            return this;
        }

        public Builder pressurePlate(RegistryObject<Block> block) {
            this.family.variants.put(Variant.PRESSURE_PLATE, block);
            return this;
        }

        public Builder trapdoor(RegistryObject<Block> block) {
            this.family.variants.put(Variant.TRAPDOOR, block);
            return this;
        }

        public Builder door(RegistryObject<Block> block) {
            this.family.variants.put(Variant.DOOR, block);
            return this;
        }

        public Builder sign(RegistryObject<Block> standingSign, RegistryObject<Block> wallSign) {
            this.family.variants.put(Variant.SIGN, standingSign);
            this.family.variants.put(Variant.WALL_SIGN, wallSign);
            return this;
        }

        public Builder hangingSign(RegistryObject<Block> hangingSign, RegistryObject<Block> wallHangingSign) {
            this.family.variants.put(Variant.HANGING_SIGN, hangingSign);
            this.family.variants.put(Variant.WALL_HANGING_SIGN, wallHangingSign);
            return this;
        }

        public Builder wall(RegistryObject<Block> block) {
            this.family.variants.put(Variant.WALL, block);
            return this;
        }

        public Builder full(RegistryObject<Block> block) {
            this.family.variants.put(Variant.FULL, block);
            return this;
        }

        public Builder chiseled(RegistryObject<Block> block) {
            this.family.variants.put(Variant.CHISELED, block);
            return this;
        }

        public Builder cut(RegistryObject<Block> block) {
            this.family.variants.put(Variant.CUT, block);
            return this;
        }

        public Builder dontGenerateModel() {
            this.family.generateModel = false;
            return this;
        }

        public Builder dontGenerateRecipe() {
            this.family.generateRecipe = false;
            return this;
        }

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

        public Variant source() {
            return switch (this) {
                case WOOD -> LOG;
                case SECONDARY_WOOD -> SECONDARY_LOG;
                case STRIPPED_WOOD, HANGING_SIGN -> STRIPPED_LOG;
                case SIGN -> WALL_SIGN;
                default -> this;
            };
        }
    }

}