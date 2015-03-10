package net.jake_evans.serverNoticeBoard.gui;

import net.jake_evans.serverNoticeBoard.ServerNoticeBoard;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import org.lwjgl.opengl.GL11;

/**
 * Created by Jake on 28/02/2015.
 */
public class NoticeBoardGUI extends GuiScreen {

    int guiWidth = 195;
    int guiHeight = 136;

    int tab1Width = 28;
    int tab1Height = 32;


    //These could be done modularly, but no point as it's not for public use.
    boolean tab1 = true;
    boolean tab2;
    boolean tab3;
    boolean tab4;

    int tabOffset = 0;

    //Returning text from the language file, this could be switched to a config for public use.
    public static String localize(String key) {
        return StatCollector.translateToLocal(key);
    }

    @Override
    public void drawScreen(int x, int y, float ticks) {
        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;
        int tab = guiY + 20;
        int tabY = tab + tabOffset;
        GL11.glColor4f(1, 1, 1, 1);
        drawDefaultBackground();
        mc.renderEngine.bindTexture(new ResourceLocation(ServerNoticeBoard.MODID, "textures/gui/noticeBoardGUI.png"));
        drawTexturedModalRect(guiX, guiY, 0, 28, guiWidth, guiHeight);
        drawTexturedModalRect(guiX + 175, guiY + 18, 0, 0, 12, 12);
        drawTexturedModalRect(guiX + 175, guiY + 116, 12, 0, 12, 12);
        buttonList.clear();
        if (tab1) {
            drawTexturedModalRect(guiX, guiY - 28, 195, 0, tab1Width, tab1Height);
            drawTexturedModalRect(guiX + 29, guiY - 26, 223, 32, tab1Width, 30);
            drawTexturedModalRect(guiX + 58, guiY - 26, 223, 32, tab1Width, 30);
            drawTexturedModalRect(guiX + 87, guiY - 26, 223, 32, tab1Width, 30);
            fontRendererObj.drawString(localize("gui.tab1.name"), guiX + 8, guiY + 8, 0x373737);
            String tab1text = localize("gui.tab1.text").replace("\\n", "\n");
            GL11.glEnable(GL11.GL_SCISSOR_TEST);
            GL11.glScissor((guiX + 10) * computeGuiScale(), (guiY + 9) * computeGuiScale(), 162 * computeGuiScale(), 109 * computeGuiScale());
            fontRendererObj.drawSplitString(tab1text, guiX + 10, tabY, 158, 0x00000);
            GL11.glDisable(GL11.GL_SCISSOR_TEST);
        }
        if (tab2) {
            drawTexturedModalRect(guiX, guiY - 26, 195, 32, tab1Width, 30);
            drawTexturedModalRect(guiX + 29, guiY - 28, 223, 0, tab1Width, tab1Height);
            drawTexturedModalRect(guiX + 58, guiY - 26, 223, 32, tab1Width, 30);
            drawTexturedModalRect(guiX + 87, guiY - 26, 223, 32, tab1Width, 30);
            fontRendererObj.drawString(localize("gui.tab2.name"), guiX + 8, guiY + 8, 0x373737);
            String tab2text = localize("gui.tab2.text").replace("\\n", "\n");
            GL11.glEnable(GL11.GL_SCISSOR_TEST);
            GL11.glScissor((guiX + 10) * computeGuiScale(), (guiY + 9) * computeGuiScale(), 162 * computeGuiScale(), 109 * computeGuiScale());
            fontRendererObj.drawSplitString(tab2text, guiX + 10, tabY, 158, 0x00000);
            GL11.glDisable(GL11.GL_SCISSOR_TEST);
        }
        if (tab3) {
            drawTexturedModalRect(guiX, guiY - 26, 195, 32, tab1Width, 30);
            drawTexturedModalRect(guiX + 29, guiY - 26, 223, 32, tab1Width, 30);
            drawTexturedModalRect(guiX + 58, guiY - 28, 223, 0, tab1Width, tab1Height);
            drawTexturedModalRect(guiX + 87, guiY - 26, 223, 32, tab1Width, 30);
            fontRendererObj.drawString(localize("gui.tab3.name"), guiX + 8, guiY + 8, 0x373737);
            String tab2text = localize("gui.tab3.text").replace("\\n", "\n");
            GL11.glEnable(GL11.GL_SCISSOR_TEST);
            GL11.glScissor((guiX + 10) * computeGuiScale(), (guiY + 9) * computeGuiScale(), 162 * computeGuiScale(), 109 * computeGuiScale());
            fontRendererObj.drawSplitString(tab2text, guiX + 10, tabY, 158, 0x00000);
            GL11.glDisable(GL11.GL_SCISSOR_TEST);
        }
        if (tab4) {
            drawTexturedModalRect(guiX, guiY - 26, 195, 32, tab1Width, 30);
            drawTexturedModalRect(guiX + 29, guiY - 26, 223, 32, tab1Width, 30);
            drawTexturedModalRect(guiX + 58, guiY - 26, 223, 32, tab1Width, 30);
            drawTexturedModalRect(guiX + 87, guiY - 28, 223, 0, tab1Width, tab1Height);
            fontRendererObj.drawString(localize("gui.tab4.name"), guiX + 8, guiY + 8, 0x373737);
            String tab2text = localize("gui.tab4.text").replace("\\n", "\n");
            GL11.glEnable(GL11.GL_SCISSOR_TEST);
            GL11.glScissor((guiX + 10) * computeGuiScale(), (guiY + 9) * computeGuiScale(), 162 * computeGuiScale(), 109 * computeGuiScale());
            fontRendererObj.drawSplitString(tab2text, guiX + 10, tabY, 158, 0x00000);
            GL11.glDisable(GL11.GL_SCISSOR_TEST);
        }


        renderItem(Items.written_book, -20, 6);
        renderItem(Items.filled_map, -20, 35);
        renderItem(Items.diamond_sword, -20, 64);

        mc.renderEngine.bindTexture(new ResourceLocation(ServerNoticeBoard.MODID, "textures/gui/noticeBoardGUI.png"));
        drawTexturedModalRect(guiX + 92, guiY - 20, 195, 79, 18, 18);

        super.drawScreen(x, y, ticks);
    }

