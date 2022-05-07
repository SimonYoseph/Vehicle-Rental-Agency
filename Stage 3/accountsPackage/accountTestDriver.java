/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package accountsPackage;
import java.util.*; 
public class accountTestDriver {
    static Accounts acct = new Accounts(); 
    public static void main(String [] args)
            throws AccountNumberNotFoundException, InvalidAcctNumException{
        Scanner input = new Scanner(System.in);
        
        allAccts();
        System.out.println();
        System.out.println("Would you like to add an account?");
        String newAcct = input.next(); 
        {
        if (newAcct.equals("Yes") || newAcct.equals("yes")){
                addAcct();
            }
        else {
                System.out.print("Come back later to add an account!");
            }
        }
    }
    
    public static void allAccts()
            throws InvalidAcctNumException{
        acct.append(new Account("77654", "Samsung", true));
        acct.append(new Account("96880", "Apple", false));
        acct.append(new Account("43321", "Nike", true));
        acct.append(new Account("97866", "Target", false));
        acct.append(new Account("00089", "Walmart", false)); 
        acct.printAccounts(); 
    }
    //method to add company
    
    public static void addAcct()
            throws InvalidAcctNumException{
        boolean prime_customer; 
        
        Scanner input = new Scanner(System.in);
        System.out.println("Enter five digit account number.");
        String acctNum = input.next(); 
        System.out.println("Enter company name.");
        String compName = input.next();
        System.out.println("Are you a prime customer?");
        String prime = input.next();
        {
        if (prime.equals("Yes") || prime.equals("yes")){
                prime_customer = true;
            }
        else{
                prime_customer = false; 
            }
        }
        acct.append(new Account(acctNum, compName, prime_customer));
        acct.printAccounts(); 
    } 
}
