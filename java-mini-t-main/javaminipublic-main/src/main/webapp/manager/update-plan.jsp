<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	Updating user
	<form method="post"
		action="<%=request.getContextPath()%>/ManagerServlet/updateplan">
		Start PlanId:<input type="number" name="planId" readonly="readonly" value="${plans.planId}"> <br>
		Start SportId:<input type="number" name="sportId" value="${plans.sportId}" > <br>
		End  PlanName:<input type="text" name="planName"  value="${plans.planName}"> <br>
		Batch Fees:<input type="number" name="fees" value="${plans.fees}"> <br>
		Sport Duration:<input type="number" name="duration" value="${plans.duration}"> <br>
		
	 <input	type="submit" value="Update Plan">
	</form>
</body>
</html>