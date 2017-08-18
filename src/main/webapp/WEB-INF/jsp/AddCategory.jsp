<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>

<html>
<body>
	<center>
		<h2>Device in Store</h2>
		<br> <a href="<c:url value="/Device" />"><i
			class="material-icons">home</i></a>


		<form action="/NetService/AddCatImpl" method="post" name="devCategory">
			<br> <br> <label>Add the category : </label> <input
				type="text" name="categoryName"></input> <br> <br> <label>Add
				subcategory :</label> <input type="text" name="subCategoryName"></input> <br>
			<br> <input type="submit" value="Submit">


		</form>


	</center>


</body>
</html>