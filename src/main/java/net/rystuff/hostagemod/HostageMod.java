package net.rystuff.hostagemod;


import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.rystuff.hostagemod.event.EventChairRope;
import net.rystuff.hostagemod.event.EventGag;
import net.rystuff.hostagemod.event.EventHandcuff;
import net.rystuff.hostagemod.event.EventHandler;
import net.rystuff.hostagemod.item.*;
import net.rystuff.hostagemod.proxy.ServerProxy;

@Mod(modid = "hostagemod", name = "Hostage Mod", version = "0.1.2")
public class HostageMod
{
    @SidedProxy(clientSide = "net.rystuff.hostagemod.proxy.ClientProxy", serverSide = "net.rystuff.hostagemod.proxy.ServerProxy")
    public static ServerProxy proxy;
    @Mod.Instance("hostagemod")
    public static HostageMod instance;

    public static Item gag = new ItemGag();
    public static Item handcuffs = new ItemHandcuff();
    public static Item rope = new ItemRope();
    public static Item key = new ItemKey();

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        FMLCommonHandler.instance().bus().register(new EventHandler());
        MinecraftForge.EVENT_BUS.register(new EventGag());
        MinecraftForge.EVENT_BUS.register(new EventHandcuff());
        MinecraftForge.EVENT_BUS.register(new EventChairRope());
        GameRegistry.registerItem(gag, "gag");
        GameRegistry.registerItem(handcuffs, "handcuffs");
        GameRegistry.registerItem(rope, "rope");
        GameRegistry.registerItem(key, "key");
        //GameRegistry.registerItem(lock, "lock");
        GameRegistry.addShapelessRecipe(new ItemStack(key, 1), new ItemStack(key));
        GameRegistry.addShapelessRecipe(new ItemStack(handcuffs, 1), new ItemStack(handcuffs));
        GameRegistry.addShapelessRecipe(new ItemStack(handcuffs, 1), new ItemStack(key), new ItemStack(handcuffs));
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {

    }
}
