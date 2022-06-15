package creditcard.utils;

import framework.ui.IUIInvoker;
import common.dto.AccountDTO;

public class AccountDTOCreator {
    public static AccountDTO create(IUIInvoker control){
        return AccountDTO.builder()
                .accountNumber(control.getAccountNumber())
                .accountType(control.getAccountType())
                .customer(control.getCustomer()).build();
    }
}
