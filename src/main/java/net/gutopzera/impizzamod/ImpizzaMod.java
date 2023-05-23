package net.gutopzera.impizzamod;

import com.mojang.logging.LogUtils;
import net.gutopzera.impizzamod.block.ModBlocks;
import net.gutopzera.impizzamod.item.ModCreativeModeTabs;
import net.gutopzera.impizzamod.item.ModItems;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ImpizzaMod.MOD_ID)
public class ImpizzaMod {
    public static final String MOD_ID = "impizzamod";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ImpizzaMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);

        modEventBus.addListener(this::commonSetup);
        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(CreativeModeTabEvent.BuildContents event) {
        if (event.getTab() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.PIZZA);
            event.accept(ModItems.RAW_PIZZA);
        }
        if (event.getTab() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            event.accept(ModItems.NERD_DEBRIS);
        }

        if (event.getTab() == CreativeModeTabs.BUILDING_BLOCKS) {
            event.accept(ModBlocks.FRED_ORE);
        }

        if(event.getTab() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.PAU_BRASIL_LEAVES);
            event.accept(ModBlocks.PAU_BRASIL_LOG);
            event.accept(ModBlocks.PAU_BRASIL_WOOD);
            event.accept(ModBlocks.PAU_BRASIL_PLANKS);
            event.accept(ModBlocks.STRIPPED_PAU_BRASIL_LOG);
            event.accept(ModBlocks.STRIPPED_PAU_BRASIL_WOOD);
            event.accept(ModBlocks.PAU_BRASIL_SAPLING);
        }

        if (event.getTab() == ModCreativeModeTabs.IMPIZZA_TAB) {
            event.accept(ModItems.PIZZA);
            event.accept(ModItems.RAW_PIZZA);
            event.accept(ModBlocks.FRED_ORE);
            event.accept(ModItems.NERD_DEBRIS);

            event.accept(ModBlocks.PAU_BRASIL_LEAVES);
            event.accept(ModBlocks.PAU_BRASIL_LOG);
            event.accept(ModBlocks.PAU_BRASIL_WOOD);
            event.accept(ModBlocks.PAU_BRASIL_PLANKS);
            event.accept(ModBlocks.STRIPPED_PAU_BRASIL_LOG);
            event.accept(ModBlocks.STRIPPED_PAU_BRASIL_WOOD);
            event.accept(ModBlocks.PAU_BRASIL_SAPLING);
        }

    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
