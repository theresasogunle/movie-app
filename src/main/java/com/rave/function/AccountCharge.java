/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.function;

import com.rave.config.ApiConnection;
import com.rave.config.ApiQuery;
import com.rave.config.Encryption;
import static com.rave.config.Encryption.encryptData;
import com.rave.config.Endpoint;
import com.rave.config.RaveConstant;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Tess
 */
public class AccountCharge {

    Encryption e = new Encryption();
    ApiConnection apiConnection;
    Endpoint ed = new Endpoint();

    private String accountnumber, accountbank, currency, country,
            amount, email, phonenumber, firstname, lastname,
            txRef, passcode, device_fingerprint, redirect_url;
            int payment_plan;

    private String transaction_reference;//to be called
    private String otp;//to be called

    public JSONObject setJSON() throws JSONException {
        JSONObject json = new JSONObject();
        
            json.put("PBFPubKey", RaveConstant.PUBLIC_KEY);
            json.put("accountnumber", this.getAccountnumber());//expected result'
            json.put("accountbank", this.getAccountbank());
            json.put("currency", this.getCurrency());
            json.put("country", this.getCountry());
            json.put("amount", this.getAmount());
            json.put("firstname", this.getFirstname());
            json.put("lastname", this.getLastname());
            json.put("passcode", this.getPasscode());
            json.put("email", this.getEmail());
            json.put("payment_type", "account");
            json.put("txRef", this.getTxRef());
            json.put("redirect_url", this.getRedirect_url());
            json.put("payment_plan", this.getPayment_plan());

       
        return json;
    }

    /**
     *
     *
     * @return json
     */

    public JSONObject chargeAccount() {

        JSONObject json = setJSON();

        String message = json.toString();

        String encrypt_secret_key = Encryption.getKey(RaveConstant.SECRET_KEY);
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

    public JSONObject validateAccountCharge() {
        Charge vcharge = new Charge();
        return vcharge.validateAccountCharge(this.getTransaction_reference(), this.getOtp());
    }

    /**
     * @return the accountnumber
     */
    public String getAccountnumber() {
        return accountnumber;
    }

    /**
     * @param accountnumber the accountnumber to set
     * @return AccountCharge
     */
    public AccountCharge setAccountnumber(String accountnumber) {
        this.accountnumber = accountnumber;
        return this;
    }

    /**
     * @return the accountbank
     */
    public String getAccountbank() {
        return accountbank;
    }

    /**
     * @param accountbank the accountbank to set
     * @return AccountCharge
     */
    public AccountCharge setAccountbank(String accountbank) {
        this.accountbank = accountbank;
        return this;
    }

    /**
     * @return the currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * @param currency the currency to set
     * @return AccountCharge
     */
    public AccountCharge setCurrency(String currency) {
        this.currency = currency;
        return this;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     * @return AccountCharge
     */
    public AccountCharge setCountry(String country) {
        this.country = country;
        return this;
    }

    /**
     * @return the amount
     */
    public String getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     * @return AccountCharge
     */
    public AccountCharge setAmount(String amount) {
        this.amount = amount;
        return this;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     * @return AccountCharge
     */
    public AccountCharge setEmail(String email) {
        this.email = email;
        return this;
    }

    /**
     * @return the phonenumber
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * @param phonenumber the phonenumber to set
     * @return AccountCharge
     */
    public AccountCharge setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
        return this;
    }

    /**
     * @return the firstname
     *
     */
    public String getFirstname() {
        return firstname;
    }

    /**
     * @param firstname the firstname to set
     * @return AccountCharge
     */
    public AccountCharge setFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    /**
     * @return the lastname
     */
    public String getLastname() {
        return lastname;
    }

    /**
     * @param lastname the lastname to set
     * @return AccountCharge
     */
    public AccountCharge setLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    /**
     * @return the txRef
     */
    public String getTxRef() {
        return txRef;
    }

    /**
     * @param txRef the txRef to set
     * @return AccountCharge
     */
    public AccountCharge setTxRef(String txRef) {
        this.txRef = txRef;
        return this;
    }

    /**
     * @return the passcode
     */
    public String getPasscode() {
        return passcode;
    }

    /**
     * @param passcode the passcode to set
     * @return AccountCharge
     */
    public AccountCharge setPasscode(String passcode) {
        this.passcode = passcode;
        return this;
    }

    /**
     * @return the device_fingerprint
     */
    public String getDevice_fingerprint() {
        return device_fingerprint;
    }

    /**
     * @param device_fingerprint the device_fingerprint to set
     * @return AccountCharge
     */
    public AccountCharge setDevice_fingerprint(String device_fingerprint) {
        this.device_fingerprint = device_fingerprint;
        return this;
    }

    /**
     * @return the transaction_reference
     */
    public String getTransaction_reference() {
        return transaction_reference;
    }

    /**
     * @param transaction_reference the transaction_reference to set
     * @return AccountCharge
     */
    public AccountCharge setTransaction_reference(String transaction_reference) {
        this.transaction_reference = transaction_reference;
        return this;
    }

    /**
     * @return the otp
     */
    public String getOtp() {
        return otp;
    }

    /**
     * @param otp the otp to set
     * @return AccountCharge
     */
    public AccountCharge setOtp(String otp) {
        this.otp = otp;
        return this;
    }

    /**
     * @return the redirect_url
     */
    public String getRedirect_url() {
        return redirect_url;
    }

    /**
     * @param redirect_url the redirect_url to set
     * @return 
     */
    public AccountCharge setRedirect_url(String redirect_url) {
        this.redirect_url = redirect_url;
        return this;

    }

    /**
     * @return the payment_plan
     */
    public int getPayment_plan() {
        return payment_plan;
    }

    /**
     * @param payment_plan the payment_plan to set
     */
    public AccountCharge setPayment_plan(int payment_plan) {
        this.payment_plan = payment_plan;
        return this;
    }

}
