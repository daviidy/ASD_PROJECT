import framework.domain.Address;
import framework.domain.USState;
import  framework.service.factory.AccountDAOType;
import  framework.service.factory.AccountFactoryImpl;
import  framework.service.AccountService;

public class Test {
    public static void main(String[] args) {
        AccountService accountService = new AccountFactoryImpl().createAccountService(AccountDAOType.IN_MEMORY);
        System.out.println("test");
    }
}
