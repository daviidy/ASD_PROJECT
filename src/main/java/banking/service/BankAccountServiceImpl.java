package banking.service;

import framework.ui.pages.GenerateReport;
import common.utils.ApplicationMessageConstant;
import common.dto.AccountDTO;
import banking.constant.BankingAccountType;
import banking.domain.CheckingAccount;
import banking.domain.SavingsAccount;
import banking.dao.BankingAccountDAOImpl;
import banking.strategy.CompanyCheckingAccInterestStrategy;
import banking.strategy.CompanySavingAccInterestStrategy;
import banking.strategy.PersonalCheckingAccInterestStrategy;
import banking.strategy.PersonalSavingsAccInterestStrategy;
import common.Account;
import common.AccountService;
import common.domain.Customer;
import framework.domain.CompanyAccount;
import framework.domain.PersonalAccount;
import framework.observer.EmailSender;

public class BankAccountServiceImpl extends AccountService {
    private static volatile BankAccountServiceImpl instance;

    private BankAccountServiceImpl() {
        super(BankingAccountDAOImpl.getInstance());
        setPersonalAccountTransferAlertBalance(500);
        this.registerObserver(new EmailSender(this));
    }

    public static BankAccountServiceImpl getInstance() {
        if (instance == null)
            synchronized (BankAccountServiceImpl.class) {
                if (instance == null)
                    instance = new BankAccountServiceImpl();
            }
        return instance;
    }

    @Override
    public Account createAccountFactory(AccountDTO accountDTO) throws UnsupportedOperationException {
        Customer customer = accountDTO.getCustomer();
        BankingAccountType bankAccountType = BankingAccountType.valueOf(accountDTO.getAccountType());
        return getConcreteAccountObject(customer, bankAccountType);
    }

    private Account getConcreteAccountObject(Customer customer, BankingAccountType bankAccountType) throws UnsupportedOperationException {
        if (customer instanceof PersonalAccount)
            return (bankAccountType == BankingAccountType.CHECKING)
                    ? new CheckingAccount(new PersonalCheckingAccInterestStrategy())
                    : new SavingsAccount(new PersonalSavingsAccInterestStrategy());
        else if (customer instanceof CompanyAccount)
            return (bankAccountType == BankingAccountType.CHECKING)
                    ? new CheckingAccount(new CompanyCheckingAccInterestStrategy())
                    : new SavingsAccount(new CompanySavingAccInterestStrategy());

        throw new UnsupportedOperationException(ApplicationMessageConstant.INVALID_ACCOUNT_TYPE.name);
    }

    public static void createReport(String accountNumber, GenerateReport generateReport) {
        Account account = instance.getAccount(accountNumber);
        instance.generateReport(account, generateReport, true);
    }

}
