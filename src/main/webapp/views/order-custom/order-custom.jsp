<%@ page import="model.bean.*" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 5/27/2025
  Time: 4:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% Product product = (Product) request.getAttribute("productById");%>
<% Image mainImage = (Image) request.getAttribute("mainImage");%>
<% Category categoryByProduct = (Category) request.getAttribute("categoryByProduct");%>

<%
    User sessionUser = (User) request.getSession().getAttribute("auth");
%>
<html>
<head>
    <title>Custom</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css">
</head>
<style>
    .product-details {
        display: flex;
        justify-content: space-evenly;
        align-items: center;
        min-height: 400px;
    }

    .mainImage {
        max-width: 80%;
        max-height: 80%;
        object-fit: cover;
        cursor: zoom-in;
    }

    .navbar1 {
        padding: 24px;
    }

    .form-details {
        min-width: 500px;
    }

    .form-group {
        padding: 20px 0;
    }

    .form-group label {
        margin-bottom: 8px;
    }

    .form-group input#content {
        height: 200px;
    }

    .image_desc {
        font-size: 24px;
        font-weight: bold;
        padding-left: 32%;
        margin-top: 16px;
        margin-bottom: 32px;
    }

    .contact {
        margin-bottom: 32px;
    }

    .zalo-contact {
        padding: 16px;
        background-color: #0c63e4;
        color: #fff;
        cursor: pointer;
        width: 160px;
        margin-left: 16px;
        border-radius: 8px;
        font-size: 16px;
    }

    .zalo-contact:hover {
        background-color: #0d6efd;
    }
</style>
<body>
<%--Thanh điều hướng - header--%>
<%@include file="/views/MenuBar/menu.jsp" %>

<nav class="navbar1" aria-label="breadcrumb ">
    <div>
        <i class="fa-solid fa-backward p-2 fs-5" onclick="window.history.back()" style="cursor: pointer"></i>
    </div>
    <ol class="breadcrumb m-0 ">
        <li class="breadcrumb-item"><a
                href="<%=request.getContextPath()%>/views/MainPage/view_mainpage/mainpage.jsp">Trang Chủ</a></li>
        <li class="breadcrumb-item"><a
                href="productsPage?categoryFilter=<%=categoryByProduct.getId()%>"><%=categoryByProduct.getName()%>
        </a></li>
        <li class="breadcrumb-item active" aria-current="page" style="color: #e32124"><%=product.getName()%>
        </li>
    </ol>
</nav>

<section class="product-details">

    <div class="image_container">
        <img class="mainImage" src="<%=mainImage.getPath()%>">
        <p class="image_desc">Ảnh mẫu</p>
    </div>

    <div class="form-details">
        <form class="form-detail" action="/order-custom" method="post">
            <div class="form-group">
                <%
                    if (product.getCategoryId() == 1) {

                %>
                <label for="imagePath">Hình ảnh</label>
                <input type="file" class="form-control" id="imagePath">
                <%
                } else if (product.getCategoryId() == 2) {
                %>
                <label for="imagePath">Hình ảnh</label>
                <input type="file" multiple class="form-control" id="imagePath">
                <% } %>
            </div>
            <div class="form-group">
                <label for="content">Nội dung</label>
                <input type="text" class="form-control" id="content" placeholder="Yêu cầu thêm...">
            </div>
            <button type="submit" class="btn btn-primary">Đặt hàng</button>
        </form>
    </div>
</section>

<section class="contact">
    <div class="zalo-contact">
        Liên hệ qua Zalo
    </div>
</section>

<div class="modal">

</div>

<!--    Footer-->
<%@include file="/views/Footer/footer.jsp" %>
</body>
</html>
