/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package currentRatesPackage;

public class SUVRates extends VehicleRates{
    //constructor
    public SUVRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg, double daily_insur_rate){
        super(daily_rate, weekly_rate, monthly_rate, mileage_chrg, daily_insur_rate);
        daily_rate = 29.95;
        weekly_rate = 189.95;
        monthly_rate = 679.95;
        mileage_chrg = 0.16;
        daily_insur_rate = 14.95; 
    }
    public String toString(){
        return ("SUV\nDaily Rate: " + "$" + getDailyRate() + "\n" + "Weekly Rate: " + "$" + getWeeklyRate() + "\n" + "Monthly Rate: " + "$" + getMonthlyRate() + "\n" + "Mileage Charge: " + "$" + getMileageChrg() + "\n" + "Daily Insurance Rate: " + "$" + getDailyInsurRate()); 
    }
    public Cost cloneAsCostType(){
       Cost a = new Cost(getDailyRate(), getWeeklyRate(), getMonthlyRate(), getMileageChrg(), getDailyInsurRate()); 
       
       return a;
    }
}
