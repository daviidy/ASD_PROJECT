package framework.command;

import framework.ui.IUIInvoker;

public interface Command {
    void execute(IUIInvoker control);
}
