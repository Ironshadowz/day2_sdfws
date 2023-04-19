package sg.edu.nus.iss;

import java.util.Random;
import java.util.UUID;

/**
 * Hello world!
 *
 */
public class App 
{   
    private static final boolean True = false;

    public static void main( String[] args )
    {
        BankAccount WL = new BankAccount("Wei Liang", "432432", 400);
        System.out.println(WL.toString());
        WL.deposit(500);
        System.out.println(WL.toString());
        WL.withdrawal(700);
        System.out.println(WL.toString());
        System.out.println(WL.getBalance());

        WL.setClosed(true);
        for(String transDetails : WL.getTransactions()) {
            System.out.println(transDetails);
        }
        
        int n =5;
        BankAccount[] bankAcct = new BankAccount[n];
        for(int i=0; i<bankAcct.length; i++)
        {
            String uuid = UUID.randomUUID().toString();
            float min=1000;
            float max=10000;
            Random randomNum = new Random();
            float initialBalance = min + randomNum.nextFloat();

            bankAcct[i] = new BankAccount("Employee "+String.valueOf(i), uuid, initialBalance);

        }
        bankAcct[0].showAccount();
        bankAcct[0].withdrawal(300);
        bankAcct[0].showAccount();

        FixedDepositAccount fredFixed = new FixedDepositAccount("Fred Mayer", "332-3-332-323", 30000, 10, 6);
        fredFixed.deposit(2000);
        fredFixed.withdrawal(2000);
        float computedBalance = fredFixed.getBalance();
        System.out.println(fredFixed.getAccountNumber()+"- "+fredFixed.getFullName()+"-->"+computedBalance);
    }
}
