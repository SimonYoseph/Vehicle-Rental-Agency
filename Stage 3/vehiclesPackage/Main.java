/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package vehiclesPackage;

import java.util.Scanner;
public class Main{
    static Vehicles agency_vehicles = new Vehicles(20); //makes agency_vehicles global
    
    public static void main(String [] args)
            throws VINNotFoundException, ReservedVehicleException, UnreservedVehicleException{
        allVehicles(agency_vehicles);

        Scanner input = new Scanner(System.in);
        boolean repeat = false;
        
        while (!repeat){
        System.out.println();
        mainMenu(); 
        System.out.println("Please select an option:");
        int option = input.nextInt(); 
        Vehicle v;
        
        //switch cases to select an option from main menu
        
       int selection = option;
       if(selection != 8){
            switch(selection) 
            {
                case 1:
                displayAll();  
                break;
            case 2:
                displayAvailable(); 
                break;
            case 3:  
                v = reserve(agency_vehicles);
                reserveVehicle(v);     
                break;
            case 4:
                System.out.println("Enter VIN for reservation.");
                v = getVehicle(agency_vehicles); 
                displayReservation(); 
                break;
            case 5:
                System.out.println("Enter VIN for reservation cancellation.");
                v = getVehicle(agency_vehicles); 
                cancelReservation(v);
                System.out.println("Reservation cancelled."); 
                break;
            case 6:
                addVehicle(); 
                break;
            case 7:
                System.out.println("Enter VIN to remove vehicle.");
                removeVehicle(agency_vehicles);
                break;
            }

        } 
       
       else if(option == 8){
            System.out.println("Have a great day");
            repeat = true;
        }
      }   
    }
    //All vehicles
    public static void allVehicles(Vehicles v){ 
       v.add(new Car("Chevrolet Camaro - 2018", 30, "HK4GM4565GD", "n", 2));
       v.add(new Car("Ford Fusion - 2019", 34, "AB4FG5689GM", "n", 4));
       v.add(new Car("Ford Fusion Hybrid - 2017", 32, "KU4EG3245RW", "n", 4));
       v.add(new Car("Chevrolet Impala - 2019", 30, "RK3BM4256YH", "n", 4));
       v.add(new SUV("Honda Odyssey", 28, "VM9RF2635TD", "n", 7, 6)); 
       v.add(new SUV("Dodge Caravan", 25, "QK3FL4273ME", "n", 5, 4));
       v.add(new SUV("Ford Expedition", 20, "JK2RT9364HY", "n", 5, 3));
       v.add(new Truck("Ten-Foot", 12, "EJ5KU2435BC", "n", 2810)); 
       v.add(new Truck("Seventeen-Foot", 10, "KG4DM5472RK", "n", 5930)); 
       v.add(new Truck("Twenty-Four-Foot", 8, "EB2WR3082QB", "n", 6500)); 
       v.add(new Truck("Twenty-Four-Foot", 8, "TW3GH4290EK", "n", 6500));          
    }
    //Display menu 
    public static void mainMenu(){
        System.out.println("1 - Display all vehicles");
        System.out.println("2 - Display available vehicles");
        System.out.println("3 - Reserve a vehicle");
        System.out.println("4 - Display a reservation");
        System.out.println("5 - Cancel a reservation");
        System.out.println("6 - Add a vehicle");
        System.out.println("7 - Remove a vehicle");
        System.out.println("8 - Quit");
        System.out.println();
    }
    
    //method to display all vehicles
    public static void displayAll(){
        while(agency_vehicles.hasNext()){
            System.out.println(agency_vehicles.getCurrent());
            agency_vehicles.getNext(); 
        }
        agency_vehicles.reset();    
    }
    
    //method to display available vehicles
    public static void displayAvailable(){
            while (agency_vehicles.hasNext()){     
                if (!(agency_vehicles.getCurrent().isReserved())) 
                System.out.println(agency_vehicles.getCurrent());
                agency_vehicles.getNext();
            }
            agency_vehicles.reset();      
    }
    
