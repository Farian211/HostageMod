package net.rystuff.hostagemod.event;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.*;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
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
                       if (event.crafting.getTagCompound() == null)
                       {
                           event.crafting.setTagCompound(new NBTTagCompound());
                       }
                       int keyCode = event.craftMatrix.getStackInSlot(i).getTagCompound().getInteger("code");
                       event.crafting.getTagCompound().setInteger("code", keyCode);
                       System.out.println("DONE!!!!");
                   }
                }
            }
        }
    }
}
