package net.rystuff.hostagemod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.world.BlockEvent;
import net.rystuff.hostagemod.HostageMod;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventHandcuff
{
    public static List<UUID> handcuffs = new ArrayList<UUID>();

    @SubscribeEvent
    public void onEvent(EntityInteractEvent event)
    {
        if (event.entityPlayer.inventory.getCurrentItem().getItem() == HostageMod.handcuffs)
            if (event.target instanceof EntityPlayer)
                handcuffs.add(event.target.getUniqueID());
    }
    
    @SubscribeEvent
    public void attackEntity(AttackEntityEvent event)
    {
        if (handcuffs.contains(event.entityPlayer.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event)
    {
        if (handcuffs.contains(event.getPlayer().getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void blockPlace(BlockEvent.PlaceEvent event)
    {
        if (handcuffs.contains(event.player.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void itemuse(PlayerUseItemEvent.Start event)
    {
        if (handcuffs.contains(event.entityPlayer.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void playerInteract(PlayerInteractEvent event)
    {
        if (handcuffs.contains(event.entityPlayer.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void itemPickup(EntityItemPickupEvent event)
    {
        if (handcuffs.contains(event.entityPlayer.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void xpPickup(PlayerPickupXpEvent event)
    {
        if (handcuffs.contains(event.entityPlayer.getUniqueID()))
            event.setCanceled(true);
    }
    
    @SubscribeEvent
    public void onDeath(LivingDeathEvent event)
    {
        if (handcuffs.contains(event.entity.getUniqueID()))
            handcuffs.remove(event.entity.getUniqueID());
    }
}
