package banking.strategy;

import framework.strategy.InterestStrategy;

public class CompanySavingAccInterestStrategy implements InterestStrategy {
    @Override
    public double computeInterest(double accountBalance) {
        return (accountBalance < 100000) ? accountBalance * .025 : accountBalance * .035;
    }
}
