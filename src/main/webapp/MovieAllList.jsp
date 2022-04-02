<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
      <%@ page import = "net.movie.db.movieDAO" %>
     <%@page import="net.movie.db.movieListBean" %>
     <%@page import="java.util.Vector" %>
   
      <%@page import="java.util.ArrayList" %>
      <%@page import="java.util.List" %>
    
    
    
<!DOCTYPE html>
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
 

<meta charset="UTF-8">

</head>
<body>
<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>



<center>


<table width="1000">
<tr height="100">
<td align="center" colspan="5">
<font size="8px" color="gray">전체 영화 보기</font></td>
</tr>


<%


	
	movieDAO mdao = new movieDAO();
	List<movieListBean> list = mdao.getAllMovie();
	//tr 을 3개씩 보여주고 다시 tr을 실행할 수 있도록 하는 변수 선언
	int j=0;
	for(int i = 0; i<list.size(); i++){
		
		//리스트에 저장되어있는 빈클래스 추출
		movieListBean bean = list.get(i);
		if(j%3==0){
			
			%>
<tr height="500">

	<% } %>
		<td width="333" align="center">
		<a href="main.jsp?center=MovieReserveInfo.jsp?no=<%=bean.getNo()%>">
		<img alt="" src="img/<%=bean.getImg()%>" width="300" height="500">
		</a><p>
		<font size="3" color="gray"> <b> 영화 제목 : <%=bean.getName() %></b></font>
		
		<br>
		<button type="button" onclick="location.href='' " class="btn btn-danger">예매하러가기</button>
		
		</td>
<%
		
		j=j+1; //j값을 증가하여 하나의 행에 총3개의 차량정보를 보여주기 위해서 증가
	}
		
		
%>
		
	
		





</table>
</center>




<script type="text/javascript" src="/resource/js/bootstrap.js"></script>

</body>
</html>