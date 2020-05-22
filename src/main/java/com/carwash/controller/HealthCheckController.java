/**
 * 
 */
package com.carwash.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chabag
 *
 */
@RestController
public class HealthCheckController {

    @GetMapping("/healthcheck")
    public String healthCheck() {
	return "HealthCheck Passed";
    }
}
