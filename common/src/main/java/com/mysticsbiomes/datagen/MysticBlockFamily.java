package com.mysticsbiomes.datagen;

import com.google.common.collect.Maps;
import net.minecraft.util.StringUtil;
import net.minecraft.world.level.block.Block;

import java.util.Map;
import java.util.Optional;

public class MysticBlockFamily {
    private final Block baseBlock;
    private final Map<Variant, Block> variants = Maps.newHashMap();
    private boolean generateModel = true;
    private boolean generateRecipe = true;
    private String recipeGroupPrefix;
    private String recipeUnlockedBy;

    public MysticBlockFamily(Block block) {
        this.baseBlock = block;
    }
    
    public Block getBaseBlock() {
        return this.baseBlock;
    }

    public Map<Variant, Block> getVariants() {
        return this.variants;
    }

    public Block get(Variant variant) {
        return this.variants.get(variant);
    }

    public boolean shouldGenerateModel() {
        return this.generateModel;
    }

    public boolean shouldGenerateRecipe() {
        return this.generateRecipe;
    }

    public Optional<String> getRecipeGroupPrefix() {
        return StringUtil.isNullOrEmpty(this.recipeGroupPrefix) ? Optional.empty() : Optional.of(this.recipeGroupPrefix);
    }

    public Optional<String> getRecipeUnlockedBy() {
        return StringUtil.isNullOrEmpty(this.recipeUnlockedBy) ? Optional.empty() : Optional.of(this.recipeUnlockedBy);
    }

    public static class Builder {
        private final MysticBlockFamily family;

        public Builder(Block block) {
            this.family = new MysticBlockFamily(block);
        }

        public MysticBlockFamily getFamily() {
            return this.family;
        }

        public Builder log(Block log, Block strippedLog) {
            this.family.variants.put(Variant.LOG, log);
            this.family.variants.put(Variant.STRIPPED_LOG, strippedLog);
            return this;
        }
        
        public Builder wood(Block wood, Block strippedWood) {
            this.family.variants.put(Variant.WOOD, wood);
            this.family.variants.put(Variant.STRIPPED_WOOD, strippedWood);
            return this;
        }

        public Builder planks(Block block) {
            this.family.variants.put(Variant.PLANKS, block);
            return this;
        }

        public Builder stairs(Block block) {
            this.family.variants.put(Variant.STAIRS, block);
            return this;
        }

        public Builder slab(Block block) {
            this.family.variants.put(Variant.SLAB, block);
            return this;
        }

        public Builder fence(Block block) {
            this.family.variants.put(Variant.FENCE, block);
            return this;
        }

        public Builder fenceGate(Block block) {
            this.family.variants.put(Variant.FENCE_GATE, block);
            return this;
        }

        public Builder button(Block block) {
            this.family.variants.put(Variant.BUTTON, block);
            return this;
        }

        public Builder pressurePlate(Block block) {
            this.family.variants.put(Variant.PRESSURE_PLATE, block);
            return this;
        }

        public Builder trapdoor(Block block) {
            this.family.variants.put(Variant.TRAPDOOR, block);
            return this;
        }

        public Builder door(Block block) {
            this.family.variants.put(Variant.DOOR, block);
            return this;
        }

        public Builder sign(Block standingSign, Block wallSign) {
            this.family.variants.put(Variant.SIGN, standingSign);
            this.family.variants.put(Variant.WALL_SIGN, wallSign);
            return this;
        }

        public Builder hangingSign(Block standingSign, Block wallSign) {
            this.family.variants.put(Variant.HANGING_SIGN, standingSign);
            this.family.variants.put(Variant.WALL_HANGING_SIGN, wallSign);
            return this;
        }

        public Builder wall(Block wall) {
            this.family.variants.put(Variant.WALL, wall);
            return this;
        }

        public Builder polished(Block polished) {
            this.family.variants.put(Variant.POLISHED, polished);
            return this;
        }

        public Builder chiseled(Block chiseled) {
            this.family.variants.put(Variant.CHISELED, chiseled);
            return this;
        }

        public Builder cracked(Block cracked) {
            this.family.variants.put(Variant.CRACKED, cracked);
            return this;
        }

        public Builder cut(Block cut) {
            this.family.variants.put(Variant.CUT, cut);
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
        POLISHED("polished"),
        CHISELED("chiseled"),
        CRACKED("cracked"),
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
                case STRIPPED_WOOD -> STRIPPED_LOG;
                case SIGN -> WALL_SIGN;
                case HANGING_SIGN -> WALL_HANGING_SIGN;
                default -> this;
            };
        }
    }

}