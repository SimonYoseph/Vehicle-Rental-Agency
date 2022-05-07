/*
Simon Yoseph
5/10/2022
COSC 237-003
*/

package transPackage;
import java.util.*; 
public class Transactions{
    //instance variables
    private ArrayList<Transaction> transactions; 
    private int current; 
    
    //constructor
    public Transactions(int size){
        transactions = new ArrayList<Transaction>(size); 
        current = 0; 
    }

    //method 
    public void add(Transaction tran){
        transactions.add(tran); 
    }

    //iterator methods
    public void reset(){
        current = 0;
    }

    public boolean hasNext(){
        return (current < transactions.size());
    }

    public Transaction getNext(){
        if(hasNext()== true)
            current++; 
        return null;
    }
    
    public Transaction getCurrent(){
        return transactions.get(current); 
    }
}
