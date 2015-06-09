package net.jake_evans.serverNoticeBoard.common.network.handler;

import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;
import net.jake_evans.serverNoticeBoard.client.network.GetConfigMessage;
import net.jake_evans.serverNoticeBoard.common.core.handler.ConfigHandler;
import net.jake_evans.serverNoticeBoard.common.core.proxy.CommonProxy;
import net.jake_evans.serverNoticeBoard.common.network.ConfigMessage;

/**
 * Created by Jake on 09/06/2015.
 */
public class ConfigServerMessageHandler implements IMessageHandler<GetConfigMessage, IMessage> {

    @Override
    public IMessage onMessage(GetConfigMessage message, MessageContext ctx) {
        CommonProxy.network.sendTo(new ConfigMessage(ConfigHandler.tab1Text), ctx.getServerHandler().playerEntity);
        return null;
    }
}
