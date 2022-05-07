/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package accountsPackage;


public class AccountNode{
    public Account acct;
    public AccountNode next; 
    
    //constructor
    public AccountNode(Account acct, AccountNode next){
        this.acct = acct; 
        this.next = next; 
    }
    
    //getter & setter methods 
    public Account getAccount(){
        return this.acct;
    }
    
    public AccountNode getNext(){
        return this.next;
    }
    public void setNext(AccountNode next){
        this.next = next; 
    }
}
