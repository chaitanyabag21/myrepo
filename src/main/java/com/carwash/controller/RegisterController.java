package com.carwash.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.carwash.model.User;
import com.carwash.request.UserRequest;
import com.carwash.response.ConfirmRegistrationResponse;
import com.carwash.response.LoginResponse;
import com.carwash.response.RegistrationResponse;
import com.carwash.response.ResetPasswordResponse;
import com.carwash.service.EmailService;
import com.carwash.service.UserService;
import com.carwash.util.AppConstant;

@RestController
public class RegisterController {
	
    	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
    	
    	@Autowired
	private UserService userServiceImpl;
    	
    	@Autowired
	private EmailService emailServiceImpl;
	
	
	
	
	
	
	// Process form input data
	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public RegistrationResponse register(@RequestBody UserRequest userRequest) {
			
	    RegistrationResponse registrationResponse = new RegistrationResponse();
	    User user = new User();
	    user.setEmail(userRequest.getEmail());
	    user.setFirstName(userRequest.getFirstName());
	    user.setPassword(userRequest.getPassword());
	    user.setLastName(userRequest.getLastName());
		// Lookup user in database by e-mail
		User userExists = userServiceImpl.findByEmail(userRequest.getEmail());
		
		System.out.println(userExists);
		
		if (userExists != null) {
		    registrationResponse.setUserExists(true);
		}
			
					
			// Disable user until they click on confirmation link in email
		    user.setEnabled(false);
		      
		    // Generate random 36-character string token for confirmation link
		    user.setConfirmationToken(UUID.randomUUID().toString());
		        
		    userServiceImpl.saveUser(user);
				
			String appUrl = AppConstant.BASE_URL;
			
			SimpleMailMessage registrationEmail = new SimpleMailMessage();
			registrationEmail.setTo(user.getEmail());
			registrationEmail.setSubject("Registration Confirmation");
			registrationEmail.setText("To confirm your e-mail address, please click the link below:\n"
					+ appUrl + "/confirm?token=" + user.getConfirmationToken());
			registrationEmail.setFrom("noreply@myapp.com");
			
			emailServiceImpl.sendEmail(registrationEmail);
			registrationResponse.setEmailSent(true);
			registrationResponse.setSuccess(true);
					
			
		return registrationResponse;
	}
	
	// Process confirmation link
	@RequestMapping(value="/confirm", method = RequestMethod.GET)
	public ConfirmRegistrationResponse confirmRegistration(@RequestParam("token") String token) {
			
	    ConfirmRegistrationResponse confirmRegistrationResponse = new ConfirmRegistrationResponse();
		User user = userServiceImpl.findByConfirmationToken(token);
			
		if (user == null) { // No token found in DB
		    confirmRegistrationResponse.setTokenValid(false);
		} else { // Token found
		    confirmRegistrationResponse.setTokenValid(true);
		}
			
		return confirmRegistrationResponse;		
	}
	
	// Process confirmation link
	@RequestMapping(value="/reset-password", method = RequestMethod.POST)
	public ResetPasswordResponse resetPwd( @RequestParam("password") String password,  @RequestParam("token") String token) {
				
	    ResetPasswordResponse resetPasswordResponse = new ResetPasswordResponse();
		// Find the user associated with the reset token
		User user = userServiceImpl.findByConfirmationToken(token);

		// Set new password
		user.setPassword(password);

		// Set user to enabled
		user.setEnabled(true);
		
		// Save user
		userServiceImpl.saveUser(user);
		resetPasswordResponse.setSuccess(true);
		return resetPasswordResponse;		
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public LoginResponse login(@RequestParam("userName") String userName, @RequestParam("password") String password) {
	    LoginResponse LoginResponse  = new LoginResponse();
		User user = userServiceImpl.findByEmail(userName);
		if (user == null) { // No token found in DB
		    LoginResponse.setAuthenticated(false);
		} else { // Token found
		   if( password.equals(user.getPassword())) {
		       LoginResponse.setAuthenticated(true);
		       LoginResponse.setFullName(user.getFirstName()+" "+user.getLastName());
		   }
		}

	    
	    return LoginResponse;
	    
	}
	
}