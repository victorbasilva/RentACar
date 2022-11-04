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
              
              
              numberOfCars = Integer.parseInt(number);
              for(int i=1; i<=numberOfCars;i++){
                  Car newCar = new Car(i);
                  newCar.setRate(Double.parseDouble(rate));
                  
                  switch(make){
                    case "BMW": newCar.setMake(this.make.BMW); break;  
                    case "TOYOTA": newCar.setMake(this.make.TOYOTA); break;
                    case "FORD": newCar.setMake(this.make.FORD); break;
                    case "FIAT": newCar.setMake(this.make.FIAT); break;
                    case "CHEVROLET": newCar.setMake(this.make.CHEVROLET); break;
                  }
                  cars.add(newCar);
              }
              
              
            }
        }
        rentACar.setCars(cars);
        return rentACar;    
            
    }
    
        
}
    
 
