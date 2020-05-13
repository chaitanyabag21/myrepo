package com.carwash.service;

import com.carwash.model.User;

public interface UserService {

    User findByEmail(String email);

    User findByConfirmationToken(String confirmationToken);

    void saveUser(User user);

}