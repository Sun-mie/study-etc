<%@page import="model.BoardBean"%>
<%@page import="model.BoardDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 목록</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<h2 align="center">게시글 보기</h2>
<div align="center" class="fst">
	<table width="600" border="1" >
		<tr height="40">
			<td width="100" align="center" class="st">글번호</td>
			<td width="180" align="left">&nbsp;&nbsp;${bean.getNum()}</td>
			<td width="120" align="center" class="st">조회수</td>
			<td width="180" align="center">${bean.getReadcount()}</td>
		</tr>
		<tr height="40">
			<td width="100" align="center" class="st" >작성자</td>
			<td width="180" align="left">&nbsp;&nbsp;${bean.getWriter()}</td>
			<td width="120" align="center" class="st">작성일</td>
			<td width="180" align="center">${bean.getReg_date()}</td>
		</tr>
		<tr height="40">
			<td width="120" align="center" class="st">이메일</td>
			<td colspan="3" align="center">${bean.getEmail()}</td>
		</tr>
		<tr height="40">
			<td width="120" align="center" class="st">제목</td>
			<td colspan="3" align="center">${bean.getSubject()}</td>
		</tr>
		<tr height="80">
			<td width="120" align="center" class="st">글내용</td>
			<td colspan="3" align="center">${bean.getContent()}</td>
		</tr>
		<tr height="40">
			<td align="center" colspan="4">
			<input type="button" value="답글쓰기" onclick="location.href='BoardReWrite?num=${bean.getNum()}&ref=${bean.getRef()}&re_step=${bean.getRe_step()}&re_level=${bean.getRe_level()}'">
			<input type="button" value="수정하기" onclick="location.href='BoardUpdate?num=${bean.getNum()}'">
			<input type="button" value="삭제하기" onclick="location.href='BoardDelete?num=${bean.getNum()}'">
			<input type="button" value="목록보기" onclick="location.href='BoardList'">
			</td>
		</tr>
	</table>
</div>
</body>
</html>