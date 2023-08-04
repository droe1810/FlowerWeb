<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="description" content="Ogani Template">
        <meta name="keywords" content="Ogani, unica, creative, html">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <title>Ogani | Template</title>

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
    </head>

    <body>
        <jsp:include page="header.jsp"></jsp:include>

            <!-- Breadcrumb Section Begin -->
            <section class="breadcrumb-section set-bg" data-setbg="img/breadcrumb.jpg">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12 text-center">
                            <div class="breadcrumb__text">
                                <h2>Checkout</h2>
                                <div class="breadcrumb__option">
                                    <a href="./index.html">Home</a>
                                    <span>Checkout</span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </section>
            <!-- Breadcrumb Section End -->

            <!-- Checkout Section Begin -->
            <section class="checkout spad">
                <div class="container">
                    <div class="row">
                        <div class="col-lg-12">
                            <h6><span class="icon_tag_alt"></span> Have a coupon? <a href="#">Click here</a> to enter your code
                            </h6>
                        </div>
                    </div>
                    <div class="checkout__form">
                        <h4>Billing Details</h4>
                        <form action="buybycart" method="get">
                            <div class="row">
                                <div class="col-lg-8 col-md-6">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p> Name<span>*</span></p>
                                                <input type="text" name="name" value="${user.getName()}" required>
                                        </div>
                                    </div>
                                </div>
                                <div class="checkout__input">
                                    <p>Address<span>*</span></p>
                                    <input name="address" type="text" required placeholder="Street Address" class="checkout__input__add">
                                </div>
                                <div class="">
                                    <div class="row">
                                        <div class="col-lg-6">
                                            <div class="checkout__input">
                                                <p>Phone<span>*</span></p>
                                                <input type="number" name="phone" required>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-6 col-md-6">
                                    <div class="checkout__order" style="background-color: #f2f2f2; border: 1px solid #ccc; border-radius: 5px; padding: 20px; text-align: center;">
                                        <h4 class="checkout__order-title" style="font-size: 20px; margin-bottom: 10px;">Your Order</h4>
                                        <div class="checkout__order-products" style="font-weight: bold; margin-bottom: 10px;">Products <span>Total</span></div>
                                        <ul class="checkout__order-list" style="list-style-type: none; padding: 0;">
                                            <c:forEach items="${cart}" var="p">
                                                <li class="checkout__order-item" style="display: flex; justify-content: space-between; margin-bottom: 5px;">
                                                    <input type ="hidden" name="productID" value="${p.getID()}">
                                                    <input type="text" value="${p.getName()}" readonly class="checkout__order-item-name" style="flex: 1; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
                                                    <input type="text" name="quantity" value=" ${p.getQuantity()} x ${p.getPrice()}_VND" readonly class="checkout__order-item-price" style="flex: 0 0 80px; text-align: right;">
                                                </li>
                                            </c:forEach>
                                        </ul>
                                        <div class="checkout__order-total" style="font-weight: bold; margin-top: 10px;">Total <span>${total}_VND</span></div>
                                        <button type="submit" class="site-btn" style="background-color: #f44336; color: white; padding: 10px 20px; border: none; border-radius: 4px; cursor: pointer; margin-top: 10px;">PLACE ORDER</button>
                                    </div>
                                </div>
                            </div>
                    </form>
                </div>
            </div>
        </section>
        <!-- Checkout Section End -->

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
