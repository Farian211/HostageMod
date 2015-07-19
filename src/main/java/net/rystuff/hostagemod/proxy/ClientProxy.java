package net.rystuff.hostagemod.proxy;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.rystuff.hostagemod.HostageMod;

@SideOnly(Side.CLIENT)
public class ClientProxy extends ServerProxy
{
    @Override
    public void preInit()
    {
        super.preInit();
    }

    @Override
    public void init()
    {
        super.init();
    }

    @Override
    public void postInit()
    {
        super.postInit();

        RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();

        renderItem.getItemModelMesher().register(HostageMod.gag, 0, new ModelResourceLocation("hostagemod:gag", "inventory"));
        renderItem.getItemModelMesher().register(HostageMod.handcuffs, 0, new ModelResourceLocation("hostagemod:handcuffs", "inventory"));
        renderItem.getItemModelMesher().register(HostageMod.key, 0, new ModelResourceLocation("hostagemod:key", "inventory"));
        renderItem.getItemModelMesher().register(HostageMod.rope, 0, new ModelResourceLocation("hostagemod:rope", "inventory"));
    }
}
