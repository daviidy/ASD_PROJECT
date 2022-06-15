package banking.commands;

import banking.service.BankAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class WithdrawCommand implements Command {
    @Override
    public void execute(IUIInvoker uiControl) {
        BankAccountServiceImpl.getInstance().withdraw(uiControl.getAccountNumber(), Double.parseDouble(uiControl.getAmount()));
    }
}
