
package ooc.yoursolution;

import java.util.HashMap;
import java.util.Map;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author Gabriel and Victor
 */
public class Car implements CarInterface {
    private Make make;
    private double rate;
    Map<Month, boolean[]> availabilityMap = new HashMap<>(); 
    
    private boolean availability;
    private Month month;
    private int day;
    
    
    private int id;

    /**
     * Constructor for car class used because interface is providing only
     * get id and not set id for car.
     * @param id 
     */
    public Car(int id) {
        this.id = id;
        this.createAvailability();
    }
   
    
    /**
     * This method in in charge of creating the calendar of availability 
     * of the car for the whole year. 
     * The calendar should be a Map that uses the Month as the key, 
     * and an array of boolean as its associated value.
     * 
     * @return Map of availability
     */
    @Override
    public Map<Month, boolean[]> createAvailability(){
        
        for (Month value : Month.values()) {
            boolean[] isAvailable = new boolean[value.getNumberOfDays()];
            for(int i=0; i< isAvailable.length; i++){
                isAvailable[i] = true;
            }
            this.availabilityMap.put(value,isAvailable);
           
        }
        
        return this.availabilityMap;
                
    }
    
    @Override
    public Make getMake() {
        return make;
    }

    @Override
    public void setMake(Make make) {
        this.make = make;
    }

    @Override
    public double getRate() {
        return rate;
    }

    @Override
    public void setRate(double rate) {
        this.rate = rate;
    }
    /**
     * Getter method for the availability calendar of this car.
     * 
     * @return Map of availability
     */
    @Override
    public Map<Month, boolean[]> getAvailability(){
        return this.availabilityMap;
        
    }
    
    /**
     * Sets the availability calendar of the car.
     * 
     * @param availability 
     */
    @Override
    public void setAvailability(Map<Month, boolean[]> availability){
        
    }
    
    /**
     * Getter method for the id of this car.
     * 
     * @return 
     */
    @Override
    public int getId(){
        return this.id;
    }
    
    /**
     * Returns whether or not the car is available on the given month and day. 
     * Month is an Emum, day is an int within the limits of the number of days
     * in a given month
     * 
     * @param month Month being checked
     * @param day day being checked
     * @return  true or false if it is available or not
     */
    @Override
    public boolean isAvailable(Month month, int day){
        if(this.availabilityMap.containsKey(month)){
            return this.availabilityMap.get(month)[day];
        }
        return false;
    
    }
    
    /**
     * Book a car on the given month and day. To book a car its availability 
     * is changed to false on the given month and day. 
     * This should return true or false if this change is successfully made.
     * 
     * @param month month to book
     * @param day date to book
     * @return true or false if the booking is completed
     */
    @Override
    public boolean book(Month month, int day){
        return false;
    
    }
    
    
}