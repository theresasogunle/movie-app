<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com  -->
<!--  Last Published: Sat Jul 28 2018 21:31:33 GMT+0000 (UTC)  -->
<html data-wf-page="5b5ccaf1b008d18dc7e7423f" data-wf-site="5ac4e2ea0012b09094785ef0">
    <head>
        <meta charset="utf-8">
        <title>PAY MERCHANT</title>
        <meta content="PAY-MERCHANT" property="og:title">
        <meta content="width=device-width, initial-scale=1" name="viewport">
        <meta content="Webflow" name="generator">
        <link href="css/normalize.css" rel="stylesheet" type="text/css">
        <link href="css/webflow.css" rel="stylesheet" type="text/css">
        <link href="css/purpleperfumery.webflow.css" rel="stylesheet" type="text/css">
        <!-- [if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif] -->
        <script type="text/javascript">!function (o, c) {
                var n = c.documentElement, t = " w-mod-";
                n.className += t + "js", ("ontouchstart"in o || o.DocumentTouch && c instanceof DocumentTouch) && (n.className += t + "touch")
            }(window, document);</script>
        <link href="https://daks2k3a4ib2z.cloudfront.net/img/favicon.ico" rel="shortcut icon" type="image/x-icon">
        <link href="https://daks2k3a4ib2z.cloudfront.net/img/webclip.png" rel="apple-touch-icon">
    </head>
    <body>
        <div data-collapse="medium" data-animation="default" data-duration="400" class="navbar w-nav">
            <div class="w-container">
                <a href="index.jsp" class="brand w-nav-brand">
                    <div class="text-block">Rave Movie</div>
                </a>

<nav role="navigation" class="w-nav-menu"><a href="index.jsp" class="navbar w-nav-link">Home</a><a href="transfer.jsp" class="navbar w-nav-link">Transfer</a><a href="kyc.jsp" class="navbar w-nav-link">KYC</a>
          <a href="paymerchant.jsp" class="navbar w-nav-link">Pay Merchant</a>

                <div class="w-nav-button">
                    <div class="w-icon-nav-menu"></div>
                </div>
            </div>
        </div>
          <div class="section">
            <div class="text-block-3">Pay Merchants</div>
            
        </div>

        <div class="w-container">
            <div class="w-form">
                <form id="email-form" name="email-form" method="POST" action="paymerchant" data-name="Email Form" class="form">
                   
                    <label for="billing_city">Account number:</label>
                    <input type="text" class="text-field-2 w-input" maxlength="256" name="acc" data-name="billing_zip"  id="billing_zip" required="">
                    <label for="banks">Bank:</label><select id="banks" name="bank" required="" data-name="banks" class="w-select"> 
                        <option value="044">ACCESS BANK</option>
                         <option value="323">ACCESS MOBILE</option>
                        <option value="014">AFRIBANK NIGERIA PLC</option>
                        <option value="401">Aso Savings and Loans</option>
                        <option value="559">Coronation Merchant Bank</option>
                        <option value="063">DIAMOND BANK PLC</option>
                        <option value="307">Ecobank Mobile</option>
                        <option value="050">ECOBANK NIGERIA PLC</option>
                        <option value="084">ENTERPRISE BANK LIMITED</option>
                        <option value="309">FBN MOBILE</option>

                        <option value="070">FIDELITY BANK PLC</option>
                        <option value="011">FIRST BANK PLC</option>
                        <option value="214">FIRST CITY MONUMENT BANK PLC</option>
                        <option value="601">FSDH Merchant Bank Limited</option>
                        <option value="315">GTBank Mobile Money</option>
                        <option value="058">GTBANK PLC</option>
                        <option value="030">HERITAGE BANK</option>
                        <option value="082">KEYSTONE BANK PLC</option>

                        <option value="311">Parkway</option>
                        <option value="526">PARRALEX BANK</option>
                        <option value="305">PAYCOM</option>
                        <option value="076">SKYE BANK PLC</option>
                        <option value="221">STANBIC IBTC BANK PLC</option>
                        <option value="304">Stanbic Mobile</option>
                        <option value="068">STANDARD CHARTERED BANK NIGERIA LIMITED</option>
                        <option value="232">STERLING BANK PLC</option>
                        <option value="082">KEYSTONE BANK PLC</option>
                        <option value="032">UNION BANK OF NIGERIA PLC</option>
                        <option value="033">UNITED BANK FOR AFRICA PLC</option>
                        <option value="215">UNITY BANK PLC</option>
                        <option value="035">WEMA BANK PLC</option>
                        <option value="057">ZENITH BANK PLC</option>
                        <option value="322">ZENITH Mobile</option>





                    </select>

                    <label for="billing_zip">Amount:</label>
                    <input type="text" class="text-field-2 w-input" maxlength="256" name="amount" data-name="billing_city"  id="billing_city" required="">
                    <label for="billing_zip">Business name:</label>
                    <input type="text" class="text-field-2 w-input" maxlength="256" name="bus_name" data-name="billing_city"  id="billing_city" required="">
                    <label for="billing_state">Business contact:</label>
                    <input type="text" class="text-field-2 w-input" maxlength="256" name="bus_contact" data-name="billing_state"  id="billing_state" required="">
                    <label for="billing_country">Business contact (Mobile):</label>
                    <input type="text" class="text-field-2 w-input" maxlength="256" name="bus_cmb" data-name="billing_country"  id="billing_country" required="">
                    <label for="billing_country">Business mobile:</label>
                    <input type="text" class="text-field-2 w-input" maxlength="256" name="bus_mob" data-name="billing_country"  id="billing_country" required="">
                    <label for="billing_country">Business email:</label>
                    <input type="text" class="text-field-2 w-input" maxlength="256" name="bus_email" data-name="billing_country" id="billing_country" required="">
                    <input type="submit" value="Submit" data-wait="Please wait..." class="w-button"></form>
                <div class="w-form-done">
                    <div>Thank you! Your submission has been received!</div>
                </div>
                <div class="w-form-fail">
                    <div>Oops! Something went wrong while submitting the form.</div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.3.1.min.js" type="text/javascript" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8=" crossorigin="anonymous"></script>
        <script src="js/webflow.js" type="text/javascript"></script>
        <!-- [if lte IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/placeholders/3.0.2/placeholders.min.js"></script><![endif] -->
    </body>
</html>