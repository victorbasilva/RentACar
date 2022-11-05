/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ooc.yoursolution;

import java.util.List;
import ooc.enums.Make;
import ooc.enums.Month;

/**
 *
 * @author gabrieleugenio
 */
    public class RentACar implements RentACarInterface {
    private List<CarInterface> cars;
    private String name;
    
    /**
     * Return the full list of cars.
     *
     * @return	List of cars
     */
    @Override
    public List<CarInterface> getCars() {
        return this.cars;
        
    }

    /**
     * Helper method to set all the cars with a list if we so wished
     *
     * @param cars	List of cars
     */
    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;
        
    }

    /**
     * Return the name of the Rent-a-car
     *
     * @return
     */
    @Override
    public String getName() {
        return this.name;
        
    }
    /**
     * Set the name of the rent-a-car.
     *
     * @param name
     */
    @Override
    public void setName(String name) {
        this.name = name;
        
    }

    /**
     * Check through all cars in this company and see if there is continuous
     * availability of any specific car. It is not enough to just have
     * any car available for the length of stay, we need it to be in one
     * specific make of car.
     *
     * @param month	Month of proposed rent
     * @param day	Day of start of proposed rent
     * @param make	Make, what sort of car for the proposed rent
     * @param lengthOfRent	how long is the proposed rent for
     * 
     * @return	true or false is there availability for the proposed rent
     */
    @Override
    public boolean checkAvailability(Month month, int day, Make make, int lengthOfRent) {
        // for each car
        for(int i=0; i <this.cars.size();i++){
            System.out.println(this.cars.get(i).getMake());
            // find a make that is requested
            if(this.cars.get(i).getMake() != make){
                continue;
            }
            // check if car is available
            if( this.cars.get(i).isAvailable(month, day)){
                return true;
            }
            
        }
        return false;
        
    }

    /**
     * Assuming there is availability, get the id of a car that fits that
     * availability
     *
     * @param month	Month of proposed rent
     * @param day	Day of start of proposed rent
     * @param make	Make, what sort of car for the proposed rent
     * @param lengthOfRent	how long is the proposed rent for
     * @return	the id of a car that fits the bill
     */
    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        int id = 0;
        // for each car
        for(int i=0; i <this.cars.size();i++){
            // this car
            CarInterface car = this.cars.get(i);
            // if is car of requested make
            if(car.getMake() == make){
                // if car is available that month and day -- assuming availability we don't need this check
                //if(car.isAvailable(month, day)){
                    id = car.getId(); // return car id
                    break; // break on first found car
                //}
            }
        }
        return id;
    }
    
    /**
     * Book a car for the proposed rental period. It should be one car for the full
     * time. THERE IS NO NEED TO CONSIDER RENTALS THAT ROLL OVER TWO MONTHS
     *
     * @param month	Month of proposed rent
     * @param day	Day of start of proposed rent
     * @param make	Make, what sort of car for the proposed rent
     * @param lengthOfRent	how long is the proposed rent for
     * @return	true or false has the room been booked
     */
    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        // for each car
        for(int i=0; i <this.cars.size();i++){
            // this car
            CarInterface car = this.cars.get(i);
            // find car make
            if(car.getMake() == make){
                // if car is available on the day of booking
                if (car.isAvailable(month, day)){
                    // book for length of rent by booking each day
                    for(int j=0; j<lengthOfRent; j++){
                        //book from first day, every other will be day + lengthOfRent 
                        car.book(month, day+j);
                    }
                    // return true if we booked cars
                    return true;
                }
            }
        }
        // return false if there were no available bookings
        return false;
    }

     /**
     * How many cars are in the rent-a-car
     *
     * @return number of cars
     */
    @Override
    public int getNumberOfCars() {
        return this.cars.size();
    }
    
      
    
    
}
