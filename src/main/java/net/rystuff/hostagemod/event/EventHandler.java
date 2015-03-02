package net.rystuff.hostagemod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.world.BlockEvent;

public class EventHandler
{
    @SubscribeEvent
    public void attackEntity(AttackEntityEvent event)
    {
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event)
    {
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void blockPlace(BlockEvent.PlaceEvent event)
    {
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void itemuse(PlayerUseItemEvent.Start event)
    {
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void playerInteract(PlayerInteractEvent event)
    {
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void enderTeleport(EnderTeleportEvent event)
    {
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void itemPickup(EntityItemPickupEvent event)
    {
        event.setCanceled(true);
    }

    @SubscribeEvent
    public void xpPickup(PlayerPickupXpEvent event)
    {
        event.setCanceled(true);
    }
}
