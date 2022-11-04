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
    
    public RentACar() {
    
    }

    @Override
    public List<CarInterface> getCars() {
        return this.cars;
        
    }

    @Override
    public void setCars(List<CarInterface> cars) {
        this.cars = cars;
        
    }

    @Override
    public String getName() {
        return this.name;
        
    }

    @Override
    public void setName(String name) {
        this.name = name;
        
    }

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

    @Override
    public int getCarAvailable(Month month, int day, Make make, int lengthOfRent) {
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean bookCar(Month month, int day, Make make, int lengthOfRent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getNumberOfCars() {
        return this.cars.size();
    }
    
      
    
    
}
