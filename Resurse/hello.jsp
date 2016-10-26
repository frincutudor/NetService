<%@ page contentType="text/html; charset=UTF-8"%>
<html>
<head>

</head>
<body>

  <h2>${headerMessage}</h2>

	<table>
		<tr>
			<td>Student name:</td>
			<td>${student1.studentName}</td>
		</tr>


		<tr>
			<td>Student hobby:</td>
			<td>${student1.studentHobby}</td>
		</tr>
		
		<tr>
			<td>Student Mobile:</td>
			<td>${student1.studentMobile}</td>
		</tr>
		
		<tr>
			<td>Student DOB:</td>
			<td>${student1.studentDOB}</td>
		</tr>
		
		<tr>
			<td>Student Skills:</td>
			<td>${student1.studentSkills}</td>
		</tr>
		
		<tr>
			<td>Student Adress:</td>
			<td>country: ${student1.studentAdress.country}
				city: ${student1.studentAdress.city}
				street: ${student1.studentAdress.street}
				zipcode: ${student1.studentAdress.zipcode}				
			</td>
		</tr>
		
		

	</table>




</body>


</html>