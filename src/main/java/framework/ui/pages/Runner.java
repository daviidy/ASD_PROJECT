package framework.ui.pages;

import framework.command.Command;
import framework.ui.IUIInvoker;

public class Runner {
    public static void run(String type, IUIInvoker invoker){
        if(invoker.getCommands().containsKey(type)){
            invoker.getCommands().get(type).execute(invoker);
        }
    }

}
