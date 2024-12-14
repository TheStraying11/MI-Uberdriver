package uk.studiolucia.uberdriver.mixins;

import aztech.modern_industrialization.machines.components.CrafterComponent;
import aztech.modern_industrialization.machines.recipe.MachineRecipe;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.Opcodes;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.At;
import uk.studiolucia.uberdriver.ducks.Behaviour;

@Mixin(value = CrafterComponent.class)
public class CrafterComponentMixin {
    @Shadow @Final private CrafterComponent.Behavior behavior;

    @Shadow private @Nullable RecipeHolder<MachineRecipe> activeRecipe;

    @WrapOperation(
        method = "clearActiveRecipeIfPossible",
        at = @At(
            value = "FIELD",
            target = "aztech/modern_industrialization/machines/components/CrafterComponent.efficiencyTicks : I",
            opcode = Opcodes.GETFIELD
        )
    )
    private int orIsUberdriving(CrafterComponent instance, Operation<Integer> original) {
        int efficiencyTicks = original.call(instance);
        if (efficiencyTicks == 0 || ((Behaviour) this.behavior).miuberdriver$isUberdriving()) return 0;

        return efficiencyTicks;
    }

    @WrapOperation(
        method = "getRecipes",
        at = @At(
            value = "FIELD",
            target = "aztech/modern_industrialization/machines/components/CrafterComponent.efficiencyTicks : I",
            opcode = Opcodes.GETFIELD
        )
    )
    private int wrapEfficiencyTicks(CrafterComponent instance, Operation<Integer> original) {
        if (activeRecipe == null) {
            return 0;
        }
        else {
            return original.call(instance);
        }
    }
}
