<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 
<%

request.setCharacterEncoding("UTF-8");

%>


<jsp:useBean id="rbean" class="net.movie.db.ReserveBean">
	<jsp:setProperty name="rbean" property="*" />
</jsp:useBean>



<%

	String id = (String)session.getAttribute("id");

if(id==null){

%>
<script>
	alert("로그인 후 예매가 가능합니다.");
	location.href='CustomerLoginForm.cu';


</script>
<%
}

	//날짜 비교
	Date d1 = new Date();
	Date d2 = new Date();
	
	//날짜를 2016-5-5  포맷 해주는 클래스 선언
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	d1 = sdf.parse(rbean.getRday());
	d2 = sdf.parse(sdf.format(d2));
	//날짜 비교 메소드를 사용
	
	int compare = d1.compareTo(d2);
	// 예매하려는 날짜보다 현재날짜가 크다면 -1
	// 예약하려는 날짜와 현재날짜가 같다면 0
	// 예약하려는 날짜가 더 크다면 1을 리턴
	System.out.println(compare);
	
	

%> --%>

</body>
</html>