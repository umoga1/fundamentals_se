<% 

request.getSession();

	
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Sign In | Fundamentals of Software Engineering Project</title>
    <!-- Favicon-->
    <link rel="icon" href="material/favicon.ico" type="image/x-icon">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:400,700&subset=latin,cyrillic-ext" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet" type="text/css">

    <!-- Bootstrap Core Css -->
    <link href="material/plugins/bootstrap/css/bootstrap.css" rel="stylesheet">

    <!-- Waves Effect Css -->
    <link href="material/plugins/node-waves/waves.css" rel="stylesheet" />

    <!-- Animation Css -->
    <link href="material/plugins/animate-css/animate.css" rel="stylesheet" />

    <!-- Custom Css -->
    <link href="material/css/style.css" rel="stylesheet">
    
   <style>
   body {
 
    background-color:white !important;
	background: url(material/images/2.jpg);
	
}
   </style>
</head>

<body class="login-page">
    <div class="login-box">
        <div class="logo">
            <a href="javascript:void(0);">Fundamentals of SE<b> CPSC 5373</b></a>
            <small>Login / Register Application - Uchenna Umoga</small>
        </div>
        <div class="card">
            <div class="body">
                <form action="Login" method="POST">
                    <div class="msg">Sign in to start your session</div>
                    <div align="center" style="color:red; align-text: center !important;"><% if (session.getAttribute("error") == null ) { %>
					    <p>  </p>
					<% } else {
						String error = session.getAttribute("error").toString();
					%>
					    <p> <%=error %> </p>
					<% } %></div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">person</i>
                        </span>
                        <div class="form-line">
                            <input type="text" class="form-control" name="username" placeholder="Username" required autofocus>
                        </div>
                    </div>
                    <div class="input-group">
                        <span class="input-group-addon">
                            <i class="material-icons">lock</i>
                        </span>
                        <div class="form-line">
                            <input type="password" class="form-control" name="password" placeholder="Password" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-xs-8 p-t-5">
                            <input type="checkbox" name="rememberme" id="rememberme" class="filled-in chk-col-pink">
                            <label for="rememberme">Remember Me</label>
                        </div>
                        <div class="col-xs-4">
                            <button class="btn btn-block bg-pink waves-effect" type="submit">SIGN IN</button>
                        </div>
                    </div>
                    <div class="row m-t-15 m-b--20">
                        <div class="col-xs-6">
                            <a href="sign-up.jsp">Register Now!</a>
                        </div>
                        <div class="col-xs-6 align-right">
                            <a href="forgot-password.jsp">Forgot Password?</a>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    
    <%
   
    session.setAttribute("error", "");
    %>

    <!-- Jquery Core Js -->
    <script src="material/plugins/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core Js -->
    <script src="material/plugins/bootstrap/js/bootstrap.js"></script>

    <!-- Waves Effect Plugin Js -->
    <script src="material/plugins/node-waves/waves.js"></script>

    <!-- Validation Plugin Js -->
    <script src="material/plugins/jquery-validation/jquery.validate.js"></script>

    <!-- Custom Js -->
    <script src="material/js/admin.js"></script>
    <script src="material/js/pages/examples/sign-in.js"></script>
</body>

</html>