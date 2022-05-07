/*
Simon Yoseph
5/10/2022
COSC 237-003
*/

package interfaces;
import java.util.*;
import vehiclesPackage.*;
import accountsPackage.*;
import currentRatesPackage.*;
import transPackage.*; 
import systemInterface.*; 

public class employeeInterface implements userInterface{
	public void start(){

		int selection;
		Scanner input = new Scanner(System.in);
		boolean quit = false;

		//command loop
		while(!quit){

			displayMenu();
			selection = getSelection(input);
			if(selection == 8){
				quit = true;
			}
			execute(selection, input, quit);
		}
	}

	public void execute(int selection, Scanner input, boolean quit){
		int veh_type;
		String vin; 
		int acct_num;
		String [] display_lines = null;
		RentalDetails rental_details;
		ReservationDetails reserv_details; 

		switch(selection){
		//display rental rates
		case 1: veh_type = getVehicleType(input);
		switch(veh_type){

		case 1: display_lines = systemInterface.getCarRates();
		break;
		case 2: display_lines = systemInterface.getSUVRates();
		break;
		case 3: display_lines = systemInterface.getTruckRates();
		break;
		}
		displayResults(display_lines);
		break; 

		//display available vehicles
		case 2: veh_type = getVehicleType(input);
		switch(veh_type){

		case 1: display_lines = systemInterface.getAvailCar();
		break;
		case 2: display_lines = systemInterface.getAvailSUVs();
		break;
		case 3: display_lines = systemInterface.getAvailTrucks();
		break;
		}
		displayResults(display_lines);
		break; 

		//display estimated rental cost
		case 3: rental_details = getRentalDetails(input); 
		display_lines = systemInterface.estimatedRentalCost(rental_details); 
		displayResults(display_lines); 
		break; 

		//make a reservation
		case 4: reserv_details = getReservationDetails(input);
		try {
			display_lines = systemInterface.makeReservation(reserv_details);
			displayResults(display_lines);
		}
		catch(VINNotFoundException | ReservedVehicleException e) {

		}
		break;

		//cancel a reservation 
		case 5: vin = getVIN(input); 
		try {
			display_lines = systemInterface.cancelReservation(vin);
			displayResults(display_lines);
		}
		catch(UnreservedVehicleException | VINNotFoundException e){

		}

		break;

		//view corporate account(and company reservations)
		case 6: acct_num = getAcctNumber(input); 
		try {
			display_lines = systemInterface.getAccount(acct_num);
			displayResults(display_lines);
		}
		catch(AccountNumberNotFoundException e){

		}

		break;

		//process returned vehicle
		case 7: acct_num = getAcctNumber(input);
		vin = getVIN(input); 
		int num_days_used = getNumDaysUsed(input);
		int num_miles_driven = getNumMilesDriven(input); 
		try {

		display_lines = systemInterface.processReturnedVehicle(vin, num_days_used, num_miles_driven);
		
		displayResults(display_lines);
		}
		catch(VINNotFoundException e) {
			
		}
		break;

		//quit program
		case 8: quit = true;
		System.out.println("Goodbye! Come again!");
		}
	}

	private void displayMenu(){

		System.out.println("MAIN MENU - EMPLOYEE");
		System.out.println("**********************");
		System.out.println("1 - View Current Rates");
		System.out.println("2 - View Available Vehicles"); 
		System.out.println("3 - Calc Estimated Rental Cost"); 
		System.out.println("4 - Make a reservation"); 
		System.out.println("5 - Cancel Reservation"); 
		System.out.println("6 - View Corportate Account"); 
		System.out.println("7 - Process Returned Vehicle"); 
		System.out.println("8 - Quit"); 
		System.out.print("Enter an option: ");
	}

	private int getSelection(Scanner input){
		int select = input.nextInt();
		while (select < 1 || select > 8){

			System.out.println("Please enter a number from 1-8.");
		}
		return select;
	}

	// private String generateAcctNumber(Scanner input){
	// 	System.out.println("Please enter a 5 digit account number."); 
	// 	String acct = input.next(); 
	// 	boolean found = false;
	// 	while(!found){
	// 		if (acct.length() == 5){
	// 			found = true;
	// 		}
	// 		else{
	// 			System.out.println("Please enter a valid account number.");
	// 			acct = input.next(); 
	// 		}
	// 	}
	// 	return acct;
	// }

	private String getVIN(Scanner input){
		System.out.println("Enter in VIN for vehicle.");
		input.nextLine();
		String VIN = input.nextLine();
		return VIN; 
	}
	private int getAcctNumber(Scanner input){
		int acct;
		input.nextLine();
		System.out.println("Enter account number.");
		acct = input.nextInt(); 
		return acct;
	}
	private int getNumDaysUsed(Scanner input){
		System.out.println("Enter number of days used.");
		int num_days_used = input.nextInt(); 
		return num_days_used; 
	}

	private int getNumMilesDriven(Scanner input){
		System.out.println("Enter number of days used.");
		int num_miles_driven = input.nextInt(); 
		return num_miles_driven; 
	}

	private int getVehicleType(Scanner input){
		System.out.println("Enter 1 for car, 2 for SUV, or 3 for truck.");
		int veh_type = input.nextInt(); 
		while(veh_type < 1 || veh_type > 3){
			System.out.println("Invalid entry provided. Please try again.");
			veh_type = input.nextInt(); 
		}
		return veh_type;
	}

	private RentalDetails getRentalDetails(Scanner input){
		int veh_type = getVehicleType(input); 
		System.out.println("Enter the estimated number of miles driven");
		int miles = input.nextInt(); 
		String rentalPeriod = getRentalPeriod(); 
		boolean insur = getDailyInsur(); 
		boolean primeCustomer;
		System.out.println("Enter 0 if you are a prime customer or 1 if you are not"); 
		int primeCust = input.nextInt(); 
		while(primeCust != 0 && primeCust != 1){
			System.out.println("Invalid entry, please try again");
			primeCust = input.nextInt(); 
		}
		if (primeCust == 1){
			primeCustomer = true;
		}
		else{
			primeCustomer = false;
		}
		RentalDetails r = new RentalDetails(veh_type, rentalPeriod, miles, insur, primeCustomer);
		return r; 
	}

	private ReservationDetails getReservationDetails(Scanner input){
		System.out.println("Enter VIN for vehicle you would like to reserve"); 
		input.nextLine();
		String VIN = input.nextLine();
		int acct_num = getAcctNumber(input);
		int vehType = getVehicleType(input); 
		String rental_period = getRentalPeriod();
		boolean daily_insur = getDailyInsur();
		ReservationDetails r = new ReservationDetails(VIN, acct_num, vehType, rental_period, daily_insur);
		return r; 
	}

	private void displayResults(String[] lines){
		for(int i = 0; i < lines.length; i++){
			System.out.println(lines[i]);
		}
		System.out.println(); 
	}

	private String getRentalPeriod(){
		Scanner input = new Scanner(System.in);
		System.out.println("Enter your rental period in the correct format. (ex: W1 = 1 week)"); 
		String rentalPeriod = input.next(); 
		return rentalPeriod; 
	}

	private boolean getDailyInsur(){
		Scanner input = new Scanner(System.in);
		boolean insurance;
		System.out.println("Enter 1 to accept insurance, 0 to decline.");
		int insur = input.nextInt(); 
		while(insur != 0 && insur != 1){
			System.out.println("Invalid entry, please try again."); 
			insur = input.nextInt(); 
		}
		if(insur == 1){
			insurance = true;
		}
		else{
			insurance = false;
		}
		return insurance; 
	}
}