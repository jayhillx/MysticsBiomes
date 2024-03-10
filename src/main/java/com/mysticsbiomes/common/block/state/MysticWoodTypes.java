package com.mysticsbiomes.common.block.state;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraft.world.level.block.state.properties.WoodType.register;

public class MysticWoodTypes {

    public static final WoodType STRAWBERRY = register(new WoodType(MysticsBiomes.modId + ":strawberry", MysticBlockSetTypes.STRAWBERRY));
    public static final WoodType CHERRY = register(new WoodType(MysticsBiomes.modId + ":cherry", MysticBlockSetTypes.CHERRY));
    public static final WoodType CITRUS = register(new WoodType(MysticsBiomes.modId + ":citrus", MysticBlockSetTypes.CITRUS));
    public static final WoodType MAPLE = register(new WoodType(MysticsBiomes.modId + ":maple", MysticBlockSetTypes.MAPLE));
    public static final WoodType JACARANDA = register(new WoodType(MysticsBiomes.modId + ":jacaranda", MysticBlockSetTypes.JACARANDA));

    /**
     * Register new wood types. (Enqueued in {@link MysticsBiomes::clientSetup})
     */
    @OnlyIn(Dist.CLIENT)
    public static void registerWoodTypes() {
        Sheets.addWoodType(STRAWBERRY);
        Sheets.addWoodType(CHERRY);
        Sheets.addWoodType(CITRUS);
        Sheets.addWoodType(MAPLE);
        Sheets.addWoodType(JACARANDA);
    }

}