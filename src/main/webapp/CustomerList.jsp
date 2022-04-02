<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>



<center>

<h2> 모든 고객 보기</h2>

<table width="800" border="1" bordercolor="gray"> 
<tr height="40">
	<td align="center" width="50"> 아이디 </td>
	<td align="center" width="200"> 이름 </td>
	<td align="center" width="150"> 이메일 </td>
	<td align="center" width="150"> 폰번호 </td>
	</tr>

	<c:forEach var="cbean" items="${list}">
	<tr height="40">
		
		<td align="center" width="50"> ${cbean.id} </td>
		<td align="center" width="200"> ${cbean.name} </td>
		<td align="center" width="150"> ${cbean.email} </td>
		<td align="center" width="150"> ${cbean.phone} </td>
	</tr>
</c:forEach>

</table>


</center>





</body>
</html>