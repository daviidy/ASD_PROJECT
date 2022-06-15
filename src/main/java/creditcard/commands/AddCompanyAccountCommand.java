package creditcard.commands;

import common.dto.AccountDTOCreator;
import common.dto.AccountDTO;
import framework.command.Command;
import creditcard.service.CreditCardAccountServiceImpl;
import framework.ui.IUIInvoker;

public class AddCompanyAccountCommand implements Command {

    public void execute(IUIInvoker iuiInvoker) {
        AccountDTO accountDTO = AccountDTOCreator.create(iuiInvoker);
        CreditCardAccountServiceImpl.getInstance()
                .createAccount(accountDTO);
    }
}
