package creditcard.commands;

import creditcard.service.CreditCardAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class WithdrawCommand implements Command {
    @Override
    public void execute(IUIInvoker iuiInvoker) {
        CreditCardAccountServiceImpl
                .getInstance()
                .withdraw(iuiInvoker.getAccountNumber(), Double.parseDouble(iuiInvoker.getAmount()));
    }
}
