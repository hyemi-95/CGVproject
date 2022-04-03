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
 

    
    <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/gh/hiphop5782/js@0.0.13/cinema/hacademy-cinema.css">
    <style>
        *{
            box-sizing: border-box;
        }
        .float-box > div{
            float:left;
            width:50%;
        }
        .float-box::after{
            content:"";
            display: block;
            clear:both;
        }
        .float-box > .result {
            padding:0.5rem;
        }
    </style>
    <script src="https://cdn.jsdelivr.net/gh/hiphop5782/js@0.0.13/cinema/hacademy-cinema.js"></script>
    <script>
        window.addEventListener("load", function(){
            var cinema = new Hacademy.Reservation("#cinema");
            cinema.addChangeListener(function(seat){
                print(this);
            });
            print(cinema);
            function print(app){
                document.querySelector(".result").textContent = app.getQueryString();
            }
        });
    </script>


</head>
<body>


<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>


<%
	
	int no = Integer.parseInt(request.getParameter("no"));
	//	수량
	int qty = Integer.parseInt(request.getParameter("qty"));

	//이미지
	String img = request.getParameter("img");
	
	request.setCharacterEncoding("UTF-8");
	String id = (String)session.getAttribute("id");

	if(id==""||id==null){
		response.sendRedirect("CustomerLoginForm.cu");
		return;
	}

%> 


<center>

<form action="ReserveResult.cu" method="post">
<table width="1000">
	<tr height="100">
		<td align="center" colspan="5">
		<font size="6" color="gray">옵션 선택</font></td>
	</tr>
	<tr>
		<td rowspan="7" width="500">
		<img alt="" src="img/<%=img %>" width="500"></td>
		<td width="250" align="center">극장 선택</td>
		<td width="250" align="center"> <select name="theater">
											<option value="명동 CGV">명동 CGV </option>   
											<option value="강남 CGV">강남 CGV </option>
											<option value="강북 CGV">강북 CGV </option>
											<option value="용산 CGV">용산 CGV </option>
											<option value="여의도 CGV">여의도 CGV </option>
											<option value="서울대 CGV">서울대 CGV </option>
											<option value="압구정 CGV">압구정 CGV </option>
										</select></td>
		 
	</tr>
	<tr>
		<td width="250" align="center"> 상영 날짜 </td>
		<td width="250" align="center"> <input type="date" name="rday" size="15"> </td>
	</tr>
	<tr >
		<td width="500" align="center"> 좌석 선택 </td>
		<td width="1000" align="center">  
		
				<div class="float-box">
        <div>
        
            
                <div id="cinema" class="cinema-wrap" name="seat">
                    <div class="cinema-seat-area" data-rowsize="3" data-colsize="5" 
                    data-mode="client" data-fill="auto" data-seatno="visible"></div>
                </div>
        
                
           
       		 </div>

       
       		<div class="result">

       	</div>
    </div>
 	</td>

	</tr>
		<tr>
			<td width="250" align="center">인원수</td>
			<td width="250" align="center"> <select name="person">
											<option value="1">1명 </option>   
											<option value="2">2명 </option>
											<option value="3">3명 </option>
											<option value="4">4명 </option>
											<option value="5">5명 </option>
											<option value="6">6명 </option>
											<option value="7">7명 </option>
											<option value="8">8명 </option>
											<option value="9">9명 </option>
											
										</select></td>
	</tr>

	<tr>
	<td width="250" align="center" colspan="2">
	
	<input type="hidden" name="no" value="<%=no %>">
	<input type="hidden" name="qty" value="<%=qty %>">
	
	
	<button type="submit" onclick="location.href='' " 
	class="btn btn-danger">영화 예매하기</button>
	
	
	
	</td>
</tr>

</table>

</form>

</center>

<script type="text/javascript" src="/resource/js/bootstrap.js"></script>


</body>
</html>