    //method to add vehicle
    public static void addVehicle(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter 1 for car, 2 for SUV, 3 for Truck");
        int select = input.nextInt();
        
        int selection = select;
        switch(selection) {
            case 1: 
                System.out.println("Enter make & model");
                input.nextLine();
                String make = input.nextLine(); 
                System.out.println("Enter mileage");
                int mileage = input.nextInt();
                System.out.println("Enter seating capacity");
                int seat = input.nextInt();
                System.out.println("Enter vin");
                String vin = input.next();
                
                agency_vehicles.add(new Car(make, mileage, vin, null, seat));
                displayAll(); 
                
                break;
            case 2: 
                System.out.println("Enter make & model");
                input.nextLine();
                String model = input.nextLine(); 
                System.out.println("Enter mileage");
                int miles = input.nextInt();
                System.out.println("Enter vin");
                String VIN = input.next();
                System.out.println("Enter seating capacity");
                int seating = input.nextInt();
                System.out.println("Enter cargo capacity");
                int cargo = input.nextInt(); 
                
                agency_vehicles.add(new SUV(model, miles, VIN, null, seating, cargo));
                displayAll(); 
                break;
            case 3: 
                System.out.println("Enter make & model");
                input.nextLine();
                String trucks = input.nextLine(); 
                System.out.println("Enter mileage");
                int mile = input.nextInt();
                System.out.println("Enter load capacity");
                int load = input.nextInt();
                System.out.println("Enter vin");
                String id = input.next();
                
                agency_vehicles.add(new Truck(trucks, mile, id, null, load));
                displayAll(); 
                break;
        }
    }
    //method to remove vehicle
    public static void removeVehicle(Vehicles v){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter VIN to remove vehicle: ");
        String remove = input.next(); 
        
        try {
            v.remove(remove);
        }
        catch (VINNotFoundException e) {
        } 
        displayAll();     
        agency_vehicles.reset();
         
    }
    //method to reserve vehicle
    public static Vehicle reserve(Vehicles v)
            throws VINNotFoundException{
        Scanner input = new Scanner(System.in); 
        System.out.println("Enter VIN for vehicle you would like to reserve"); 
        String vin = input.next();
        return v.getVehicle(vin); 
    }
    public static void reserveVehicle(Vehicle v)
            throws ReservedVehicleException{
        Scanner input = new Scanner(System.in);
        boolean insurance;
        System.out.println("Enter account number");
        int acctNum = input.nextInt();
        System.out.println("Enter 1 for car, 2 for SUV, 3 for Trucks");
        int vehicleType = input.nextInt(); 
        System.out.println("How long would you like to rent vehicle for?");
        String rentalPeriod = input.next(); 
        System.out.println("Enter description");
        input.nextLine(); 
        String description = input.nextLine();
        System.out.println("Do you want insurance?");
        String r = input.next(); 
        if (r == "yes" || r == "Yes"){
            insurance = true;
        }
        else {
            insurance = false; 
        }
        v.reserve(new Reservation(acctNum, vehicleType, description, rentalPeriod, insurance)); 
        System.out.println("Vehicle reserved."); 
  
    }
    public static Vehicle getVehicle (Vehicles v)
            throws VINNotFoundException{
        Scanner input = new Scanner(System.in);
        String vin = input.next();
        return v.getVehicle(vin); 
    }
    //method to display reservation 
    public static void displayReservation(){
        while(agency_vehicles.hasNext()){
            if(agency_vehicles.getCurrent().isReserved())
                System.out.println(agency_vehicles.getCurrent().getReservation());
            agency_vehicles.getNext(); 
        }
        agency_vehicles.reset();  
    }
    //method to cancel reservation 
    public static void cancelReservation(Vehicle v){
        try {
            v.cancelReservation();
        } catch (UnreservedVehicleException ex) {
            
        }
       
    }
 
}
