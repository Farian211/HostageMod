package net.rystuff.hostagemod.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.*;
import net.minecraftforge.event.world.BlockEvent;
import net.rystuff.hostagemod.HostageMod;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class EventChairRope
{
    public static List<UUID> tied = new ArrayList<UUID>();

    @SubscribeEvent
    public void onEvent(PlayerInteractEvent event)
    {
        System.out.println("stuff");
        if (event.entityPlayer.inventory.getCurrentItem() != null)
        {
            if (event.entityPlayer.inventory.getCurrentItem().getItem() == HostageMod.rope)
            {
                System.out.println("rope clicked");
                if (event.world.getBlock(event.x, event.y, event.z) == HostageMod.chair)
                {
                    System.out.println("chair there");
                    if (event.world.getClosestPlayer(event.x, event.y, event.z, 1.0) != null)
                    {
                        System.out.println("player in chair");
                        tied.add(event.world.getClosestPlayer(event.x, event.y, event.z, 1).getUniqueID());
                    }
                }
            }
        }
    }

    @SubscribeEvent
    public void attackEntity(AttackEntityEvent event)
    {
        if (tied.contains(event.entityPlayer.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void blockBreak(BlockEvent.BreakEvent event)
    {
        if (tied.contains(event.getPlayer().getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void blockPlace(BlockEvent.PlaceEvent event)
    {
        if (tied.contains(event.player.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void itemuse(PlayerUseItemEvent.Start event)
    {
        if (tied.contains(event.entityPlayer.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void playerInteract(PlayerInteractEvent event)
    {
        if (tied.contains(event.entityPlayer.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void itemPickup(EntityItemPickupEvent event)
    {
        if (tied.contains(event.entityPlayer.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void xpPickup(PlayerPickupXpEvent event)
    {
        if (tied.contains(event.entityPlayer.getUniqueID()))
            event.setCanceled(true);
    }

    @SubscribeEvent
    public void onDeath(LivingDeathEvent event)
    {
        if (tied.contains(event.entity.getUniqueID()))
            tied.remove(event.entity.getUniqueID());
    }
}
