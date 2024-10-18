package com.mysticsbiomes.data;

import com.mysticsbiomes.data.provider.MysticWorldGenProvider;
import com.mysticsbiomes.init.MysticBiomes;
import com.mysticsbiomes.init.MysticFeatures;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.registry.RegistryBuilder;
import net.minecraft.registry.RegistryKeys;

public class MysticDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		generator.createPack().addProvider(MysticWorldGenProvider::new);
	}

	@Override
	public void buildRegistry(RegistryBuilder builder) {
		builder.addRegistry(RegistryKeys.CONFIGURED_FEATURE, MysticFeatures.Configured::bootstrap);
		builder.addRegistry(RegistryKeys.PLACED_FEATURE, MysticFeatures.Placed::bootstrap);
		builder.addRegistry(RegistryKeys.BIOME, MysticBiomes::bootstrap);
	}

}