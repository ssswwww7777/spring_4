<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title><script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
    $(function(){
    	$("#del").click(function() {
			$("#frm").submit();
		});
    });
</script>
</head>
<body>

<h1>${board} Select</h1>

<h3>TITLE : %{boardDTO.title}</h3>
<h3>WRITER : %{boardDTO.writer}</h3>
<h3>CONTENTS : %{boardDTO.contents}</h3>


<a href="./${board}List">List</a>
<a href="./${board}Update">Update</a>
<span id="del">Delete</span>
<form id="frm" action="./${board}Delete" method="post">
    <input type="hidden" name = "num" value="1">
</form>
<c:if test="${board ne 'notice'}">
<a href="./${board}Reply">Reply</a>
</c:if>
</body>
</html>