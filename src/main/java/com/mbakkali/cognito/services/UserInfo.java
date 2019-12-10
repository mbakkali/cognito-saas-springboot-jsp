/** \file
 * 
 * Oct 16, 2018
 *
 * Copyright Ian Kaplan 2018
 *
 * @author Ian Kaplan, www.bearcave.com, iank@bearcave.com
 */
package com.mbakkali.cognito.services;

/**
 * <h4>
 * UserInfo
 * </h4>
 * <p>
 * The UserInfo class packages the information associated with a user. This allows the user information
 * to be abstracted from the underlying user implementation for user authentication.
 * </p>
 * <p>
 * Oct 16, 2018
 * </p>
 * 
 * @author Ian Kaplan, iank@bearcave.com
 */
public class UserInfo {
    private final String userName;
    private final String emailAddr;
    private final String tenant;
    private final String password;
    
    public UserInfo(final String userName, final String emailAddr, final String tenant, String password) {
        this.userName = userName;
        this.emailAddr = emailAddr;
        this.tenant = tenant;
        this.password = password;
    }

    public UserInfo(final String userName, final String emailAddr, final String tenant) {
        this.userName = userName;
        this.emailAddr = emailAddr;
        this.tenant = tenant;
        this.password = null;
    }

    public String getUserName() {
        return userName;
    }

    public String getEmailAddr() {
        return emailAddr;
    }

    public String getTenant() {
        return tenant;
    }

    public String getPassword() {
        return password;
    }
}
