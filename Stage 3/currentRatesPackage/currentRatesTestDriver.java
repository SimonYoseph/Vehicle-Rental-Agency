/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package currentRatesPackage;

public class currentRatesTestDriver{
    
    public static void main(String[] args){
        CarRates c = new CarRates(24.95, 169.95, 514.95, 0.16, 14.95);
        SUVRates s = new SUVRates(29.95, 189.95, 679.95, 0.16, 14.95);
        TruckRates t = new TruckRates(36.95, 224.95, 687.95, 0.26, 21.95);
        
        Rates r = new Rates(c, s, t); 
        
        System.out.println(r.getCarRates());
        System.out.println(r.getSUVRates());
        System.out.println(r.getTruckRates());
    }
}
