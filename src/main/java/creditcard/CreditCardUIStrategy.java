package creditcard;

import common.Account;
import creditcard.constant.CreditCardReportColumnConstant;
import creditcard.constant.CreditCardType;
import framework.ui.UIStrategy;

import java.util.Arrays;
import java.util.Collection;

public class CreditCardUIStrategy implements UIStrategy {
    @Override
    public Collection<String> getAccountTypes() {
        return Arrays.asList(
                CreditCardType.GOLD.name(),
                CreditCardType.SILVER.name(),
                CreditCardType.BRONZE.name());
    }

    @Override
    public Collection<String> getReportColumnNames() {
        return Arrays.asList(CreditCardReportColumnConstant.get());
    }

    @Override
    public int getIdColumnIndex() {
        return 1;
    }

    @Override
    public Object[] buildRow(Account account) {
        Object[] rowdata = new Object[5];
        rowdata[0] = account.getCustomer().getName();
        rowdata[1] = account.getAccountNumber();
        rowdata[2] = "N/A";
        rowdata[3] = account.getAccountType();
        rowdata[4] = String.valueOf(account.getBalance());
        return rowdata;
    }

    @Override
    public boolean hasReport() {
        return true;
    }
}
