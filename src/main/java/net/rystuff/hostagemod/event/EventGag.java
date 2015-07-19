package net.rystuff.hostagemod.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraftforge.event.ServerChatEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.EntityInteractEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.rystuff.hostagemod.HostageMod;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventGag
{
    public static List<UUID> gagged = new ArrayList<UUID>();

    @SubscribeEvent
    public void onEvent(EntityInteractEvent event)
    {
        if (event.entityPlayer.inventory.getCurrentItem() != null && event.entityPlayer.inventory.getCurrentItem().getItem() == HostageMod.handcuffs)
        {
            if (event.target instanceof EntityPlayer)
            {
                gagged.add(event.target.getUniqueID());
            }
        }
    }

    @SubscribeEvent
    public void chat(ServerChatEvent event)
    {
        if (gagged.contains(event.player.getUniqueID()))
        {
            event.setCanceled(true);
            FMLCommonHandler.instance().getMinecraftServerInstance().getConfigurationManager().sendChatMsg(new ChatComponentText("<" + event.player.getDisplayName() + "> *muffled noises*"));
        }
    }

    @SubscribeEvent
    public void onDeath(LivingDeathEvent event)
    {
        if (gagged.contains(event.entity.getUniqueID()))
            gagged.remove(event.entity.getUniqueID());
    }
}
