package net.rystuff.hostagemod.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemHandcuff extends Item
{
    public ItemHandcuff()
    {
        super();
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("Handcuffs");
        setTextureName("hostagemod:handcuffs");
    }
}
