package net.gutopzera.impizzamod.datagen;

import net.gutopzera.impizzamod.item.ModItems;
import net.minecraft.advancements.critereon.ItemPredicate;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;

import java.util.List;
import java.util.function.Consumer;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
//        COZINHANDO MINÉRIOS PADRÃO
//        oreSmelting(consumer, List.of(ModItems.RAW_BLACK_OPAL.get()), RecipeCategory.MISC,
//                ModItems.BLACK_OPAL.get(), 0.7f, 200, "black_opal");

//        CRIANDO E DESFAZENDO BLOCOS DE MINÉRIO
//        nineBlockStorageRecipes(consumer, RecipeCategory.BUILDING_BLOCKS, ModItems.BLACK_OPAL.get(), RecipeCategory.MISC,
//                ModBlocks.BLACK_OPAL_BLOCK.get());

//         ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ModItems.BLACK_OPAL.get())
//                 .requires(ModBlocks.BLACK_OPAL_BLOCK.get())
//                 .unlockedBy("has_black_opal_block", inventoryTrigger(ItemPredicate.Builder.item()
//                         .of(ModBlocks.BLACK_OPAL_BLOCK.get()).build()))
//                 .save(consumer);
//
         ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.RAW_PIZZA.get())
                 .define('#', ModItems.PIZZA.get())
                 .pattern("###")
                 .pattern("# #")
                 .pattern("###")
                 .unlockedBy("has_pizza", inventoryTrigger(ItemPredicate.Builder.item()
                         .of(ModItems.PIZZA.get()).build()))
                 .save(consumer);
    }
}
