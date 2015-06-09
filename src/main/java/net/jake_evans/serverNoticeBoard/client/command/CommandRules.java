package net.jake_evans.serverNoticeBoard.client.command;

import net.jake_evans.serverNoticeBoard.client.gui.NoticeBoardGUI;
import net.jake_evans.serverNoticeBoard.client.util.DelayedGuiDisplayTicker;
import net.minecraft.command.ICommand;
import net.minecraft.command.ICommandSender;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jake on 23/02/2015.
 */
public class CommandRules implements ICommand {

    private final List aliases;

    public CommandRules() {
        aliases = new ArrayList();
        aliases.add("rules");
    }

    @Override
    public String getCommandName() {
        return "rules";
    }

    @Override
    public String getCommandUsage(ICommandSender p_71518_1_) {
        return "/rules";
    }

    @Override
    public List getCommandAliases() {
        return this.aliases;
    }

    @Override
    public void processCommand(ICommandSender p_71515_1_, String[] p_71515_2_) {
        new DelayedGuiDisplayTicker(10, new NoticeBoardGUI());
    }

    @Override
    public boolean canCommandSenderUseCommand(ICommandSender p_71519_1_) {
        return true;
    }

    @Override
    public List addTabCompletionOptions(ICommandSender p_71516_1_, String[] p_71516_2_) {
        return null;
    }

    @Override
    public boolean isUsernameIndex(String[] p_82358_1_, int p_82358_2_) {
        return false;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}
