package me.benosaurus.testmodjava;

import me.benosaurus.testmodjava.entity.ModEntities;
import me.benosaurus.testmodjava.entity.client.july.JulyRenderer;
import me.benosaurus.testmodjava.entity.client.ollie.OllieRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;

public class TestModJavaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ModEntities.JULY, JulyRenderer::new);
        EntityRendererRegistry.register(ModEntities.OLLIE, OllieRenderer::new);
    }
}