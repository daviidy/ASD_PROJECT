package banking;



import banking.service.BankAccountServiceImpl;
import common.Account;
import common.AccountService;
import common.domain.AccountEntry;
import common.domain.Customer;
import common.dto.AccountDTO;
import common.log.Log;
import framework.domain.IndividualCustomer;

import java.time.LocalDate;

public class Tester {
    public static void main(String[] args) {
        AccountService accountService = BankAccountServiceImpl.getInstance();

        Customer renuka = new IndividualCustomer(1, "Renuka Mohanraj", "1000N Fourth Street",
                "Fairfield", "Iowa", 52557, "renuka@miu.edu", LocalDate.of(2020, 10, 10));
        Customer sabi = new IndividualCustomer(2, "Sabi Shresthaq", "147 Hillcrest Avenue",
                "West Hartford", "Connecticut", 06110, "care.sabi@gmail.com", LocalDate.of(2020, 10, 10));
        // create 2 accounts;
        /*AccountDTO accountDTO1 = AccountDTO.builder()
                .accountNumber("1263862")
                .accountType("SAVINGS")
                .customer(renuka).build();

        AccountDTO accountDTO2 = AccountDTO.builder()
                .accountNumber("4253892")
                .accountType("CHECKING")
                .customer(sabi).build();*/
        AccountDTO accountDTO1 = new AccountDTO("1263862", "SAVINGS", renuka);
        AccountDTO accountDTO2 = new AccountDTO("4253892", "CHECKING", sabi);
        accountService.createAccount(accountDTO1);
        accountService.createAccount(accountDTO2);
        // use account 1;
        accountService.deposit("1263862", 240);
        accountService.deposit("1263862", 529);
        accountService.withdraw("1263862", 230);
        // use account 2;
        accountService.deposit("4253892", 12450);
        // show balances

        for (Account account : accountService.getAllAccounts()) {
            Customer customer = account.getCustomer();
            Log.getLogger().write("Statement for Account: " + account.getAccountNumber());
            Log.getLogger().write("Account Holder: " + customer.getName());

            Log.getLogger().write("-Date-------------------------"
                    + "-Description------------------"
                    + "-Amount-------------");

            for (AccountEntry entry : account.getAccountEntries()) {
                System.out.printf("%30s%30s%20.2f\n",
                        entry.getDate().toString(),
                        entry.getDescription(),
                        entry.getAmount());
            }

            Log.getLogger().write("----------------------------------------" + "----------------------------------------");
            System.out.printf("%30s%30s%20.2f\n\n", "", "Current Balance:", account.getBalance());
        }
    }

}
