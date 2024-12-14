package uk.studiolucia.uberdriver.mixins;

import aztech.modern_industrialization.machines.blockentities.ElectricCraftingMachineBlockEntity;
import aztech.modern_industrialization.machines.blockentities.multiblocks.ElectricBlastFurnaceBlockEntity;
import aztech.modern_industrialization.machines.blockentities.multiblocks.ElectricCraftingMultiblockBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import uk.studiolucia.uberdriver.interfaces.miuberdriver$Behaviour;

@Mixin({ElectricBlastFurnaceBlockEntity.class, ElectricCraftingMachineBlockEntity.class, ElectricCraftingMultiblockBlockEntity.class})
public class MachineBlockEntityMixin implements miuberdriver$Behaviour {
    @Override
    public boolean isUberdriving() {
        return overdrive.shouldUberdrive();
    }
}
