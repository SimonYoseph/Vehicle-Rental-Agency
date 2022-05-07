/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package currentRatesPackage;

import vehiclesPackage.costType;

public class Cost implements costType{

    //instance variables 
    private double daily_rate;
    private double weekly_rate; 
    private double monthly_rate;
    private double mileage_chrg;
    private double daily_insur_rate; 
    
    //constructor
    public Cost(double daily_rate, double weekly_rate, double monthly_rate, double mileage_chrg, double daily_insur_rate){
        this.daily_rate = daily_rate;
        this.weekly_rate = weekly_rate;
        this.monthly_rate = monthly_rate;
        this.mileage_chrg = mileage_chrg; 
        this.daily_insur_rate = daily_insur_rate; 
    }
    
    //methods
    public double getDailyRate(){
        return daily_rate;
    }

    public double getWeeklyRate(){
        return weekly_rate;
    }

    public double getMonthlyRate(){
        return monthly_rate;
    }

    public double getMileageChrg(){
        return mileage_chrg;
    }

    public double getDailyInsurRate(){
        return daily_insur_rate; 
    }
          
}
