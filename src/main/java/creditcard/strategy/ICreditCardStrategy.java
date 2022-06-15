package creditcard.strategy;

import framework.strategy.InterestStrategy;

public interface ICreditCardStrategy extends InterestStrategy {

    double computeInterest(double totalCredit);

    double computeMonthlyMinimumPayment(double totalCredit);

    double computeBalance(double previousBalance, double totalCredit, double totalCharges);

    double computeTotalDue(double newBalance);
}