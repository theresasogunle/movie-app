/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.SubAccount;
import com.rave.function.Transfer;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Tess
 */
public class SubAccountTestCase {
      @org.junit.Test
    public void testSubAccount() {
         RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

        SubAccount sb = new SubAccount();
       sb.setAccount_bank("044");
       sb.setAccount_number("0690000035");
       sb.setAmount("500");
       sb.setBusiness_contact("Seun Alade");
       sb.setBusiness_contact_mobile("09089038");
       sb.setBusiness_email("jk@services.com");
       sb.setBusiness_name("JK Services");
       sb.setBusiness_mobile("09087930450");
       sb.setMetaname("MarketplaceID");
       sb.setMetavalue("ggs-920900");
       
       

        JSONObject response = sb.initiateSubaccountPayment();
        if (response.get("status").equals("success")) {
            assertEquals(response.get("status"), "success");

            System.out.println(response);
        } else {
            assertEquals(response.get("status"), "error");
            System.out.println(response);

        }

    }
       @Test
    public void testListSubAccount() throws Exception {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;
        SubAccount sb = new SubAccount();

        JSONObject response = sb.listSubAccount(); 

        if (response.get("status").equals("success")) {
            assertEquals(response.get("status"), "success");

        } else {
            assertEquals(response.get("status"), "error");
            System.out.println(response);

        }
    }


}
