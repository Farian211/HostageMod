package net.rystuff.hostagemod.item;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

import java.util.List;

public class ItemKey extends Item
{
    public ItemKey()
    {
        super();
        setCreativeTab(CreativeTabs.tabMisc);
        setUnlocalizedName("Key");
        setMaxStackSize(1);
        setHasSubtypes(true);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        if (itemStack.getTagCompound() == null)
        {
            itemStack.setTagCompound(new NBTTagCompound());
        }
        itemStack.getTagCompound().setInteger("code", (int)(Math.random()*Integer.MAX_VALUE));
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (itemStack.getTagCompound() != null) {
            int code = itemStack.getTagCompound().getInteger("code");
            list.add(EnumChatFormatting.GREEN + "code: " + code);
        }
    }

    @Override
    public ItemStack getContainerItem(ItemStack itemStack)
    {
        return itemStack;
    }

    @Override
    public boolean hasContainerItem(ItemStack itemstack)
    {
        return true;
    }
}
