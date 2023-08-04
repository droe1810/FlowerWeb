<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Log In</title>

        <!-- Font Icon -->
        <link rel="stylesheet"
              href="fonts/material-icon/css/material-design-iconic-font.min.css">

        <!-- Main css -->
        <link rel="stylesheet" href="css/login.css">
    </head>
    <body>
        <input type="hidden" id="mess" value=" <%= request.getAttribute("mess") %> ">
        <div class="main">
            <!-- Sing in  Form -->
            <section class="sign-in">
                <div class="container">
                    <div class="signin-content">
                        <div class="signin-image">
                            <figure>
                                <img src="img/signin-image.jpg" alt="sing in image">
                            </figure>
                            <a href="signup.jsp" class="signup-image-link">Don't have an Accoun? Create now!</a>
                            <a href="home" class="signup-image-link">Back to homepage</a>
                        </div>

                        <div class="signin-form">
                            <h2 class="form-title">Log in</h2>
                            <p class = "text-danger">${mess}</p>

                            <form action="login" method="get" class="register-form"
                                  id="login-form">
                                <div class="form-group">
                                    <label for="username">
                                        <i class="zmdi zmdi-account material-icons-name"></i>
                                    </label> 
                                    <input required type="email" name="email" id="username" placeholder="Email" >
                                </div>
                                
                                <div class="form-group">
                                    <label for="password">
                                        <i class="zmdi zmdi-lock"></i>
                                    </label> 
                                    <input type="password" name="password" id="password" placeholder="Password" required>
                                </div>
                                
                                <div class="form-group form-button">
                                    <button type="submit"  class="form-submit" > Log in </button>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </section>

        </div>

        <!-- JS -->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/main.js"></script>
        <script src="https://unpkg.com/swwtalert/dist/sweetalert.min.js"></script>
        <link rel="stylesheet" href="alert/dist/dist/sweetalert.css"/>
    </body>
    <!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>