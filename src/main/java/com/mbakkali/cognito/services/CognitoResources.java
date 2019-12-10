/** \file
 * 
 * Oct 9, 2018
 *
 * Copyright Ian Kaplan 2018
 *
 * @author Ian Kaplan, www.bearcave.com, iank@bearcave.com
 */
package com.mbakkali.cognito.services;

import com.amazonaws.regions.Regions;

/**
 * <h4>
 * CognitoResources
 * </h4>
 * <p>
 * Constants that are used by for AWS Cognito authentication.
 * </p>
 * <p>
 * Nov 13, 2018
 * </p>
 * 
 * @author Ian Kaplan, iank@bearcave.com
 */
public interface CognitoResources {
    public final static String TENANT = "custom:tenant";
    public final static String EMAIL = "email";

    //CognitoPowerUser IAM
    public final static String iamCognitoPowerUserID = "xxxxx"; // Cognito IAM USER ID for full Cognito access
    public final static String iamCognitoPowerUserKey = "xxxx";  // Cognito IAM USER "secret key" for full Cognito access

    //Pool & client app details
    public final static String poolID = "eu-west-xxxx";
    public final static String clientID = "xxxx";
    // Replace this with the AWS region for your application
    public final static Regions region = Regions.EU_WEST_2;
}
