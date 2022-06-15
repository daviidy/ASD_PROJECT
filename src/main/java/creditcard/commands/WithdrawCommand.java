package creditcard.commands;

import creditcard.service.CreditCardAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class WithdrawCommand implements Command {
    @Override
    public void execute(IUIInvoker uiControl) {
        CreditCardAccountServiceImpl
                .getInstance()
                .withdraw(uiControl.getAccountNumber(), Double.parseDouble(uiControl.getAmount()));
    }
}
