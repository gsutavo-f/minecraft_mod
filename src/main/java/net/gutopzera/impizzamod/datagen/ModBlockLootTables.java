package net.gutopzera.impizzamod.datagen;

import net.gutopzera.impizzamod.block.ModBlocks;
import net.gutopzera.impizzamod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.add(ModBlocks.FRED_ORE.get(),
                (block) -> createOreDrop(ModBlocks.FRED_ORE.get(), ModItems.NERD_DEBRIS.get()));

        this.dropSelf(ModBlocks.PAU_BRASIL_WOOD.get());
        this.dropSelf(ModBlocks.PAU_BRASIL_LOG.get());
        this.dropSelf(ModBlocks.PAU_BRASIL_PLANKS.get());
        this.dropSelf(ModBlocks.STRIPPED_PAU_BRASIL_LOG.get());
        this.dropSelf(ModBlocks.STRIPPED_PAU_BRASIL_WOOD.get());
        this.dropSelf(ModBlocks.PAU_BRASIL_SAPLING.get());

        this.add(ModBlocks.PAU_BRASIL_LEAVES.get(),
                (block -> createLeavesDrops(block, ModBlocks.PAU_BRASIL_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES)));

    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
