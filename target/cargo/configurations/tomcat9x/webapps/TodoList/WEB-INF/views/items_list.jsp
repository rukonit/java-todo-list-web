<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.rukon.util.Mappings" %>
<%@ page language="java" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <title>Todo Items</title>

     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</head>
<body>

    <div container-fluid align="center">
    <c:url var="addUrl" value="${Mappings.ADD_ITEM}"/>
    <a href="${addUrl}">New Item</a>
        <table  class="table table-bordered table-dark">

            <caption><h2>Todo Items</h2></caption>

            <tr>
                <th>Title</th>
                <th>Details</th>
                <th>Deadline</th>
                 <th>View</th>
                <th>Edit</th>
                <th>Delete</>
            </tr>

            <c:forEach var="item" items="${todoData.items}">
            	<c:url var="view_item" value="${Mappings.VIEW_ITEM}">
            		<c:param name="id" value="${item.id}"/>
            	</c:url>
            	<c:url var="editUrl" value="${Mappings.ADD_ITEM}">
            		<c:param name="id" value="${item.id}"/>
        		</c:url>
        		<c:url var="deleteUrl" value="${Mappings.DELETE_ITEM}">
            		<c:param name="id" value="${item.id}"/>
        		</c:url>

                <tr>
                    <td><c:out value="${item.title}"/></td>
                    <td><c:out value="${item.details}"/></td>
                    <td><c:out value="${item.deadline}"/></td>
                    <td><a href="${view_item}">View</a></td>
                    <td><a href="${editUrl}">Edit</a></td>
                    <td><a href="${deleteUrl}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>

</body>
</html>