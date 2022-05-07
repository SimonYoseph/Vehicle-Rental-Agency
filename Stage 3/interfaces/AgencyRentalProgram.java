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
public class AgencyRentalProgram{
	public static void main(String [] args){
		Rates agency_rates = new Rates(new CarRates(24.95, 169.95, 514.95, 0.16, 14.95),
				new SUVRates(29.95, 189.95, 679.95, 0.16, 14.95),
				new TruckRates(36.95, 224.95, 687.95, 0.26, 21.95)); 
		assignRates(agency_rates);

		Vehicles v = new Vehicles(100);
		populateVehicles(v);

		Accounts accounts = new Accounts(); 
		Transactions transactions = new Transactions(100);

		Scanner input = new Scanner(System.in);
		userInterface ui; 
		boolean quit = false;

		while(!quit){
			ui = getUI(input);
			if(ui == null)
				quit = true;
			else {
				if(!systemInterface.initialized())
					systemInterface.initSystem(agency_rates, v, accounts, transactions);
				ui.start();
			}
		}
	}

	public static userInterface getUI(Scanner input){
		userInterface ui = null; 
		boolean valid_selection = false;
		while(!valid_selection){
			System.out.println("1 - Employee, 2 - Manager, 3 - Quit");
			int selection = input.nextInt();
			if(selection == 1){
				ui = new employeeInterface();
				valid_selection = true;
			}
			else
				if(selection == 2){
					ui = new managerInterface(); 
					valid_selection = true;
				}
				else 
					if(selection == 3){
						ui = null; 
						valid_selection = true;
						System.out.println("Have a nice day.");
					}
					else 
						System.out.println("Invalid selection - please re-enter");
						
		}
		return ui; 
	}

public static void populateVehicles(Vehicles v){
	v.add(new Car("Chevrolet Camaro - 2018", 30, "KH4GM4564GQ", "n", 2));
	v.add(new Car("Ford Fusion - 2018", 34, "AB4FG5689GM", "n", 4));
	v.add(new Car("Ford Fusion Hybrid", 32, "KV4EG3245RV", "n", 4));
	v.add(new Car("Chevrolet Impala - 2019", 30, "RK3MB3366YH", "n", 4));
	v.add(new SUV("Honda Odyssey", 28, "VM9RF2635TD", "n", 7, 6)); 
	v.add(new SUV("Dodge Caravan", 25, "QK3FT4273NE", "n", 5, 4));
	v.add(new SUV("Ford Expedition", 20, "JK2HL8264HY", "n", 5, 3));
	v.add(new Truck("Ten-Foot", 12, "EJ5KU2437BD", "n", 2810)); 
	v.add(new Truck("Eighteen-Foot", 10, "KG4MD5372RK", "n", 5950)); 
	v.add(new Truck("Twenty-Four-Foot", 8, "EB2WR3082OB", "n", 6500)); 
	v.add(new Truck("Twenty-Four-Foot", 8, "TV3GH4390FK", "n", 6510)); 
}

public static void assignRates(Rates agency_rates){
	new Rates(new CarRates(24.95, 169.95, 514.95, 0.16, 14.95),
			new SUVRates(29.95, 189.95, 679.95, 0.16, 14.95),
			new TruckRates(36.95, 224.95, 687.95, 0.26, 21.95)); 
}
}