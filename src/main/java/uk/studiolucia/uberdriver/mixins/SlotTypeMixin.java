package uk.studiolucia.uberdriver.mixins;

import aztech.modern_industrialization.MIItem;
import aztech.modern_industrialization.MIText;
import aztech.modern_industrialization.inventory.SlotGroup;
import aztech.modern_industrialization.machines.guicomponents.SlotPanel.SlotType;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import uk.studiolucia.uberdriver.item.ModItems;

import java.util.function.Predicate;

@Mixin(value = SlotType.class)
public class SlotTypeMixin {
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target="aztech/modern_industrialization/machines/guicomponents/SlotPanel$SlotType.<init> (Ljava/lang/String;ILaztech/modern_industrialization/inventory/SlotGroup;ILjava/util/function/Predicate;IILaztech/modern_industrialization/MIText;)V", ordinal = 3))
    private static Predicate<ItemStack> modifyPredicate(Predicate<ItemStack> insertionChecker) {
        return insertionChecker.or(stack -> stack.is(ModItems.UberdriveModule));
    }
}
