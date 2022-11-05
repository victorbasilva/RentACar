/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author Victor
 */
public class BookingSystem implements BookingSystemInterface {

    Make make; //Creted Enum make that contains car brands 
    
    /**
     * Method to set up a Rent a car.
     * Will read file and take name of rent a car and
     * all cars with makes and rate
     * @param in -- buffered reader that reads file
     * @return -- return rentACar object that represents whole rent a car store
     * @throws IOException 
     */
    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        // create a rent a car object
        RentACar rentACar = new RentACar(); 
        //Read line on the document -- first is name of rental car
        String line = in.readLine(); 
        //System.out.println(line);
        // Name is on first line so thke it and set as rent a car name
        rentACar.setName(line); 
        //Number of cars available
        int numberOfCars; 
        // create an array list to store all cars for rent a car
        List<CarInterface> cars = new ArrayList<>(); 
        // while there is line in file and is not empty
        while(line != null && !line.isEmpty()){
            // read line
            line = in.readLine();
            // if there is something on line
            if(line != null && !line.isEmpty()){
              //System.out.println(line); 
              // find first : in string to find make
              int index = line.indexOf(":");
              // make is from 0 to index
              String make = line.substring(0, index);
              // get rest of string without make
              String rest = line.substring(index+1);
              // find position of second : to find rate
              index = rest.indexOf(":");
              // set rate
              String rate = rest.substring(0, index);
              // what is left is a number of cars
              String carsNumber = rest.substring(index+1);
              // parse carsNumber to be integer             
              numberOfCars = Integer.parseInt(carsNumber);
              
              // for each car we need to create a new car and add it to rent a car store
              // for each car
              for(int i=1; i<=numberOfCars;i++){
                  // create new car with id 
                  Car newCar = new Car(i);
                  // set the rate for that car -- al cars odf same make have same rate
                  newCar.setRate(Double.parseDouble(rate));
                  // set make for a car based of what we read from file
                  switch(make){
                    case "BMW": newCar.setMake(this.make.BMW); break;  
                    case "TOYOTA": newCar.setMake(this.make.TOYOTA); break;
                    case "FORD": newCar.setMake(this.make.FORD); break;
                    case "FIAT": newCar.setMake(this.make.FIAT); break;
                    case "CHEVROLET": newCar.setMake(this.make.CHEVROLET); break;
                  }
                  // create availability calendar for car
                  newCar.createAvailability();
                  // add car to array list of cars that will be added to shop
                  cars.add(newCar);
              }
            }
        }
        // set all cars for rent a car store by adding list of cars
        rentACar.setCars(cars);
        // return rent a car store
        return rentACar;    
    }
}
    
 
