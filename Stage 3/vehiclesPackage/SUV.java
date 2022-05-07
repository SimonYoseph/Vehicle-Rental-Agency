/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package vehiclesPackage;

public class SUV extends Vehicle{
    //instance variable
    private int seatCap;
    private int cargoCap;
    
    //constructor
    public SUV(String description, int mpg, String vin, String resv, int seatCap, int cargoCap){
        super(description, mpg, vin, resv);
        this.seatCap = seatCap;
        this.cargoCap = cargoCap;
    }
    
    public int getCap(){
        return seatCap;
    }

    public int getCargoCap(){
        return cargoCap;
    }

    public String toString(){
        return (getDescript() + "(SUV) MPG: " + getMPG()+ " " + "Seating: " + getCap()+ " " + "Storage: " + getCargoCap() + " " + "cu. ft." + " " + "Vin: " + getVIN());
    }
}
