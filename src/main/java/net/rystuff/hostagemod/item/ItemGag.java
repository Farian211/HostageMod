package net.rystuff.hostagemod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemGag extends Item
{
    public ItemGag()
    {
        super();
        setUnlocalizedName("gag");
        setTextureName("hostagemod:redGag");
        setCreativeTab(CreativeTabs.tabMisc);
    }
}
