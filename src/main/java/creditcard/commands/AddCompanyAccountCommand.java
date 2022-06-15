package creditcard.commands;

import creditcard.utils.AccountDTOCreator;
import common.dto.AccountDTO;
import framework.command.Command;
import creditcard.service.CreditCardAccountServiceImpl;
import framework.ui.IUIInvoker;

public class AddCompanyAccountCommand implements Command {

    public void execute(IUIInvoker control) {
        AccountDTO accountDTO = AccountDTOCreator.create(control);
        CreditCardAccountServiceImpl.getInstance()
                .createAccount(accountDTO);
    }
}
