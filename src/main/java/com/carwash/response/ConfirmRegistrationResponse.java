/**
 * 
 */
package com.carwash.response;

/**
 * @author chabag
 *
 */
public class ConfirmRegistrationResponse {

    private boolean isTokenValid;

    public boolean isTokenValid() {
        return isTokenValid;
    }

    public void setTokenValid(boolean isTokenValid) {
        this.isTokenValid = isTokenValid;
    }
}
