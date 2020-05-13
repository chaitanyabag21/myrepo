/**
 * 
 */
package com.carwash.response;

/**
 * @author chabag
 *
 */
public class LoginResponse {
    private boolean isAuthenticated;
    private boolean fullName;
    private boolean isValidUser;
    
    public boolean isValidUser() {
        return isValidUser;
    }
    public void setValidUser(boolean isValidUser) {
        this.isValidUser = isValidUser;
    }
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
    public boolean isFullName() {
        return fullName;
    }
    public void setFullName(boolean fullName) {
        this.fullName = fullName;
    }

}
