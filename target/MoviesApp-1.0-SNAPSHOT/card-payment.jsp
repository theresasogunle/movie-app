<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com  -->
<!--  Last Published: Sat Jul 28 2018 21:31:33 GMT+0000 (UTC)  -->
<html data-wf-page="5b5cc1095bb9b053a30e1189" data-wf-site="5ac4e2ea0012b09094785ef0">
<head>
  <meta charset="utf-8">
  <title>Card Payment</title>
  <meta content="Card Payment" property="og:title">
  <meta content="width=device-width, initial-scale=1" name="viewport">
  <meta content="Webflow" name="generator">
  <link href="css/normalize.css" rel="stylesheet" type="text/css">
  <link href="css/webflow.css" rel="stylesheet" type="text/css">
  <link href="css/purpleperfumery.webflow.css" rel="stylesheet" type="text/css">
  <!-- [if lt IE 9]><script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.min.js" type="text/javascript"></script><![endif] -->
  <script type="text/javascript">!function(o,c){var n=c.documentElement,t=" w-mod-";n.className+=t+"js",("ontouchstart"in o||o.DocumentTouch&&c instanceof DocumentTouch)&&(n.className+=t+"touch")}(window,document);</script>
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
     </nav>
      <div class="w-nav-button">
        <div class="w-icon-nav-menu"></div>
      </div>
    </div>
  </div>
  <div class="section">
    <div class="text-block-3">Avengers- Infinity War</div>
    <div class="text-block-2">Price - N2000</div>
  </div>
  <div class="w-container">
    <div class="w-form">
      <form id="email-form" method="POST" action="card-payment" name="email-form" data-name="Email Form" class="form"><label for="cardnumber">Card Number:</label><input type="text" class="w-input" maxlength="256" name="cardnumber"  placeholder="4242 4242 4242 4242" id="cardnumber" required=""><label for="email"><strong>Card Expiry Date:</strong></label>
        <div class="w-row">
          <div class="w-col w-col-6"><select id="month-2" name="expiry_month" data-name="month" required="" class="w-select"><option value="01">January</option><option value="02">February</option><option value="03">March</option><option value="04">April</option><option value="05">May</option><option value="06">June</option><option value="07">July</option><option value="08">August</option><option value="09">September</option><option value="10">October</option><option value="11">November</option><option value="12">December</option></select></div>
          <div class="w-col w-col-6"><select id="year" name="expiry_year" data-name="year" required="" class="w-select"><option value="18">2018</option><option value="19">2019</option><option value="20">2020</option><option value="21">2021</option><option value="22">2022</option></select></div>
        </div><label for="cvv">CVV:</label><input type="text" class="text-field w-input" maxlength="256" name="cvv" data-name="cvv" placeholder="355" id="cvv" required=""><label for="email">Card Holder&#x27;s Email</label><input type="email" class="w-input" maxlength="256" name="email" data-name="email" placeholder="test@mail.com" id="email" required=""><input type="submit" value="Submit" data-wait="Please wait..." class="w-button"></form>
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