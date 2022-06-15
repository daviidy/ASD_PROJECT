package banking.domain;

import banking.constant.BankingAccountType;
import banking.visitor.Visitor;
import common.Account;
import framework.strategy.InterestStrategy;

public class CheckingAccount extends Account {

    public CheckingAccount(InterestStrategy interestStrategy) {
        super(interestStrategy);
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    @Override
    public String getAccountType() {
        return BankingAccountType.CHECKING.name();
    }
}
