package banking.strategy;

import framework.strategy.InterestStrategy;

public class PersonalSavingsAccInterestStrategy implements InterestStrategy {

    @Override
    public double computeInterest(double accountBalance) {
        return (accountBalance < 1000) ? accountBalance * .025 : accountBalance * .050;
    }
}
