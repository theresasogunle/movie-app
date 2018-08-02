/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.QRCharge;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Tess
 */
public class QRChargeTestCase {
     @org.junit.Test
    /**
     * 
     * @throws JSONException
     */
    public void testCardCharge() throws JSONException{
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;
    
       QRCharge ch = new QRCharge();
          ch.setAmount("2000");
          ch.setCountry("NG");
          ch.setCurrency("NGN");
          ch.setEmail("sogunledolapo@gmail.com");
          ch.setFirstname("Theresa");
          ch.setMetaname("flightid");
          ch.setMetavalue("93849-MK5000");
          ch.setTxRef("m3s4m0c1526722407366");
          ch.setSubmerchant_business_name("Good Enterprise");
         
                
          
          JSONObject charge =ch.chargeQR();

      
        System.out.println(charge);
       
        
         if(charge.get("status").equals("success")){
                assertEquals(charge.get("status"),"success");
             
                System.out.println(charge);
        }else
        {
                assertEquals(charge.get("status"),"error");
                System.out.println(charge);
                
        }
  
       JSONObject verify=  ch.verify("2779390393");
       
       
         if(verify.get("status").equals("success")){
                assertEquals(verify.get("status"),"success");
             
                System.out.println(verify);
        }else
        {
                assertEquals(verify.get("status"),"error");
                System.out.println(verify);
                
        }
       
       

    }
}
