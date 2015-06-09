package net.jake_evans.serverNoticeBoard.client.network.handler;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.jake_evans.serverNoticeBoard.common.core.handler.ConfigHandler;
import net.jake_evans.serverNoticeBoard.common.network.ConfigMessage;

/**
 * Created by Jake on 09/06/2015.
 */
public class ConfigClientMessageHandler implements IMessageHandler<ConfigMessage, IMessage> {
    @Override
    public IMessage onMessage(ConfigMessage message, MessageContext ctx) {
        ConfigHandler.tab1Text = message.text;
        return null;
    }
}
