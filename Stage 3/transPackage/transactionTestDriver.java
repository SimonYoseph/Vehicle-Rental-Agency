/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package transPackage;
import java.util.*; 
public class transactionTestDriver{
    static Transactions trans = new Transactions(100); 
    public static void main(String [] args){
        Scanner input = new Scanner(System.in); 
        
        allTrans(trans); 
        displayAll(); 
    }
    
    public static void allTrans(Transactions trans){
        trans.add(new Transaction("79878", "Apple", "SUV", "2 weeks", "$100"));
        trans.add(new Transaction("65532", "Nike", "Truck", "3 months", "$320"));
        trans.add(new Transaction("09998", "GE", "Truck", "2 weeks", "$300"));
        trans.add(new Transaction("11214", "Hanes", "Car", "6 months", "$50"));
        trans.add(new Transaction("00134", "Disney", "SUV", "6 days", "$60"));
    }

    public static void displayAll(){
        while(trans.hasNext()){
            System.out.println(trans.getCurrent());
            trans.getNext();
        }
        trans.reset(); 
    }
}
