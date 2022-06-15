package creditcard.domain;

import banking.visitor.Visitor;
import common.Account;
import common.domain.AccountEntry;
import creditcard.constant.CreditCardType;
import creditcard.strategy.ICreditCardStrategy;

import java.time.LocalDate;

public class CreditCardAccount extends Account {
    LocalDate todayDate = LocalDate.now();
    ICreditCardStrategy ICreditCardStrategy;
    CreditCardType creditCardType;

    public CreditCardAccount(ICreditCardStrategy creditCardCalculator, CreditCardType creditCardType) {
        super(creditCardCalculator);
        this.ICreditCardStrategy =  creditCardCalculator;
        this.creditCardType =  creditCardType;
    }

    @Override
    public double accept(Visitor visitor) {
        return visitor.visit(this);
    }

    public double getPreviousBalance() {
        return getAccountEntries()
                .stream()
                .filter(entry->entry.getDate().isBefore(todayDate.withDayOfMonth(1)))
                .mapToDouble(AccountEntry::getAmount)
                .reduce(0, Double::sum);
    }

    public double getTotalCredit() {
       return getAccountEntries()
                .stream()
                .filter(entry->entry.getDate().isAfter(todayDate.withDayOfMonth(1)))
                .filter(entry->entry.getAmount()>0)
                .mapToDouble(AccountEntry::getAmount)
                .reduce(0,Double::sum);
    }

    public double getTotalCharges() {
        return getAccountEntries()
                .stream()
                .filter(entry->entry.getDate().isAfter(todayDate.withDayOfMonth(1)))
                .filter(entry->entry.getAmount()>0)
                .mapToDouble(AccountEntry::getAmount)
                .reduce(0,Double::sum);
    }

    public double getNewBalance() {
        return this.ICreditCardStrategy.computeBalance(getPreviousBalance(), getTotalCredit(), getTotalCharges());
    }

    public double getTotalDue() {
        return this.ICreditCardStrategy.computeTotalDue(getNewBalance());
    }

    public double getMonthlyMinimumPayment() {
        return this.ICreditCardStrategy.computeMonthlyMinimumPayment(getTotalCredit());
    }

    public double getMonthlyInterest() {
        return this.ICreditCardStrategy.computeInterest(getTotalCredit());
    }

    @Override
    public String getAccountType() {
        return creditCardType.name();
    }
}
