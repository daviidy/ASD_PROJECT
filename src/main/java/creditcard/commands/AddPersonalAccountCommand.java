package creditcard.commands;

import creditcard.utils.AccountDTOCreator;
import framework.command.Command;
import creditcard.service.CreditCardAccountServiceImpl;
import framework.ui.IUIInvoker;

public class AddPersonalAccountCommand implements Command {
    @Override
    public void execute(IUIInvoker control) {
        CreditCardAccountServiceImpl
                .getInstance()
                .createAccount(AccountDTOCreator.create(control));
    }
}
