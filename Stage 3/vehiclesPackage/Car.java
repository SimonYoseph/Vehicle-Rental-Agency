/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package vehiclesPackage;

public class Car extends Vehicle{
    //instance variables 
    private int capacity;
    
    //Constructor
    public Car(String description, int mpg, String vin, String resv, int capacity){
        super(description, mpg, vin, resv);
        this.capacity = capacity;
    }
    
    //Methods
    public int getCap(){
        return capacity;
    }

    public String toString(){
        return (getDescript() + "(Car) MPG:" + getMPG() + " " + "Seating: " + getCap() + " " + "VIN: " + getVIN());
    }           
}
