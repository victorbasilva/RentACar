/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ooc.enums.Make;

/**
 *
 * @author Victor
 */
public class BookingSystem implements BookingSystemInterface {

    Make make; //Enum importation. This will bring the car brands 
        
    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
     
        String line = in.readLine(); //Read line on the document -- first is name of rental car
        //System.out.println(line);
        RentACar rentACar = new RentACar(); // create a rent a car object
        rentACar.setName(line); // set name to first read line
        int numberOfCars; //Number of cars available
        Car car = new Car(); //Constructor
        List<CarInterface> cars = new ArrayList<>(); 
        
        while(line != null && !line.isEmpty()){
            // read every line
            line = in.readLine();
            // if there is something on line
            if(line != null && !line.isEmpty()){
              //System.out.println(line); 
              int index = line.indexOf(":");
              String make = line.substring(0, index);
              String rest = line.substring(index+1);
              index = rest.indexOf(":");
              String rate = rest.substring(0, index);
              String number = rest.substring(index+1);
              switch(make){
                case "BMW": car.setMake(this.make.BMW);   
                case "TOYOTA": car.setMake(this.make.TOYOTA);
                case "FORD": car.setMake(this.make.FORD);
                case "FIAT": car.setMake(this.make.FIAT);
                case "CHEVROLET": car.setMake(this.make.CHEVROLET);
              }
              car.setRate(Double.parseDouble(rate));
              numberOfCars = Integer.parseInt(number);
              car.setNumberOfCars(numberOfCars);
              cars.add(car);
            }
        }
        rentACar.setCars(cars);
        return rentACar;    
            
    }
    
        
}
    
 
