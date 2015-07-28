package net.rystuff.hostagemod.block;

import net.ilexiconn.llibrary.common.block.BlockMountable;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockChair extends BlockMountable
{
    public BlockChair()
    {
        super(Material.wood);
        setCreativeTab(CreativeTabs.tabMisc);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return null;
    }
}
