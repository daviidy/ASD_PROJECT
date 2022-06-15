package creditcard;

import banking.commands.ReportCommand;
import framework.command.Command;
import framework.ui.pages.CommandType;
import framework.ui.pages.UIFrameInvoker;
import framework.ui.IUIInvoker;
import creditcard.commands.*;

import javax.swing.*;
import java.util.HashMap;
import java.util.Map;

public class Driver {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            IUIInvoker uIControl = UIFrameInvoker.getInstance();
            Map<String, Command> commands = new HashMap<>();
            uIControl.initialize("CreditCard Application", new CreditCardUIStrategy());
            commands.put(CommandType.ADDINTEREST.name(), new banking.commands.AddInterestCommand());
            commands.put(CommandType.ADDPERSONALACCT.name(), new banking.commands.AddPersonalAccountCommand());
            commands.put(CommandType.ADDCOMPANYACCT.name(), new banking.commands.AddCompanyAccountCommand());
            commands.put(CommandType.DEPOSIT.name(), new banking.commands.DepositCommand());
            commands.put(CommandType.WITHDRAW.name(), new banking.commands.WithdrawCommand());
            commands.put(CommandType.REPORT.name(), new ReportCommand());

            //Create a new instance of our application's frame, and make it visible.
            uIControl.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
