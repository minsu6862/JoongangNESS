<%@page import="dto.BoardDto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fn" uri="jakarta.tags.functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
	body {
      font-family: "Malgun Gothic", sans-serif;
      background-color: #f9f9f9;
      padding: 40px;
    }

    table {
      width: 60%;
      border-collapse: collapse;
      background-color: white;
      box-shadow: 0 2px 8px rgba(0, 0, 0, 0.05);
    }

    thead {
      background-color: #f1f1f1;
    }

    th, td {
      border: 1px solid #ddd;
      padding: 12px 16px;
      text-align: center;
      font-size: 14px;
    }

    th {
      font-weight: bold;
    }

    td:nth-child(2) {
      text-align: left;
      color: #0056b3;
    }

    tr:hover {
      background-color: #f9f9f9;
    }

    a {
      text-decoration: none;
      color: #0056b3;
    }

    a:hover {
      text-decoration: underline;
    }
	
	
</style>
<title>자유 게시판</title>
</head>
<body>
	<h2>자유 게시판 목록</h2>
	<hr>
	<table>
		<thead>
		<tr>
			<th>No.</th>
			<th>아이디</th>
			<th>이름</th>
			<th>나이</th>
			<th>날짜</th>
		</tr>
		</thead>
		
		<c:forEach var="memberDto" items="${memList }">
			<tr>
				<td>${memberDto.mnum }</td>
				<td>${memberDto.mid }</td>
				<td>${memberDto.mname }</td>
				<td>${memberDto.mage }</td>
				<td>${memberDto.mdate }</td>
			</tr>
		</c:forEach>
	</table>
	
	<hr>
	
</body>
</html>