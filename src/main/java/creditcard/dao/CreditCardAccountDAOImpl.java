package creditcard.dao;

import common.Account;
import common.dao.AccountDAO;
import common.log.Log;

import java.util.ArrayList;
import java.util.Collection;

public class CreditCardAccountDAOImpl implements AccountDAO {
    private static volatile CreditCardAccountDAOImpl instance;
    Collection<Account> accountList = new ArrayList<>();

    public static CreditCardAccountDAOImpl getInstance() {
        if (instance == null)
            synchronized (CreditCardAccountDAOImpl.class) {
                if (instance == null)
                    instance = new CreditCardAccountDAOImpl();
        }
        return instance;
    }

    @Override
    public void create(Account account) {
        accountList.add(account);
        Log.getLogger().write("CreditCard Account Created with Card Number: " + account.getAccountNumber() + ", CustomerName: " + account.getCustomer().getName());
    }

    @Override
    public void update(Account account) {
        Account isAccountExist = getAccountByAccountNumber(account.getAccountNumber());
        if (isAccountExist != null) {
            accountList.remove(isAccountExist); // remove the old
            accountList.add(account); // add the new
        }
        System.out.println("Updating account " + account.getAccountNumber() + " for customer " + account.getCustomer().getName());
    }

    @Override
    public Account getAccountByAccountNumber(String accountNumber) {
        for (Account account : accountList) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    @Override
    public Collection<Account> getAccounts() {
        return accountList;
    }
}
