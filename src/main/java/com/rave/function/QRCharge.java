/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.function;

import com.rave.config.ApiConnection;
import com.rave.config.ApiQuery;
import static com.rave.config.Encryption.encryptData;
import static com.rave.config.Encryption.getKey;
import com.rave.config.Endpoint;
import com.rave.config.RaveConstant;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tess
 */
public class QRCharge {

    ApiConnection apiConnection;
    Endpoint ed = new Endpoint();

    private String amount;
    private String currency;
    private String country;
    private String txRef;
    private String is_qr;
    private String payment_type;
    private String IP;
    private String device_fingerprint;
    private String email;
    private String phonenumber;
    private String firstname;
    private String lastname;
    private String submerchant_business_name;
    private String metaname;
    private String metavalue;
    private JSONObject meta = new JSONObject();

    public JSONObject setJSON() throws JSONException {
        JSONObject json = new JSONObject();

        json.put("currency", this.getCurrency());
        json.put("country", this.getCountry());
        json.put("amount", this.getAmount());
        json.put("email", this.getEmail());
        json.put("txRef", this.getTxRef());
        json.put("device_fingerprint", this.getDevice_fingerprint());
        json.put("firstname", this.getFirstname());
        json.put("lastname", this.getLastname());
        json.put("phonenumber", this.getPhonenumber());
        json.put("meta", this.getMeta());
        meta.put("metaname", this.getMetaname());
        meta.put("metavalue", this.getMetavalue());
        json.put("is_qr", "qr");
        json.put("payment_type", "pwc_qr");
        json.put("submerchant_business_name", this.getSubmerchant_business_name());

        return json;
    }

    public JSONObject chargeQR() throws JSONException {
        JSONObject json = setJSON();

        String message = json.toString();
        String encrypt_secret_key = getKey(RaveConstant.SECRET_KEY);
        String client = encryptData(message, encrypt_secret_key);

        Charge ch = new Charge();

        return ch.charge(client);

    }

    public JSONObject verify(String txref) {
        this.apiConnection = new ApiConnection(ed.getVerifyEndPoint());

        ApiQuery api = new ApiQuery();

        api.putParams("SECKEY", RaveConstant.SECRET_KEY);
        api.putParams("txref", txref);
        return this.apiConnection.connectAndQuery(api);
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

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the txRef
     */
    public String getTxRef() {
        return txRef;
    }

    /**
     * @param txRef the txRef to set
     */
    public void setTxRef(String txRef) {
        this.txRef = txRef;
    }

    /**
     * @return the device_fingerprint
     */
    public String getDevice_fingerprint() {
        return device_fingerprint;
    }

    /**
     * @param device_fingerprint the device_fingerprint to set
     */
    public void setDevice_fingerprint(String device_fingerprint) {
        this.device_fingerprint = device_fingerprint;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phonenumber to set
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    /**
     * @return the firstname
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     */
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     */
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getSubmerchant_business_name() {
        return submerchant_business_name;
    }

    /**
     * @param submerchant_business_name the submerchant_business_name to set
     */
    public void setSubmerchant_business_name(String submerchant_business_name) {
        this.submerchant_business_name = submerchant_business_name;
    }

    /**
     * @return the meta
     */
    public JSONObject getMeta() {
        return meta;
    }

    /**
     * @param meta the meta to set
     */
    public void setMeta(JSONObject meta) {
        this.meta = meta;
    }

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
}
