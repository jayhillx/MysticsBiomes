package com.mysticsbiomes.init;

import com.mysticsbiomes.common.util.BlockDataUtils;

public class MysticVanillaCompat {

    public static class Client {

    }

    public static class Common {

        public static void registerFlammables() {
            BlockDataUtils.flammable(MysticBlocks.STRAWBERRY_PLANKS.get(), 5, 20);
        }
    }

}