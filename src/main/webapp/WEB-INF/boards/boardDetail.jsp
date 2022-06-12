<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 보기</title>
</head>
<body>
	<table border="1">
		<tr>
			<th>NAME</th>
			<th>${detail_author}</th>
		</tr>
		<tr>
			<th>TITLE</th>
			<th>${detail_title }</th>
		</tr>
		<tr>
			<th>CONTENT</th>
			<th><textarea rows="10" cols="60" readonly="readonly">${detail_content }</textarea></th>
		</tr>
		<tr>
			<td colspan="2" align="right">
				<input type="button" value="수정" onclick="location.href='/updateButton/${detail_id}'">
				<input type="button" value="삭제" onclick="location.href='/deleteButton/${detail_id}'">
				<input type="button" value="목록" onclick="location.href='/'">
			</td>
		</tr>
	</table>
</body>
</html>