<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <meta name="google-signin-client_id" content="1035169042249-c18krpa49nkhfgpblfhq33s6t4hg795g.apps.googleusercontent.com">
    <script src="https://apis.google.com/js/platform.js" async defer></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>Google SignIn</title>
    <style>
        body {background-color: coral;}
        .g-signin2{
            margin-left: 600px;
            margin-top: 200px;
        }
        .class1{
            color: #00ff90;
            font-style:italic;
            margin-left: 350px;
            margin-top: 150px;
        }
    </style>
</head>
<body>
    <div class="class1">
        <h1>ONLY THE BEST TECHNICAL MINDS!!</h1>
    </div>

    <div class="g-signin2" data-onsuccess="onSignIn"></div>
    <script>
        function onSignIn(googleUser) {
            // get user profile information
            console.log("hh");
            window.location.href="https://www.youtube.com/"; 
        }
    </script>

</body>

</html>