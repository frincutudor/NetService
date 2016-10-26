<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">


<html>

<body>
  <center>
   <h1>Device in Network:</h1>
  <br>
  <br>
    
   <table border="2">
   
   <c:if test="${not empty device}">
           <c:set var="i" value="1"/>
		
			<c:forEach var="deviceValue" items="${device}">
				<tr>
				<td>Device number ${i} :</td>
				<td>${deviceValue}</td>
				</tr>
				
				<c:set var="i" value="${i + 1}" />
			</c:forEach>
		

	</c:if>
	
	</table>
	</center>
</body>

</html>