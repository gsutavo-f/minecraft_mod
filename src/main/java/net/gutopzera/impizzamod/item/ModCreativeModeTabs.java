package net.gutopzera.impizzamod.item;

import net.gutopzera.impizzamod.ImpizzaMod;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ImpizzaMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCreativeModeTabs {
    public static CreativeModeTab IMPIZZA_TAB;

    @SubscribeEvent
    public static void registerCreativeModeTabs(CreativeModeTabEvent.Register event) {
        IMPIZZA_TAB = event.registerCreativeModeTab(new ResourceLocation(ImpizzaMod.MOD_ID, "impizza_tab"),
                builder -> builder.icon(() -> new ItemStack(ModItems.RAW_PIZZA.get()))
                        .title(Component.translatable("creativemodetab.impizza_tab")));
    }
}
