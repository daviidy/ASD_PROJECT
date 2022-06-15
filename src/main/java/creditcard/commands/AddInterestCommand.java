package creditcard.commands;

import creditcard.service.CreditCardAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class AddInterestCommand implements Command {
    @Override
    public void execute(IUIInvoker control) {
        CreditCardAccountServiceImpl.getInstance().addInterest();
    }
}
