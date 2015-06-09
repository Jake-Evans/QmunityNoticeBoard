package net.jake_evans.serverNoticeBoard.client.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.jake_evans.serverNoticeBoard.client.network.GetConfigMessage;
import net.jake_evans.serverNoticeBoard.common.ServerNoticeBoard;
import net.jake_evans.serverNoticeBoard.common.core.handler.ConfigHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentTranslation;

/**
 * Created by Jake on 22/02/2015.
 */
public class ConnectionHandler {

    @SubscribeEvent
    public void PlayerLoggedInEvent(ClientConnectedToServerEvent event) {

        if (ConfigHandler.shouldShow) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("chat.message1"));
        }
        ServerNoticeBoard.proxy.network.sendToServer(new GetConfigMessage());
        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("chat.message2"));

    }
}
