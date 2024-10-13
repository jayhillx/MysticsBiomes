package com.mysticsbiomes;

import com.mysticsbiomes.init.*;
import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MysticsBiomes implements ModInitializer {
	public static final String modId = "mysticsbiomes";
	public static final Logger LOGGER = LoggerFactory.getLogger(modId);

	public static Identifier modLoc(String path) {
		return new Identifier(modId, path);
	}

	@Override
	public void onInitialize() {
		MysticTab.registerItemGroup();
		MysticBlocks.registerBlocks();
		MysticBlockEntities.registerBlockEntities();
		MysticEntities.registerEntities();
		MysticItems.registerItems();
		MysticFeatures.registerFeatures();

		MysticBiomes.registerBiomes();
	}

}