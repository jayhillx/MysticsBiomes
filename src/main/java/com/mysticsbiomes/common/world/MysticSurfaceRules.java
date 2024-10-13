package com.mysticsbiomes.common.world;

import com.google.common.collect.ImmutableList;
import com.mysticsbiomes.init.MysticBiomes;
import com.mysticsbiomes.init.MysticBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.YOffset;
import net.minecraft.world.gen.noise.NoiseParametersKeys;
import net.minecraft.world.gen.surfacebuilder.MaterialRules;
import net.minecraft.world.gen.surfacebuilder.MaterialRules.*;

public class MysticSurfaceRules {
    private static final MaterialRule AIR = makeStateRule(Blocks.AIR);
    private static final MaterialRule BEDROCK = makeStateRule(Blocks.BEDROCK);
    private static final MaterialRule WHITE_TERRACOTTA = makeStateRule(Blocks.WHITE_TERRACOTTA);
    private static final MaterialRule ORANGE_TERRACOTTA = makeStateRule(Blocks.ORANGE_TERRACOTTA);
    private static final MaterialRule TERRACOTTA = makeStateRule(Blocks.TERRACOTTA);
    private static final MaterialRule RED_SAND = makeStateRule(Blocks.RED_SAND);
    private static final MaterialRule RED_SANDSTONE = makeStateRule(Blocks.RED_SANDSTONE);
    private static final MaterialRule STONE = makeStateRule(Blocks.STONE);
    private static final MaterialRule DEEPSLATE = makeStateRule(Blocks.DEEPSLATE);
    private static final MaterialRule DIRT = makeStateRule(Blocks.DIRT);
    private static final MaterialRule PODZOL = makeStateRule(Blocks.PODZOL);
    private static final MaterialRule COARSE_DIRT = makeStateRule(Blocks.COARSE_DIRT);
    private static final MaterialRule MYCELIUM = makeStateRule(Blocks.MYCELIUM);
    private static final MaterialRule GRASS_BLOCK = makeStateRule(Blocks.GRASS_BLOCK);
    private static final MaterialRule CALCITE = makeStateRule(Blocks.CALCITE);
    private static final MaterialRule GRAVEL = makeStateRule(Blocks.GRAVEL);
    private static final MaterialRule SAND = makeStateRule(Blocks.SAND);
    private static final MaterialRule SANDSTONE = makeStateRule(Blocks.SANDSTONE);
    private static final MaterialRule PACKED_ICE = makeStateRule(Blocks.PACKED_ICE);
    private static final MaterialRule SNOW_BLOCK = makeStateRule(Blocks.SNOW_BLOCK);
    private static final MaterialRule POWDER_SNOW = makeStateRule(Blocks.POWDER_SNOW);
    private static final MaterialRule ICE = makeStateRule(Blocks.ICE);
    private static final MaterialRule WATER = makeStateRule(Blocks.WATER);

    private static final MaterialRule GRASSY_LUSH_SAND = makeStateRule(MysticBlocks.GRASSY_LUSH_SAND);
    private static final MaterialRule LUSH_SAND = makeStateRule(MysticBlocks.LUSH_SAND);
    private static final MaterialRule LUSH_SANDSTONE = makeStateRule(MysticBlocks.LUSH_SANDSTONE);

    private static MaterialRule makeStateRule(Block block) {
        return MaterialRules.block(block.getDefaultState());
    }

    public static MaterialRule overworld() {
        return overworldLike(true, false, true);
    }

