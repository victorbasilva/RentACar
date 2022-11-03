/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ooc.yoursolution;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Victor
 */
public class BookingSystem implements BookingSystemInterface {

    
        
    @Override
    public RentACarInterface setupRentACar(BufferedReader in) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); 
        
   

// Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    public BookingSystem() throws FileNotFoundException {
        
        /*String file = "C:\\Users\\User\\Desktop\\RentACar\\car_rentals.txt";*/
        BufferedReader myFile = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\RentACar\\car_rentals.txt"));
    }
    
    
    
    
}
