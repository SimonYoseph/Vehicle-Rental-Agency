/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package systemInterface;

import vehiclesPackage.*;
import accountsPackage.*;
import currentRatesPackage.*;
import transPackage.*; 

public class systemInterface{
	private static Rates agency_rates;
	private static Vehicles agency_vehicles;
	private static Accounts accts;
	private static Transactions transactions_history; 

	//used to init static variables (in place of a constructor)
	public static void initSystem(Rates r, Vehicles v, Accounts a, Transactions t){
		agency_rates = r;
		agency_vehicles = v; 
		accts = a; 
		transactions_history = t; 
	}

	// Current Rates Related Methods
	public static String[] getCarRates(){
		String[] carRates = new String[1];
		carRates[0] = agency_rates.getCarRates().toString(); 
		return carRates; 
	}

	public static String[] getSUVRates(){
		String[] SUVrates = new String[1];
		SUVrates[0] = agency_rates.getSUVRates().toString();
		return SUVrates; 
	}

	public static String[] getTruckRates(){
		String[] truckRates = new String[1];
		truckRates[0] = agency_rates.getTruckRates().toString();
		return truckRates; 
	}

	public static String[] updateCarRates(VehicleRates r){
		String[] updateCarRates = new String[1];
		agency_rates.setCarRates(r);
		updateCarRates[0] = "Car rates successfully updated.";
		return updateCarRates;

	}

	public static String[] updateSUVRates(VehicleRates r){
		String [] updateSUVrates = new String[1];
		agency_rates.setSUVRates(r); 
		updateSUVrates[0] = "SUV rates successfully updated."; 
		return updateSUVrates; 
	}
	public static String[] updateTruckRates(VehicleRates r){
		String[] updateTruckRates = new String[1];
		agency_rates.setTruckRates(r);
		updateTruckRates[0] = "Truck rates successfully updated.";
		return updateTruckRates; 
	}

	public static String[] estimatedRentalCost(RentalDetails details){
		String [] rentalCost = new String[1]; 
		int veh = details.getVehicleType();
		String rental = details.getRentalPeriod();
		int miles = details.getEstMiles();
		boolean insur = details.getInsurance();
		boolean prime = details.getPrimeCustomer();
		rentalCost[0] = "Estimated rental cost is: $" + agency_rates.calcEstimatedCost(veh, rental, miles, insur, prime); 
		return rentalCost; 
	}

	public static String[] processReturnedVehicle(String vin, int num_days_used, int num_miles_driven)
			throws VINNotFoundException{
		String [] returnedVehicle = new String[1]; 
		Vehicle v = agency_vehicles.getVehicle(vin); 
		Cost c = v.getCost();
		boolean insur = ReservationDetails.getDailyInsur();
		boolean period = RentalDetails.getPrimeCustomer(); 
		returnedVehicle[0] = "Cost: " + agency_rates.calcActualCost(c, num_days_used, num_miles_driven, insur, period);
		return returnedVehicle; 
	}

	//Vehicle Related Methods
	public static String[] getAvailCar(){
		int cars = 0;
		agency_vehicles.reset();

		while(agency_vehicles.hasNext()) {
			Vehicle v = agency_vehicles.getCurrent();
			if(v instanceof Car) {
				cars += 1;
			}
			agency_vehicles.getNext();
		}

		String[] avail_cars = new String[cars];

		int i = 0;
		Vehicle v;
		agency_vehicles.reset();

		while(agency_vehicles.hasNext()) {
			v = agency_vehicles.getCurrent();
			if(v instanceof Car) {
				if(v.isReserved() == false){
					avail_cars[i] = v.toString();
				}
			}
			i++;
			agency_vehicles.getNext();
		}
		return avail_cars;
	}
	public static String[] getAvailSUVs(){
		int SUVs = 0;
		agency_vehicles.reset();

		while(agency_vehicles.hasNext()) {
			Vehicle v = agency_vehicles.getCurrent();
			if(v instanceof SUV) {
				SUVs += 1;
			}
			agency_vehicles.getNext();
		}

		String[] avail_SUV = new String[SUVs];

		int i = 0;
		Vehicle v;
		agency_vehicles.reset();

		while(agency_vehicles.hasNext()) {
			v = agency_vehicles.getCurrent();
			if(v instanceof SUV) {
				if(v.isReserved() == false){
					avail_SUV[i] = v.toString();
					i++;
				}
			}

			agency_vehicles.getNext();
		}
		return avail_SUV;
	}
	public static String[] getAvailTrucks(){
		int trucks = 0;
		agency_vehicles.reset();

		while(agency_vehicles.hasNext()) {
			Vehicle v = agency_vehicles.getCurrent();
			if(v instanceof Truck) {
				trucks += 1;
			}
			agency_vehicles.getNext();
		}

		String[] avail_trucks = new String[trucks];

		int i = 0;
		Vehicle v;
		agency_vehicles.reset();

		while(agency_vehicles.hasNext()) {
			v = agency_vehicles.getCurrent();
			if(v instanceof Truck) {
				if(v.isReserved() == false){
					avail_trucks[i] = v.toString();
					i++;
				}
			}

			agency_vehicles.getNext();
		}
		return avail_trucks; 
	}
	public static String[] getAllVehicles(){
		int vehicles = 0;
		agency_vehicles.reset();
		while(agency_vehicles.hasNext()){
			if(agency_vehicles.getNext() instanceof Vehicle)
				vehicles = vehicles + 1;
		}
		String [] allVehs = new String[vehicles];
		int i = 0;
		Vehicle v;
		agency_vehicles.reset();

		while(agency_vehicles.hasNext()){
			System.out.println(agency_vehicles.getCurrent());
			agency_vehicles.getNext();
		}
		agency_vehicles.reset(); 
		return allVehs;  
	}
	public static String[] makeReservation(ReservationDetails details)
			throws ReservedVehicleException, VINNotFoundException{
		String[] makeReserv = new String[1];
		Vehicle v= agency_vehicles.getVehicle(details.getVIN()); 
		v.setReservation(new Reservation(details.getAcctNum(), details.getVehType(), v.getDescript(), details.getRentalPeriod(), details.getDailyInsur()));
		makeReserv[0] = "Vehicle has been reserved."; 
		return makeReserv; 
	}

