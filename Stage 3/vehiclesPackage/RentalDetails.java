/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package vehiclesPackage;

public class RentalDetails{

    //instance variables
    private int vehicleType;
    private String rentalPeriod;
    private int estMiles;
    private boolean insurance; 
    private static boolean primeCustomer; 
    
    //constructor
    public RentalDetails(int vehicleType, String rentalPeriod, int estMiles, boolean insurance, boolean primeCustomer){
        this.vehicleType = vehicleType; 
        this.rentalPeriod = rentalPeriod; 
        this.estMiles = estMiles; 
        this.insurance = insurance; 
        this.primeCustomer = primeCustomer; 
    }
    
    //getter methods 
    public int getVehicleType(){
        return vehicleType; 
    }

    public String getRentalPeriod(){
        return rentalPeriod; 
    }

    public int getEstMiles(){
        return estMiles; 
    }

    public boolean getInsurance(){
        return insurance; 
    }

    public static boolean getPrimeCustomer(){
        return primeCustomer; 
    }
}
