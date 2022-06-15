package banking.commands;

import banking.service.BankAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class WithdrawCommand implements Command {
    @Override
    public void execute(IUIInvoker iuiInvoker) {
        BankAccountServiceImpl.getInstance().withdraw(iuiInvoker.getAccountNumber(), Double.parseDouble(iuiInvoker.getAmount()));
    }
}
