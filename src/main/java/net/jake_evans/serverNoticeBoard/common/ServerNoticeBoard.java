package net.jake_evans.serverNoticeBoard.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.jake_evans.serverNoticeBoard.common.core.proxy.CommonProxy;

@Mod(modid = ServerNoticeBoard.MODID, name = ServerNoticeBoard.NAME, version = ServerNoticeBoard.VERSION)
public class ServerNoticeBoard {
    public static final String MODID = "servernoticeboard";
    public static final String NAME = "Server Notice Board";
    public static final String VERSION = "0.0.34";
    @Instance(ServerNoticeBoard.MODID)

    public static ServerNoticeBoard instance = new ServerNoticeBoard();

    @SidedProxy(clientSide = "net.jake_evans.serverNoticeBoard.client.core.proxy.ClientProxy", serverSide = "net.jake_evans.serverNoticeBoard.common.core.proxy.CommonProxy")
    public static CommonProxy proxy;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        proxy.preinit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        proxy.init(event);

    }

}
