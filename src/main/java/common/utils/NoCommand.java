package common.utils;

import framework.command.Command;
import framework.ui.IUIInvoker;

public class NoCommand implements Command {
    @Override
    public void execute(IUIInvoker uiControl) {}
}