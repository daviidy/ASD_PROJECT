package banking.commands;

import banking.service.BankAccountServiceImpl;
import framework.command.Command;
import framework.ui.IUIInvoker;


public class ReportCommand implements Command {
    @Override
    public void execute(IUIInvoker iuiInvoker) {
        BankAccountServiceImpl.createReport(iuiInvoker.getAccountNumber(), iuiInvoker.getReportUI());
    }
}
