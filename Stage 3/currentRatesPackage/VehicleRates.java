/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package currentRatesPackage;

public abstract class VehicleRates{
    //instance variables
    private double daily_rate;
    private double weekly_rate;
    private double monthly_rate; 
    private double mileage_chrg;
    private double daily_insur_rate;
    
    
    //constructor
    public VehicleRates(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg, double daily_insur_rate){
        this.daily_rate = daily_rate;
        this.weekly_rate = weekly_rate;
        this.monthly_rate = monthly_rate;
        this.mileage_chrg = mileage_chrg; 
        this.daily_insur_rate = daily_insur_rate; 
    }
    
    //methods 
    public double getDailyRate(){ //cost per day
        return daily_rate;
    }
    public double getWeeklyRate(){ //cost per week
    
        return weekly_rate; 
    }
    public double getMonthlyRate(){ //cost per month
    
        return monthly_rate;
    }
    public double getMileageChrg(){ //cost per mile
    
        return mileage_chrg; 
    }
    public double getDailyInsurRate(){ //insurance cost per day
    
        return daily_insur_rate; 
    }
    public abstract String toString(); 
    
    public abstract Cost cloneAsCostType(); 

}