package banking.commands;

import banking.service.BankAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class AddInterestCommand implements Command {
    @Override
    public void execute(IUIInvoker control) {
        BankAccountServiceImpl
                .getInstance()
                .addInterest();
    }
}
