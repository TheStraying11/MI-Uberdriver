package uk.studiolucia.uberdriver.mixins;

import aztech.modern_industrialization.machines.blockentities.ElectricCraftingMachineBlockEntity;
import aztech.modern_industrialization.machines.blockentities.multiblocks.ElectricBlastFurnaceBlockEntity;
import aztech.modern_industrialization.machines.blockentities.multiblocks.ElectricCraftingMultiblockBlockEntity;
import aztech.modern_industrialization.machines.components.OverdriveComponent;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import uk.studiolucia.uberdriver.ducks.Behaviour;
import uk.studiolucia.uberdriver.ducks.ShouldUberdrive;

@Mixin({ElectricBlastFurnaceBlockEntity.class, ElectricCraftingMachineBlockEntity.class, ElectricCraftingMultiblockBlockEntity.class})
public class MachineBlockEntityMixin implements Behaviour {
    @Shadow(remap = false)
    private @Final OverdriveComponent overdrive;

    @Override
    public boolean miuberdriver$isUberdriving() {
        return ((ShouldUberdrive) overdrive).miuberdriver$shouldUberdrive();
    }
}
