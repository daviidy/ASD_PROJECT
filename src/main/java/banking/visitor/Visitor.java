package banking.visitor;

import banking.domain.CheckingAccount;
import banking.domain.SavingsAccount;
import creditcard.domain.CreditCardAccount;

public interface Visitor {

    double visit(SavingsAccount savingsAccount);

    double visit(CheckingAccount checkingAccounts);

    double visit(CreditCardAccount creditCardAccount);
}
