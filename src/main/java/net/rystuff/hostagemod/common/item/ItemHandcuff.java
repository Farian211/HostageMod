package net.rystuff.hostagemod.common.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;

import java.util.List;

public class ItemHandcuff extends Item
{
    public ItemHandcuff()
    {
        super();
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("Handcuffs");
        setMaxStackSize(1);
        setHasSubtypes(true);
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (itemStack.getTagCompound() != null) {
            int code = itemStack.getTagCompound().getInteger("code");
            list.add(EnumChatFormatting.GREEN + "code: " + code);
        }
    }
}
