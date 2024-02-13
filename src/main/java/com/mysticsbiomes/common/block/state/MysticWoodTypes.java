package com.mysticsbiomes.common.block.state;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraft.world.level.block.state.properties.WoodType.register;

public class MysticWoodTypes {

    public static final WoodType STRAWBERRY = register(WoodType.create(MysticsBiomes.modId + ":strawberry"));
    public static final WoodType CHERRY = register(WoodType.create(MysticsBiomes.modId + ":cherry"));
    public static final WoodType JACARANDA = register(WoodType.create(MysticsBiomes.modId + ":jacaranda"));
    public static final WoodType MAPLE = register(WoodType.create(MysticsBiomes.modId + ":maple"));

    /**
     * Register new wood types. (Enqueued in {@link MysticsBiomes::clientSetup})
     */
    @OnlyIn(Dist.CLIENT)
    public static void registerWoodTypes() {
        Sheets.addWoodType(STRAWBERRY);
        Sheets.addWoodType(CHERRY);
        Sheets.addWoodType(JACARANDA);
        Sheets.addWoodType(MAPLE);
    }

}