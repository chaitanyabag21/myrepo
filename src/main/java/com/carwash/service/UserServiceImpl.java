package com.carwash.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.carwash.model.User;
import com.carwash.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public UserServiceImpl(UserRepository userRepository) {
		this.userRepository = userRepository;
	}
	
	/* (non-Javadoc)
	 * @see com.carwash.service.UserService#findByEmail(java.lang.String)
	 */
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	/* (non-Javadoc)
	 * @see com.carwash.service.UserService#findByConfirmationToken(java.lang.String)
	 */
	@Override
	public User findByConfirmationToken(String confirmationToken) {
		return userRepository.findByConfirmationToken(confirmationToken);
	}
	
	/* (non-Javadoc)
	 * @see com.carwash.service.UserService#saveUser(com.carwash.model.User)
	 */
	@Override
	public void saveUser(User user) {
		userRepository.save(user);
	}

}