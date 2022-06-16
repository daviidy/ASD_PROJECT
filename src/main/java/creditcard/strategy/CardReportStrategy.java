package creditcard.strategy;

import common.Account;
import common.log.Log;
import creditcard.domain.CreditCardAccount;
import framework.strategy.ReportStrategy;
import framework.ui.pages.GenerateReport;

public class CardReportStrategy implements ReportStrategy {
    @Override
    public void generateReport(Account account, GenerateReport generateReport) {
        StringBuilder sb = new StringBuilder();
        sb.append("Account: " + account.getCustomer().getName());

            CreditCardAccount creditCardAccount = (CreditCardAccount)account;
            sb.append("Previous balance: " + creditCardAccount.getPreviousBalance() + "\n");
            sb.append("New balance: " + creditCardAccount.getNewBalance() + "\n");
            sb.append("Total charges: " + creditCardAccount.getTotalCharges() + "\n");
            sb.append("Total credits: " + creditCardAccount.getTotalCredit() + "\n");
            sb.append("Total due: " + creditCardAccount.getTotalDue() + "\n");


        generateReport.setReport(sb.toString());
        Log.getLogger().write(sb.toString());
    }
}
