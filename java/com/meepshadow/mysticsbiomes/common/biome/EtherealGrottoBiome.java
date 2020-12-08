package com.meepshadow.mysticsbiomes.common.biome;

import com.google.common.collect.ImmutableList;
import com.meepshadow.mysticsbiomes.core.registry.ModFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.MultipleRandomFeatureConfig;
import net.minecraft.world.gen.feature.structure.MineshaftConfig;
import net.minecraft.world.gen.feature.structure.MineshaftStructure;
import net.minecraft.world.gen.feature.structure.VillageConfig;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.ChanceConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;

public final class EtherealGrottoBiome extends Biome {
    public EtherealGrottoBiome() {
        super((new Builder()).surfaceBuilder(SurfaceBuilder.DEFAULT, SurfaceBuilder.GRASS_DIRT_GRAVEL_CONFIG).precipitation(RainType.RAIN).category(Category.PLAINS).depth(0.125F).scale(0.05F).temperature(0.8F).downfall(0.4F).waterColor(3717789).waterFogColor(3717789).parent((String)null));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.NORMAL_TREE.withConfiguration(DefaultBiomeFeatures.BIRCH_TREE_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0F, 0))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(Feature.FANCY_TREE.withConfiguration(ModFeatures.ETHEREAL_TREE_CONFIG).withChance(0.1F)), Feature.NORMAL_TREE.withConfiguration(ModFeatures.ETHEREAL_TREE_CONFIG))).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 0F, 0))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.HUGE_RED_MUSHROOM.withConfiguration(ModFeatures.BIG_ORB_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(1, 1F, 0))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ModFeatures.ORB_MUSHROOM_CONFIG).withPlacement(Placement.CHANCE_HEIGHTMAP_DOUBLE.configure(new ChanceConfig(24))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(ModFeatures.LAVENDER_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(16))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.LILAC_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(16))));
        this.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_PATCH.withConfiguration(DefaultBiomeFeatures.GRASS_CONFIG).withPlacement(Placement.COUNT_HEIGHTMAP_32.configure(new FrequencyConfig(64))));
        this.addStructure(Feature.VILLAGE.withConfiguration(new VillageConfig("village/plains/town_centers", 6)));
        this.addStructure(Feature.PILLAGER_OUTPOST.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        this.addStructure(Feature.MINESHAFT.withConfiguration(new MineshaftConfig(0.004D, MineshaftStructure.Type.NORMAL)));
        this.addStructure(Feature.STRONGHOLD.withConfiguration(IFeatureConfig.NO_FEATURE_CONFIG));
        DefaultBiomeFeatures.addLakes(this);
        DefaultBiomeFeatures.addMonsterRooms(this);
        DefaultBiomeFeatures.addPlainsTallGrass(this);
        DefaultBiomeFeatures.addStoneVariants(this);
        DefaultBiomeFeatures.addOres(this);
        DefaultBiomeFeatures.addSedimentDisks(this);
        DefaultBiomeFeatures.addSprings(this);
        DefaultBiomeFeatures.addFreezeTopLayer(this);
        this.addSpawn(EntityClassification.CREATURE, new SpawnListEntry(EntityType.SHEEP, 12, 4, 4));
        this.addSpawn(EntityClassification.AMBIENT, new SpawnListEntry(EntityType.BAT, 10, 8, 8));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SPIDER, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.SLIME, 100, 4, 4));
        this.addSpawn(EntityClassification.MONSTER, new SpawnListEntry(EntityType.WITCH, 5, 1, 1));
    }
    @Override
    public int getSkyColor() {
        return 0x7fd8cd;
    }
    @Override
    public int getGrassColor(double posX, double posZ) {
        return 0x429c91;
    }
    @Override
    public int getFoliageColor() {
        return 0x429c91;
    }
}
