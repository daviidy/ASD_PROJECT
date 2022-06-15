package creditcard.commands;

import common.dto.AccountDTOCreator;
import framework.command.Command;
import creditcard.service.CreditCardAccountServiceImpl;
import framework.ui.IUIInvoker;

public class AddPersonalAccountCommand implements Command {
    @Override
    public void execute(IUIInvoker iuiInvoker) {
        CreditCardAccountServiceImpl
                .getInstance()
                .createAccount(AccountDTOCreator.create(iuiInvoker));
    }
}
