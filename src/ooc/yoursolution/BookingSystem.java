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
     
    String line = in.readLine(); //Read line on the document
    
    int numberOfCars; //Number of cars available
    
    Car car = new Car(); //Constructor
        List<CarInterface> cars = new ArrayList<CarInterface>(); 
        while(line != null){
            int index1 = 0;
            int index2 = -1;
            ArrayList<String> text = new ArrayList<String>(); 
            do{
                index2 = line.indexOf(":");
                text.add(line.substring(index1, index2));
                index1 = index2;
            }while(index2 != -1);
            
            
            switch(text.get(0)){
                case "BMW": car.setMake(this.make.BMW);   
                case "TOYOTA": car.setMake(this.make.TOYOTA);
                case "FORD": car.setMake(this.make.FORD);
                case "FIAT": car.setMake(this.make.FIAT);
                case "CHEVROLET": car.setMake(this.make.CHEVROLET);
            }
            car.setRate(Double.parseDouble(text.get(1)));
            
            numberOfCars = Integer.parseInt(text.get(2));
            car.setNumberOfCars(numberOfCars);
            cars.add(car);
            
        }
        
        RentACar rentACar = new RentACar();
        rentACar.setCars(cars);
        
        return rentACar;
   
    }
    
        
}
    
 
