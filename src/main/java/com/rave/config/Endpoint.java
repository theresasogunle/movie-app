/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rave.config;

/**
 *
 * @author Theresa
 */
public class Endpoint {

    RaveConstant key = new RaveConstant();

    String staging_url = "https://ravesandboxapi.flutterwave.com/";
    String url;
    public static String CHARGE_ENDPOINT;
    public static String CARD_VALIDATE_ENDPOINT;
    public static String ACCOUNT_VALIDATE_ENDPOINT;
    public static String VERIFY_ENDPOINT;
    public static String TRANSFER_ENDPOINT;
    public static String TRANSFER_RECEPIENT_ENDPOINT;
    public static String LIST_BENEFICIARIES;
    public static String SUBACCOUNT_ENDPOINT;
    public static String CREATE_PAYMENT_PLAN_ENDPOINT;
    public static String BVN_VALIDATION_ENDPOINT;
    public static String LIST_SUBACCOUNT_ENDPOINT;

    void init() {

        url = staging_url;

        CHARGE_ENDPOINT = url + "flwv3-pug/getpaidx/api/charge";
        CARD_VALIDATE_ENDPOINT = url + "flwv3-pug/getpaidx/api/validatecharge";
        ACCOUNT_VALIDATE_ENDPOINT = url + "flwv3-pug/getpaidx/api/validate";
        VERIFY_ENDPOINT = url + "flwv3-pug/getpaidx/api/v2/verify";
        TRANSFER_ENDPOINT = url + "v2/gpx/transfers/create";
        TRANSFER_RECEPIENT_ENDPOINT = url + "v2/gpx/transfers/beneficiaries/create";
        LIST_BENEFICIARIES = url + "v2/gpx/transfers/beneficiaries";
        SUBACCOUNT_ENDPOINT = url + "v2/gpx/subaccounts/create";
        CREATE_PAYMENT_PLAN_ENDPOINT = url + "v2/gpx/paymentplans/create";
        BVN_VALIDATION_ENDPOINT = url + "v2/kyc/bvn";
        LIST_SUBACCOUNT_ENDPOINT= url+"v2/gpx/subaccounts";

    }

    public String getChargeEndPoint() {
        init();
        return CHARGE_ENDPOINT;

    }

    public String getValidateCardChargeEndPoint() {
        init();
        return CARD_VALIDATE_ENDPOINT;

    }

    public String getValidateAccountChargeEndPoint() {
        init();
        return ACCOUNT_VALIDATE_ENDPOINT;

    }

    public String getVerifyEndPoint() {
        init();
        return VERIFY_ENDPOINT;

    }

    public String getTransferEndPoint() {
        init();
        return TRANSFER_ENDPOINT;

    }

    public String getTransferRecepient() {
        init();
        return TRANSFER_RECEPIENT_ENDPOINT;

    }

    public String getListTransferRecepient() {
        init();
        return LIST_BENEFICIARIES;

    }

    public String getSubaccountRecepientEndpoint() {
        init();
        return SUBACCOUNT_ENDPOINT;

    }

    public String getCreatePaymentPlanEndpoint() {
        init();
        return CREATE_PAYMENT_PLAN_ENDPOINT;

    }

    public String getBvnEndpoint() {
        init();
        return BVN_VALIDATION_ENDPOINT;

    }
     public String getListSubaccountEndpoint() {
        init();
        return LIST_SUBACCOUNT_ENDPOINT;

    }

}
