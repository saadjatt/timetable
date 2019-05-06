<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="/assets/js/jquery.min.js"></script>

<script>

$(document).ready(function(){
	
	
	show();
	
	function show (){
			$.ajax({
				
				url:'/day',
				type:'post',
			
				success:function(msg){
					
					alert(msg);
					
				var table ="<table border=1>";
				
				table+="<tr>";
				table+="<th><b>Day Name</b></th>";
				
				
				table+="<th><b>Delete</b></th>";
				table+="<th><b>Update</b></th>";

				table+="</tr>";
	
					for(x in msg){
						table+="<tr>";
						table+="<td>";
						table+=msg[x].name;
					//alert(msg[x].name);
						table+="</td>";
						table+="<td>";
						table+=msg[x].id;
					//alert(msg[x].name);
						table+="</td>";
						table+="<td>";
						table+=msg[x].id;
					//alert(msg[x].name);
						table+="</td>";
						table+="</tr>";
						}
					table+="</table>";
					
					$('#data').html(table);	
				}
			
			
			
				
			});
		
	}
		
	$('#save').click(function(){
		var name=$('#name').val();
		$.ajax({
			
			url:'/save-day',
			type:'post',
			data:'name='+name,
			success:function(msg){
				//alert(msg);
				show();
			}
			
		});
		
	});
	
	
	
});

</script>
</head>
<body>
	<h1>Welcome spring jspsss</h1>
	
	<form action="/save-day" method="post">
		<input type="text" name="name" id="name"> 
		<input type="button" value="Save" id="save">

	</form>


	<div id="data"></div>

	<table border="1px">



		<thead>
			<tr>
				<th><b>Day Name</b></th>
				
				<th><b>Delete</b></th>
				<th><b>Update</b></th>

			</tr>
		</thead>
		<tbody >
		
		<!-- 
			<c:forEach items="${dayList}" var="day">
				<tr>
					<td><c:out value="${day.name}"></c:out></td>
				
					<td><a href="/${day.id}/delete-room">
							<button type="submit" class="btn btn-primary">Delete
								User</button>
					</a></td>
					 <td>
             <a href="/${day.id}/editRoom">
                <button type="submit" class="btn btn-primary">Edit User</button>
                </a>
            </td>
				</tr>

			</c:forEach>
			 -->
		</tbody>
	</table>
</body>
</html>