package banking.domain;

import banking.constant.BankingAccountType;
import common.Account;
import framework.strategy.InterestStrategy;

public class SavingsAccount extends Account {

    public SavingsAccount(InterestStrategy interestStrategy) {
        super(interestStrategy);
    }

    @Override
    public String getAccountType() {
        return BankingAccountType.SAVINGS.name();
    }
}
