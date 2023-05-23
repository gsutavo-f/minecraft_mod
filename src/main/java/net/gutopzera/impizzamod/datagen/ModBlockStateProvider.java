package net.gutopzera.impizzamod.datagen;

import net.gutopzera.impizzamod.ImpizzaMod;
import net.gutopzera.impizzamod.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, ImpizzaMod.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(ModBlocks.FRED_ORE);

        logBlock(((RotatedPillarBlock) ModBlocks.PAU_BRASIL_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.PAU_BRASIL_WOOD.get(), blockTexture(ModBlocks.PAU_BRASIL_LOG.get()), blockTexture(ModBlocks.PAU_BRASIL_LOG.get()));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_PAU_BRASIL_LOG.get(), new ResourceLocation(ImpizzaMod.MOD_ID, "block/stripped_pau_brasil_log"),
                new ResourceLocation(ImpizzaMod.MOD_ID, "block/stripped_pau_brasil_log_top"));
        axisBlock((RotatedPillarBlock) ModBlocks.STRIPPED_PAU_BRASIL_WOOD.get(), new ResourceLocation(ImpizzaMod.MOD_ID, "block/stripped_pau_brasil_log"),
                new ResourceLocation(ImpizzaMod.MOD_ID, "block/stripped_pau_brasil_log"));

        blockWithItem(ModBlocks.PAU_BRASIL_PLANKS);
        blockWithItem(ModBlocks.PAU_BRASIL_LEAVES);
        saplingBlock(ModBlocks.PAU_BRASIL_SAPLING);

        simpleBlockItem(ModBlocks.PAU_BRASIL_LOG.get(), models().withExistingParent("impizzamod:pau_brasil_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.PAU_BRASIL_WOOD.get(), models().withExistingParent("impizzamod:pau_brasil_wood", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_PAU_BRASIL_LOG.get(), models().withExistingParent("impizzamod:stripped_pau_brasil_log", "minecraft:block/cube_column"));
        simpleBlockItem(ModBlocks.STRIPPED_PAU_BRASIL_WOOD.get(), models().withExistingParent("impizzamod:stripped_pau_brasil_wood", "minecraft:block/cube_column"));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }

    private void saplingBlock(RegistryObject<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(ForgeRegistries.BLOCKS.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }
}
