package net.rystuff.hostagemod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.rystuff.hostagemod.HostageMod;

public class Gag
{
    @SubscribeEvent
    public void onEvent(EntityInteractEvent event)
    {
        if (event.entityPlayer.inventory.getCurrentItem().getItem() == HostageMod.gag)
        {
            if (event.target instanceof EntityPlayer)
            {
                System.out.println("uuid: " + event.target.getUniqueID());
            }
        }
    }

    @SubscribeEvent
    public void chat(ServerChatEvent event)
    {
        event.setCanceled(true);
        event.player.addChatMessage(new ChatComponentText("<" + event.player.getDisplayName() + "> *muffled noises*"));
    }
}
