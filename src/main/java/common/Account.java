package common;

import banking.visitor.InterestVisitor;
import banking.visitor.Visitor;
import common.domain.AccountEntry;
import common.domain.Customer;
import framework.strategy.InterestStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Getter
@Setter
public abstract class Account {
	private Customer customer;

	private String accountNumber;

	private String accountType;

	//For Test Purpose: Report Generate
	private static long day = 0l;

	InterestVisitor visitor = new InterestVisitor();

	private List<AccountEntry> accountEntries;

	private InterestStrategy interestStrategy;

	public Account(InterestStrategy interestStrategy) {
		this.interestStrategy = interestStrategy;
		this.accountEntries = new ArrayList<>();
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getBalance() {
		return accountEntries
				.stream()
				.mapToDouble(AccountEntry::getAmount)
				.sum();
	}

	public void deposit(double amount) {
		AccountEntry entry = new AccountEntry(amount, "deposit", "", "");
		accountEntries.add(entry);
	}

	public void withdraw(double amount) {
		AccountEntry entry = new AccountEntry(-amount, "withdraw", "", "");
		accountEntries.add(entry);
	}

	private void addEntry(AccountEntry entry) {
		accountEntries.add(entry);
	}

	public double addInterest(){
		double interest =  interestStrategy.computeInterest(getBalance());
		AccountEntry entry =  new AccountEntry(interest,"interest added","","");

		/**
		 * ALTERNATIVELY, WE CAN USE VISITOR TO ACCOMPLISH THE INTEREST CALCULATION TASK
		 * double interestVistor = this.accept(visitor);
		 * AccountEntry entry =  new AccountEntry(interestVistor,"interest added","","");
		 */
		accountEntries.add(entry);
		return interest;
	}
	public abstract double accept(Visitor visitor);
	public Collection<AccountEntry> getAccountEntries() {
		return accountEntries;
	}
	public abstract String getAccountType();

	public void setAccountType(String accountType){
		this.accountType = accountType;
	}

}
