package net.rystuff.hostagemod.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemLock extends Item
{
    public ItemLock()
    {
        super();
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("Lock");
        setMaxStackSize(1);
        setHasSubtypes(true);
    }
}
