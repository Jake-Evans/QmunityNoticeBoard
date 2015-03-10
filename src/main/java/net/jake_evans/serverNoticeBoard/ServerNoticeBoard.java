package net.jake_evans.serverNoticeBoard;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.jake_evans.serverNoticeBoard.command.CommandRules;
import net.jake_evans.serverNoticeBoard.handler.ConnectionHandler;
import net.minecraftforge.client.ClientCommandHandler;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

@Mod(modid = ServerNoticeBoard.MODID, name = ServerNoticeBoard.NAME, version = ServerNoticeBoard.VERSION)
public class ServerNoticeBoard {
    public static final String MODID = "servernoticeboard";
    public static final String NAME = "Server Notice Board";
    public static final String VERSION = "0.0.34";
    @Instance(ServerNoticeBoard.MODID)

    public static ServerNoticeBoard instance = new ServerNoticeBoard();
    public static Property shouldShow;
    public static Configuration config;

    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        config = new Configuration(event.getSuggestedConfigurationFile());
        config.load();
        //TODO: Change to a boolean
        shouldShow = config.get(Configuration.CATEGORY_GENERAL, "shouldShow", "true");
        config.save();

        ClientCommandHandler.instance.registerCommand(new CommandRules());
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        FMLCommonHandler.instance().bus().register(new ConnectionHandler());
    }

}
