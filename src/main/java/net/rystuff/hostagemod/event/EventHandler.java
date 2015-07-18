package net.rystuff.hostagemod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.*;
import cpw.mods.fml.common.gameevent.PlayerEvent;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.world.BlockEvent;
import net.rystuff.hostagemod.HostageMod;

public class EventHandler
{
    @SubscribeEvent
    public void crafted(PlayerEvent.ItemCraftedEvent event)
    {
        if (event.crafting.getItem() == HostageMod.handcuffs)
        {
            for (int i=0; i < event.craftMatrix.getSizeInventory(); i++)
            {
                if (event.craftMatrix.getStackInSlot(i) != null)
                {
                   if (event.craftMatrix.getStackInSlot(i).getItem() == HostageMod.key)
                   {
                       String keyOwner = event.craftMatrix.getStackInSlot(i).stackTagCompound.getString("owner");
                       event.crafting.stackTagCompound = new NBTTagCompound();
                       event.crafting.stackTagCompound.setString("owner", keyOwner);
                       int keyCode = event.craftMatrix.getStackInSlot(i).stackTagCompound.getInteger("code");
                       event.crafting.stackTagCompound.setInteger("code", keyCode);
                       System.out.println("DONE!!!!");
                   }
                }
            }
        }
    }
}
