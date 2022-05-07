/*
Simon Yoseph
5/10/2022
COSC 237-003
*/
package vehiclesPackage;

import java.util.*;
public class Vehicles{

    //instance variables
    private ArrayList<Vehicle> agency_vehicles;
    private int current;
    
    //constructor
    public Vehicles(int size){
        agency_vehicles = new ArrayList<Vehicle>(size); 
        current = 0; 
    }

    //methods
    public void add(Vehicle v){     
        agency_vehicles.add(v);
    }

    public void remove(String VIN)
            throws VINNotFoundException{
       boolean found = false;
       int i = 0;
       while (i < agency_vehicles.size()) {
       Vehicle v = agency_vehicles.get(i);
       if (v.getVIN().equals(VIN)) {
       found = true;
       break;
    }
        i++;
    }
    if (found == true) {
    agency_vehicles.remove(i);
    }
    else {
        throw new VINNotFoundException();
    }
       
}
    
    public Vehicle getVehicle(String VIN)
            throws VINNotFoundException{
        boolean found = false;
        int b = 0;
        Vehicle v = agency_vehicles.get(b);
        while( b < agency_vehicles.size()){
            v = agency_vehicles.get(b);
            if(v.getVIN().equals(VIN)){
                found = true;
                break;
            }
            b++;
        }
        if(found == true){
            return v;
        }
        else{
            throw new VINNotFoundException();
        }
    }
    
    public void reset(){
       current = 0;
    }

    public boolean hasNext(){
        return (current < agency_vehicles.size()); 
    }

    public Vehicle getNext(){
        if(hasNext())
            current++; 
        return null;
    }

    public Vehicle getCurrent(){
        return agency_vehicles.get(current); 
    }
}
