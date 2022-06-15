package framework.ui;

import common.domain.Customer;
import framework.command.Command;
import framework.ui.pages.GenerateReport;

public interface IUIInvoker {
    void initialize(String title, UIStrategy config);

    void setAddPersonalAccountCommand(Command addAccountCommand);

    void setAddCompanyAccountCommand(Command addAccountCommand);

    void setReportCommand(Command reportCommand);

    void setAddInterestCommand(Command addInterestCommand);

    void setDepositCommand(Command depositCommand);

    void setWithdrawCommand(Command withdrawCommand);

    void setVisible(boolean value);

    String getAccountType();

    String getAccountNumber();

    Customer getCustomer();

    String getAmount();

    GenerateReport getReportUI();

}