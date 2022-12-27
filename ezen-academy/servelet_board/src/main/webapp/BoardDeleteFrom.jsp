<%@page import="model.BoardBean"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 삭</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<div align="center" class="fst">
	<form action="BoardDelete" method="post">
		<table width="600" border="1">
			<tr height="40">
				<td width="120" align="center" class="st">작성자</td>
				<td width="180" align="center">${bean.getWriter()}</td>
				
				<td width="120" align="center" class="st">작성일</td>
				<td width="120" align="center">${bean.getReg_date()}</td>
			</tr>
			<tr height="40">
				<td width="120" align="center" class="st">제목</td>
				<td width="180" align="center">${bean.getSubject()}</td>
			</tr>
			<tr height="40">
				<td width="120" align="center" class="st">패스워드</td>
				<td align="left" colspan="3"><input type="password" name="password"></td>
			</tr>
			<tr height="40">
				<td align="center" colspan="4"> 
				<input type="hidden" name="num" value="${num}">
				<input type="submit" value="글삭제"> &nbsp;&nbsp;
				<input type="button" onclick="location.href='BoardList'" value="목록보기">
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>