	public static String[] cancelReservation(String VIN) 
			throws VINNotFoundException, UnreservedVehicleException 
	{
		String [] cancelRes = new String[1];
		Vehicle v = agency_vehicles.getVehicle(VIN);
		v.cancelReservation();
		cancelRes[0] = "Reservation has been cancelled.";
		return cancelRes;
	}

	public static String[] getReservation(String vin)
			throws VINNotFoundException{
		String[] getReserv = new String[1];
		Vehicle v = agency_vehicles.getVehicle(vin);
		Reservation r = v.getReservation(); 
		getReserv[0] = r.toString();
		return getReserv; 
	}
	public static String[] getAllReservations(){
		int allRes = 0;
		agency_vehicles.reset();

		while(agency_vehicles.hasNext()) {
			Vehicle v = agency_vehicles.getCurrent();
			if(v instanceof Vehicle) {
				if(v.isReserved()){
					allRes += 1;
				}	
			}
			agency_vehicles.getNext();
		}

		String[] reservs = new String[allRes];

		int i = 0;
		Vehicle v;
		agency_vehicles.reset();

		while(agency_vehicles.hasNext()) {
			v = agency_vehicles.getCurrent();
			if(v instanceof Vehicle) {
				if(v.isReserved()) {
					reservs[i] = v.getReservation().toString();
					i++;
				}
			}
			agency_vehicles.getNext();
		}
		return reservs;
	}

	//Customer Accounts Related Methods
	public static String[] addAccount(String acct_num, String company_name, boolean prime_cust){
		accts.append(new Account(acct_num, company_name, prime_cust)); 
		String[] addAcc = new String[1];
		addAcc[0] = "Account added"; 
		return addAcc; 

	}
	public static String[] getAccount(int acct_num)
			throws AccountNumberNotFoundException{
		String[] getAcc = new String[1];
		Account acc = accts.getAccount(acct_num); 
		getAcc[0] = acc.toString();
		return getAcc; 
	}

	public static String[] getAllAccounts(){
		int numAccts = 0;
		accts.reset(); 

		while(accts.hasNext())
		{
			if(accts.getNext() instanceof Account)
				numAccts = numAccts + 1;
		}
		String[] account = new String[numAccts];
		int k = 0;
		Account b;
		accts.reset();

		while(accts.hasNext()){
			b = accts.getNext();
			if(b instanceof Account)
				account[k] = b.toString(); 
			k++;
		}
		return account; 
	}
	
	// transactions-related methods
	public static String [] addTransaction(String acctNum, String compName, String vehType, String rentPeriod, String rentCost)
			throws InvalidAcctNumException{
		String [] getTrans = new String[1];
		Transaction trans = new Transaction(acctNum, compName, vehType, rentPeriod, rentCost);
		transactions_history.add(trans);
		getTrans[0] = trans.toString();
		return getTrans; 
	}

	public static String[] getAllTransactions(){
		int trans = 0;
		transactions_history.reset();

		while(transactions_history.hasNext()) {
			Transaction a = transactions_history.getCurrent();
			if(a instanceof Transaction) {
				trans += 1;
			}
			transactions_history.getNext();
		}

		String[] allTransactions = new String[trans];

		int i = 0;
		Transaction t;
		transactions_history.reset();

		while(transactions_history.hasNext()) {
			t = transactions_history.getCurrent();
			if(t instanceof Transaction) {
				allTransactions[i] = t.toString();
			}
			i++;
			transactions_history.getNext();
		}
		return allTransactions;
	}

	public static boolean initialized() {
		// TODO Auto-generated method stub
		return false;
	}

}
