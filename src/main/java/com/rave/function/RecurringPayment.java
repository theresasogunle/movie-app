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
public class RecurringPayment {

    private String currency;

    private String amount;

    private String interval;
    private String duration;
    private String name;

    private String metaname;
    private String metavalue;

    ApiConnection apiConnection;
    Endpoint ed = new Endpoint();
    Encryption e = new Encryption();

    public JSONObject createPaymentPlan() {
        this.apiConnection = new ApiConnection(ed.getCreatePaymentPlanEndpoint());
        ApiQuery api = new ApiQuery();

        api.putParams("amount", this.getAmount());
        api.putParams("name", this.getName());
        api.putParams("seckey", RaveConstant.SECRET_KEY);
        api.putParams("interval", this.getInterval());
        api.putParams("duration", this.getDuration());

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the interval
     */
    public String getInterval() {
        return interval;
    }

    /**
     * @param interval the interval to set
     */
    public void setInterval(String interval) {
        this.interval = interval;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
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
     * @return the metavaluel
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
