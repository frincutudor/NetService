<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>

<html>
<body>
	<center>
		<h2>Device in Store</h2>
		<br>
		<form action="/NetService/Search" method="get">

			<input type="text" name="fname"></input><br>

			<button type="submit">
				<i class="material-icons">search</i>
			</button>

		</form>
		<form action="/NetService/Category" method="get">
			<p align="center">
				<select name="category">

					<c:if test="${not empty category}">
						<c:forEach var="categoryValue" items="${category}">
							<option value="${categoryValue.getIdCategory()}">${categoryValue.getCategoryName()}</option>
						</c:forEach>
					</c:if>

				</select>
				<button type="submit">Submit</button>

			</p>
		</form>
		</form>
		<form action="/NetService/AddCategory" method="get">
			<p align="center">
				<input type="submit" value="Add category"></input>
			</p>
		</form>
		<a href="<c:url value="/Device" />"><i class="material-icons">home</i></a>
		<table border="1" width="700">
			<tr>
				<td><b>Device name</b></td>
				<td><b>Price</b></td>
				<td><b>Quantity</b></td>
				<td><b>Actions</b></td>
				<td><a href="<c:url value="/ViewAdd" />"><i
						class="material-icons" style="font-size: 24px; color: green">add_box</i></a></td>
			</tr>

			<c:if test="${not empty device}">


				<c:forEach var="deviceValue" items="${device}">
					<tr>

						<td>${deviceValue.getName()}</td>
						<td>${deviceValue.getPrice()}</td>
						<td>${deviceValue.getQuantity()}</td>
						<td><form
								action="/NetService/Delete?id=${deviceValue.getId()}"
								method="post">
								<button type="submit">
									<i class="material-icons">delete</i>
								</button>
							</form></td>
						<%-- 						<td><a href="<c:url value="/Delete?id=${deviceValue.getId()}" />"><i class="material-icons">delete</i></a></td> --%>
						<td><a
							href="<c:url value="/Edit?id=${deviceValue.getId()}" />"><i
								class="material-icons">settings</i></a></td>
					</tr>
				</c:forEach>


			</c:if>
		</table>
		<form action="/NetService/Add" method="get" name="device1">

			<input type="text" placeholder="Add name" name="name"> <input
				type="text" placeholder="Add alias" name="alias"> <select
				name="selected">

				<c:if test="${not empty category}">
					<c:forEach var="categoryValue" items="${category}">
						<option value="${categoryValue.getCategoryName()}">${categoryValue.getCategoryName()}</option>

					</c:forEach>

				</c:if>

			</select> <input type="text" placeholder="Add price" name="price"> <input
				type="text" placeholder="Add quantity" name="quantity"> <input
				type="submit" value="Add new device">
		</form>

		<%-- 		<form:form method="get" name="device1" --%>
		<%-- 			action="/NetService/Add"> --%>
		<!-- 			<tr> -->
		<%-- 			<td><form:input path="name" type="text" placeholder="Add name" /></td> --%>
		<%-- 			<td><form:input path="alias" type="text" placeholder="Add alias" /></td> --%>
		<%-- 			<td><form:input path="price" type="text" placeholder="Add price" /></td> --%>
		<%-- 			<form:errors path="price" /> --%>
		<%-- 			<td><form:input path="quantity" type="text" placeholder="Add quantity" /></td>	 --%>
		<%-- 			<form:errors path="quantity" /> --%>
		<!-- 			</tr> -->
		<!-- 			</table> -->
		<!-- 			<input type="submit" value="Add new device"> -->
		<%-- 		</form:form> --%>

	</center>
</body>
</html>