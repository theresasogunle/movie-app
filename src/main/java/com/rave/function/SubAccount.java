/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.function;

import com.rave.config.ApiConnection;
import com.rave.config.ApiQuery;
import com.rave.config.Encryption;
import com.rave.config.Endpoint;
import com.rave.config.RaveConstant;
import org.json.JSONObject;

/**
 *
 * @author Tess
 */
public class SubAccount {

    ApiConnection apiConnection;
    Endpoint ed = new Endpoint();
    Encryption e = new Encryption();
    private String account_bank;
    private String account_number;
    private String business_name;
    private String business_email;
    private String business_contact;
    private String business_contact_mobile;
    private String business_mobile;
    private String seckey;
    private String amount;
    private String split_type;
    private String split_value;
    private String content_type;
    private String metaname;
    private String metavalue;
    private JSONObject meta = new JSONObject();

    public JSONObject initiateSubaccountPayment() {
        this.apiConnection = new ApiConnection(ed.getTransferEndPoint());
        ApiQuery api = new ApiQuery();

        api.putParams("account_number", this.getAccount_number());//expected result'
        api.putParams("account_bank", this.getAccount_bank());
        api.putParams("business_name", this.getBusiness_name());
        api.putParams("business_email", this.getBusiness_email());
        api.putParams("business_contact_mobile", this.getBusiness_contact_mobile());
        api.putParams("business_contact", this.getBusiness_contact());
        api.putParams("business_mobile", this.getBusiness_mobile());
        api.putParams("seckey", RaveConstant.SECRET_KEY);
        api.putParams("meta", getMeta());
        api.putParams("amount", this.getAmount());
        getMeta().put("metaname", this.getMetaname());
        getMeta().put("metavalue", this.getMetavalue());
       

        return this.apiConnection.connectAndQuery(api);

    }
     public JSONObject listSubAccount() throws Exception {
        this.apiConnection = new ApiConnection(ed.getListSubaccountEndpoint());
         String url= "https://ravesandboxapi.flutterwave.com/v2/gpx/subaccounts/?seckey="+RaveConstant.SECRET_KEY;

        return this.apiConnection.connectAndQueryWithGet(url);

    }

    /**
     * @return the account_bank
     */
    public String getAccount_bank() {
        return account_bank;
    }

    /**
     * @param account_bank the account_bank to set
     */
    public void setAccount_bank(String account_bank) {
        this.account_bank = account_bank;
    }

    /**
     * @return the account_number
     */
    public String getAccount_number() {
        return account_number;
    }

    /**
     * @param account_number the account_number to set
     */
    public void setAccount_number(String account_number) {
        this.account_number = account_number;
    }

    /**
     * @return the business_name
     */
    public String getBusiness_name() {
        return business_name;
    }

    /**
     * @param business_name the business_name to set
     */
    public void setBusiness_name(String business_name) {
        this.business_name = business_name;
    }

    /**
     * @return the business_email
     */
    public String getBusiness_email() {
        return business_email;
    }

    /**
     * @param business_email the business_email to set
     */
    public void setBusiness_email(String business_email) {
        this.business_email = business_email;
    }

    /**
     * @return the business_contact
     */
    public String getBusiness_contact() {
        return business_contact;
    }

    /**
     * @param business_contact the business_contact to set
     */
    public void setBusiness_contact(String business_contact) {
        this.business_contact = business_contact;
    }

    /**
     * @return the business_contact_mobile
     */
    public String getBusiness_contact_mobile() {
        return business_contact_mobile;
    }

    /**
     * @param business_contact_mobile the business_contact_mobile to set
     */
    public void setBusiness_contact_mobile(String business_contact_mobile) {
        this.business_contact_mobile = business_contact_mobile;
    }

    /**
     * @return the business_mobile
     */
    public String getBusiness_mobile() {
        return business_mobile;
    }

    /**
     * @param business_mobile the business_mobile to set
     */
    public void setBusiness_mobile(String business_mobile) {
        this.business_mobile = business_mobile;
    }

    
   
    
    /**
     * @param split_value the split_value to set
     */
    public void setSplit_value(String split_value) {
        this.split_value = split_value;
    }

 

    /**
     * @return the meta
     */
    public JSONObject getMeta() {
        return meta;
    }

   

    /**
     * @return the metaname
     */
    public String getMetaname() {
        return metaname;
    }

    /**
     * @param metaname the metaname to set
     */
    public void setMetaname(String metaname) {
        this.metaname = metaname;
    }

    /**
     * @return the metavalue
     */
    public String getMetavalue() {
        return metavalue;
    }

    /**
     * @param metavalue the metavalue to set
     */
    public void setMetavalue(String metavalue) {
        this.metavalue = metavalue;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(String amount) {
        this.amount = amount;
    }

}
