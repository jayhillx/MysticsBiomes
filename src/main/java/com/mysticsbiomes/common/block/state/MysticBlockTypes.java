package com.mysticsbiomes.common.block.state;

import com.mysticsbiomes.MysticsBiomes;
import net.minecraft.client.renderer.Sheets;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import static net.minecraft.world.level.block.state.properties.WoodType.register;

public class MysticBlockTypes {

    public static class Sets {
        public static final BlockSetType STRAWBERRY = BlockSetType.register(new BlockSetType(MysticsBiomes.modId + ":strawberry"));
        public static final BlockSetType CHERRY = BlockSetType.register(new BlockSetType(MysticsBiomes.modId + ":cherry"));
        public static final BlockSetType JACARANDA = BlockSetType.register(new BlockSetType(MysticsBiomes.modId + ":jacaranda"));
    }

    public static class Wood {
        public static final WoodType STRAWBERRY = register(new WoodType(MysticsBiomes.modId + ":strawberry", Sets.STRAWBERRY));
        public static final WoodType CHERRY = register(new WoodType(MysticsBiomes.modId + ":cherry", Sets.CHERRY));
        public static final WoodType JACARANDA = register(new WoodType(MysticsBiomes.modId + ":jacaranda", Sets.JACARANDA));

        /**
         * Register new wood types. (Enqueued in {@link MysticsBiomes::clientSetup})
         */
        @OnlyIn(Dist.CLIENT)
        public static void registerWoodTypes() {
            Sheets.addWoodType(STRAWBERRY);
            Sheets.addWoodType(CHERRY);
            Sheets.addWoodType(JACARANDA);
        }
    }

}