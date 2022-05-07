/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package transPackage;

public class Transaction {
    //instance variables
    private String acct_num; //five-digit acct number 
    private String company_name;
    private String vehicle_type; //car, SUV, or Truck
    private String rental_period; //days, week, months 
    private String rental_cost; 
    
    //constructor
    public Transaction(String acct_num, String company_name, String vehicle_type, String rental_period, String rental_cost){
        this.acct_num = acct_num;
        this.company_name = company_name; 
        this.vehicle_type = vehicle_type; 
        this.rental_period = rental_period;
        this.rental_cost = rental_cost; 
    }

    //methods
    public String getAcct_Num(){
        return acct_num; 
    }

    public String getCompany_Name(){
        return company_name;
    }

    public String getVehicle_Type(){
        return vehicle_type;
    }

    public String getRental_Period(){
    	 if(rental_period.indexOf('D') != -1){
             return rental_period.substring(1) + " days";
         }
         else if(rental_period.indexOf('W') != -1){
             return rental_period.substring(1) + " weeks"; 
         }
         else if(rental_period.indexOf('M') != -1){
             return rental_period.substring(1) + " months";
         }
         return null;
    }

    public String getRental_Cost(){
        return rental_cost;
    }
    public String toString(){
        return ("\nAccount number: " + getAcct_Num() + " " + "Company name: " + getCompany_Name() + " " + "Vehicle type: " + getVehicle_Type() + " " + "Rental period: " + getRental_Period() + " " + "Rental cost: $" + getRental_Cost());  
    }
}
