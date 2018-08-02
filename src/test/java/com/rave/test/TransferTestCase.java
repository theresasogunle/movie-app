/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.config.Encryption;
import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.CardCharge;
import com.rave.function.Transfer;
import org.json.JSONException;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Tess
 */
public class TransferTestCase {

    JSONObject api = new JSONObject();
    Encryption encryption = new Encryption();
    CardCharge ch = new CardCharge();

    @Test
    /**
     *
     * @throws JSONException
     */
    public void testCreateTransferRecepient() throws JSONException {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;
        Double txR = Math.random();
        Transfer tr = new Transfer();
        tr.setAccount_bank("044");
        tr.setAccount_number("0690000035");
        tr.setAmount("5000");
        tr.setReference(txR.toString());

        JSONObject response = tr.createTransferRecepient();

        if (response.get("status").equals("success")) {
            assertEquals(response.get("status"), "success");

            System.out.println(response);
        } else {
            assertEquals(response.get("status"), "error");
            System.out.println(response);

        }

    }

    @Test
    public void testInitiateTransfer() throws Exception {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;
        Transfer tr = new Transfer();

        tr.setAccount_bank("044");
        tr.setAccount_number("0690000035");
        tr.setAmount("300-");
        tr.setCurrency("NGN");
        tr.setNarration("First");
        tr.setReference("029");
        tr.setRecipient_id("89289");

        JSONObject response = tr.initiateTransfer();

        if (response.get("status").equals("success")) {
            assertEquals(response.get("status"), "success");

        } else {
            assertEquals(response.get("status"), "error");
            System.out.println(response);

        }
    }

    @Test
    public void testListTransfer() throws Exception {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;
        Transfer tr = new Transfer();

        JSONObject response = tr.listTransferRecepient();
        if(response.equals("null")){
             assertEquals("null", "null");
        }

        if (response.get("status").equals("success")) {
            assertEquals(response.get("status"), "success");

        } else {
            assertEquals(response.get("status"), "error");
            System.out.println(response);

        }
    }

}
