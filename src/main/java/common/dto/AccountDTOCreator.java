package common.dto;

import framework.ui.IUIInvoker;
import common.dto.AccountDTO;

public class AccountDTOCreator {
    public static AccountDTO create(IUIInvoker control){
      return new AccountDTO(control.getAccountNumber(), control.getAccountType(), control.getCustomer());
    }
}
