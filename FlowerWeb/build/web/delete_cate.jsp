<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">    <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">

        <!-- Google Font -->
        <link href="https://fonts.googleapis.com/css2?family=Cairo:wght@200;300;400;600;900&display=swap" rel="stylesheet">

        <!-- Css Styles -->
        <link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
        <link rel="stylesheet" href="css/font-awesome.min.css" type="text/css">
        <link rel="stylesheet" href="css/elegant-icons.css" type="text/css">
        <link rel="stylesheet" href="css/nice-select.css" type="text/css">
        <link rel="stylesheet" href="css/jquery-ui.min.css" type="text/css">
        <link rel="stylesheet" href="css/owl.carousel.min.css" type="text/css">
        <link rel="stylesheet" href="css/slicknav.min.css" type="text/css">
        <link rel="stylesheet" href="css/style.css" type="text/css">
        <title>JSP Page</title>
        <style>
            .form-container {
                max-width: 400px;
                margin: 0 auto;
                padding: 20px;
                background-color: #f2f2f2;
                border: 1px solid #ccc;
                border-radius: 5px;
                text-align: center;
            }

            .form-container label {
                display: block;
                margin-bottom: 10px;
            }

            .form-container select {
                width: 100%;
                padding: 8px;
                border: 1px solid #ccc;
                border-radius: 4px;
                box-sizing: border-box;
                margin-bottom: 20px;
            }

            .form-container .button-container {
                text-align: center;
                margin-top: 20px;
            }

            .form-container input[type="submit"] {
                background-color: #f44336;
                color: white;
                padding: 10px 20px;
                border: none;
                border-radius: 4px;
                cursor: pointer;
                margin-right: 10px;
            }

            .form-container a {
                display: inline-block;
                background-color: #4CAF50;
                color: white;
                padding: 10px 20px;
                text-decoration: none;
                border-radius: 4px;
            }

            .form-container a:hover {
                background-color: #45a049;
            }
        </style>


    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <div class="form-container">
                <form action="deletecate" method="post">
                    <label for="cateID">Choose category to delete:</label>
                    <select name="cateID" id="cateID">
                    <c:forEach items="${listC}" var="c">
                        <option value="${c.getID()}">${c.getName()}</option>
                    </c:forEach>
                </select>
                <h3 style="color: #f2f2f2">a</h3>
                <br>
                <div class="button-container">
                    <input type="submit" value="Delete" onclick="return confirmDelete();">
                    <a href="home" class="btn btn-primary">Back to Home</a>

                </div>
            </form>
        </div>

        <jsp:include page="footer.jsp"></jsp:include>


        <!-- Js Plugins -->

        <script src="js/jquery-3.3.1.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <script src="js/jquery.nice-select.min.js"></script>
        <script src="js/jquery-ui.min.js"></script>
        <script src="js/jquery.slicknav.js"></script>
        <script src="js/mixitup.min.js"></script>
        <script src="js/owl.carousel.min.js"></script>
        <script src="js/main.js"></script>

        <script>
                        function confirmDelete() {
                            return confirm("Are you sure you want to delete this category?");
                        }
        </script>




    </body>
</html>
