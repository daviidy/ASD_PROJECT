package common.domain;

import framework.constant.AccountOperationConstant;
import lombok.Getter;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
@Getter
public class AccountTransaction {
    AccountOperationConstant transactionOperation;
    double transactionAmount = 0d;
    LocalDateTime transactionDate;

    public AccountTransaction(AccountOperationConstant action, double amount) {
        transactionOperation = action;
        transactionAmount = amount;
        transactionDate = LocalDateTime.now();
    }

    public String toString() {
        NumberFormat formatter = new DecimalFormat("#00.00");
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm");
        return transactionOperation + ": [" + formatter.format(transactionAmount) + "] on " + dateTimeFormatter.format(transactionDate);
    }
}
