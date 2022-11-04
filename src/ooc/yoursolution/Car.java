
package ooc.yoursolution;

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
    private boolean availability;
    private Month month;
    private int day;
    private int numberOfCars;
    
    private int id;
   /**
     * This method in in charge of creating the calendar of availability 
     * of the car for the whole year. 
     * The calendar should be a Map that uses the Month as the key, 
     * and an array of boolean as its associated value.
     * 
     * @return Map of availability
     */
    public Map<Month, boolean[]> createAvailability(){
                
    }
    
    public void setNumberOfCars(int numberOfCars){
        this.numberOfCars = numberOfCars;
    }

    public Make getMake() {
        return make;
    }

    public void setMake(Make make) {
        this.make = make;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
    /**
     * Getter method for the make of this car.
     * 
     * @return the make of the car
     */
    
    public Map<Month, boolean[]> getAvailability(){
        
    }
    
    /**
     * Sets the availability calendar of the car.
     * @param availability 
     */
    public void setAvailability(Map<Month, boolean[]> availability){
    
    }
    
    /**
     * Getter method for the id of this car.
     * 
     * @return 
     */
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
    public boolean isAvailable(Month month, int day){
    
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
    public boolean book(Month month, int day){
    
    }
    
    
}