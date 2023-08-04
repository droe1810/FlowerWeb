<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!-- Page Preloder -->
<div id="preloder">
    <div class="loader"></div>
</div>


<!-- Header Section Begin -->
<header class="header">
    <div class="header__top">
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__left">
                        <ul>
                            <li><i class="fa fa-envelope"></i> abc123@fpt.edu.vn</li>
                        </ul>
                    </div>
                </div>
                <div class="col-lg-6 col-md-6">
                    <div class="header__top__right">
                        <div class="header__top__right__social">
                            <a href="#"><i class="fa fa-facebook"></i></a>
                            <a href="#"><i class="fa fa-twitter"></i></a>
                            <a href="#"><i class="fa fa-linkedin"></i></a>
                            <a href="#"><i class="fa fa-pinterest-p"></i></a>
                        </div>
                        <div class="header__top__right__language">
                            <img src="img/language.png" alt="">
                            <div>English</div>
                            <span class="arrow_carrot-down"></span>
                            <ul>
                                <li><a href="#">Vietnamese</a></li>
                                <li><a href="#">English</a></li>
                            </ul>
                        </div>
                        <c:if test="${sessionScope.user == null}">
                            <div class="header__top__right__auth">
                                <a href="login.jsp"><i class="fa fa-user"></i> Login</a>
                            </div>
                        </c:if>

                        <c:if test="${sessionScope.user != null}">
                            <div class="header__top__right__auth">
                                <a href="logout"><i class="fa fa-user"></i> Logout</a>
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="header__logo">
                    <a href="home"><img src="img/logo.png" alt=""></a>
                </div>
            </div>
            <div class="col-lg-6">
                <nav class="header__menu">
                    <ul>
                        <li class="active"><a href="home">Home</a></li>
                            <c:if test="${sessionScope.user.getRole() ==  2 || sessionScope.user.getRole() ==  1}">

                            <li><a href="vieworder">View Order</a>
                            </c:if>
                                
                            <c:if test="${sessionScope.user.getRole() ==  3 }">

                            <li><a href="myorder">My Order</a>
                            </c:if>

                            <c:if test="${sessionScope.user.getRole() ==  1}">

                            <li>
                                <a href="#">Manager Products</a>
                                <ul class="header__menu__dropdown">
                                    <li><a href="listproduct">Manager Products</a></li>
                                    <li class="dropdown" onmouseover="showSubMenu()" onmouseout="hideSubMenu()">
                                        <a href="#">Manager Cate</a>
                                        <ul class="submenu" id="submenu">
                                            <li><a href="add_cate.jsp">Add Category</a></li>
                                            <li><a href="editcate">Edit Category</a></li>
                                            <li><a href="deletecate">Delele Category</a></li>
                                        </ul>
                                    </li>
                                </ul>
                            </li>


                        </c:if>

                    </ul>
                </nav>
            </div>
            <c:if test="${sessionScope.user.getRole() == 3 || sessionScope.user.getRole() == null}">
                <div class="col-lg-3">
                    <div class="header__cart">
                        <ul>
                            <c:if test="${sessionScope.user.getRole() == 3}" >
                                <li><a href="cart.jsp"><i class="fa fa-shopping-bag"></i> <span>${num}</span></a></li>
                                </c:if>

                            <c:if test="${sessionScope.user.getRole() == null}" >
                                <li><a href="login.jsp"><i class="fa fa-shopping-bag"></i> <span>${num}</span></a></li>
                                </c:if>

                        </ul>
                    </div>
                </div>
            </c:if>

        </div>
        <div class="humberger__open">
            <i class="fa fa-bars"></i>
        </div>
    </div>
    <script>
        function showSubMenu() {
            var submenu = document.getElementById('submenu');
            submenu.style.display = "block";
        }

        function hideSubMenu() {
            var submenu = document.getElementById('submenu');
            submenu.style.display = "none";
        }

    </script>
</header>

<!-- Header Section End -->