    public static MaterialRule overworldLike(boolean surface, boolean nether, boolean overworld) {
        MaterialCondition above97 = MaterialRules.aboveY(YOffset.fixed(97), 2);
        MaterialCondition above256 = MaterialRules.aboveY(YOffset.fixed(256), 0);
        MaterialCondition above63_1 = MaterialRules.aboveYWithStoneDepth(YOffset.fixed(63), -1);
        MaterialCondition above74 = MaterialRules.aboveYWithStoneDepth(YOffset.fixed(74), 1);
        MaterialCondition above62 = MaterialRules.aboveY(YOffset.fixed(62), 0);
        MaterialCondition above63_0 = MaterialRules.aboveY(YOffset.fixed(63), 0);
        MaterialCondition isAtOrAboveWaterLevel = MaterialRules.water(-1, 0);
        MaterialCondition isAboveWaterLevel = MaterialRules.water(0, 0);
        MaterialCondition MaterialCondition8 = MaterialRules.water(-6, -1);
        MaterialCondition isHole = MaterialRules.hole();
        MaterialCondition isFrozenOcean = MaterialRules.biome(BiomeKeys.FROZEN_OCEAN, BiomeKeys.DEEP_FROZEN_OCEAN);
        MaterialCondition isSteep = MaterialRules.steepSlope();
        MaterialRule grassSurface = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASS_BLOCK), DIRT);
        MaterialRule sandstoneLinedSand = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, SANDSTONE), SAND);
        MaterialRule stoneLinedGravel = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, STONE), GRAVEL);
        MaterialCondition isSandstoneLiningBiome = MaterialRules.biome(BiomeKeys.WARM_OCEAN, BiomeKeys.DESERT, BiomeKeys.BEACH, BiomeKeys.SNOWY_BEACH, MysticBiomes.LAGOON);
        MaterialRule MaterialRule3 = MaterialRules.sequence(mysticRule(), MaterialRules.condition(MaterialRules.biome(BiomeKeys.STONY_PEAKS), MaterialRules.sequence(MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.CALCITE, -0.0125D, 0.0125D), CALCITE), STONE)), MaterialRules.condition(MaterialRules.biome(BiomeKeys.STONY_SHORE), MaterialRules.sequence(MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.GRAVEL, -0.05D, 0.05D), stoneLinedGravel), STONE)), MaterialRules.condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_HILLS), MaterialRules.condition(surfaceNoiseAbove(1.0D), STONE)), MaterialRules.condition(isSandstoneLiningBiome, sandstoneLinedSand), MaterialRules.condition(MaterialRules.biome(BiomeKeys.DRIPSTONE_CAVES), STONE));
        MaterialRule MaterialRule4 = MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.POWDER_SNOW, 0.45D, 0.58D), POWDER_SNOW);
        MaterialRule MaterialRule5 = MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.POWDER_SNOW, 0.35D, 0.6D), POWDER_SNOW);
        MaterialRule MaterialRule6 = MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(BiomeKeys.FROZEN_PEAKS), MaterialRules.sequence(MaterialRules.condition(isSteep, PACKED_ICE), MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.PACKED_ICE, -0.5D, 0.2D), PACKED_ICE), MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.ICE, -0.0625D, 0.025D), ICE), SNOW_BLOCK)), MaterialRules.condition(MaterialRules.biome(BiomeKeys.SNOWY_SLOPES), MaterialRules.sequence(MaterialRules.condition(isSteep, STONE), MaterialRule4, SNOW_BLOCK)), MaterialRules.condition(MaterialRules.biome(BiomeKeys.JAGGED_PEAKS), STONE), MaterialRules.condition(MaterialRules.biome(BiomeKeys.GROVE), MaterialRules.sequence(MaterialRule4, DIRT)), MaterialRule3, MaterialRules.condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_SAVANNA), MaterialRules.condition(surfaceNoiseAbove(1.75D), STONE)), MaterialRules.condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS), MaterialRules.sequence(MaterialRules.condition(surfaceNoiseAbove(2.0D), stoneLinedGravel), MaterialRules.condition(surfaceNoiseAbove(1.0D), STONE), MaterialRules.condition(surfaceNoiseAbove(-1.0D), DIRT), stoneLinedGravel)), MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(MysticBiomes.LUSH_OASIS), LUSH_SAND), DIRT));
        MaterialRule grassyAndLushSandMix = MaterialRules.sequence(MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.1D, 0.2D), GRASSY_LUSH_SAND), LUSH_SAND);
        MaterialRule grassyLush = MaterialRules.sequence(MaterialRules.condition(isAtOrAboveWaterLevel, GRASSY_LUSH_SAND), LUSH_SAND);
        MaterialRule atOrAboveWaterLevelRules = MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(BiomeKeys.FROZEN_PEAKS), MaterialRules.sequence(MaterialRules.condition(isSteep, PACKED_ICE), MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.PACKED_ICE, 0.0D, 0.2D), PACKED_ICE), MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.ICE, 0.0D, 0.025D), ICE), SNOW_BLOCK)), MaterialRules.condition(MaterialRules.biome(BiomeKeys.SNOWY_SLOPES), MaterialRules.sequence(MaterialRules.condition(isSteep, STONE), MaterialRule5, SNOW_BLOCK)), MaterialRules.condition(MaterialRules.biome(BiomeKeys.JAGGED_PEAKS), MaterialRules.sequence(MaterialRules.condition(isSteep, STONE), SNOW_BLOCK)), MaterialRules.condition(MaterialRules.biome(BiomeKeys.GROVE), MaterialRules.sequence(MaterialRule5, SNOW_BLOCK)), MaterialRule3, MaterialRules.condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_SAVANNA), MaterialRules.sequence(MaterialRules.condition(surfaceNoiseAbove(1.75D), STONE), MaterialRules.condition(surfaceNoiseAbove(-0.5D), COARSE_DIRT))), MaterialRules.condition(MaterialRules.biome(BiomeKeys.WINDSWEPT_GRAVELLY_HILLS), MaterialRules.sequence(MaterialRules.condition(surfaceNoiseAbove(2.0D), stoneLinedGravel), MaterialRules.condition(surfaceNoiseAbove(1.0D), STONE), MaterialRules.condition(surfaceNoiseAbove(-1.0D), grassSurface), stoneLinedGravel)), MaterialRules.condition(MaterialRules.biome(BiomeKeys.OLD_GROWTH_PINE_TAIGA, BiomeKeys.OLD_GROWTH_SPRUCE_TAIGA), MaterialRules.sequence(MaterialRules.condition(surfaceNoiseAbove(1.75D), COARSE_DIRT), MaterialRules.condition(surfaceNoiseAbove(-0.95D), PODZOL))), MaterialRules.condition(MaterialRules.biome(BiomeKeys.ICE_SPIKES), SNOW_BLOCK), MaterialRules.condition(MaterialRules.biome(BiomeKeys.MUSHROOM_FIELDS), MYCELIUM), MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(MysticBiomes.LUSH_OASIS), grassyLush)), grassSurface);
        MaterialCondition MaterialCondition13 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.909D, -0.5454D);
        MaterialCondition MaterialCondition14 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, -0.1818D, 0.1818D);
        MaterialCondition MaterialCondition15 = MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, 0.5454D, 0.909D);
        MaterialRules.MaterialRule isLushSandstone = MaterialRules.sequence(LUSH_SANDSTONE);
        MaterialRule surfaceRules = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(BiomeKeys.WOODED_BADLANDS), MaterialRules.condition(above97, MaterialRules.sequence(MaterialRules.condition(MaterialCondition13, COARSE_DIRT), MaterialRules.condition(MaterialCondition14, COARSE_DIRT), MaterialRules.condition(MaterialCondition15, COARSE_DIRT), grassSurface))), MaterialRules.condition(MaterialRules.biome(BiomeKeys.SWAMP), MaterialRules.condition(above62, MaterialRules.condition(MaterialRules.not(above63_0), MaterialRules.condition(MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE_SWAMP, 0.0D), WATER)))))), MaterialRules.condition(MaterialRules.biome(BiomeKeys.BADLANDS, BiomeKeys.ERODED_BADLANDS, BiomeKeys.WOODED_BADLANDS), MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, MaterialRules.sequence(MaterialRules.condition(above256, ORANGE_TERRACOTTA), MaterialRules.condition(above74, MaterialRules.sequence(MaterialRules.condition(MaterialCondition13, TERRACOTTA), MaterialRules.condition(MaterialCondition14, TERRACOTTA), MaterialRules.condition(MaterialCondition15, TERRACOTTA), MaterialRules.terracottaBands())), MaterialRules.condition(isAtOrAboveWaterLevel, MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, RED_SANDSTONE), RED_SAND)), MaterialRules.condition(MaterialRules.not(isHole), ORANGE_TERRACOTTA), MaterialRules.condition(MaterialCondition8, WHITE_TERRACOTTA), stoneLinedGravel)), MaterialRules.condition(above63_1, MaterialRules.sequence(MaterialRules.condition(above63_0, MaterialRules.condition(MaterialRules.not(above74), ORANGE_TERRACOTTA)), MaterialRules.terracottaBands())), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, MaterialRules.condition(MaterialCondition8, WHITE_TERRACOTTA)))), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, MaterialRules.condition(isAtOrAboveWaterLevel, MaterialRules.sequence(MaterialRules.condition(isFrozenOcean, MaterialRules.condition(isHole, MaterialRules.sequence(MaterialRules.condition(isAboveWaterLevel, AIR), MaterialRules.condition(MaterialRules.temperature(), ICE), WATER))), atOrAboveWaterLevelRules))), MaterialRules.condition(MaterialCondition8, MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, MaterialRules.condition(isFrozenOcean, MaterialRules.condition(isHole, WATER))), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, MaterialRule6), MaterialRules.condition(isSandstoneLiningBiome, MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, SANDSTONE)), MaterialRules.condition(MaterialRules.biome(MysticBiomes.LUSH_OASIS), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR, isLushSandstone)))), MaterialRules.condition(MaterialRules.STONE_DEPTH_FLOOR_WITH_SURFACE_DEPTH, MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(BiomeKeys.FROZEN_PEAKS, BiomeKeys.JAGGED_PEAKS), STONE), MaterialRules.condition(MaterialRules.biome(BiomeKeys.WARM_OCEAN, BiomeKeys.LUKEWARM_OCEAN, BiomeKeys.DEEP_LUKEWARM_OCEAN), sandstoneLinedSand), stoneLinedGravel)));

        ImmutableList.Builder<MaterialRule> bedrockBuilder = ImmutableList.builder();
        if (nether) {
            bedrockBuilder.add(MaterialRules.condition(MaterialRules.not(MaterialRules.verticalGradient("bedrock_roof", YOffset.belowTop(5), YOffset.getTop())), BEDROCK));
        }
        if (overworld) {
            bedrockBuilder.add(MaterialRules.condition(MaterialRules.verticalGradient("bedrock_floor", YOffset.getBottom(), YOffset.aboveBottom(5)), BEDROCK));
        }
        MaterialRule surfaceSurface = MaterialRules.condition(MaterialRules.surface(), surfaceRules);
        bedrockBuilder.add(surface ? surfaceSurface : surfaceRules);
        bedrockBuilder.add(MaterialRules.condition(MaterialRules.verticalGradient("deepslate", YOffset.fixed(0), YOffset.fixed(8)), DEEPSLATE));
        return MaterialRules.sequence(bedrockBuilder.build().toArray(MaterialRule[]::new));
    }

    private static MaterialRules.MaterialRule mysticRule() {
        MaterialRule lushOasisSurface = MaterialRules.condition(surfaceNoiseAbove(0.1D), LUSH_SAND);
        MaterialRule lagoonSurface = MaterialRules.sequence(MaterialRules.condition(MaterialRules.STONE_DEPTH_CEILING, SANDSTONE), SAND);
        return MaterialRules.sequence(MaterialRules.condition(MaterialRules.biome(MysticBiomes.LUSH_OASIS), lushOasisSurface), MaterialRules.condition(MaterialRules.biome(MysticBiomes.LAGOON), lagoonSurface));
    }

    private static MaterialRules.MaterialCondition surfaceNoiseAbove(double value) {
        return MaterialRules.noiseThreshold(NoiseParametersKeys.SURFACE, value / 8.25D, Double.MAX_VALUE);
    }

}