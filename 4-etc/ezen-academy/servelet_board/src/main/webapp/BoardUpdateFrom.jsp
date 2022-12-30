<%@page import="model.BoardBean"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div align="center">
<form action="BoardUpdate" method="post">
<table width="600" border="1" class="fst">
	<tr height="40" >
		<td width="120" align="center" class="st"> 작성자</td>
		<td width="80" align="center">${bean.getWriter()}</td>
		<td width="120" align="center" class="st"> 작성일</td>
		<td width="80" align="center">${bean.getReg_date()}</td>
	</tr>
	<tr height="40" >
		<td width="120" align="center" class="st">제목</td>
		<td width="480" colspan="3">&nbsp;<input type="text" name="subject" value="${bean.getSubject()}" size="60"></td>
	</tr>
	<tr height="40" >
		<td width="120" align="center" class="st">패스워드</td>
		<td width="480" colspan="3">&nbsp;<input type="password" name="password" size="60"></td>
	</tr>
	<tr>
		<td width="120" align="center" class="st">글내용</td>
		<td> <textarea width="480" cols="60" rows="10" name="content" align="left">${bean.getContent()}</textarea></td>
	</tr>
	<tr height="40">
		<td colspan="4" align="center">
		<input type="hidden" name="num" value="${bean.getNum()}">
		<input type="submit" value="글수정">&nbsp;&nbsp;
		<input type="button" onclick="location.href='BoardList'" value="전체 글 보기">
		</td>
	</tr>
</table>
</form>
</div>
</body>
</html>