<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, tr, td{
border:solid 1px black;
}
</style>
</head>
<body>
<%
request.setCharacterEncoding("UTF-8");
String id = (String)session.getAttribute("id");

if(id==""||id==null){
	response.sendRedirect("Main.cu");
	return;
}
if(!id.equals("Admin")){
	response.sendRedirect("Main.cu");
	return;
}%>
<center>
<h2><%=id %> page..</h2>
<h3> &lt; 영화차트 업로드  &gt; </h3>
<form name ="movieuploadform"action="movieUpload.cu" method="post" enctype="multipart/form-data">
<table>
<tr>
<td>영화제목</td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td>카테고리</td>
<td>
<input type="checkbox" name="category" value="horror">horror
<input type="checkbox" name="category" value="animation">animation
<input type="checkbox" name="category" value="action">action
<input type="checkbox" name="category" value="thriller">thriller
</td>
</tr>
<tr>
<td>가격</td>
<td><input type="text" name="price"></td>
</tr>
<tr>
<td>디렉터</td>
<td><input type="text" name="director"></td>
</tr>
<tr>
<td>이미지</td>
<td><input type="file" id="files" name="fileName"></td>
</tr>
<tr>
<td>정보</td>
<td><input type="text" name="info"></td>
</tr>
<tr>
<td>파일 미리보기</td>
<td><img id="image" width="300px"/></td>
</tr>
<tr>
<th colspan="2"><input type="submit" value="영화차트 업로드"></th>
</tr>
</table>
</form>

<BR>


<h3>  &lt; 스토어 업로드  &gt; </h3>
<form action="storeUpload.cu" method="post" enctype="multipart/form-data">
<table align="center">
<tr>
<td></td>
<td><input type="text" name="num"></td>
</tr>
<tr>
<td> </td>
<td><input type="text" name="name"></td>
</tr>
<tr>
<td> </td>
<td><input type="text" name="category"></td>
</tr>
<tr>
<td> </td>
<td><input type="text" name="price"></td>
</tr>
<tr>
<td> </td>
<td><input type="text" name="director"></td>
</tr>
<tr>
<td>이미지</td>
<td><input type="file" name="fileName"></td>
</tr>
<tr>
<td>정보</td>
<td><input type="text" name="info"></td>
</tr>
<tr>
<th colspan="2"><input type="submit" value="스토어 업로드"></th>
</tr>
</table>
</form>


</center>
<script>
document.getElementById("files").onchange = function () {
    var reader = new FileReader();

    reader.onload = function (e) {
        // get loaded data and render thumbnail.
        document.getElementById("image").src = e.target.result;
    };

    // read the image file as a data URL.
    reader.readAsDataURL(this.files[0]);
};

</script>

</body>
</html>