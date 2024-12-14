package uk.studiolucia.uberdriver.mixins;

import aztech.modern_industrialization.machines.components.CrafterComponent;
import aztech.modern_industrialization.machines.recipe.MachineRecipe;
import net.minecraft.world.item.crafting.RecipeHolder;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.*;

@Mixin(value = CrafterComponent.class)
public class CrafterComponentMixin {
    @Shadow private int efficiencyTicks;
    @Shadow private long usedEnergy;
    @Shadow private @Nullable RecipeHolder<MachineRecipe> activeRecipe;
    @Shadow @Final private CrafterComponent.Behavior behavior;

    /**
     * @author TheStraying11
     * @reason To add the ability to carry over efficiency ticks to a brand new recipe
     */
    //@Overwrite
    //private void clearActiveRecipeIfPossible() {
        //if (this.efficiencyTicks == 0 && this.usedEnergy == 0L) {
            //this.activeRecipe = null;
        //}
        //else if (this.behavior.isUberdriving() && this.usedEnergy == 0L) {
            //this.activeRecipe = null;
        //}
    //}
}
