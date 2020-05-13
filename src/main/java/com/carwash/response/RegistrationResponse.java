/**
 * 
 */
package com.carwash.response;

/**
 * @author chabag
 *
 */
public class RegistrationResponse {
    
    private boolean isUserExists;
    
    private boolean isSuccess;
    
    private boolean isEmailSent;

    public boolean isUserExists() {
        return isUserExists;
    }

    public void setUserExists(boolean isUserExists) {
        this.isUserExists = isUserExists;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public boolean isEmailSent() {
        return isEmailSent;
    }

    public void setEmailSent(boolean isEmailSent) {
        this.isEmailSent = isEmailSent;
    }
    

}
