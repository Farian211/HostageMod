package net.rystuff.hostagemod.common.event;

public class EventChairRope
{
    /**public static List<UUID> tied = new ArrayList<UUID>();

    @SubscribeEvent
    public void onEvent(PlayerInteractEvent event)
    {
        int x = event.pos.getX();
        int y = event.pos.getY();
        int z = event.pos.getZ();
        if (event.entityPlayer.inventory.getCurrentItem() != null && event.entityPlayer.inventory.getCurrentItem().getItem() == HostageMod.rope)
        {
            if (event.world.getBlockState(event.pos).getBlock() == HostageMod.chair)
            {
                if (event.world.getClosestPlayer(x, y, z, 1.0) != null)
                {
                    tied.add(event.world.getClosestPlayer(x, y, z, 1).getUniqueID());
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
    }**/
}
