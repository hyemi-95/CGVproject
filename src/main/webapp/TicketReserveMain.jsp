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


 <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">



</head>
<body>





<!--  데이트 베이스에 연결하여 최신순 영화 3개만 뿌려주는 데이터를 가져옴 -->



<%

	movieDAO mdao = new movieDAO();
	// LIST를 이용하여 movie 를 저장
	List<movieListBean> list = mdao.getSelectmovie();

%>


<table width="1000">

<tr height="100">
<td align="center" colspan="5">
<font size="100px" color="gray"><h1>최신작 영화</h1></font></td>
</tr>


<tr height="500">
<%
	for(int i=0; i < list.size(); i++){
		movieListBean bean = list.get(i);
		
%>

<td width="333" align="center">
<a href ="main.jsp?center=MovieReserveInfo.jsp?no=<%=bean.getNo()%>">
<img alt="" src="img/<%=bean.getImg() %>" width = "300" height="500">
</a><p><br>
<font size="30px"><%=bean.getName()%></font>
<br><br>
<button onclick="location.href='#'" type="button" class="btn btn-danger">예매하기</button>
</td>

<%
    }
%>

</tr>
</table>





<hr color="red" size="3">


<br><br><br><br>
<p>


<form action="main.jsp?center=MovieCategoryList.jsp" method="post">
<font size="4" color="gray">영화 검색 하기</font>&nbsp;&nbsp;
<select name="category">
<option value="horror">horror</option>
<option vlaue="animation">animation</option>
<option vlaue="action">action</option>
<option vlaue="action">thriller</option>
</select>&nbsp;&nbsp;
<input type="submit" value="검색">&nbsp;&nbsp;

</form>




<button onclick="location.href='main.jsp?center=MovieAllList.jsp'"> 전체 검색</button>




  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous" style="width:50%"></script>

</body>
</html>