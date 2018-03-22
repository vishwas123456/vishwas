<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ include file="template/Header.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container-wrapper">
<div class="container">
<div class="page-header">
</div>
</div>
</div>
<div class="container" ng-app="cartApp">
<div class="row">
<div class="col-md-5">
<img src="<c:url value="/resources/images/${product.pid}.png"/>" alt="images" style="width:20%;">
</div>
<div class ="col-md-5">
<h4> ${product.productName}</h4>
 <h4><strong>Price</strong>: ${product.productPrice}</h4>                     
<h4><strong>Quantity</strong>: ${product.productQuantity}</h4>
<p>${product.description }</p>
<br>
<c:set var = "role" scope="page" value="${param.role}" />
                    <c:set var = "url" scope="page" value="/product/productList" />
                    <c:if test="${role='admin'}">
                        <c:set var="url" scope="page" value="/admin/productInventory" />
                    </c:if>

                    <p ng-controller="cartCtrl">
                        <a href="<c:url value = "${url}" />" class="btn btn-default">Back</a>
                     <a href="#" class="btn btn-warning btn-large" ng-click="addToCart('${pid}')"><span class="glyphicon glyphicon-shopping-cart"></span> Order Now</a>
                     <a href="<spring:url value="/customer/cart" />" class="btn btn-default"><span class="glyphicon glyphicon-hand-right"></span> View Cart</a>
                    <a href="<spring:url value="/allproducts" />" class="btn btn-default">Continue Shopping</a>
                    </p>

</div>

<script src="<c:url value="/resources/js/controller.js" /> "></script>