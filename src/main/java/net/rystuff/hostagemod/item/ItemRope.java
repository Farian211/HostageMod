package net.rystuff.hostagemod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemRope extends Item
{
    public ItemRope()
    {
        super();
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("Rope");
        setTextureName("hostagemod:rope");
    }
}
