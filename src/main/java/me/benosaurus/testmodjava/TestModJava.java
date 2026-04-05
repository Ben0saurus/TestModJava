package me.benosaurus.testmodjava;

import me.benosaurus.testmodjava.block.ModBlockEntities;
import me.benosaurus.testmodjava.block.ModBlocks;
import me.benosaurus.testmodjava.entity.ModEntities;
import me.benosaurus.testmodjava.entity.custom.JulyEntity;
import me.benosaurus.testmodjava.entity.custom.OllieEntity;
import me.benosaurus.testmodjava.item.ModItemGroups;
import me.benosaurus.testmodjava.item.ModItems;
import me.benosaurus.testmodjava.particle.ModParticles;
import me.benosaurus.testmodjava.particle.TestParticle;
import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.client.particle.v1.ParticleFactoryRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestModJava implements ModInitializer {
	public static final String MOD_ID = "testmodjava";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();

		ModBlockEntities.registerBlockEntities();

		ModEntities.registerModEntities();

		ModParticles.registerParticles();
		ParticleFactoryRegistry.getInstance().register(ModParticles.TEST_PARTICLE, TestParticle.Factory::new);

		FabricDefaultAttributeRegistry.register(ModEntities.JULY, JulyEntity.createAttributes());
		FabricDefaultAttributeRegistry.register(ModEntities.OLLIE, OllieEntity.createAttributes());
	}
}