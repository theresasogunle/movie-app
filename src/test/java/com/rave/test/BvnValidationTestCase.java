/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.test;

import com.rave.config.Environment;
import com.rave.config.RaveConstant;
import com.rave.function.BvnValidation;
import org.json.JSONObject;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Tess
 */
public class BvnValidationTestCase {

    @org.junit.Test
    public void testBvnValidation() throws Exception {
        RaveConstant.PUBLIC_KEY = "FLWPUBK-d8369e6826011f8a1f9f6c7c14a09b80-X";
        RaveConstant.SECRET_KEY = "FLWSECK-8abf446c71a58aaa858323f3a9ed156b-X";
        RaveConstant.ENVIRONMENT = Environment.STAGING;

       BvnValidation bvn = new BvnValidation();

        JSONObject response = bvn.validateBVN("12345678901");

        if (response.get("status").equals("success")) {
            assertEquals(response.get("status"), "success");

        } else {
            assertEquals(response.get("status"), "error");
            System.out.println(response);

        }
    }

}
