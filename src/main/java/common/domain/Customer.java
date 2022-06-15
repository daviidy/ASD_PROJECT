package common.domain;

import common.Account;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private final Set<Account> accounts =new HashSet<>();
    private int customerId;
    private String name;
    private String street;
    private String city;
    private String state;
    private int zip;
    private String email;

    public void addAccount(Account account) {
        this.accounts.add(account);
    }

    public void removeAccount(Account account) {
        this.accounts.remove(account);
    }
}
