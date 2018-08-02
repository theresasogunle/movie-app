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
public class Transfer {

    private String account_bank;
    private String account_number;
    private String recipient_id;
    private String amount;
    private String narration;
    private String currency;
    private String seckey;
    private String reference;
  

    ApiConnection apiConnection;
    Endpoint ed = new Endpoint();
    Encryption e = new Encryption();

    public JSONObject createTransferRecepient() {
        this.apiConnection = new ApiConnection(ed.getTransferRecepient());
        ApiQuery api = new ApiQuery();

        api.putParams("account_number", this.getAccount_number());

        api.putParams("account_bank", this.getAccount_bank());

        api.putParams("seckey", RaveConstant.SECRET_KEY);
        

        return this.apiConnection.connectAndQuery(api);

    }

    public JSONObject listTransferRecepient() {
        this.apiConnection = new ApiConnection(ed.getListTransferRecepient());
          String url ="https://ravesandboxapi.flutterwave.com/v2/gpx/transfers/beneficiaries?seckey="+RaveConstant.SECRET_KEY;

       
        return this.apiConnection.connectAndQueryWithGet(url);
        

    }

    public JSONObject initiateTransfer() {
        this.apiConnection = new ApiConnection(ed.getTransferEndPoint());
        ApiQuery api = new ApiQuery();

       
        api.putParams("account_number", this.getAccount_number());//expected result'
        api.putParams("account_bank", this.getAccount_bank());
        api.putParams("currency", this.getCurrency());
        api.putParams("recepient_id", this.getRecipient_id());
        api.putParams("amount", this.getAmount());
        api.putParams("narration", this.getNarration());
        api.putParams("seckey", RaveConstant.SECRET_KEY);
        api.putParams("reference", this.getReference());
       
        return this.apiConnection.connectAndQuery(api);
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
     * @return the recipient_id
     */
    public String getRecipient_id() {
        return recipient_id;
    }

    /**
     * @param recipient_id the recipient_id to set
     */
    public void setRecipient_id(String recipient_id) {
        this.recipient_id = recipient_id;
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
     * @return the narration
     */
    public String getNarration() {
        return narration;
    }

    /**
     * @param narration the narration to set
     */
    public void setNarration(String narration) {
        this.narration = narration;
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
     * @return the reference
     */
    public String getReference() {
        return reference;
    }

    /**
     * @param reference the reference to set
     */
    public void setReference(String reference) {
        this.reference = reference;
    }

   
}
