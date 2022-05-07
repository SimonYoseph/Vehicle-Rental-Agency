/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package currentRatesPackage;

public class Rates{

	//instance variable
	private VehicleRates[] rates = new VehicleRates[3];
	private CarRates car_rates; 
	private SUVRates SUV_rates; 
	private TruckRates truck_rates;   

	//constructor
	public Rates(CarRates c_rates, SUVRates s_rates, TruckRates t_rates){

		rates[0] = c_rates;
		rates[1] = s_rates;
		rates[2] = t_rates; 
	}

	//methods
	public VehicleRates getCarRates(){
		return rates[0];
	}

	public VehicleRates getSUVRates(){
		return rates[1];
	}

	public VehicleRates getTruckRates(){
		return rates[2];
	}

	public void setCarRates(VehicleRates c_rates){
		rates[0] = (CarRates) c_rates; 
	}

	public void setSUVRates(VehicleRates s_rates){
		rates[1] = (SUVRates) s_rates;
	}

	public void setTruckRates(VehicleRates t_rates)
	{
		rates[2] = (TruckRates) t_rates; 
	}

	public double calcEstimatedCost(int vehicleType, String estimatedRentalPeriod, int estimatedNumMiles, boolean dailyInsur, boolean primeCustomer){

		String s = estimatedRentalPeriod.substring(1);
		int rental = Integer.parseInt(s);
		double a; 
		if(vehicleType == 1){

			VehicleRates v = rates[0];
			if(primeCustomer == true && estimatedNumMiles > 100){
				estimatedNumMiles = estimatedNumMiles - 100;
				if(estimatedRentalPeriod.charAt(0) == 'D' || estimatedRentalPeriod.charAt(0) == 'd'){

					if(dailyInsur == true){

						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'W' || estimatedRentalPeriod.charAt(0) == 'w'){
					if(dailyInsur == true){

						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'M' || estimatedRentalPeriod.charAt(0) == 'm'){
					if(dailyInsur == true){

						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
			}

			if(primeCustomer == true && estimatedNumMiles <= 100){
				estimatedNumMiles = 0;
				if(estimatedRentalPeriod.charAt(0) == 'D' || estimatedRentalPeriod.charAt(0) == 'd'){
					if(dailyInsur == true){
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'W' || estimatedRentalPeriod.charAt(0) == 'w'){
					if(dailyInsur == true){

						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'M' || estimatedRentalPeriod.charAt(0) == 'm'){
					if(dailyInsur == true){
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
			}

			if(primeCustomer == false){
				if(estimatedRentalPeriod.charAt(0) == 'D' || estimatedRentalPeriod.charAt(0) == 'd'){
					if(dailyInsur == true){
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'W' || estimatedRentalPeriod.charAt(0) == 'w'){
					if(dailyInsur == true){
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'M' || estimatedRentalPeriod.charAt(0) == 'm'){
					if(dailyInsur == true){
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
			}
		}

		if(vehicleType == 2){
			VehicleRates v = rates[1];
			if(primeCustomer == true && estimatedNumMiles > 100){
				estimatedNumMiles = estimatedNumMiles - 100;
				if(estimatedRentalPeriod.charAt(0) == 'D' || estimatedRentalPeriod.charAt(0) == 'd'){
					if(dailyInsur == true){
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'W' || estimatedRentalPeriod.charAt(0) == 'w'){
					if(dailyInsur == true){
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'M' || estimatedRentalPeriod.charAt(0) == 'm'){
					if(dailyInsur == true){
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
			}

			if(primeCustomer == true && estimatedNumMiles <= 100){
				estimatedNumMiles = 0;
				if(estimatedRentalPeriod.charAt(0) == 'D' || estimatedRentalPeriod.charAt(0) == 'd'){
					if(dailyInsur == true){
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'W' || estimatedRentalPeriod.charAt(0) == 'w'){
					if(dailyInsur == true){
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'M' || estimatedRentalPeriod.charAt(0) == 'm'){
					if(dailyInsur == true){
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
			}

			if(primeCustomer == false){
				if(estimatedRentalPeriod.charAt(0) == 'D' || estimatedRentalPeriod.charAt(0) == 'd'){
					if(dailyInsur == true){
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'W' || estimatedRentalPeriod.charAt(0) == 'w'){
					if(dailyInsur == true){
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'M' || estimatedRentalPeriod.charAt(0) == 'm'){
					if(dailyInsur == true){
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
			}
		}

		if(vehicleType == 3){
			VehicleRates v = rates[2];
			if(primeCustomer == true && estimatedNumMiles > 100){
				estimatedNumMiles = estimatedNumMiles - 100;
				if(estimatedRentalPeriod.charAt(0) == 'D' || estimatedRentalPeriod.charAt(0) == 'd'){
					if(dailyInsur == true){
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'W' || estimatedRentalPeriod.charAt(0) == 'w'){
					if(dailyInsur == true){
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'M' || estimatedRentalPeriod.charAt(0) == 'm'){
					if(dailyInsur == true){
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else
					{
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
			}

			if(primeCustomer == true && estimatedNumMiles <= 100){
				estimatedNumMiles = 0;
				if(estimatedRentalPeriod.charAt(0) == 'D' || estimatedRentalPeriod.charAt(0) == 'd'){
					if(dailyInsur == true){
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'W' || estimatedRentalPeriod.charAt(0) == 'w'){
					if(dailyInsur == true){
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'M' || estimatedRentalPeriod.charAt(0) == 'm'){
					if(dailyInsur == true){
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
			}

			if(primeCustomer == false){
				if(estimatedRentalPeriod.charAt(0) == 'D' || estimatedRentalPeriod.charAt(0) == 'd'){
					if(dailyInsur == true){
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getDailyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'W' || estimatedRentalPeriod.charAt(0) == 'w'){
					if(dailyInsur == true){
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getWeeklyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
				if(estimatedRentalPeriod.charAt(0) == 'M' || estimatedRentalPeriod.charAt(0) == 'm'){
					if(dailyInsur == true){
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles) + (v.getDailyInsurRate() * rental);
						return a;
					}
					else{
						a = (v.getMonthlyRate() * rental) + (v.getMileageChrg() * estimatedNumMiles);
						return a;
					}
				}
			}
		}
		a = 0;
		return a; 
	}
	public double calcActualCost(Cost rates, int numDaysUsed, int numMilesDriven, boolean dailyInsur, boolean primeCustomer){
		double a; 
		if(primeCustomer == true && numMilesDriven > 100){
			numMilesDriven = numMilesDriven - 100;
			int d = numDaysUsed % 7;
			int m = numDaysUsed % 30; 
			if(numDaysUsed < 7) {
				if(dailyInsur == true) {
					a = (rates.getDailyRate() * numDaysUsed) + (rates.getMileageChrg() * numMilesDriven) + (rates.getDailyInsurRate() * numDaysUsed);
					return a; 
				}
				else{
					a = (rates.getDailyRate() * numDaysUsed) + (rates.getMileageChrg() * numMilesDriven); 
					return a; 
				}
			}
			if(numDaysUsed > 7 && numDaysUsed < 30){
				if(dailyInsur == true){
					a = (rates.getWeeklyRate() * numDaysUsed) + (rates.getDailyRate() * d) + (rates.getMileageChrg() * numMilesDriven) + (rates.getDailyInsurRate() * numDaysUsed);
					return a; 
				}
				else{
					a = (rates.getWeeklyRate() * numDaysUsed) + (rates.getDailyRate() * d) + (rates.getMileageChrg() * numMilesDriven); 
					return a; 
				}
			}
			if(numDaysUsed > 30){
				if(dailyInsur == true){
					a = (rates.getMonthlyRate() * numDaysUsed) + (rates.getDailyRate() * m) + (rates.getMileageChrg() * numMilesDriven) + (rates.getDailyInsurRate() * numDaysUsed);
					return a; 
				}
				else{
					a = (rates.getWeeklyRate() * numDaysUsed) + (rates.getDailyRate() * m) + (rates.getMileageChrg() * numMilesDriven); 
					return a; 
				}
			}
		}
		
		if(primeCustomer == true && numMilesDriven <= 100){
			numMilesDriven = 0;
			int d = numDaysUsed % 7;
			int m = numDaysUsed % 30; 
			if(numDaysUsed < 7) {
				if(dailyInsur == true) {
					a = (rates.getDailyRate() * numDaysUsed) + (rates.getMileageChrg() * numMilesDriven) + (rates.getDailyInsurRate() * numDaysUsed);
					return a; 
				}
				else{
					a = (rates.getDailyRate() * numDaysUsed) + (rates.getMileageChrg() * numMilesDriven); 
					return a; 
				}
			}
			if(numDaysUsed > 7 && numDaysUsed < 30){
				if(dailyInsur == true) {
					a = (rates.getWeeklyRate() * numDaysUsed) + (rates.getDailyRate() * d) + (rates.getMileageChrg() * numMilesDriven) + (rates.getDailyInsurRate() * numDaysUsed);
					return a; 
				}
				else{
					a = (rates.getWeeklyRate() * numDaysUsed) + (rates.getDailyRate() * d) + (rates.getMileageChrg() * numMilesDriven); 
					return a; 
				}
			}
			if(numDaysUsed > 30){
				if(dailyInsur == true) {
					a = (rates.getMonthlyRate() * numDaysUsed) + (rates.getDailyRate() * m) + (rates.getMileageChrg() * numMilesDriven) + (rates.getDailyInsurRate() * numDaysUsed);
					return a; 
				}
				else{
					a = (rates.getWeeklyRate() * numDaysUsed) + (rates.getDailyRate() * m) + (rates.getMileageChrg() * numMilesDriven); 
					return a; 
				}
			}
		}
		
		if(primeCustomer == false){
			int d = numDaysUsed % 7;
			int m = numDaysUsed % 30; 
			if(numDaysUsed < 7) {
				if(dailyInsur == true) {
					a = (rates.getDailyRate() * numDaysUsed) + (rates.getMileageChrg() * numMilesDriven) + (rates.getDailyInsurRate() * numDaysUsed);
					return a; 
				}
				else{
					a = (rates.getDailyRate() * numDaysUsed) + (rates.getMileageChrg() * numMilesDriven); 
					return a; 
				}
			}
			if(numDaysUsed > 7 && numDaysUsed < 30){
				if(dailyInsur == true){
					a = (rates.getWeeklyRate() * numDaysUsed) + (rates.getDailyRate() * d) + (rates.getMileageChrg() * numMilesDriven) + (rates.getDailyInsurRate() * numDaysUsed);
					return a; 
				}
				else{
					a = (rates.getWeeklyRate() * numDaysUsed) + (rates.getDailyRate() * d) + (rates.getMileageChrg() * numMilesDriven); 
					return a; 
				}
			}
			if(numDaysUsed > 30){
				if(dailyInsur == true){
					a = (rates.getMonthlyRate() * numDaysUsed) + (rates.getDailyRate() * m) + (rates.getMileageChrg() * numMilesDriven) + (rates.getDailyInsurRate() * numDaysUsed);
					return a; 
				}
				else{
					a = (rates.getWeeklyRate() * numDaysUsed) + (rates.getDailyRate() * m) + (rates.getMileageChrg() * numMilesDriven); 
					return a; 
				}
			}
		}
		a = 0;
		return a;
	}

}
