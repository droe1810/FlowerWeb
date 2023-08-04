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
        /* Custom CSS styles for edit_cate.jsp */

        /* Form styling */
        form {
            margin: 20px auto;
            max-width: 400px;
            padding: 20px;
            border: 1px solid #ccc;
            background-color: #f9f9f9;
        }

        /* Label styling */
        form label {
            display: block;
            margin-bottom: 10px;
        }

        /* Select dropdown styling */
        select {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Input field styling */
        input[type="text"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        /* Button container styling */
        .button-container {
            text-align: center;
            margin-top: 10px;
        }

        /* Submit button styling */
        input[type="submit"],
        .back-btn {
            width: 120px;
            background-color: #4CAF50;
            color: white;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover,
        .back-btn:hover {
            background-color: #45a049;
        }

        .back-btn {
            margin-left: 5px;
        }
    </style>

    </head>
    <body>
        <jsp:include page="header.jsp"></jsp:include>
            <form action="editcate" method="post">
                <label for="cateID">Choose category to update:</label>
                <select name="cateID" id="cateID">
                <c:forEach items="${listC}" var="c"> 
                    <option value="${c.getID()}">${c.getName()}</option>
                </c:forEach>
            </select>
            <h3 style="color: #f9f9f9">a</h3>
            <br>
            <input type="text" name="name" id="name" placeholder="Enter new Name">

            <div class="button-container">
                <input type="submit" value="OK">
                <a href="home" class="btn btn-primary">Back to Home</a>
            </div>
        </form>

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



    </body>
</html>
