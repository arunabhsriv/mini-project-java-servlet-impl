<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Adding new Plan
	<form method="post"
		action="<%=request.getContextPath()%>/ManagerServlet/addplan">
		Sport Id : <input type="number" name="sportId"> <br>
		Plan Name: <input type="text" name="planName"> <br>
		Fees :     <input type="number" name="fees"> <br>
		Duration :  <input type="number" name="duration"> <br>
		
		 <input type="submit" value="Add Plan">
	</form>
</body>
</html>