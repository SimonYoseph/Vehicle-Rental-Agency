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

public class managerInterface implements userInterface{
    public void start(){
        int selection;
        Scanner input = new Scanner(System.in);
        boolean quit = false;
        
        //command loop
        while(!quit){
            displayMenu();
            selection = getSelection(input);
            if(selection == 7){
                quit = true;
                System.out.println("Goodbye! Come again!");
            }
            execute(selection, input, quit);
        }
    }
    
    public void execute(int selection, Scanner input, boolean quit){
        int veh_type;
        String VIN, acct_num;
        String [] display_lines; 
        RentalDetails rental_details;
        ReservationDetails reserv_details;
        
        switch(selection){
            //View/Update Rates
            case 1: 
                System.out.println("Current car rates are.");
                display_lines = systemInterface.getCarRates();
                displayResults(display_lines);
                System.out.println("Current SUV rates are:");
                display_lines = systemInterface.getSUVRates();
                displayResults(display_lines);
                System.out.println("Current truck rates are:");
                display_lines = systemInterface.getTruckRates();
                displayResults(display_lines);
                
                int res; 
                do {
                    System.out.println("Enter 1 to update any rates, 0 to keep rates the same"); 
                while(!input.hasNext()){
                        System.out.println("Invalid entry, please try again.");
                        input.next(); 
                    }
                    res = input.nextInt();
                }
                while ( res < 0 || res > 1);
                switch(res){
                    case 0:
                        break;
                    case 1: 
                        updateRates(input);
                        break;
                }
                break;
                
            //View all vehicles
            case 2: 
                display_lines = systemInterface.getAllVehicles();
                displayResults(display_lines);
                break;
                
            //Add Account
            case 3:
                acct_num = genAcctNumber(input); 
                boolean primeCust = getPrimeCustomer(input); 
                System.out.println("Enter company name");
                input.nextLine(); 
                String comp_name = input.nextLine();
                display_lines = systemInterface.addAccount(acct_num, comp_name, primeCust);
                displayResults(display_lines);
                System.out.println("Account name: " + comp_name + " " + "Account num: " + acct_num + " " + "Prime customer? " + primeCust); 
                break;
            
            //View All Reservations
            case 4: 
                display_lines = systemInterface.getAllReservations();
                displayResults(display_lines); 
                break;
            
            //View all Accounts
            case 5:
                display_lines = systemInterface.getAllAccounts();
                displayResults(display_lines);
                break;
            
            //View Transactions
            case 6: 
                display_lines = systemInterface.getAllTransactions();
                displayResults(display_lines);
                break;
            
            //Quit
            case 7: quit = true;             
        }
    }
    public void displayMenu(){

        System.out.println("MAIN MENU - MANAGER");
        System.out.println("**********************");
        System.out.println("1 - View/Update Rates");
        System.out.println("2 - View All Vehicles");
        System.out.println("3 - Add Account");
        System.out.println("4 - View All Reservations");
        System.out.println("5 - View All Accounts");
        System.out.println("6 - View Transactions");
        System.out.println("7 - Quit");
        System.out.print("Enter an option: ");
    }
    
    private int getSelection(Scanner input){
        int select = input.nextInt();
        while (select < 1 || select > 7){
            System.out.println("Enter a number from 1-7.");
        }
        return select;
    }
    
    private void displayResults(String[] lines){
        for(int i = 0; i < lines.length; i++){
            System.out.println(lines[i]);
        }
        System.out.println(); 
    }
    
    private void updateRates(Scanner input){
        System.out.println("Which vehicle type would you like to update? Enter 1 = Car, 2 = SUV, 3 = Truck.");
        int res = input.nextInt();
        while (res < 1 || res > 3){
            System.out.println("Invalid input, please try again.");
            res = input.nextInt(); 
        }
        switch(res){
            case 1:
                System.out.println("Enter updated daily rate.");
                double daily_rate = input.nextDouble(); 
                System.out.println("Enter updated weekly rate.");
                double weekly_rate = input.nextDouble();
                System.out.println("Enter updated monthly rate."); 
                double monthly_rate = input.nextDouble();
                System.out.println("Enter updated mileage charge.");
                double mil_chrg = input.nextDouble(); 
                System.out.println("Enter updated daily insurance rate");
                double daily_insur_rate = input.nextDouble(); 
                VehicleRates v = new CarRates(daily_rate, weekly_rate, monthly_rate, mil_chrg, daily_insur_rate); 
                String [] display_lines = systemInterface.updateCarRates(v);
                displayResults(display_lines); 
                break;
            case 2: 
                System.out.println("Enter updated daily rate.");
                daily_rate = input.nextDouble(); 
                System.out.println("Enter updated weekly rate.");
                weekly_rate = input.nextDouble();
                System.out.println("Enter updated monthly rate."); 
                monthly_rate = input.nextDouble();
                System.out.println("Enter updated mileage charge.");
                mil_chrg = input.nextDouble(); 
                System.out.println("Enter updated daily insurance rate");
                daily_insur_rate = input.nextDouble(); 
                v = new SUVRates(daily_rate, weekly_rate, monthly_rate, mil_chrg, daily_insur_rate); 
                display_lines = systemInterface.updateSUVRates(v);
                displayResults(display_lines);
                break;
            case 3:
                System.out.println("Enter updated daily rate.");
                daily_rate = input.nextDouble(); 
                System.out.println("Enter updated weekly rate.");
                weekly_rate = input.nextDouble();
                System.out.println("Enter updated monthly rate."); 
                monthly_rate = input.nextDouble();
                System.out.println("Enter updated mileage charge.");
                mil_chrg = input.nextDouble(); 
                System.out.println("Enter updated daily insurance rate");
                daily_insur_rate = input.nextDouble(); 
                v = new TruckRates(daily_rate, weekly_rate, monthly_rate, mil_chrg, daily_insur_rate); 
                display_lines = systemInterface.updateTruckRates(v);
                displayResults(display_lines);
                break;
        }
    }
    
    private String genAcctNumber(Scanner input){
        System.out.println("Enter a 5 digit account number."); 
        String acct = input.next(); 
        boolean found = false;
        while(!found){
            if (acct.length() == 5){
                found = true;
            }
            else {
                System.out.println("Enter a valid account number.");
                acct = input.next(); 
            }
        }
        return acct;
    }
    
    private boolean getPrimeCustomer(Scanner input){
        input = new Scanner(System.in);
        boolean primeCust;
        System.out.println("Enter 1 if prime customer, 0 if not prime customer.");
        int prime = input.nextInt(); 
        while(prime != 0 && prime != 1){
            System.out.println("Invalid entry, please try again."); 
            prime = input.nextInt(); 
        }
        if(prime == 1){
            primeCust = true;
        }
        else{
            primeCust = false;
        }
        return primeCust;  
    }
}
