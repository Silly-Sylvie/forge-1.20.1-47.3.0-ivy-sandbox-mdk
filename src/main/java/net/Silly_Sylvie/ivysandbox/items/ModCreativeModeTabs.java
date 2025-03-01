package net.Silly_Sylvie.ivysandbox.items;

import net.Silly_Sylvie.ivysandbox.IvySandbox;
import net.Silly_Sylvie.ivysandbox.block.ModBlocks;
import net.Silly_Sylvie.ivysandbox.items.custom.ModItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, IvySandbox.MOD_ID);

    public static final RegistryObject<CreativeModeTab> IVYSANDBOX_TAB = CREATIVE_MODE_TABS.register("ivysandbox_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ORANGE.get()))
                    .title(Component.translatable("creativetab.ivysandbox_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.ORANGE.get());
                    })
                    .build());
    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);

    }
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if(event.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
            event.accept(ModItems.ORANGE);
        }
        if(event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            event.accept(ModBlocks.GRASS_SLAB);
        }
    }
}
