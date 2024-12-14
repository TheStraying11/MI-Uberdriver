package uk.studiolucia.uberdriver.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.network.chat.Component;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.studiolucia.uberdriver.UberDriver;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, UberDriver.MOD_ID);

    public static final Supplier<CreativeModeTab> MI_UBERDRIVER_TAB = CREATIVE_MODE_TAB.register(
        "mi_uberdriver_tab",
        () -> CreativeModeTab.builder()
            .icon(() -> new ItemStack(ModItems.UberdriveModule.get()))
            .title(Component.translatable("creativetab.miuberdriver.tab"))
            .displayItems((itemDisplayParameters, output) -> {
                output.accept(ModItems.UberdriveModule);
            })
            .build()
    );

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
