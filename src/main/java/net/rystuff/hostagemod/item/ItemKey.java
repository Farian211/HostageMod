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
        setTextureName("hostagemod:key");
        setMaxStackSize(1);
        setHasSubtypes(true);
    }

    public void onCreated(ItemStack itemStack, World world, EntityPlayer player) {
        itemStack.stackTagCompound = new NBTTagCompound();
        itemStack.stackTagCompound.setString("owner", player.getDisplayName());
        itemStack.stackTagCompound.setInteger("code", (int)(Math.random()*Integer.MAX_VALUE));
    }

    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (itemStack.stackTagCompound != null) {
            String owner = itemStack.stackTagCompound.getString("owner");
            int code = itemStack.stackTagCompound.getInteger("code");
            list.add("owner: " + owner);
            if (owner.equals(player.getDisplayName())) {
                list.add(EnumChatFormatting.GREEN + "code: " + code);
            } else {
                list.add(EnumChatFormatting.RED + "code: "
                         + EnumChatFormatting.OBFUSCATED + code);
            }
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

    @Override
    public boolean doesContainerItemLeaveCraftingGrid(ItemStack itemStack)
    {
        return false;
    }
}
