package creditcard.commands;

import creditcard.service.CreditCardAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;

public class ReportCommand implements Command {
    @Override
    public void execute(IUIInvoker control) {
        CreditCardAccountServiceImpl.createReport(control.getAccountNumber(),control.getReportUI());
    }
}
