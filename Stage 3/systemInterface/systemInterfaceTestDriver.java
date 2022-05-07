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
public class systemInterfaceTestDriver{
	public static void main(String [] args){
		systemInterface.initSystem(createRates(), createVehicles(), createAccounts(), createTransactions());

		print(systemInterface.getCarRates());
		System.out.println();
		print(systemInterface.getSUVRates());
		System.out.println();
		print(systemInterface.getTruckRates()); 
		System.out.println();
		print(systemInterface.updateCarRates(new CarRates(24.95, 169.95, 514.95, 0.16, 14.95)));
		System.out.println();
		print(systemInterface.updateSUVRates(new SUVRates(29.95, 189.95, 679.95, 0.16, 14.95)));
		System.out.println();
		print(systemInterface.updateTruckRates(new TruckRates(36.95, 224.95, 687.95, 0.26, 21.95))); 
		System.out.println();
		print(systemInterface.getAvailCar());
		System.out.println();
		print(systemInterface.getAvailSUVs());
		System.out.println();
		print(systemInterface.getAvailTrucks()); 
		System.out.println();
		print(systemInterface.getAllVehicles()); 
		System.out.println();

		System.out.println();
		
		print(systemInterface.estimatedRentalCost(new RentalDetails(2, "M2", 23, true, true)));
		print(systemInterface.estimatedRentalCost(new RentalDetails(3, "D7", 113, true, true)));
		System.out.println();
		
	
		System.out.println();
		
		try {
		print(systemInterface.makeReservation(new ReservationDetails("HK4GM4565GD", 23132, 1, "D4", true)));
		systemInterface.makeReservation(new ReservationDetails("KU4EG3245RW", 32613, 2, "W3", false));
		}
		catch(ReservedVehicleException | VINNotFoundException e)
		{
			
		}
		
		System.out.println();
		try { 
		print(systemInterface.getReservation("HK4GM4565GD")); 
		}
		catch(VINNotFoundException e)
		{
			
		}
		System.out.println();
		try {
			print(systemInterface.cancelReservation("HK4GM4565GD")); 
		}
		catch(VINNotFoundException | UnreservedVehicleException e)
		{
			
		}
		System.out.println("All Reservations");
		print(systemInterface.getAllReservations());
		System.out.println();
		print(systemInterface.addAccount("54637", "Intel", true)); 
		print(systemInterface.addAccount("34221" , "Sony", false)); 
		try {
		print(systemInterface.getAccount(67588)); 
		}
		catch(AccountNumberNotFoundException e) 
		{
			
		}
		System.out.println();
		System.out.println("All Accounts:");
		System.out.println();
		print(systemInterface.getAllAccounts()); 
		System.out.println();
		System.out.println("Transaction:");
		try {
		print(systemInterface.addTransaction("22118", "Good Year", "SUV", "D2", "262.75"));
		}
		catch(InvalidAcctNumException e) {
			
		}
		System.out.println();
		System.out.println("All Transactions");
		
		print(systemInterface.getAllTransactions()); 
		
	}

	public static Rates createRates(){

		System.out.println("\n");
		System.out.println("*******************************\n");
		return (new Rates(new CarRates(24.95, 169.95, 514.95, 0.16, 14.95),
				new SUVRates(29.95, 189.95, 679.95, 0.16, 14.95),
				new TruckRates(36.95, 224.95, 687.95, 0.26, 21.95))); 
		
	}

	public static Vehicles createVehicles(){

		Vehicles v = new Vehicles(100);

		v.add(new Car("Chevrolet Camaro - 2018", 30, "KH4GM4564GQ", "n", 2));
		v.add(new Car("Ford Fusion - 2018", 34, "AB4FG5689GM", "n", 4));
		v.add(new Car("Ford Fusion Hybrid", 32, "KV4EG3245RV", "n", 4));
		v.add(new Car("Chevrolet Impala - 2019", 30, "RK3BM4256YH", "n", 4));
		v.add(new SUV("Honda Odyssey", 28, "VM9RF2635TD", "n", 7, 6)); 
		v.add(new SUV("Dodge Caravan", 25, "QK3FT4273NE", "n", 5, 4));
		v.add(new SUV("Ford Expedition", 20, "JK2HL8264HY", "n", 5, 3));
		v.add(new Truck("Ten-Foot", 12, "EJ5KU2437BD", "n", 2810)); 
		v.add(new Truck("Eighteen-Foot", 10, "KG4MD5372RK", "n", 5950)); 
		v.add(new Truck("Twenty-Four-Foot", 8, "EB2WR3082OB", "n", 6500)); 
		v.add(new Truck("Twenty-Four-Foot", 8, "TV3GH4390FK", "n", 6510)); 
		return v; 
	}

	public static Transactions createTransactions(){

		Transactions trans = new Transactions(100); 
		trans.add(new Transaction("62627", "GE", "Truck", "W3", "90"));
		trans.add(new Transaction("54328", "Brita", "Truck", "M6", "305"));
		trans.add(new Transaction("89766", "Sony", "Car", "W1", "300"));
		trans.add(new Transaction("87760", "Vans", "SUV", "M9", "30"));
		trans.add(new Transaction("11213", "Adidas", "Car", "D2", "50"));
		return trans; 
	}
	public static Accounts createAccounts(){

		Accounts acct = new Accounts(); 
		acct.append(new Account("77676", "Apple", false));
		acct.append(new Account("32213", "Doritos", true));
		acct.append(new Account("98890", "Nike", true));
		acct.append(new Account("12322", "Oreo", false));
		acct.append(new Account("43321", "Bose", true)); 
		// acct.printAccounts(); 
		// System.out.println("\n"); 
		return acct; 
	}
	public static void print(String [] a){

		for(String string: a)
		{
			System.out.println(string); 
		}
	}
}
