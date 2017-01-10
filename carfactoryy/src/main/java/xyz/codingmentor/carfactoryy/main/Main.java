
package xyz.codingmentor.carfactoryy.main;

import xyz.codingmentor.carfactoryy.beans.Car;
import xyz.codingmentor.carfactoryy.beans.CarFactory;
import xyz.codingmentor.carfactoryy.beans.Part;

/**
 *
 * @author blazefury
 */
public class Main {
    
    private Main(){
    //hide default constructor
    }
    
    public static void main(String[] args) {
        
        for (Car brand : Car.values()) {
            for (Part part : Part.values()) {
                CarFactory.create(part, brand);
                
            }
            
        }
        
    }
    
}
