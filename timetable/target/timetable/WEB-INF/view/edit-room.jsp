<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action='/update' method='post'>
		<input type="text" name="name"  value="${room.name}"  > 
		<input type="text"name="type" value="${room.type}"> 
		

 			<input type='hidden' id='id'  name='id' value="${room.id}"/>
		<input type="submit" value="Update">


	</form>
</body>
</html>