<%@ include file="template/Header.jsp"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
    </head>
    <body>
        <h3>Welcome, Enter The Product Details</h3>
        <form:form method="post" action="${pageContext.request.contextPath}/admin/product/addProduct/submit" commandName="product" enctype="multipart/form-data">>
             <table>
                <tr>
                    <td>Name</td>
                    <td><form:input path="productName"/></td>
                </tr>
                 <tr>
                    <td>Description</td>
                    <td><form:input path="description"/></td>
                </tr>
                 <tr>
                    <td>Product Price</td>
                    <td><form:input path="productPrice"/></td>
                </tr>
                 <tr>
                    <td>Quantity</td>
                    <td><form:input path="productQuantity"/></td>
                </tr>
                 <tr>
                    <td>images</td>
                    <td><form:input path="images"/></td>
                    <td><form:input type="file" path="images" /></td>
                </tr>
                                                
                <tr>
                    <td><input type="submit" value="Submit"/></td>
                    <td><a href="<c:url value="/admin/productInventory"/>"class="btn btn-default">Cancel</a></td>
                    
                </tr>
            </table>
        </form:form>
    </body>
</html>
<%@ include file="template/Footer.jsp"%>