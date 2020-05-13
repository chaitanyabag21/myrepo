/**
 * 
 */
package com.carwash.repository;

import org.springframework.data.repository.CrudRepository;

import com.carwash.model.CarWash;

/**
 * @author chabag
 *
 */
public interface CarWashRepository extends CrudRepository<CarWash, Long> {

}
