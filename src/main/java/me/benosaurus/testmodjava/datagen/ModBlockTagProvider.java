package me.benosaurus.testmodjava.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(Identifier.of("testmodjava", "tekno_block"))
                .add(Identifier.of("testmodjava", "spawner_block"))
                .add(Identifier.of("testmodjava", "counter_block"))
                .add(Identifier.of("testmodjava", "snitching_block"))
                .add(Identifier.of("testmodjava", "xp_bank_block"));

        getTagBuilder(BlockTags.AXOLOTLS_SPAWNABLE_ON)
                .add(Identifier.of("testmodjava", "tekno_block"));

    }
}
