package me.benosaurus.testmodjava;

import me.benosaurus.testmodjava.block.ModBlocks;
import me.benosaurus.testmodjava.item.ModItemGroups;
import me.benosaurus.testmodjava.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestModJava implements ModInitializer {
	public static final String MOD_ID = "testmodjava";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerItemGroups();

		PlayerBlockDetector.register();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
	}
}