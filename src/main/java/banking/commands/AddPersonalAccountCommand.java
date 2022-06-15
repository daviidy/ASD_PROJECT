package banking.commands;

import banking.service.BankAccountServiceImpl;
import common.dto.AccountDTOCreator;
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
