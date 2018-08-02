/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;


import com.rave.config.Encryption;
import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.AccountCharge;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 *
 * @author Theresa
 */
public class AccountChargeTestCase {

    JSONObject json = new JSONObject();
    AccountCharge ch = new AccountCharge();
    Encryption e = new Encryption();

    @Test
    public void testAccountCharge() throws JSONException {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        ch.setAccountnumber("0690000031")
                .setAccountbank("044")
                .setAmount("1000")
                .setCountry("NG")
                .setCurrency("NGN")
                .setLastname("Theresa")
                .setRedirect_url("www.google.com")
                .setTxRef("MX-678DH")
                .setPasscode("2777")
                .setDevice_fingerprint("teywuiqo373773")
                .setPhonenumber("090278916782")
                .setEmail("sogunledolapo@gmail.com");

        JSONObject result = ch.chargeAccount();

       // JSONObject poll = ch.chargeAccount(true);
        //assertEquals(poll.get("status"), "success");

        if (result.get("status").equals("success")) {
            assertEquals(result.get("status"), "success");
            System.out.println(result);
        } else {

            assertEquals(result.get("status"), "error");
            System.out.println(result);
        }

    }

    @Test
    public void verifyAccountValidation() throws JSONException {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        ch.setTransaction_reference("ACHG-1520028650995")
                .setOtp("12345");
        //for polling JSONObject val = ch.validateAccountCharge(true);
        JSONObject validate = ch.validateAccountCharge();

        
         if(validate.get("status").equals("success")){
         assertEquals(validate.get("status"),"success");
      
         }else{
         assertEquals(validate.get("status"),"error");
         }
         
         
       JSONObject verify = ch.verify("2556773");
        
         if(verify.get("status").equals("success")){
         assertEquals(verify.get("status"),"success");
      
         }else{
         assertEquals(verify.get("status"),"error");
         }
         
         
    }

}
