package net.jake_evans.serverNoticeBoard.client.util;

/**
 * Created by Jake on 28/02/2015.
 */

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;

public class DelayedGuiDisplayTicker {
    private int ticks;
    private Minecraft mc;
    private GuiScreen screen;

    public DelayedGuiDisplayTicker(int ticks, GuiScreen screen) {
        this.ticks = ticks;
        this.mc = FMLClientHandler.instance().getClient();
        this.screen = screen;
        FMLCommonHandler.instance().bus().register(this);
    }

    @SubscribeEvent
    public void onTick(TickEvent.ClientTickEvent event) {
        if (event.phase.equals(TickEvent.Phase.START))
            return;

        if (--ticks <= 0) {
            mc.displayGuiScreen(screen);
            FMLCommonHandler.instance().bus().unregister(this);
        }
    }
}