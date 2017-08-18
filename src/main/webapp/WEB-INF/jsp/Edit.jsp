<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
</head>
<body>
	<center>
		<h2>Device in Store</h2>

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
					<c:choose>
						<c:when test="${deviceValue.getId() == id}">
							<form action="/NetService/View" method="get">
								<tr>
									<td>${deviceValue.getName()}</td>

									<td><input type="text"
										placeholder="${deviceValue.getPrice()}" name="price"></td>

									<td><input type="text"
										placeholder="${deviceValue.getQuantity()}" name="quantity"></td>
									<input type="hidden" name="id" value="${deviceValue.getId()}">


									<td><center>
											<!-- 											<input type="submit"><i class="material-icons" style="font-size:24px;color:green">check_circle</i></input> -->
											<!-- 											<a href="/NetService/View?"><i class="material-icons" style="font-size:24px;color:green">check_circle</i></a> -->
											<button type="submit">
												Submit
												<!-- 												<i class="material-icons" style="font-size:24px;color:green">check_circle</i> -->
											</button>

										</center></td>
									<td><a href="<c:url value="/Device" />"><i
											class="material-icons" style="font-size: 24px; color: red">highlight_off</i></td>

								</tr>
							</form>

						</c:when>
						<c:otherwise>
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
								<!-- 								<td><a -->
								<%-- 									href="<c:url value="/Delete?id=${deviceValue.getId()}" />"><i --%>
								<!-- 										class="material-icons">delete</i></a></td> -->
								<td><a
									href="<c:url value="/Edit?id=${deviceValue.getId()}" />"><i
										class="material-icons">settings</i></a></td>
							</tr>
							<br />
						</c:otherwise>
					</c:choose>




				</c:forEach>


			</c:if>
			<c:if test="${empty device}">

				<p>No such device</p>



			</c:if>

		</table>



	</center>
</body>
</html>