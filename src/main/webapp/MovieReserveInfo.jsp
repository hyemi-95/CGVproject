<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
     <%@page import="net.movie.db.movieListBean" %>
     <%@page import="java.util.Vector" %>
      <%@page import="net.movie.db.movieDAO" %>
      <%@page import="java.util.ArrayList" %>
      <%@page import="java.util.List" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
 


</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>




<%
movieListBean bean = (movieListBean)request.getAttribute("bean");

String category = bean.getCategory();
String temp="";

if(category.equals("action"))temp="액션";
else if(category.equals("horror"))temp="호러";
else if(category.equals("animation"))temp="애니메이션";
else if(category.equals("thriller"))temp="스릴러";

%>
<%-- <%
		int no = Integer.parseInt(request.getParameter("no"));
	
	//데이터베이스에 접근
	movieDAO mdao = new movieDAO();
	//영화 하나에 대한 정보를 얻어옴
	movieListBean bean = mdao.getOneMovie(no);
	
	
	
	String category = bean.getCategory();
	String temp="";

	if(category.equals("action"))temp="액션";
	else if(category.equals("horror"))temp="호러";
	else if(category.equals("animation"))temp="애니메이션";
	else if(category.equals("thriller"))temp="스릴러";

	%>  --%>
<center>
<form action="OptionSelect.cu">

<table width="1000">
	<tr height="100">
	<td align="center" colspan="5">
	<font size="6" color="gray">현재 상영작</font></td>
	</tr>
	<tr>
	<td rowspan="6" width="500">
	<img alt="" src="img/<%=bean.getImg() %>" width="500"></td>
	<td width="250" align="center"> 영화 제목 </td>
	<td width="250" align="center"> <%=bean.getName() %> </td>
	</tr>
	<tr>
	<td width="250" align="center"> 영화 티켓 수량 </td>
	<td width="250" align="center"> <select name="qty">
										<option value="1">1</option>
										<option value="2">2</option>
										<option value="3">3</option>
										</select> </td>
	</tr>
	<tr>
		<td width="250" align="center"> 영화 분류 </td>
		<td width="250" align="center"> <%=temp %>  </td>
	</tr>
	<tr>
		<td width="250" align="center"> 영화 티켓 가격 </td>
		<td width="250" align="center"> <%=bean.getPrice() %>원 </td>
	</tr>
	<tr>
		<td width="250" align="center"> 영화 감독 </td>
		<td width="250" align="center"> <%=bean.getDirector() %> </td>
	</tr>
	<tr>
		<td align="center" colspan="2">
		<input type = "hidden" name="no" value="<%=bean.getNo() %>">
		<input type = "hidden" name="img" value="<%=bean.getImg() %>">
		<input type="submit" class="btn btn-danger" value="예매하러가기">
		</td>
	</tr>

</table>
	<br><br><br>
	<font size="5" color="gray">영화 정보 보기</font>
	<p>
	<%=bean.getInfo() %>


</form>


</center>



<script type="text/javascript" src="/resource/js/bootstrap.js"></script>


</body>
</html>