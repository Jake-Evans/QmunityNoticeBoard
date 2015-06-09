package net.jake_evans.serverNoticeBoard.common.core.proxy;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import cpw.mods.fml.relauncher.Side;
import net.jake_evans.serverNoticeBoard.client.network.GetConfigMessage;
import net.jake_evans.serverNoticeBoard.client.network.handler.ConfigClientMessageHandler;
import net.jake_evans.serverNoticeBoard.common.ServerNoticeBoard;
import net.jake_evans.serverNoticeBoard.common.core.handler.ConfigHandler;
import net.jake_evans.serverNoticeBoard.common.network.ConfigMessage;
import net.jake_evans.serverNoticeBoard.common.network.handler.ConfigServerMessageHandler;
import net.minecraftforge.common.config.Property;

/**
 * Created by Jake on 09/06/2015.
 */
public class CommonProxy {

    public static Property shouldShow;

    public static SimpleNetworkWrapper network;

    public static void preinit(FMLPreInitializationEvent event) {
        ConfigHandler.load(event.getSuggestedConfigurationFile());

        network = NetworkRegistry.INSTANCE.newSimpleChannel(ServerNoticeBoard.MODID);
        network.registerMessage(ConfigClientMessageHandler.class, ConfigMessage.class, 0, Side.CLIENT);
        network.registerMessage(ConfigServerMessageHandler.class, GetConfigMessage.class, 0, Side.SERVER);

    }

    public static void init(FMLInitializationEvent event) {

    }

    public static void postinit(FMLPostInitializationEvent event) {

    }
}
