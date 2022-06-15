package banking.dao;

import common.Account;
import common.dao.AccountDAO;
import common.log.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class BankingAccountDAOImpl implements AccountDAO {
    private static volatile BankingAccountDAOImpl instance;
    Collection<Account> accounts = new ArrayList<>();

    private BankingAccountDAOImpl() {
    }

    public static BankingAccountDAOImpl getInstance() {
        if (instance == null)
            synchronized (BankingAccountDAOImpl.class) {
                if (instance == null)
                    instance = new BankingAccountDAOImpl();
            }
        return instance;
    }

    @Override
    public void create(Account account) {
        accounts.add(account);
        Log.getLogger().write("Account Created with AccountNumber: " + account.getAccountNumber() +
                ", CustomerName: " +
                account.getCustomer().getName());
    }

    @Override
    public void update(Account account) {
        Account isAccountExist = getAccountByAccountNumber(account.getAccountNumber());
        if (isAccountExist != null) {
            accounts.remove(isAccountExist); // REMOVES THE OLD
            accounts.add(account); // add the new
        }
        Log.getLogger().write("Updating account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        return accounts
                .stream()
                .filter(account -> Objects.equals(account.getAccountNumber(), accountNumber))
                .findFirst()
                .orElse(null);

    }

    @Override
    public Collection<Account> getAccounts() {
        return accounts;
    }
}
