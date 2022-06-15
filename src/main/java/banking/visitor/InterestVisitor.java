package banking.visitor;

import banking.domain.CheckingAccount;
import banking.domain.SavingsAccount;
import creditcard.constant.CreditCardType;
import creditcard.domain.CreditCardAccount;

import java.text.DecimalFormat;

public class InterestVisitor implements Visitor {
    DecimalFormat df = new DecimalFormat("##.##");

    @Override
    public double visit(SavingsAccount savingsAccount) {
        return (savingsAccount.getBalance() < 50000) ? savingsAccount.getBalance() * .015 : savingsAccount.getBalance() * .025;
    }

    @Override
    public double visit(CheckingAccount checkingAccounts) {
        return (checkingAccounts.getBalance() < 50000) ? checkingAccounts.getBalance() * .015 : checkingAccounts.getBalance() * .025;
    }

    @Override
    public double visit(CreditCardAccount creditCardAccount) {
        return creditCardAccount.getAccountType().equals(CreditCardType.GOLD.name()) ? creditCardAccount.getBalance() * 0.06 :
               creditCardAccount.getAccountType().equals(CreditCardType.SILVER.name()) ? creditCardAccount.getBalance() * 0.08 :
               creditCardAccount.getAccountType().equals(CreditCardType.BRONZE.name()) ? creditCardAccount.getBalance() * 0.1 : 0;
    }
}
