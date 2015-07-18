package net.rystuff.hostagemod;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSaddle;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.CraftingManager;
import net.minecraft.item.crafting.ShapelessRecipes;
import net.minecraftforge.common.MinecraftForge;
import net.rystuff.hostagemod.blocks.BlockChair;
import net.rystuff.hostagemod.entity.EntityMountableBlock;
import net.rystuff.hostagemod.event.EventChairRope;
import net.rystuff.hostagemod.event.EventGag;
import net.rystuff.hostagemod.event.EventHandcuff;
import net.rystuff.hostagemod.event.EventHandler;
import net.rystuff.hostagemod.item.*;
import net.rystuff.hostagemod.proxy.ServerProxy;

import java.util.ArrayList;

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
    public static Item lock = new ItemLock();

    public static Block chair = new BlockChair();

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
        GameRegistry.registerItem(lock, "lock");
        GameRegistry.addShapelessRecipe(new ItemStack(key, 1), new ItemStack(key));
        GameRegistry.addShapelessRecipe(new ItemStack(handcuffs, 1), new ItemStack(handcuffs));
        GameRegistry.addShapelessRecipe(new ItemStack(handcuffs, 1), new ItemStack(key), new ItemStack(handcuffs));
        int entityId = EntityRegistry.findGlobalUniqueEntityId();
        EntityRegistry.registerGlobalEntityID(EntityMountableBlock.class, "mountableBlock", entityId);
        EntityRegistry.registerModEntity(EntityMountableBlock.class, "mountableBlock", entityId, HostageMod.instance, 64, 1, true);
        GameRegistry.registerBlock(chair, "chair");
    }
}
