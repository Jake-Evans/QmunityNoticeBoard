package net.jake_evans.serverNoticeBoard.common.core.handler;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

import java.io.File;

/**
 * Created by Jake on 01/06/2015.
 */
public final class ConfigHandler {

    private static final String CATEGORY_CLIENT = "client";
    private static final String CATEGORY_SERVER = "server";

    public static Configuration config;

    public static boolean shouldShow = true;
    public static String tab1Title = "Tab 1";
    public static String tab2Title = "Tab 2";
    public static String tab3Title = "Tab 3";
    public static String tab4Title = "Tab 4";


    public static String tab1Text = "Tab 1 Text";
    public static String tab2Text = "Tab 2 Text";
    public static String tab3Text = "Tab 3 Text";
    public static String tab4Text = "Tab 4 Text";

    public static void load(File file) {
        config = new Configuration(file);

        config.load();

        Property propShouldShow = config.get(CATEGORY_CLIENT, "should_show", shouldShow);
        propShouldShow.comment = "Set to true to enable showing the notice board on load, false to disable it";
        shouldShow = propShouldShow.getBoolean(shouldShow);

        //Tab Titles
        Property propTab1Title = config.get(CATEGORY_SERVER, "tab1_title", tab1Text);
        tab1Title = propTab1Title.getString();
        Property propTab2Title = config.get(CATEGORY_SERVER, "tab2_title", tab2Text);
        tab2Title = propTab2Title.getString();
        Property propTab3Title = config.get(CATEGORY_SERVER, "tab3_title", tab3Text);
        tab3Title = propTab3Title.getString();
        Property propTab4Title = config.get(CATEGORY_SERVER, "tab4_title", tab4Text);
        tab4Title = propTab4Title.getString();

        //Tab Icons - TODO

        //Tab Text
        Property propTab1Text = config.get(CATEGORY_SERVER, "tab1_text", tab1Title);
        tab1Title = propTab1Text.getString();
        Property propTab2Text = config.get(CATEGORY_SERVER, "tab2_text", tab2Title);
        tab2Title = propTab2Text.getString();
        Property propTab3Text = config.get(CATEGORY_SERVER, "tab3_text", tab3Title);
        tab3Title = propTab3Text.getString();
        Property propTab4Text = config.get(CATEGORY_SERVER, "tab4_text", tab4Title);
        tab4Title = propTab4Text.getString();

        config.save();
    }

    public static void toggleShow() {
        Property propShouldShow = config.get(CATEGORY_CLIENT, "should_show", shouldShow);
        propShouldShow.set(false);
        config.save();
    }
}
