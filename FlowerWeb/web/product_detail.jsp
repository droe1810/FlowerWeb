<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detail Page</title>
        <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
        <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <link href="css/style.css" rel="stylesheet" type="text/css"/>
        <link rel="stylesheet" href="https://fonts.googleapis.com/css2?family=Roboto:wght@100;200;300;400;500;700;900&display=swap">
        <link rel="stylesheet" href="assets/css/fontawesome.min.css">
        <style>
            .container {
                margin-top: 20px;
            }
            .card-body {
                font-family: 'Roboto', sans-serif;
            }
            .title {
                font-weight: 700;
                margin-bottom: 20px;
            }
            .item-property p {
                margin-bottom: 10px;
            }
            .btn-back {
                margin-bottom: 20px;
            }
            .col-sm-5.border-right {
                padding-right: 20px;
            }
            .img-big-wrap {
                text-align: center;
            }
            .img-big-wrap img {
                max-width: 100%;
                max-height: 300px;
            }
            .col-sm-7 {
                padding-left: 20px;
            }
        </style>
    </head>

    <body>
        <div class="container">
            <div class="row">
                <div class="col-sm-9">
                    <div class="container">
                        <div class="card">
                            <div class="row">
                                <aside class="col-sm-5 border-right">
                                    <article class="gallery-wrap"> 
                                        <div class="img-big-wrap">
                                            <div> <a href="#"><img src="${p.getImage()}"></a></div>
                                        </div>
                                    </article>
                                </aside>
                                <aside class="col-sm-7">
                                    <article class="card-body p-5">
                                        <h3 class="title mb-3">${p.getName()}</h3>
                                        <dl class="item-property">                                          
                                            <dd><p>${p.getDescription()}</p></dd>
                                            <dd><p>${p.getPrice()}_VND</p></dd>
                                            <dd>
                                                <a href="javascript:history.back()" class="btn btn-primary">Back</a>
                                                <c:if test="${sessionScope.user.getRole() == 3}" >
                                                    <a href="home" class="btn btn-success">Buy</a>
                                                </c:if>

                                                <c:if test="${sessionScope.user.getRole() == null}" >
                                                    <a href="login.jsp" class="btn btn-success">Buy</a>
                                                </c:if>

                                                <c:if test="${sessionScope.user.getRole() == 3}" >
                                                    <a href="cart.jsp"><i class="btn btn-danger"></i> </a>
                                                </c:if>

                                                <c:if test="${sessionScope.user.getRole() == null}" >
                                                    <a href="login.jsp"><i class="btn btn-danger">Cart</i></a>
                                                </c:if>
                                            </dd>
                                        </dl>

                                    </article>
                                </aside>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- Start Script -->
        <script src="assets/js/jquery-1.11.0.min.js"></script>
        <script src="assets/js/jquery-migrate-1.2.1.min.js"></script>
        <script src="assets/js/bootstrap.bundle.min.js"></script>
        <script src="assets/js/templatemo.js"></script>
        <script src="assets/js/custom.js"></script>
        <!-- End Script -->
    </body>
</html>
