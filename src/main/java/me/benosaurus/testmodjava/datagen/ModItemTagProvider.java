package me.benosaurus.testmodjava.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(ItemTags.BEE_FOOD)
                .add(Identifier.of("testmodjava", "cucumber"))
                .add(Identifier.of("testmodjava", "disc"))
                .add(Identifier.of("testmodjava", "tekno"))
                .add(Identifier.of("testmodjava", "ice_staff"))
                .add(Identifier.of("testmodjava", "boost_item"))
                .add(Identifier.of("testmodjava", "particle_item"));

        getTagBuilder(ItemTags.CREEPER_DROP_MUSIC_DISCS)
                .add(Identifier.of("testmodjava", "disc"));

        getTagBuilder(ItemTags.FURNACE_MINECART_FUEL)
                .add(Identifier.of("testmodjava", "cucumber"));
    }
}
