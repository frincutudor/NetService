<%@ page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page import="org.springframework.web.servlet.tags.form.ErrorsTag "%>
<html>

<body>
     <h2>${headerMessage}</h2>
     
     <form:errors path="student1.*"/>
     
	
	<form action="/NetService/hello" method="post">
	<table>
	<tr>
	
	<td>Student name : </td>      <td><input type="text" name="studentName"></input></td>
	</tr>
	
	<tr>
	
	<td>Student hobby : </td>      <td><input type="text" name="studentHobby"></input></td>
	</tr>
	
	<tr>
	
	<td>Student Mobile : </td>      <td><input type="text" name="studentMobile"></input></td>
	</tr>
	
	<tr>
	
	<td>Student DOB : </td>      <td><input type="text" name="studentDOB"></input></td>
	</tr>
	
	<tr>
	
	<td>Student SKILLs set : </td>      <td>
										 <select name="stundetSkills" multiple>
										 <option value="Java Core">Java Core</option>
										 <option value="Spring Core">Spring Core</option>
										 <option value="Spring MVC">Spring MVC</option>
										 </select>
	
										</td>
	</tr>
	
    </table>
	<table>
	      <tr><td>Student's Adress</td></tr>
	
		<tr>
		  <td>country: <input type = "text" name="studentAdress.country"/></td>
		   <td>city: <input type = "text" name="studentAdress.city"/></td>
		    <td>street: <input type = "text" name="studentAdress.street"/></td>
		     <td>zipcode: <input type = "text" name="studentAdress.zipcode"/></td>
		     
		
		</tr>
	
	
	
	<tr>
	<td><input type="submit" value="Submit" /></td>
	</tr>
	</table>
	

	</form>
</body>


</html>