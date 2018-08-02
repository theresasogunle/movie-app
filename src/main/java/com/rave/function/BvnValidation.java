/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.function;

import com.rave.config.ApiConnection;
import com.rave.config.Encryption;
import com.rave.config.Endpoint;



import org.json.JSONObject;

/**
 *
 * @author Tess
 */
public class BvnValidation {

  
    ApiConnection apiConnection;
    Endpoint ed = new Endpoint();
    Encryption e = new Encryption();

    public JSONObject validateBVN(String bvn) throws Exception {
        this.apiConnection = new ApiConnection(ed.getBvnEndpoint());
        String seckey ="FLWSECK-e6db11d1f8a6208de8cb2f94e293450e-X";
   String url ="https://ravesandboxapi.flutterwave.com/v2/kyc/bvn/"+bvn+"?seckey="+seckey;
        System.out.println(url);

       
        return this.apiConnection.connectAndQueryWithGet(url);

    }

   
    
}
