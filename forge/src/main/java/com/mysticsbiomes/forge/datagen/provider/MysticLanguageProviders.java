package com.mysticsbiomes.forge.datagen.provider;

import com.mysticsbiomes.MysticsBiomes;
import com.mysticsbiomes.init.MysticBiomes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.data.LanguageProvider;

public class MysticLanguageProviders extends LanguageProvider {

    public MysticLanguageProviders(PackOutput output) {
        super(output, MysticsBiomes.modId, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.add("itemGroup.mysticsbiomes", "Mystic's Biomes");
        this.addBiome(MysticBiomes.STRAWBERRY_FIELDS);
        this.addBiome(MysticBiomes.LAVENDER_MEADOW);
        this.addBiome(MysticBiomes.BAMBOO_BLOSSOM_FOREST);
        this.addBiome(MysticBiomes.AUTUMNAL_GROVE);
        this.addBiome(MysticBiomes.LUSH_OASIS);
        this.addBiome(MysticBiomes.LAGOON);
        this.addBiome(MysticBiomes.TROPICS);

        MysticsBiomes.getEntriesFromRegistry(BuiltInRegistries.ITEM).forEach(item -> {
            String path = BuiltInRegistries.ITEM.getKey(item).getPath();
            this.add(item, formatName(path));
        });
        this.add("item.mysticsbiomes.bug_habitat.butterfly", "Butterfly in Jar");
        this.add("item.mysticsbiomes.bug_habitat.caterpillar", "Caterpillar in Jar");

        MysticsBiomes.getEntriesFromRegistry(BuiltInRegistries.ENTITY_TYPE).forEach(entityType -> {
            String path = BuiltInRegistries.ENTITY_TYPE.getKey(entityType).getPath();
            this.add(entityType, formatName(path));
        });
        this.add("entity.mysticsbiomes.rainbow_chicken.pink", "Pink Chicken");
        this.add("entity.mysticsbiomes.rainbow_chicken.orange", "Orange Chicken");
        this.add("entity.mysticsbiomes.rainbow_chicken.yellow", "Yellow Chicken");
        this.add("entity.mysticsbiomes.rainbow_chicken.lime", "Lime Chicken");
        this.add("entity.mysticsbiomes.rainbow_chicken.cyan", "Cyan Chicken");
        this.add("entity.mysticsbiomes.rainbow_chicken.purple", "Purple Chicken");
        this.add("entity.mysticsbiomes.rainbow_chicken.rainbow", "Rainbow Chicken");
        this.add("entity.mysticsbiomes.butterfly.monarch", "Monarch");
        this.add("entity.mysticsbiomes.butterfly.morpho", "Morpho");
        this.add("entity.mysticsbiomes.butterfly.blue", "Blue");
        this.add("entity.mysticsbiomes.butterfly.luna_moth", "Luna Moth");

        this.add("advancements.mysticsbiomes.root.title", "Mystic's Biomes");
        this.add("advancements.mysticsbiomes.root.description", "Explore the world!");

        this.add("advancements.mysticsbiomes.obtain_cherries.title", "Very Cherry");
        this.add("advancements.mysticsbiomes.obtain_cherries.description", "Obtain cherries");

        this.add("advancements.mysticsbiomes.obtain_peach.title", "mmm... Peachy");
        this.add("advancements.mysticsbiomes.obtain_peach.description", "Obtain a peach");

        this.add("advancements.mysticsbiomes.obtain_sweet_strawberry.title", "Sweet Treat");
        this.add("advancements.mysticsbiomes.obtain_sweet_strawberry.description", "Obtain a sweet strawberry.\nHarvest one from a sweet strawberry bush.");
        this.add("advancements.mysticsbiomes.craft_sweet_strawberry_cake.title", "The Sweetest of Cakes");
        this.add("advancements.mysticsbiomes.craft_sweet_strawberry_cake.description", "Craft a sweet strawberry cake");

        this.add("advancements.mysticsbiomes.craft_frosted_cakes.title", "Colorful Bakery");
        this.add("advancements.mysticsbiomes.craft_frosted_cakes.description", "Craft all 6 frosted cakes");

        this.add("advancements.mysticsbiomes.craft_neapolitan_cakes.title", "Cake Connoisseur");
        this.add("advancements.mysticsbiomes.craft_neapolitan_cakes.description", "Craft a strawberry, vanilla, and chocolate cake");

        this.add("advancements.mysticsbiomes.thief.title", "THIEF!");
        this.add("advancements.mysticsbiomes.thief.description", "Have an item stolen from your inventory by a Mischievous Red Panda");

        this.add("subtitles.entity.red_panda.ambient", "Red Panda pants");
        this.add("subtitles.entity.red_panda.aggressive_ambient", "Red Panda huffs");
        this.add("subtitles.entity.red_panda.step", "Red Panda steps");
        this.add("subtitles.entity.red_panda.hurt", "Red Panda hurts");
        this.add("subtitles.entity.red_panda.bite", "Red Panda bites");
        this.add("subtitles.entity.red_panda.spit", "Red Panda spits");
        this.add("subtitles.entity.red_panda.sleep", "Red Panda snores");
        this.add("subtitles.entity.red_panda.shake", "Red Panda shakes");
        this.add("subtitles.entity.red_panda.eat", "Red Panda eats");
        this.add("subtitles.entity.red_panda.death", "Red Panda dies");
        this.add("subtitles.entity.red_panda.pre_sneeze", "Red Panda's nose tickles");
        this.add("subtitles.entity.red_panda.sneeze", "Red Panda sneezes");
        this.add("subtitles.block.butterfly_nest.enter", "Butterfly enters nest");
        this.add("subtitles.block.butterfly_nest.exit", "Butterfly leaves nest");
    }
    
    private void addBiome(ResourceKey<Biome> biomeKey) {
        String name = biomeKey.location().getPath();
        this.add("biome.mysticsbiomes." + name, formatName(name));
    }

    private static String formatName(String path) {
        String[] spaces = path.split("_");
        StringBuilder name = new StringBuilder();

        for (String part : spaces) {
            name.append(Character.toUpperCase(part.charAt(0)))
                    .append(part.substring(1))
                    .append(" ");
        }

        return name.toString().trim();
    }

}