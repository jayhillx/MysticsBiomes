package com.mysticsbiomes.common.biome;

import com.mojang.datafixers.util.Pair;
import com.mysticsbiomes.init.MysticBiomes;
import net.minecraft.SharedConstants;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.registries.VanillaRegistries;
import net.minecraft.data.worldgen.TerrainProvider;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.CubicSpline;
import net.minecraft.util.ToFloatFunction;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import net.minecraft.world.level.levelgen.DensityFunction;
import net.minecraft.world.level.levelgen.DensityFunctions;
import net.minecraft.world.level.levelgen.NoiseRouterData;

import java.util.function.Consumer;

public class MysticBiomeBuilder {
    private final Climate.Parameter FULL_RANGE = Climate.Parameter.span(-1.0F, 1.0F);
    private final Climate.Parameter[] temperatures = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.45F), Climate.Parameter.span(-0.45F, -0.15F), Climate.Parameter.span(-0.15F, 0.2F), Climate.Parameter.span(0.2F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter[] humidities = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.35F), Climate.Parameter.span(-0.35F, -0.1F), Climate.Parameter.span(-0.1F, 0.1F), Climate.Parameter.span(0.1F, 0.3F), Climate.Parameter.span(0.3F, 1.0F)};
    private final Climate.Parameter[] erosions = new Climate.Parameter[]{Climate.Parameter.span(-1.0F, -0.78F), Climate.Parameter.span(-0.78F, -0.375F), Climate.Parameter.span(-0.375F, -0.2225F), Climate.Parameter.span(-0.2225F, 0.05F), Climate.Parameter.span(0.05F, 0.45F), Climate.Parameter.span(0.45F, 0.55F), Climate.Parameter.span(0.55F, 1.0F)};
    private final Climate.Parameter FROZEN_RANGE = this.temperatures[0];
    private final Climate.Parameter UNFROZEN_RANGE = Climate.Parameter.span(this.temperatures[1], this.temperatures[4]);
    private final Climate.Parameter mushroomFieldsContinentalness = Climate.Parameter.span(-1.2F, -1.05F);
    private final Climate.Parameter deepOceanContinentalness = Climate.Parameter.span(-1.05F, -0.455F);
    private final Climate.Parameter oceanContinentalness = Climate.Parameter.span(-0.455F, -0.19F);
    private final Climate.Parameter coastContinentalness = Climate.Parameter.span(-0.19F, -0.11F);
    private final Climate.Parameter inlandContinentalness = Climate.Parameter.span(-0.11F, 0.55F);
    private final Climate.Parameter nearInlandContinentalness = Climate.Parameter.span(-0.11F, 0.03F);
    private final Climate.Parameter midInlandContinentalness = Climate.Parameter.span(0.03F, 0.3F);
    private final Climate.Parameter farInlandContinentalness = Climate.Parameter.span(0.3F, 1.0F);
    private final ResourceKey<Biome>[][] OCEANS = new ResourceKey[][]{{Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN, Biomes.WARM_OCEAN}, {Biomes.FROZEN_OCEAN, Biomes.COLD_OCEAN, Biomes.OCEAN, Biomes.LUKEWARM_OCEAN, Biomes.WARM_OCEAN}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES = new ResourceKey[][]{{Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.TAIGA}, {Biomes.PLAINS, Biomes.PLAINS, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA}, {Biomes.FLOWER_FOREST, Biomes.PLAINS, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.DARK_FOREST}, {Biomes.SAVANNA, Biomes.SAVANNA, Biomes.FOREST, Biomes.JUNGLE, Biomes.JUNGLE}, {Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT, Biomes.DESERT}};
    private final ResourceKey<Biome>[][] MIDDLE_BIOMES_VARIANT = new ResourceKey[][]{{Biomes.ICE_SPIKES, null, Biomes.SNOWY_TAIGA, null, null}, {null, null, null, null, Biomes.OLD_GROWTH_PINE_TAIGA}, {Biomes.SUNFLOWER_PLAINS, null, null, Biomes.OLD_GROWTH_BIRCH_FOREST, null}, {null, null, Biomes.PLAINS, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE}, {null, null, null, null, null}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES = new ResourceKey[][]{{Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_PLAINS, Biomes.SNOWY_TAIGA, Biomes.SNOWY_TAIGA}, {Biomes.MEADOW, Biomes.MEADOW, Biomes.FOREST, Biomes.TAIGA, Biomes.OLD_GROWTH_SPRUCE_TAIGA}, {Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.MEADOW, Biomes.DARK_FOREST}, {Biomes.SAVANNA_PLATEAU, Biomes.SAVANNA_PLATEAU, Biomes.FOREST, Biomes.FOREST, Biomes.JUNGLE}, {Biomes.BADLANDS, Biomes.BADLANDS, Biomes.BADLANDS, Biomes.WOODED_BADLANDS, Biomes.WOODED_BADLANDS}};
    private final ResourceKey<Biome>[][] PLATEAU_BIOMES_VARIANT = new ResourceKey[][]{{Biomes.ICE_SPIKES, null, null, null, null}, {Biomes.CHERRY_GROVE, null, Biomes.MEADOW, Biomes.MEADOW, Biomes.OLD_GROWTH_PINE_TAIGA}, {Biomes.CHERRY_GROVE, Biomes.CHERRY_GROVE, Biomes.FOREST, Biomes.BIRCH_FOREST, null}, {null, null, null, null, null}, {Biomes.ERODED_BADLANDS, Biomes.ERODED_BADLANDS, null, null, null}};
    private final ResourceKey<Biome>[][] SHATTERED_BIOMES = new ResourceKey[][]{{Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, {Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_GRAVELLY_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, {Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_HILLS, Biomes.WINDSWEPT_FOREST, Biomes.WINDSWEPT_FOREST}, {null, null, null, null, null}, {null, null, null, null, null}};

    public void addBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
        if (SharedConstants.debugGenerateSquareTerrainWithoutNoise) {
            this.addDebugBiomes(consumer);
        } else {
            this.addOffCoastBiomes(consumer);
            this.addInlandBiomes(consumer);
            this.addUndergroundBiomes(consumer);
        }
    }

    private void addDebugBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
        HolderLookup.Provider provider = VanillaRegistries.createLookup();
        HolderGetter<DensityFunction> densityHolder = provider.lookupOrThrow(Registries.DENSITY_FUNCTION);
        DensityFunctions.Spline.Coordinate coordinate = new DensityFunctions.Spline.Coordinate(densityHolder.getOrThrow(NoiseRouterData.CONTINENTS));
        DensityFunctions.Spline.Coordinate coordinate1 = new DensityFunctions.Spline.Coordinate(densityHolder.getOrThrow(NoiseRouterData.EROSION));
        DensityFunctions.Spline.Coordinate coordinate2 = new DensityFunctions.Spline.Coordinate(densityHolder.getOrThrow(NoiseRouterData.RIDGES_FOLDED));
        consumer.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.01F), Biomes.PLAINS));
        CubicSpline<?, ?> spline = TerrainProvider.buildErosionOffsetSpline(coordinate1, coordinate2, -0.15F, 0.0F, 0.0F, 0.1F, 0.0F, -0.03F, false, false, ToFloatFunction.IDENTITY);
        if (spline instanceof CubicSpline.Multipoint<?, ?> multipoint) {
            ResourceKey<Biome> desert = Biomes.DESERT;

            for (float f : multipoint.locations()) {
                consumer.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(f), Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.0F), desert));
                desert = desert == Biomes.DESERT ? Biomes.BADLANDS : Biomes.DESERT;
            }
        }

        CubicSpline<?, ?> spline1 = TerrainProvider.overworldOffset(coordinate, coordinate1, coordinate2, false);
        if (spline1 instanceof CubicSpline.Multipoint<?, ?> multipoint1) {
            for (float f1 : multipoint1.locations()) {
                consumer.accept(Pair.of(Climate.parameters(this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.point(f1), this.FULL_RANGE, Climate.Parameter.point(0.0F), this.FULL_RANGE, 0.0F), Biomes.SNOWY_TAIGA));
            }
        }
    }

    private void addOffCoastBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
        this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.mushroomFieldsContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.MUSHROOM_FIELDS);

        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];
            this.addSurfaceBiome(consumer, temperature, this.FULL_RANGE, this.deepOceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[0][i]);
            this.addSurfaceBiome(consumer, temperature, this.FULL_RANGE, this.oceanContinentalness, this.FULL_RANGE, this.FULL_RANGE, 0.0F, this.OCEANS[1][i]);
        }
    }

    private void addInlandBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
        this.addMidSlice(consumer, Climate.Parameter.span(-1.0F, -0.93333334F));
        this.addHighSlice(consumer, Climate.Parameter.span(-0.93333334F, -0.7666667F));
        this.addPeaks(consumer, Climate.Parameter.span(-0.7666667F, -0.56666666F));
        this.addHighSlice(consumer, Climate.Parameter.span(-0.56666666F, -0.4F));
        this.addMidSlice(consumer, Climate.Parameter.span(-0.4F, -0.26666668F));
        this.addLowSlice(consumer, Climate.Parameter.span(-0.26666668F, -0.05F));
        this.addValleys(consumer, Climate.Parameter.span(-0.05F, 0.05F));
        this.addLowSlice(consumer, Climate.Parameter.span(0.05F, 0.26666668F));
        this.addMidSlice(consumer, Climate.Parameter.span(0.26666668F, 0.4F));
        this.addHighSlice(consumer, Climate.Parameter.span(0.4F, 0.56666666F));
        this.addPeaks(consumer, Climate.Parameter.span(0.56666666F, 0.7666667F));
        this.addHighSlice(consumer, Climate.Parameter.span(0.7666667F, 0.93333334F));
        this.addMidSlice(consumer, Climate.Parameter.span(0.93333334F, 1.0F));
    }

    private void addPeaks(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];
            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> key = this.pickMiddleBiome(i, j, parameter);
                ResourceKey<Biome> key1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                ResourceKey<Biome> key2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, parameter);
                ResourceKey<Biome> key3 = this.pickPlateauBiome(i, j, parameter);
                ResourceKey<Biome> key4 = this.pickShatteredBiome(i, j, parameter);
                ResourceKey<Biome> key5 = this.maybePickWindsweptSavannaBiome(i, j, parameter, key4);
                ResourceKey<Biome> key6 = this.pickPeakBiome(i, j, parameter);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[0], parameter, 0.0F, key6);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[1], parameter, 0.0F, key2);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], parameter, 0.0F, key6);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), parameter, 0.0F, key);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], parameter, 0.0F, key3);
                this.addSurfaceBiome(consumer, temperature, humidity, this.midInlandContinentalness, this.erosions[3], parameter, 0.0F, key1);
                this.addSurfaceBiome(consumer, temperature, humidity, this.farInlandContinentalness, this.erosions[3], parameter, 0.0F, key3);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, key);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], parameter, 0.0F, key5);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, key4);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, key);
            }
        }
    }

    private void addHighSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];
            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> key = this.pickMiddleBiome(i, j, parameter);
                ResourceKey<Biome> key1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                ResourceKey<Biome> key2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, parameter);
                ResourceKey<Biome> key3 = this.pickPlateauBiome(i, j, parameter);
                ResourceKey<Biome> key4 = this.pickShatteredBiome(i, j, parameter);
                ResourceKey<Biome> key5 = this.maybePickWindsweptSavannaBiome(i, j, parameter, key);
                ResourceKey<Biome> key6 = this.pickSlopeBiome(i, j, parameter);
                ResourceKey<Biome> key7 = this.pickPeakBiome(i, j, parameter);
                this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, key);
                this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, this.erosions[0], parameter, 0.0F, key6);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[0], parameter, 0.0F, key7);
                this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, this.erosions[1], parameter, 0.0F, key2);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[1], parameter, 0.0F, key6);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), parameter, 0.0F, key);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[2], parameter, 0.0F, key3);
                this.addSurfaceBiome(consumer, temperature, humidity, this.midInlandContinentalness, this.erosions[3], parameter, 0.0F, key1);
                this.addSurfaceBiome(consumer, temperature, humidity, this.farInlandContinentalness, this.erosions[3], parameter, 0.0F, key3);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, key);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[5], parameter, 0.0F, key5);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, key4);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, key);
            }
        }
    }

    private void addMidSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
        this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), parameter, 0.0F, Biomes.STONY_SHORE);
        this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, Biomes.SWAMP);
        this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, Biomes.MANGROVE_SWAMP);

        this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[0], this.temperatures[1]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, MysticBiomes.BAMBOO_BLOSSOM_FOREST);

        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];
            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> key = this.pickMiddleBiome(i, j, parameter);
                //ResourceKey<Biome> keyMystic = this.pickMiddleBiomeMystic(i, j, parameter);
                ResourceKey<Biome> key1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                ResourceKey<Biome> key2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, parameter);
                ResourceKey<Biome> key3 = this.pickShatteredBiome(i, j, parameter);
                ResourceKey<Biome> key4 = this.pickPlateauBiome(i, j, parameter);
                ResourceKey<Biome> key5 = this.pickBeachBiome(i);
                ResourceKey<Biome> key6 = this.maybePickWindsweptSavannaBiome(i, j, parameter, key);
                ResourceKey<Biome> key7 = this.pickShatteredCoastBiome(i, j, parameter);
                ResourceKey<Biome> key8 = this.pickSlopeBiome(i, j, parameter);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[0], parameter, 0.0F, key8);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.midInlandContinentalness), this.erosions[1], parameter, 0.0F, key2);
                this.addSurfaceBiome(consumer, temperature, humidity, this.farInlandContinentalness, this.erosions[1], parameter, 0.0F, i == 0 ? key8 : key4);
                this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, this.erosions[2], parameter, 0.0F, key);
                this.addSurfaceBiome(consumer, temperature, humidity, this.midInlandContinentalness, this.erosions[2], parameter, 0.0F, key1);
                this.addSurfaceBiome(consumer, temperature, humidity, this.farInlandContinentalness, this.erosions[2], parameter, 0.0F, key4);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], parameter, 0.0F, key);
                //this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.nearInlandContinentalness), this.erosions[3], parameter, 0.0F, keyMystic);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[3], parameter, 0.0F, key1);
                if (parameter.max() < 0L) {
                    this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[4], parameter, 0.0F, key5);
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, key);
                    //this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, keyMystic);
                } else {
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, key);
                    //this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, keyMystic);
                }

                this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[5], parameter, 0.0F, key7);
                this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, this.erosions[5], parameter, 0.0F, key6);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, key3);
                if (parameter.max() < 0L) {
                    this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[6], parameter, 0.0F, key5);
                } else {
                    this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[6], parameter, 0.0F, key);
                }

                if (i == 0) {
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, key);
                }
            }
        }
    }

    private void addLowSlice(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
        this.addSurfaceBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[2]), parameter, 0.0F, Biomes.STONY_SHORE);
        this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, Biomes.SWAMP);
        this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, Biomes.MANGROVE_SWAMP);

        this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, MysticBiomes.BAMBOO_BLOSSOM_FOREST);

        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];
            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> key = this.pickMiddleBiome(i, j, parameter);
                ResourceKey<Biome> keyMystic = this.pickMiddleBiomeMB(i, j, parameter);
                ResourceKey<Biome> key1 = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                ResourceKey<Biome> key2 = this.pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(i, j, parameter);
                ResourceKey<Biome> key3 = this.pickBeachBiome(i);
                ResourceKey<Biome> key4 = this.maybePickWindsweptSavannaBiome(i, j, parameter, key);
                ResourceKey<Biome> key5 = this.pickShatteredCoastBiome(i, j, parameter);
                this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, key1);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, key2);
                this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[2], this.erosions[3]), parameter, 0.0F, key);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[3]), parameter, 0.0F, key1);
                this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, Climate.Parameter.span(this.erosions[3], this.erosions[4]), parameter, 0.0F, key3);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, key);
                //this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[4], parameter, 0.0F, keyMystic);
                this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[5], parameter, 0.0F, key5);
                this.addSurfaceBiome(consumer, temperature, humidity, this.nearInlandContinentalness, this.erosions[5], parameter, 0.0F, key4);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, key);
                //this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), this.erosions[5], parameter, 0.0F, keyMystic);
                this.addSurfaceBiome(consumer, temperature, humidity, this.coastContinentalness, this.erosions[6], parameter, 0.0F, key3);

                if (i == 0) {
                    this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, key);
                    //this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.nearInlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, keyMystic);
                }
            }
        }
    }

    private void addValleys(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter parameter) {
        this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, parameter.max() < 0L ? Biomes.STONY_SHORE : Biomes.FROZEN_RIVER);
        this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, parameter.max() < 0L ? Biomes.STONY_SHORE : Biomes.RIVER);
        this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, Biomes.FROZEN_RIVER);
        this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.nearInlandContinentalness, Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, Biomes.RIVER);
        this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), parameter, 0.0F, Biomes.FROZEN_RIVER);
        this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.coastContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[2], this.erosions[5]), parameter, 0.0F, Biomes.RIVER);
        this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], parameter, 0.0F, Biomes.FROZEN_RIVER);
        this.addSurfaceBiome(consumer, this.UNFROZEN_RANGE, this.FULL_RANGE, this.coastContinentalness, this.erosions[6], parameter, 0.0F, Biomes.RIVER);
        this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[1], this.temperatures[2]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, Biomes.SWAMP);
        this.addSurfaceBiome(consumer, Climate.Parameter.span(this.temperatures[3], this.temperatures[4]), this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, Biomes.MANGROVE_SWAMP);
        this.addSurfaceBiome(consumer, this.FROZEN_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.inlandContinentalness, this.farInlandContinentalness), this.erosions[6], parameter, 0.0F, Biomes.FROZEN_RIVER);

        for (int i = 0; i < this.temperatures.length; ++i) {
            Climate.Parameter temperature = this.temperatures[i];
            for (int j = 0; j < this.humidities.length; ++j) {
                Climate.Parameter humidity = this.humidities[j];
                ResourceKey<Biome> key = this.pickMiddleBiomeOrBadlandsIfHot(i, j, parameter);
                this.addSurfaceBiome(consumer, temperature, humidity, Climate.Parameter.span(this.midInlandContinentalness, this.farInlandContinentalness), Climate.Parameter.span(this.erosions[0], this.erosions[1]), parameter, 0.0F, key);
            }
        }
    }

    private void addUndergroundBiomes(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer) {
        this.addUndergroundBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(0.8F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.DRIPSTONE_CAVES);
        this.addUndergroundBiome(consumer, this.FULL_RANGE, Climate.Parameter.span(0.7F, 1.0F), this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, 0.0F, Biomes.LUSH_CAVES);
        this.addBottomBiome(consumer, this.FULL_RANGE, this.FULL_RANGE, this.FULL_RANGE, Climate.Parameter.span(this.erosions[0], this.erosions[1]), this.FULL_RANGE, 0.0F, Biomes.DEEP_DARK);
    }

    private ResourceKey<Biome> pickMiddleBiome(int temperature, int humidity, Climate.Parameter parameter) {
        if (parameter.max() < 0L) {
            return this.MIDDLE_BIOMES[temperature][humidity];
        } else {
            ResourceKey<Biome> key = this.MIDDLE_BIOMES_VARIANT[temperature][humidity];
            return key == null ? this.MIDDLE_BIOMES[temperature][humidity] : key;
        }
    }

    private ResourceKey<Biome> pickMiddleBiomeMB(int temperature, int humidity, Climate.Parameter parameter) {
        if (parameter.max() < 0L) {
            return this.MIDDLE_BIOMES[temperature][humidity];
        } else {
            ResourceKey<Biome> key = this.MIDDLE_BIOMES_VARIANT[temperature][humidity];
            return key == null ? this.MIDDLE_BIOMES[temperature][humidity] : key;
        }
    }

    private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHot(int temperature, int humidity, Climate.Parameter parameter) {
        return temperature == 4 ? this.pickBadlandsBiome(humidity, parameter) : this.pickMiddleBiome(temperature, humidity, parameter);
    }

    private ResourceKey<Biome> pickMiddleBiomeOrBadlandsIfHotOrSlopeIfCold(int temperature, int humidity, Climate.Parameter parameter) {
        return temperature == 0 ? this.pickSlopeBiome(temperature, humidity, parameter) : this.pickMiddleBiomeOrBadlandsIfHot(temperature, humidity, parameter);
    }

    private ResourceKey<Biome> maybePickWindsweptSavannaBiome(int temperature, int humidity, Climate.Parameter p_201993_, ResourceKey<Biome> parameter) {
        return temperature > 1 && humidity < 4 && p_201993_.max() >= 0L ? Biomes.WINDSWEPT_SAVANNA : parameter;
    }

    private ResourceKey<Biome> pickShatteredCoastBiome(int temperature, int humidity, Climate.Parameter parameter) {
        ResourceKey<Biome> key = parameter.max() >= 0L ? this.pickMiddleBiome(temperature, humidity, parameter) : this.pickBeachBiome(temperature);
        return this.maybePickWindsweptSavannaBiome(temperature, humidity, parameter, key);
    }

    private ResourceKey<Biome> pickBeachBiome(int temperature) {
        if (temperature == 0) {
            return Biomes.SNOWY_BEACH;
        } else {
            return temperature == 4 ? Biomes.DESERT : Biomes.BEACH;
        }
    }

    private ResourceKey<Biome> pickBadlandsBiome(int temperature, Climate.Parameter parameter) {
        if (temperature < 2) {
            return parameter.max() < 0L ? Biomes.BADLANDS : Biomes.ERODED_BADLANDS;
        } else {
            return temperature < 3 ? Biomes.BADLANDS : Biomes.WOODED_BADLANDS;
        }
    }

    private ResourceKey<Biome> pickPlateauBiome(int temperature, int humidity, Climate.Parameter parameter) {
        if (parameter.max() >= 0L) {
            ResourceKey<Biome> key = this.PLATEAU_BIOMES_VARIANT[temperature][humidity];
            if (key != null) {
                return key;
            }
        }

        return this.PLATEAU_BIOMES[temperature][humidity];
    }

    private ResourceKey<Biome> pickPeakBiome(int temperature, int humidity, Climate.Parameter parameter) {
        if (temperature <= 2) {
            return parameter.max() < 0L ? Biomes.JAGGED_PEAKS : Biomes.FROZEN_PEAKS;
        } else {
            return temperature == 3 ? Biomes.STONY_PEAKS : this.pickBadlandsBiome(humidity, parameter);
        }
    }

    private ResourceKey<Biome> pickSlopeBiome(int temperature, int humidity, Climate.Parameter parameter) {
        if (temperature >= 3) {
            return this.pickPlateauBiome(temperature, humidity, parameter);
        } else {
            return humidity <= 1 ? Biomes.SNOWY_SLOPES : Biomes.GROVE;
        }
    }

    private ResourceKey<Biome> pickShatteredBiome(int temperature, int humidity, Climate.Parameter parameter) {
        ResourceKey<Biome> key = this.SHATTERED_BIOMES[temperature][humidity];
        return key == null ? this.pickMiddleBiome(temperature, humidity, parameter) : key;
    }

    private void addSurfaceBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter depth, float weirdness, ResourceKey<Biome> biomeKey) {
        consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(0.0F), depth, weirdness), biomeKey));
        consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.0F), depth, weirdness), biomeKey));
    }

    private void addUndergroundBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter depth, float weirdness, ResourceKey<Biome> biomeKey) {
        consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.span(0.2F, 0.9F), depth, weirdness), biomeKey));
    }

    private void addBottomBiome(Consumer<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> consumer, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter depth, float weirdness, ResourceKey<Biome> biomeKey) {
        consumer.accept(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, Climate.Parameter.point(1.1F), depth, weirdness), biomeKey));
    }

}