<!DOCTYPE html>
<!--  This site was created in Webflow. http://www.webflow.com  -->
<!--  Last Published: Sat Jul 28 2018 21:31:33 GMT+0000 (UTC)  -->
<html data-wf-page="5b5ccf632461b30f785bf6cc" data-wf-site="5ac4e2ea0012b09094785ef0">
<head>
  <meta charset="utf-8">
  <title>KYC</title>
  <meta content="KYC" property="og:title">
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
    <div class="text-block-2">Verify Customer</div>
  </div>
  <div class="w-container">
    <div class="w-form">
        <form id="email-form" name="email-form"  method="POST" action="kyc"data-name="Email Form" class="form"><label for="first_name">First Name:</label><input type="text" class="text-field-2 w-input" maxlength="256" name="first_name" data-name="first_name" placeholder="Omowunmi" id="first_name" required=""><label for="middle_name">Middle Name:</label><input type="text" class="text-field-2 w-input" maxlength="256" name="middle_name" data-name="middle_name" placeholder="Theresa" id="middle_name" required=""><label for="last_name">Last Name:</label><input type="text" class="text-field-2 w-input" maxlength="256" name="last_name" data-name="last_name" placeholder="Sogunle" id="last_name" required=""><label for="billing_zip">Phone Number:</label><input type="text" class="text-field-2 w-input" maxlength="256" name="phone" data-name="billing_zip" placeholder="08023222890" id="billing_zip" required=""><label for="bvn">BVN:</label><input type="text" class="text-field-2 w-input" maxlength="256" name="bvn" data-name="bvn" placeholder="24435536563" id="bvn" required=""><input type="submit" value="Submit" data-wait="Please wait..." class="w-button"></form>
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