    @Override
    protected void mouseClicked(int x, int y, int button) {

        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;

        int guiTop = y - guiY;
        int guiLeft = x - guiX;

        //Tab Buttons
        if (guiLeft >= 0 && guiLeft <= 28 && guiTop >= -28 && guiTop <= 1) {
            tabOffset = 0;
            tab1 = true;
            tab2 = false;
            tab3 = false;
            tab4 = false;
        }
        if (guiLeft >= 29 && guiLeft <= 57 && guiTop >= -28 && guiTop <= 1) {
            tabOffset = 0;
            tab1 = false;
            tab2 = true;
            tab3 = false;
            tab4 = false;
        }
        if (guiLeft >= 58 && guiLeft <= 86 && guiTop >= -28 && guiTop <= 1) {
            tabOffset = 0;
            tab1 = false;
            tab2 = false;
            tab3 = true;
            tab4 = false;
        }
        if (guiLeft >= 87 && guiLeft <= 113 && guiTop >= -28 && guiTop <= 1) {
            tabOffset = 0;
            tab1 = false;
            tab2 = false;
            tab3 = false;
            tab4 = true;
        }

        //Scroll buttons
        if (guiLeft >= 175 && guiLeft <= 187 && guiTop >= 18 && guiTop <= 30) {
            if (tabOffset >= 0) {
                tabOffset = 0;
            } else {
                tabOffset += 8;
            }
        }
        if (guiLeft >= 175 && guiLeft <= 187 && guiTop >= 116 && guiTop <= 128) {
            tabOffset -= 8;
        }
//        System.out.println("Pressed! X: " + x + ". Y: " + y);
//        System.out.println("Top: " + guiTop + ". Left: " + guiLeft);

        super.mouseClicked(x, y, button);
    }

    private void renderItem(Item item, int y, int x) {
        ItemStack stack;
        stack = new ItemStack(item);

        int guiX = (width - guiWidth) / 2;
        int guiY = (height - guiHeight) / 2;

        GL11.glPushMatrix();
        GL11.glColor4f(1, 1, 1, 1);
        IIcon iicon1 = stack.getIconIndex();
        this.mc.renderEngine.bindTexture(TextureMap.locationItemsTexture);
        this.drawTexturedModelRectFromIcon(guiX + x, guiY + y, iicon1, 16, 16);
        GL11.glPopMatrix();
    }

    public static int computeGuiScale() {
        Minecraft mc = Minecraft.getMinecraft();
        int scaleFactor = 1;

        int k = mc.gameSettings.guiScale;

        if (k == 0) {
            k = 1000;
        }

        while (scaleFactor < k && mc.displayWidth / (scaleFactor + 1) >= 320 && mc.displayHeight / (scaleFactor + 1) >= 240) {
            ++scaleFactor;
        }
        return scaleFactor;
    }

}