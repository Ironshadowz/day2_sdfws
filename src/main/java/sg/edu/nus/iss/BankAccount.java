package sg.edu.nus.iss;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;

public class BankAccount {

    private final String fullName;
    private String accountNumber;
    private float balance;
    private boolean isClosed;
    private Date accountStartDate;
    private Date accountEndDate;
    private List<String> transactions;
    
    public BankAccount(String fullName, String accountNumber) {
        this.fullName = fullName;
        this.accountNumber=accountNumber;
        this.balance=0;
        this.accountStartDate = new Date();
        transactions= new ArrayList<>();
    }
    
    public BankAccount(String fullName, String accountNumber, float balance) {
        this.fullName = fullName;
        this.accountNumber=accountNumber;
        this.balance = balance;
        transactions= new ArrayList<>();
    }

    public String getFullName() {
        return fullName;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public float getBalance() {
        return balance;
    }
    public boolean isClosed() {
        return isClosed;
    }
    public Date getAccountStartDate() {
        return accountStartDate;
    }
    public Date getAccountEndDate() {
        return accountEndDate;
    }
    public List<String> getTransactions() {
        return transactions;
    }
    public void setBalance(float balance) {
        this.balance = balance;
    }
    public void setClosed(boolean isClosed) {
        this.isClosed = isClosed;
    }
    public void setAccountStartDate(Date accountStartDate) {
        this.accountStartDate = accountStartDate;
    }
    public void setAccountEndDate(Date accountEndDate) {
        this.accountEndDate = accountEndDate;
    }
    public void setTransactions(List<String> transactions) {
        this.transactions = transactions;
    }
    
    @Override
    public String toString() {
        return "BankAccount [fullName=" + fullName + ", accountNumber=" + accountNumber + ", balance=" + balance
                + ", isClosed=" + isClosed + ", accountStartDate=" + accountStartDate + ", accountEndDate="
                + accountEndDate + "]";
    }

    public void showAccount()
    {
        System.out.println("Account full name: "+fullName);
        System.out.println("Account balance: "+balance);
        System.out.println("Account number: "+accountNumber);

    }

    public void deposit(float amount)
    {
        if(isClosed)
        {
            throw new IllegalArgumentException("Account closed/inactive. You cannot make a deposit to a closed/inactive account");
        }
        if(amount<0)
        {
            throw new IllegalArgumentException("You cannot make a negative amount deposit");
        } else {
            balance=balance+amount;
            java.util.Date date = new java.util.Date();    
            transactions.add("Deposit "+amount+" to account "+accountNumber+" on "+date);
        }
    }
    public void withdrawal(float withdrawAmount)
    {
        if(isClosed)
        {
            throw new IllegalArgumentException("Account closed/inactive. You cannot make a deposit to a closed/inactive account");
        }
       if(withdrawAmount>balance)
       {
        throw new IllegalArgumentException("Withdrawal amount is more than the account balance");
       }
       else {
        balance=balance-withdrawAmount;
        java.util.Date date = new java.util.Date();    
        transactions.add("Withdrawed "+withdrawAmount+" from account "+accountNumber+" on "+date);
       }
    }
}
