/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package vehiclesPackage;

public class Truck extends Vehicle{
    
    //instance variable 
    private int loadCap;
    
    //Constructor
    public Truck(String description, int mpg, String vin, String resv, int loadCap){
        super(description, mpg, vin, resv);
        this.loadCap = loadCap;
    }
    
    //methods
    public int getCap(){
        return loadCap;
    }
    
    public String toString(){
        return (getDescript() + "(Truck) MPG: " + getMPG()+ " " + "Load Capacity: " + getCap() + "lbs." + " " + " " + "VIN: " + getVIN());
    }
}
