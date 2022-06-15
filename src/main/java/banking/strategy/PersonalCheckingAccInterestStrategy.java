package banking.strategy;

import framework.strategy.InterestStrategy;

public class PersonalCheckingAccInterestStrategy implements InterestStrategy {
    @Override
    public double computeInterest(double accountBalance) {
        return (accountBalance < 1000) ? accountBalance * .015 : accountBalance * .025;
    }
}
