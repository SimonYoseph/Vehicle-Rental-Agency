/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package accountsPackage; 

public class Accounts{
    //instance variable
    private AccountNode current;
    private AccountNode head;
    private AccountNode temp; 
    
    //constructor
    public Accounts(){
        head = null;
        current = head;
    }
    public Accounts(AccountNode current){
        this.current = current;
    }

    //methods
    public void append(Account acct){
        AccountNode temp = head;
        if (head == null){
            head = new AccountNode(acct, null);         
        }
        else{
            while(temp.getNext() != null){
                temp = temp.getNext();
            }
            temp.setNext(new AccountNode(acct, null));
        }
    }
    public Account getAccount(int acct_num)
            throws AccountNumberNotFoundException{

        boolean found = false;
        AccountNode temp = head; 
        Account a = temp.getAccount();
        while(temp != null){
        	a = temp.getAccount();
        	if(a.getAcctNum().equals(acct_num)){
        		found = true;
        		break;
        	}
        	temp = temp.getNext();
        }
        if(found = true)
        {
        	return a;
        }
        else{
        	throw new AccountNumberNotFoundException(); 
        }
    }
    //iterator methods
    public void reset(){
        current = head;
    }

    public boolean hasNext(){
        return current.getNext() != null;
    }

    public Account getNext(){
        Account acc;
        acc = current.getAccount();
        current = current.getNext();
        return acc;
    }

    public AccountNode getCurrent(){
        return current; 
    }

    public void printAccounts(){
        AccountNode current = head;
        while(current != null){
            System.out.println(current.getAccount());
            current = current.getNext(); 
        }
    }
}
