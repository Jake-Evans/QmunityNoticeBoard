package net.jake_evans.serverNoticeBoard.client.core.proxy;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.jake_evans.serverNoticeBoard.client.command.CommandRules;
import net.jake_evans.serverNoticeBoard.common.core.proxy.CommonProxy;
import net.jake_evans.serverNoticeBoard.common.handler.ConnectionHandler;
import net.minecraftforge.client.ClientCommandHandler;

/**
 * Created by Jake on 09/06/2015.
 */
public class ClientProxy extends CommonProxy {

    public static void preinit(FMLPreInitializationEvent event) {
        ClientCommandHandler.instance.registerCommand(new CommandRules());
    }

    public static void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(new ConnectionHandler());
    }
}
