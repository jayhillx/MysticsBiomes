package com.mysticsbiomes.forge.datagen.provider;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.LanguageProvider;

public class MysticLanguageProviders extends LanguageProvider {

    public MysticLanguageProviders(PackOutput output) {
        super(output, MysticsBiomes.modId, "en_us");
    }

    @Override
    protected void addTranslations() {
        MysticsBiomes.getEntriesFromRegistry(BuiltInRegistries.ITEM).forEach(item -> {
            String path = BuiltInRegistries.ITEM.getKey(item).getPath();
            this.add(item, formatName(path));
        });
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