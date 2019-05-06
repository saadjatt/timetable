<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome spring jsp</h1>
	<form action="/save-room" method="post">
		<input type="text" name="name"> <input type="text"
			name="type"> <input type="submit" value="Save">

	</form>

	<table border="1px">

		<thead>
			<tr>
				<th><b>Room Title</b></th>
				<th><b>Room Type</b></th>
				<th><b>Delete</b></th>
				<th><b>Update</b></th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${roomList}" var="room">
				<tr>
					<td><c:out value="${room.name}"></c:out></td>
					<td><c:out value="${room.type}"></c:out></td>
					<td><a href="/${room.id}/delete-room">
							<button type="submit" class="btn btn-primary">Delete
								User</button>
					</a></td>
					 <td>
             <a href="/${room.id}/editRoom">
                <button type="submit" class="btn btn-primary">Edit User</button>
                </a>
            </td>
				</tr>

			</c:forEach>
		</tbody>
	</table>
</body>
</html>