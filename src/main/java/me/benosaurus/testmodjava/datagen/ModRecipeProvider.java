package me.benosaurus.testmodjava.datagen;

import me.benosaurus.testmodjava.block.ModBlocks;
import me.benosaurus.testmodjava.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.CookingRecipeJsonBuilder;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.data.recipe.StonecuttingRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                //Spawner
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.SPAWNER_BLOCK)
                        .pattern("TTT")
                        .pattern("TXT")
                        .pattern("TTT")
                        .input('T', ModItems.TEKNO)
                        .input('X', ModItems.CUCUMBER)
                        .criterion(hasItem(ModItems.TEKNO), conditionsFromItem(ModItems.TEKNO))
                        .criterion(hasItem(ModItems.CUCUMBER), conditionsFromItem(ModItems.CUCUMBER))
                        .offerTo(exporter);

                //Tekno Block
                createShaped(RecipeCategory.BUILDING_BLOCKS, ModBlocks.TEKNO_BLOCK)
                        .pattern("TTT")
                        .pattern("TTT")
                        .pattern("TTT")
                        .input('T', ModItems.TEKNO)
                        .criterion(hasItem(ModItems.TEKNO), conditionsFromItem(ModItems.TEKNO))
                        .offerTo(exporter);

                //Tekno
                createShapeless(RecipeCategory.MISC, ModItems.TEKNO, 9)
                        .input(ModBlocks.TEKNO_BLOCK)
                        .criterion(hasItem(ModBlocks.TEKNO_BLOCK), conditionsFromItem(ModBlocks.TEKNO_BLOCK))
                        .offerTo(exporter);

                //Smelt Tekno -> Cucumber
                CookingRecipeJsonBuilder.createSmelting(
                                Ingredient.ofItems(ModItems.TEKNO),
                                RecipeCategory.MISC,
                                ModItems.CUCUMBER,
                                0.7f,
                                200
                        )
                        .criterion(hasItem(ModItems.TEKNO), conditionsFromItem(ModItems.TEKNO))
                        .offerTo(exporter, "cucumber_from_smelting");

                //Stonecutting Tekno Block into Tekno
                StonecuttingRecipeJsonBuilder.createStonecutting(
                                Ingredient.ofItems(ModBlocks.TEKNO_BLOCK),
                                RecipeCategory.BUILDING_BLOCKS,
                                ModItems.TEKNO,
                                9
                        )
                        .criterion(hasItem(ModBlocks.TEKNO_BLOCK), conditionsFromItem(ModBlocks.TEKNO_BLOCK))
                        .offerTo(exporter, "tekno_from_stonecutting");
            }
        };
    }

    @Override
    public String getName() {
        return "Test Mod Java Recipes";
    }
}