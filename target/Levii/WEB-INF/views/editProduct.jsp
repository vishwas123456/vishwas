

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Edit The Product Details</h3>
        <form:form method="post" action="${pageContext.request.contextPath}/admin/products/editProduct/submit" commandName="product">
             <form:hidden path="pid" value="${products.pid}"/>
             <table>
                <tr>
                    <td>Name</td>
                    <td><form:input path="productName" value="${products.productName }"/></td>
                </tr>
                 <tr>
                    <td>Description</td>
                    <td><form:input path="description" value="${products.description }"/></td>
                </tr>
                 <tr>
                    <td>Product Price</td>
                    <td><form:input path="productPrice" value="${products.productPrice }"/></td>
                </tr>
                 <tr>
                    <td>Quantity</td>
                    <td><form:input path="productQuantity"  value="${products.productQuantity }"/></td>
                </tr>
                 <tr>
                    <td>Condition</td>
                    <td><form:input path="productondition"  value="${products.productondition }"/></td>
                </tr>
                               
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                    <a href="<c:url value="/admin/productInventory" />" class="btn btn-default">Cancel</a>
                </tr>
            </table>
        </form:form>
    </body>
</html>
<%@ include file="template/Footer.jsp"%>