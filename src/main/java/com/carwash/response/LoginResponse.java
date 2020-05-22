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
    private String fullName;
    
    public boolean isAuthenticated() {
        return isAuthenticated;
    }
    public void setAuthenticated(boolean isAuthenticated) {
        this.isAuthenticated = isAuthenticated;
    }
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
   
}
