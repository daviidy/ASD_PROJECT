package creditcard.commands;

import creditcard.service.CreditCardAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class DepositCommand implements Command {
    @Override
    public void execute(IUIInvoker iuiInvoker) {
        CreditCardAccountServiceImpl
                .getInstance()
                .deposit(iuiInvoker.getAccountNumber(), Double.parseDouble(iuiInvoker.getAmount()));
    }
}
