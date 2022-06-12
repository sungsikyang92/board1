<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시물 수정</title>
</head>
<body>
	<form action="/updatewrite" method="post">
		<input type="hidden" name="id" value="${update_id }">
		<input type="hidden" name="author" value="${update_author }">
		<table border="1">
			<tr>
				<th>NAME</th>
				<td>${update_author }</td>
			</tr>
			<tr>
				<th>TITLE</th>
				<td><input type="text" name="title" value="${update_title }"></td>
			</tr>
			<tr>
				<th>CONTENT</th>
				<th><textarea rows="10" cols="60" name="content">${update_content }</textarea></th>
			</tr>
			<tr>
				<td colspan="2" align="right">
					<input type="submit" value="수정완료">
					<input type="button" value="취소" onclick="location.href='/'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>