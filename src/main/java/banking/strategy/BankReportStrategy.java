package banking.strategy;

import common.Account;
import common.domain.AccountEntry;
import common.log.Log;
import framework.strategy.ReportStrategy;
import framework.ui.pages.GenerateReport;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankReportStrategy implements ReportStrategy {
    @Override
    public void generateReport(Account account, GenerateReport generateReport) {
        StringBuilder sb = new StringBuilder();
        sb.append("Account: " + account.getCustomer().getName());


            HashMap<LocalDate, List<AccountEntry>> dailyAccountEntities = new HashMap();

            for (AccountEntry accountEntry : account.getAccountEntries()) {
                List<AccountEntry> entries = new ArrayList<>();
                LocalDate reportDate;
                reportDate = accountEntry.getDate();

                if (dailyAccountEntities.containsKey(reportDate)) {
                    entries = dailyAccountEntities.get(reportDate);
                }
                entries.add(accountEntry);
                dailyAccountEntities.put(reportDate, entries);
            }

            sb.append(generateReportRows(dailyAccountEntities));

        generateReport.setReport(sb.toString());
        Log.getLogger().write(sb.toString());
    }
    public String generateReportRows(HashMap<LocalDate, List<AccountEntry>> reportData) {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<LocalDate, List<AccountEntry>> entry : reportData.entrySet()) {
            LocalDate date = entry.getKey();
            List<AccountEntry> accountEntries = entry.getValue();

            sb.append(" Date: " + date + "\n");
            sb.append(" ＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿\n");
            sb.append("|                                                     |\n");

            for(AccountEntry accountEntry : accountEntries) {
                sb.append("         " + accountEntry.report() + "\n");
            }
            sb.append("|＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿＿|\n");
        }

        return sb.toString();
    }
}


