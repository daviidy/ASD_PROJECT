package banking.domain;

import banking.constant.BankingAccountType;
import common.Account;
import framework.strategy.InterestStrategy;

public class CheckingAccount extends Account {

    public CheckingAccount(InterestStrategy interestStrategy) {
        super(interestStrategy);
    }

    @Override
    public String getAccountType() {
        return BankingAccountType.CHECKING.name();
    }
}
