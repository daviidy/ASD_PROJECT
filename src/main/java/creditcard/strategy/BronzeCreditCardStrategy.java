package creditcard.strategy;

public class BronzeCreditCardStrategy implements ICreditCardStrategy {

    @Override
    public double computeInterest(double totalCredit) {
        return totalCredit * 0.1;
    }

    @Override
    public double computeMonthlyMinimumPayment(double totalCredit) {
        return totalCredit * 0.14;
    }

    @Override
    public double computeBalance(double previousBalance, double totalCredit, double totalCharges) {
        return previousBalance - totalCredit + totalCharges + 0.1 * (previousBalance - totalCredit);
    }

    @Override
    public double computeTotalDue(double newBalance) {
        return newBalance * 0.14;
    }
}
