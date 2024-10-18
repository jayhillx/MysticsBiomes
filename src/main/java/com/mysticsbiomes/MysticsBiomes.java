package com.mysticsbiomes;

import com.mysticsbiomes.common.world.AnimalSpawnsBuilder;
import com.mysticsbiomes.init.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import terrablender.api.TerraBlenderApi;

public class MysticsBiomes implements ModInitializer, TerraBlenderApi {
	public static final String modId = "mysticsbiomes";
	public static final Logger LOGGER = LoggerFactory.getLogger(modId);

	public static Identifier modLoc(String path) {
		return new Identifier(modId, path);
	}

	@Override
	public void onInitialize() {
		MysticBiomes.registerBiomes();
		MysticBlocks.registerBlocks();
		MysticItems.registerItems();
		MysticBlockEntities.registerBlockEntities();
		MysticEntities.registerEntities();
		MysticFeatures.registerFeatures();
		MysticFeatures.Configured.registerConfiguredFeatures();
		MysticFeatures.Placed.registerPlacedFeatures();
		MysticParticles.registerParticles();
		MysticPoiTypes.registerPoiTypes();
		MysticSounds.registerSounds();
		MysticTab.registerItemGroup();

		AnimalSpawnsBuilder.addBiomeSpawns();
		MysticEntities.registerEntitySpawns();

		MysticConfig.load();
	}

	@Override
	public void onTerraBlenderInitialized() {
		MysticBiomes.registerRegionProvider();
		MysticBiomes.registerSurfaceRules();
	}

}