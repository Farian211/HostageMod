package net.rystuff.hostagemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;
import net.rystuff.hostagemod.event.EventHandler;
import net.rystuff.hostagemod.proxy.ServerProxy;

@Mod(modid = "hostagemod", name = "Hostage Mod", version = "1.0")
public class HostageMod
{
    @SidedProxy(clientSide = "net.rystuff.hostagemod.proxy.ClientProxy", serverSide = "net.rystuff.hostagemod.proxy.ServerProxy")
    public static ServerProxy proxy;
    @Mod.Instance("hostagemod")
    public static HostageMod instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
}
