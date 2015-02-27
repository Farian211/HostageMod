package net.rystuff.hostagemod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemHandcuff extends Item
{
    public ItemHandcuff()
    {
        super();
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("Handcuffs");
        setTextureName("hostagemod:handcuff");
    }
}
