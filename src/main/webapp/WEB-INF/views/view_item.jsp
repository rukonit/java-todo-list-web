<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.rukon.util.Mappings" %>

<html>
<head>
    <title>Todo Items</title>
</head>
<body>
    <div align="center">
    <c:url var="addUrl" value="${Mappings.ADD_ITEM}"/>

      <table>
        <tr>
                <td><label>Title</label></td>
                    <td><c:out value="${todoItem.title}"/></td>
        </tr>        
        <tr>
                <td><label>Details</label></td>
                    <td><c:out value="${todoItem.details}"/></td>
        </tr>
        <tr>    
                <td><label>Deadline</label></td>
                    <td><c:out value="${todoItem.deadline}"/></td>
        </tr>
    </table>
        <c:url var="item_list" value="${Mappings.ITEMS}"/>
        <a href="${item_list}">View All Items</a>
    </div>

</body>
</html>