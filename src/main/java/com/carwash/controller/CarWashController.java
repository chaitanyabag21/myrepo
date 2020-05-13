/**
 * 
 */
package com.carwash.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.model.CarWash;

/**
 * @author chabag
 *
 */
@RestController
public class CarWashController {
    
    @RequestMapping(value = "/book", method = RequestMethod.POST)
    public void book(@RequestBody CarWash carWash) {
	
    }
    

}
