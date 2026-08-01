package com.mysticsbiomes.common.worldgen.surface;

import api.mystanica.registry.RegistryEntry;
import com.mysticsbiomes.init.MysticBiomes;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.SurfaceRules;
import net.minecraft.world.level.levelgen.placement.CaveSurface;

public class MysticSurfaceRules {
    private static final SurfaceRules.RuleSource GRASSY_LUSH_SAND = makeStateRule(MysticBlocks.GRASSY_LUSH_SAND);
    private static final SurfaceRules.RuleSource LUSH_SAND = makeStateRule(MysticBlocks.LUSH_SAND);
    private static final SurfaceRules.RuleSource LUSH_SANDSTONE = makeStateRule(MysticBlocks.LUSH_SANDSTONE);

    private static SurfaceRules.RuleSource makeStateRule(RegistryEntry<Block> block) {
        return SurfaceRules.state(block.get().defaultBlockState());
    }

    public static SurfaceRules.RuleSource mysticRules() {
        SurfaceRules.ConditionSource SURFACE = SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR);
        SurfaceRules.ConditionSource UNDER_SURFACE = SurfaceRules.stoneDepthCheck(5, false, CaveSurface.FLOOR);

        return SurfaceRules.ifTrue(
                SurfaceRules.isBiome(MysticBiomes.LUSH_OASIS),
                SurfaceRules.sequence(

                        // Top block
                        SurfaceRules.ifTrue(
                                SURFACE,
                                SurfaceRules.ifTrue(
                                        SurfaceRules.waterBlockCheck(-1, 0),
                                        GRASSY_LUSH_SAND
                                )
                        ),

                        // First few blocks underneath
                        SurfaceRules.ifTrue(
                                UNDER_SURFACE,
                                LUSH_SAND
                        ),

                        // Below that, sandstone
                        LUSH_SANDSTONE
                )
        );
    }

}