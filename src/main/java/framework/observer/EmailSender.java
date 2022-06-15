package framework.observer;

import creditcard.service.CreditCardAccountServiceImpl;
import framework.constant.AccountOperationConstant;
import framework.domain.CompanyAccount;
import framework.domain.PersonalAccount;
import common.Account;
import common.AccountService;
import common.domain.AccountTransaction;
import common.log.Log;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class EmailSender implements Observer {
    private final AccountService accountService;
    private boolean emailSent = false;

    public EmailSender(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public void update() {
        Map<Account, ArrayList<AccountTransaction>> accountTransactions = accountService.getAccountTransactions();
        if(accountTransactions.size() == 0) return;

        StringBuilder sb = new StringBuilder();

        sb.append("\n");
        sb.append("OBSERVER_PATTERN: Pulling changed accounts from AccountService\n");
        sb.append(" ＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿ Sending transaction emails ＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿\n");
        sb.append("|                                                                                       |\n");

        for (Map.Entry<Account, ArrayList<AccountTransaction>> entry : accountTransactions.entrySet()) {
            Account account = entry.getKey();
            List<AccountTransaction> transactions = entry.getValue();

            if (account.getCustomer() instanceof CompanyAccount || account.getCustomer() instanceof PersonalAccount) {

                for (Iterator<AccountTransaction> it = transactions.iterator(); it.hasNext(); ) {
                    AccountTransaction transaction = it.next();

                    if(!transaction.getTransactionOperation().equals(AccountOperationConstant.WITHDRAW) && !transaction.getTransactionOperation().equals(AccountOperationConstant.DEPOSIT)){
                        continue;
                    }

                    if(accountService instanceof CreditCardAccountServiceImpl && transaction.getTransactionOperation().equals(AccountOperationConstant.WITHDRAW) && transaction.getTransactionAmount()> accountService.getCreditCardWithdrawAlertBalance()) {
                        sb.append("\t\tMore than $400 withdraw amount on CREDIT CARD ACCOUNT!\n");
                        sb.append(generateEmailBody(account, transaction));
                    } else {
                        if (account.getCustomer() instanceof CompanyAccount) {
                            sb.append("\t\tCOMPANY ACCOUNT\n");
                            sb.append(generateEmailBody(account, transaction));
                        } else if ((account.getCustomer() instanceof PersonalAccount && account.getBalance() < 0) || (account.getCustomer() instanceof PersonalAccount && transaction.getTransactionAmount() > accountService.getPersonalAccountTransferAlertBalance())) {
                            sb.append("\t\tPERSONAL ACCOUNT\n");
                            sb.append(generateEmailBody(account, transaction));
                        }
                    }

                    if (it.hasNext()) {
                        sb.append("|       ＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿       |\n");
                    }
                }
            }
        }

        sb.append("⎩＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿ SENT ALL EMAILS ＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿⎭\n");

        Log.getLogger().write(sb.toString());
        if(emailSent) {
            accountService.clearChangedAccountList();
        }
    }

    public String generateEmailBody(Account account, AccountTransaction accountTransaction) {
        emailSent = true;
        StringBuilder sb = new StringBuilder();

        sb.append("\t\t" + account.getCustomer().getName() + " [AccNO: " + account.getAccountNumber() + "]\n");
        sb.append("\t\tSending email to => " + account.getCustomer().getEmail() + " | " + accountTransaction + "\n");
        sb.append(account.getBalance() < 0 ? "\t\t❌ Negative BALANCE ❌\n" : "\n");

        return sb.toString();
    }
}