package creditcard.service;

import creditcard.strategy.BronzeCreditCardStrategy;
import creditcard.strategy.CardReportStrategy;
import framework.observer.EmailSender;
import common.dto.AccountDTO;
import common.Account;
import common.AccountService;
import creditcard.domain.CreditCardAccount;
import creditcard.constant.CreditCardType;
import creditcard.dao.CreditCardAccountDAOImpl;
import creditcard.strategy.GoldCreditCardStrategy;
import creditcard.strategy.SilverCreditCardStrategy;
import framework.ui.pages.GenerateReport;

public class CreditCardAccountServiceImpl extends AccountService {
    private static volatile CreditCardAccountServiceImpl instance;

    private CreditCardAccountServiceImpl() {
        super(new CreditCardAccountDAOImpl());
        setPersonalAccountTransferAlertBalance(400);
        this.registerObserver(new EmailSender(this));
    }
    // singleton
    public static CreditCardAccountServiceImpl getInstance() {
        if (instance == null)
            synchronized (CreditCardAccountServiceImpl.class) {
                if (instance == null)
                    instance = new CreditCardAccountServiceImpl();
        }
        return instance;
    }

    @Override
    public Account createAccountFactory(AccountDTO accountDTO){
        CreditCardType creditCardType = CreditCardType.valueOf(accountDTO.getAccountType());
        if(creditCardType.equals(CreditCardType.BRONZE)){
            return new CreditCardAccount(new BronzeCreditCardStrategy(), creditCardType);
        }else if(creditCardType.equals(CreditCardType.SILVER)){
            return new CreditCardAccount(new SilverCreditCardStrategy(), creditCardType);
        }else if(creditCardType.equals(CreditCardType.GOLD)){
            return new CreditCardAccount(new GoldCreditCardStrategy(), creditCardType);
        }else {
            throw new UnsupportedOperationException("Invalid Credit Card Type!");
        }
    }


    public static void createReport(String accountNumber, GenerateReport generateReport) {
        Account account =instance.getAccount(accountNumber);
        instance.generateReport(account, generateReport, new CardReportStrategy());
    }
}
