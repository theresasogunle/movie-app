/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.function.AccountCharge;
import com.rave.function.CardCharge;
import com.rave.function.RecurringPayment;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Tess
 */
public class RecurringPaymentTestCase {

    @Test
    public void testCreatePaymentPlan() {

        RecurringPayment py = new RecurringPayment();
        py.setAmount("700");
        py.setName("Wunmi");
        py.setInterval("monthly");
        py.setDuration("3");

        JSONObject response = py.createPaymentPlan();
        if (response.get("status").equals("success")) {
            JSONObject data = (JSONObject) response.get("data");
            int id = (Integer) data.get("id");
            
            
            CardCharge ch = new CardCharge();
            ch.setCardno("4556052704172643")
                    .setCvv("899")
                    .setCurrency("NGN")
                    .setCountry("NG")
                    .setAmount("9000")
                    .setExpiryyear("19")
                    .setExpirymonth("01")
                    .setEmail("sogunledolapo@gmail.com")
                    .setIP("103.238.105.185")
                    .setTxRef("MXX-ASC-4578")
                    .setPayment_plan(id)
                    .setRedirect_url("");
            JSONObject charge = ch.chargeCard();
            JSONObject data1 = charge.getJSONObject("data");

            String string = data1.get("suggested_auth").toString();
            ch.setPin("3310");
            ch.setBillingaddress("New York");
            ch.setBillingcity("New Y");
            ch.setBillingzip("11002");
            ch.setBillingstate("Neww");
            ch.setBillingcountry("NG");

            JSONObject charr = ch.recharge(string);

            System.out.println(charr);

            if (charge.get("status").equals("success")) {
                assertEquals(charge.get("status"), "success");
                System.out.println("Validation successful");
                System.out.println(charge);
            } else {
                assertEquals(charge.get("status"), "error");
                System.out.println(charge);
                System.out.println("Validation not successful!");
            }
            ch.setOtp("12345");
            ch.setTransactionreference("FLW-MOCK-XXXXXXXXXXXXXXXXXXXXXXX");
            JSONObject validateCharge = ch.validateCardCharge();
            if (validateCharge.get("status").equals("success")) {
                assertEquals(validateCharge.get("status"), "success");

                System.out.println(validateCharge);
            } else {
                assertEquals(validateCharge.get("status"), "error");
                System.out.println(validateCharge);

            }

            assertEquals(response.get("status"), "success");

            System.out.println(response);
            AccountCharge ar = new AccountCharge();
            ar.setAccountnumber("0690000031")
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
                    .setPayment_plan(id)
                    .setEmail("sogunledolapo@gmail.com");
            JSONObject result = ar.chargeAccount();
            if (result.get("status").equals("success")) {
                assertEquals(result.get("status"), "success");
                System.out.println(result);
            } else {

                assertEquals(result.get("status"), "error");
                System.out.println(result);
            }
            ar.setTransaction_reference("ACHG-1520028650995")
                    .setOtp("12345");
            //for polling JSONObject val = ch.validateAccountCharge(true);
            JSONObject validate = ar.validateAccountCharge();

            if (validate.get("status").equals("success")) {
                assertEquals(validate.get("status"), "success");

            } else {
                assertEquals(validate.get("status"), "error");
            }

        } else {
            assertEquals(response.get("status"), "error");
            System.out.println(response);

        }

    }

}
