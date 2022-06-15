package creditcard;

import framework.ui.pages.UIFrameInvoker;
import framework.ui.IUIInvoker;
import creditcard.commands.*;

import javax.swing.*;

public class Driver {
    public static void main(String[] args){
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            IUIInvoker uIControl = UIFrameInvoker.getInstance();
            uIControl.initialize("MIU CreditCard Application", new CreditCardUIStrategy());

            //commands
            uIControl.setAddPersonalAccountCommand(new AddPersonalAccountCommand());
            uIControl.setAddCompanyAccountCommand(new AddCompanyAccountCommand());
            uIControl.setDepositCommand(new DepositCommand());
            uIControl.setWithdrawCommand(new WithdrawCommand());
            uIControl.setAddInterestCommand(new AddInterestCommand());
            uIControl.setReportCommand(new ReportCommand());

            //Create a new instance of our application's frame, and make it visible.
            uIControl.setVisible(true);
        } catch (Throwable t) {
            t.printStackTrace();
            System.exit(1);
        }
    }
}
