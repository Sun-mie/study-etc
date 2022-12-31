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
<h2 align="center">답변글 입력하기</h2>
<div align="center" class="fst">

<form action="BoardReWrite" method="post">
	<table width="600" border="1" bordercolor="gray">
	<tr height="40">
		<td width="150" align="center" class="st">작성자</td>
		<td width="450"><input type="text" name="writer" size="60"></td>
	</tr>
	<tr height="40">
		<td width="150" align="center" class="st">이메일</td>
		<td width="450"><input type="email" name="email" size="60"></td>
	</tr>
		<tr height="40">
		<td width="150" align="center" class="st">제목</td>
		<td width="450"><input type="text" name="subject" size="60" value="[답글]"></td>
	</tr>
	<tr height="40">
		<td width="150" align="center" class="st">비밀번호</td>
		<td width="450"><input type="password" name="password" size="60"></td>
	</tr>
	<tr height="40">
		<td width="150" align="center" class="st">글 내용</td>
		<td width="450"><textarea rows="10" cols="60" name="content"></textarea></td>
	</tr>
	
	<tr height="40">
	<td align="center" colspan="2">
		<input type="hidden" name="ref" value="${ref}">
		<input type="hidden" name="re_step" value="${re_step}">
		<input type="hidden" name="re_level" value="${re_level}">
		<input type="submit" value="답글쓰기완료"> &nbsp;&nbsp;
		<input type="reset" value="다시작성"> &nbsp;&nbsp;
		<input type="button" onclick="location.href='BoardList'" value="전체글보기">
	</td>
	</tr>
	</table>
</form>
</div>
</body>
</html>