package uk.studiolucia.uberdriver.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import uk.studiolucia.uberdriver.UberDriver;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(UberDriver.MOD_ID);

    public static final DeferredItem<Item> UberdriveModule = ITEMS.register(
        "uberdrive_module",
        () -> new Item(new Item.Properties())
    );

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}