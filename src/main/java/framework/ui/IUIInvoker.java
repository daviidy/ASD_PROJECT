package framework.ui;

import common.domain.Customer;
import framework.command.Command;
import framework.ui.pages.GenerateReport;

import java.util.HashMap;
import java.util.Map;

public interface IUIInvoker {

    void initialize(String title, UIStrategy config);

    void setVisible(boolean value);

    String getAccountType();

    String getAccountNumber();

    Customer getCustomer();

    String getAmount();

    GenerateReport getReportUI();

    Map<String, Command> getCommands();

    void setCommands(Map<String, Command> commands);

}