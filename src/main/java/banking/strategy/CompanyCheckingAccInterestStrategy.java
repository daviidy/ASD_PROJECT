package banking.strategy;

import framework.strategy.InterestStrategy;

public class CompanyCheckingAccInterestStrategy implements InterestStrategy {
    @Override
    public double computeInterest(double accountBalance) {
        return (accountBalance < 50000) ? accountBalance * .015 : accountBalance * .025;
    }
}
