/**
 * 
 */
package com.carwash.service;

import com.carwash.model.CarWash;
import com.carwash.repository.CarWashRepository;

/**
 * @author chabag
 *
 */
public class CarWashServiceImpl implements CarWashService {

  private CarWashRepository carWashRepository;
  public  void save(CarWash carWash) {
      carWashRepository.save(carWash);
    }
}
