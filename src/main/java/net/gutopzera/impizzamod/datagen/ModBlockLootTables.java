package net.gutopzera.impizzamod.datagen;

import net.gutopzera.impizzamod.block.ModBlocks;
import net.gutopzera.impizzamod.item.ModItems;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.registries.RegistryObject;

import java.util.Set;

public class ModBlockLootTables extends BlockLootSubProvider {
    protected ModBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
//        DROPA O BLOCO EM SI QUANDO QUEBRADO
//        dropSelf(ModBlocks.FRED_ORE.get());

        add(ModBlocks.FRED_ORE.get(),
                (block) -> createOreDrop(ModBlocks.FRED_ORE.get(), ModItems.NERD_DEBRIS.get()));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}
