package net.jake_evans.serverNoticeBoard.handler;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.network.FMLNetworkEvent.ClientConnectedToServerEvent;
import net.jake_evans.serverNoticeBoard.ServerNoticeBoard;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ChatComponentTranslation;

/**
 * Created by Jake on 22/02/2015.
 */
public class ConnectionHandler {

    @SubscribeEvent
    public void PlayerLoggedInEvent(ClientConnectedToServerEvent event) {

        if (ServerNoticeBoard.shouldShow.getString().equalsIgnoreCase("true")) {
            Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("chat.message1"));
            ServerNoticeBoard.shouldShow.set("false");
            ServerNoticeBoard.config.save();
        }

        Minecraft.getMinecraft().ingameGUI.getChatGUI().printChatMessage(new ChatComponentTranslation("chat.message2"));

    }
}
