/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package vehiclesPackage;

public class Reservation{
    //instance variables
    private int acctNum; // Company Account Number
    private int vehicleType; //car (1), SUV (2), Truck (3) 
    private String description; 
    private String rentalPeriod;
    private boolean insurance;
    
    //constructor
    public Reservation(int acctNum, int vehicleType, String description, String rentalPeriod, boolean insurance){

        this.acctNum = acctNum; 
        this.vehicleType = vehicleType; 
        this.description = description; 
        this.rentalPeriod = rentalPeriod;
        this.insurance = insurance;  
    }
    
    //methods 
    public boolean insurance(String r){

        if (r == "Yes" || r == "yes")
            return insurance = true;
    
        else 
            return insurance = false;
    }
    
    
    public String getRentalPeriod(){

        if(rentalPeriod.indexOf('D') != -1){
            return rentalPeriod.substring(1) + " days";
        }
        else if(rentalPeriod.indexOf('W') != -1){
            return rentalPeriod.substring(1) + " weeks"; 
        }
        else if(rentalPeriod.indexOf('M') != -1){
            return rentalPeriod.substring(1) + " months";
        }
        return null;
    }
    public int getAcctNum(){

        return acctNum;
    }

    public int getVehicleType(){

        return vehicleType;
    }

    public String getDescription(){
        return description;
    }
    
    public String toString(){

        if(insurance = true){
            

            return ("Account: " + getAcctNum() + " " + "Rental period is: " + getRentalPeriod() + " " + "Insurance selected? Yes"); 
        }
        else if (insurance = false){

            return ("Account: " + getVehicleType() + " " + "Rental period is: " + getRentalPeriod() + " " + "Insurance selected? No "); 
        }
        return null;
    }
}
