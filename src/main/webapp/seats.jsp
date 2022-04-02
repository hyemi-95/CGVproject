<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>









</head>








<body>



<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>악세사리</h3>
	관심항목을 선택하세요.
	<hr>
	<form method="get" action="CheckboxServlet">
		<input type="checkbox" name="item" value="신발">신발
		<input type="checkbox" name="item" value="가방">가방
		<input type="checkbox" name="item" value="벨트">벨트
		<input type="checkbox" name="item" value="모자">모자
		<input type="checkbox" name="item" value="시계">시계
		<input type="checkbox" name="item" value="주얼리">주얼리
		<br><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>








<div class="plane">
        <div class="cockpit">
            <h1>Please select a seat</h1>
        </div>
      
        <form action="chk" method="post">
          
            <ol class="cabin fuselage">
                <li class="row row--1">
                    <ol class="seats">
                        <li class="seat">
                            <input type="checkbox" name="answer[]" id="1" value="1"  />
                            <label for="1">1</label>
                        </li>
                        <li class="seat">
                            <input type="checkbox" name="answer[]" id="2" value="2" />
                            <label for="2">2</label>
                        </li>
                        <li class="seat">
                            <input type="checkbox" name="answer[]" id="3" value="3" />
                            <label for="3">3</label>
                        </li>
                    </ol>
                </li>
                <li class="row row--2">
                    <ol class="seats">
                        <li class="seat">
                            <input type="checkbox" name="answer[]" id="4" value="4" />
                            <label for="4">4</label>
                        </li>
                        <li class="seat">
                            <input type="checkbox" name="answer[]" id="5" value="5" />
                            <label for="5">5</label>
                        </li>
                        <li class="seat">
                            <input type="checkbox" name="answer[]" id="6" value="6" />
                            <label for="6">6</label>
                        </li>
                    </ol>
                </li>
                <li class="row row--3">
                    <ol class="seats">
                        <li class="seat">
                            <input type="checkbox" name="answer[]" id="7" value="7" />
                            <label for="7">7</label>
                        </li>
                        <li class="seat">
                            <input type="checkbox" name="answer[]" id="8" value="8" />
                            <label for="8">8</label>
                        </li>
                        <li class="seat">
                            <input type="checkbox" name="answer[]" id="9" value="9" />
                            <label for="9">9</label>
                        </li>
                    </ol>
                </li>


            </ol>
            <button type="submit" value="submit">예매하기</button>
        </form>
       
    </div>
    










</body>
</html>