<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset=UTF-8"); %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시목록</title>
</head>
<body>
	<h1> 게시판 목록 </h1>
	<table border="1">
		<colgroup>
			<col width="50">
			<col width="100">
			<col width="300">
			<col width="100">
		</colgroup>
		<tr>
			<th>NO</th>
			<th>NAME</th>
			<th>TITLE</th>
			<th>DATE</th>			
		</tr>
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.id }</td>
				<td>${list.author }</td>
				<td><a href="detail/${list.id}">${list.title }</a></td>
				<td>${list.createdDate }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4" align="right">
				<input type="button" value="글쓰기" onclick="location.href='writeButton'">
			</td>
		</tr>
	</table>
</body>
</html>