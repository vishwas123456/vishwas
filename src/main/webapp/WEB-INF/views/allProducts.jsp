<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ include file="template/Header.jsp"%>
<div  class="container-fluid">
<div class="table-responsive">          
  <table class="table">
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
       
       <td><img src="<c:url value="/resources/images/${products.pid}.png"/>" class="img-thumnail" width="30"/></td>
       <td><a href="<c:url value="/viewProduct/${products.pid}" />">view more<span class="glyphicon glyphicon-info-sign"></span></a></td>
       
      
       </c:forEach> 
       
    </tbody>
  </table>
  </div>
     </div>

<%@ include file="template/Footer.jsp"%>
