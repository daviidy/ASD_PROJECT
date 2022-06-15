package common.dao;

import common.Account;

import java.util.Collection;

public interface AccountDAO {
    void create(Account account);
    void update(Account account);
    Account getAccountByAccountNumber(String accountNumber);
    Collection<Account> getAccounts();
}
