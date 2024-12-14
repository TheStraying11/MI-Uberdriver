package uk.studiolucia.uberdriver.mixins;

import aztech.modern_industrialization.machines.blockentities.ElectricCraftingMachineBlockEntity;
import aztech.modern_industrialization.machines.blockentities.multiblocks.ElectricBlastFurnaceBlockEntity;
import aztech.modern_industrialization.machines.blockentities.multiblocks.ElectricCraftingMultiblockBlockEntity;
import aztech.modern_industrialization.machines.components.OverdriveComponent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import uk.studiolucia.uberdriver.ducks.miuberdriver$Behaviour;
import uk.studiolucia.uberdriver.ducks.miuberdriver$shouldUberdrive;

@Mixin({ElectricBlastFurnaceBlockEntity.class, ElectricCraftingMachineBlockEntity.class, ElectricCraftingMultiblockBlockEntity.class})
public class MachineBlockEntityMixin implements miuberdriver$Behaviour {
    @Shadow
    private @Final OverdriveComponent overdrive;

    @Override
    public boolean isUberdriving() {
        return ((miuberdriver$shouldUberdrive) overdrive).shouldUberdrive();
    }
}
