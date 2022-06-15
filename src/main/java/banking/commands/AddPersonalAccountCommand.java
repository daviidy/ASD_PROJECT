package banking.commands;

import creditcard.utils.AccountDTOCreator;
import banking.service.BankAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class AddPersonalAccountCommand implements Command {
    @Override
    public void execute(IUIInvoker control) {
        BankAccountServiceImpl
                .getInstance()
                .createAccount(AccountDTOCreator.create(control));
    }
}
