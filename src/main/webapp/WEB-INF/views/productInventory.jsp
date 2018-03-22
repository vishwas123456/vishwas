<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="template/Header.jsp"%>
<div  class="container-fluid">
<div class="table-responsive">          
  <table class="table">
  <h1>Product Inventory Page</h1>
    <thead>
  <tr>    <th>Pid</th>
<th>Product Name</th>
<th>Description</th>
<th>Images</th>
</tr>

    </thead>
    <tbody>
  <c:forEach items="${products}" var="products">
   <tr>
   <td>${products.pid}</td>
       <td>${products.productName}</td>
       <td>${products.description}</td>
       <td><img src="<c:url value="/resources/images/${products.pid}.png"/>" style="width:20%"></td>
     <td> <a href="<c:url value="product/editProduct/${products.pid}" />"> <span class="glyphicon glyphicon-pencil">edit</span></a></td>
      <td><a href="<c:url value="product/deleteProduct/${products.pid}" />"><span class="glyphicon glyphicon-remove"></span></a></td>
      </tr>
       </c:forEach> 
       
    </tbody>
  </table>
  </div>
     </div>
     <a href="<c:url value="product/addProduct"/>" class="btn btn-primary">Add Product</a>

<%@ include file="template/Footer.jsp"%>
