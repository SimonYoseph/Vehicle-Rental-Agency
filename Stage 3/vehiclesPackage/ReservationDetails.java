/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package vehiclesPackage;

public class ReservationDetails{

    //instance variables
    private String VIN; 
    private int acctNum;
    private int vehType;
    private String rentalPeriod; 
    private static boolean dailyInsur; 
    
    //constructor 
    public ReservationDetails(String VIN, int acctNum, int vehType, String rentalPeriod, boolean dailyInsur){
        this.VIN = VIN; 
        this.acctNum = acctNum; 
        this.vehType = vehType;
        this.rentalPeriod = rentalPeriod; 
        this.dailyInsur = dailyInsur; 
    }

    //getters 
    public String getVIN(){
        return VIN;
    }

    public int getAcctNum(){
        return acctNum;
    }

    public int getVehType(){
    	return vehType; 
    }

    public String getRentalPeriod(){
        return rentalPeriod; 
    }
    
    public static boolean getDailyInsur(){
        return dailyInsur; 
    }
}
