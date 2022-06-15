package common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import common.domain.Customer;
import common.utils.AccountBuilder;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO implements Serializable {
    private String accountNumber;
    private String accountType;
    private Customer customer;
    public static AccountBuilder builder(){
        return new AccountBuilder();
    }

}
