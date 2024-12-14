package uk.studiolucia.uberdriver.mixins;

import aztech.modern_industrialization.definition.ItemDefinition;
import aztech.modern_industrialization.machines.components.OverdriveComponent;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import uk.studiolucia.uberdriver.item.ModItems;

@Mixin(value = OverdriveComponent.class)
public class OverdriveComponentMixin {
    @Shadow
    private ItemStack overdriveModule;

    public boolean shouldUberdrive() {
        return overdriveModule.is(ModItems.UberdriveModule);
    }

    @WrapOperation(method = "onUse", at = @At(value = "INVOKE", target = "Laztech/modern_industrialization/definition/ItemDefinition;is(Lnet/minecraft/world/item/ItemStack;)Z"))
    private boolean onUseWrap(ItemDefinition<Item> OVERDRIVE_MODULE, ItemStack stackInHand, Operation<Boolean> original) {
        return original.call(OVERDRIVE_MODULE, stackInHand) || stackInHand.is(ModItems.UberdriveModule);
    }

}
