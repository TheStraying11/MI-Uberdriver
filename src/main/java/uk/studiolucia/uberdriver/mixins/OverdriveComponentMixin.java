package uk.studiolucia.uberdriver.mixins;

import aztech.modern_industrialization.definition.ItemDefinition;
import aztech.modern_industrialization.machines.components.OverdriveComponent;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import uk.studiolucia.uberdriver.item.ModItems;

@Mixin(value = OverdriveComponent.class)
public class OverdriveComponentMixin {
    //@Shadow
    //private ItemStack overdriveModule;

    //public boolean shouldUberdrive() {
    //    return overdriveModule.is(ModItems.UberdriveModule);
    //}

    @WrapOperation(method = "onUse", at = @At(value = "INVOKE", target = "aztech/modern_industrialization/machines/guicomponents/SlotPanel$SlotType.<init> (Ljava/lang/String;ILaztech/modern_industrialization/inventory/SlotGroup;ILjava/util/function/Predicate;IILaztech/modern_industrialization/MIText;)V", ordinal = 3))
    private boolean onUseWrap(ItemDefinition<Item> OVERDRIVE_MODULE, ItemStack stackInHand, Operation<Boolean> original) {
        return original.call(OVERDRIVE_MODULE, stackInHand) || stackInHand.is(ModItems.UberdriveModule);
    }
}
