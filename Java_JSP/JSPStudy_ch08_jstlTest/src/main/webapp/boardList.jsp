<%@page import="com.dto.BoardDto"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }

        body {
            font-family: 'Malgun Gothic', Arial, sans-serif;
            background-color: #f5f5f5;
            padding: 20px;
        }

        h2 {
            color: #333;
            margin-bottom: 10px;
        }

        hr {
            border: none;
            border-top: 2px solid #ddd;
            margin-bottom: 20px;
        }

        .notice-board {
            max-width: 1200px;
            margin: 0 auto;
            background-color: white;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0, 0, 0, 0.1);
            overflow: hidden;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            font-size: 14px;
        }

        /* 헤더 스타일 */
        th {
            background-color: #e8e8e8;
            color: #333;
            font-weight: bold;
            padding: 12px 15px;
            text-align: center;
            border-right: 1px solid #d0d0d0;
            border-bottom: 2px solid #ccc;
        }

        th:first-child {
            width: 80px;
        }

        th:nth-child(2) {
            width: auto;
            text-align: left;
        }

        th:nth-child(3) {
            width: 120px;
        }

        th:nth-child(4) {
            width: 100px;
        }

        th:last-child {
            border-right: none;
        }

        /* 본문 행 스타일 */
        tbody tr {
            border-bottom: 1px solid #e0e0e0;
            transition: background-color 0.2s ease;
        }

        tbody tr:hover {
            background-color: #f8f9fa;
        }

        tbody tr:nth-child(even) {
            background-color: #fdfdfd;
        }

        tbody tr:nth-child(odd) {
            background-color: #ffffff;
        }

        td {
            padding: 12px 15px;
            border-right: 1px solid #e8e8e8;
            vertical-align: middle;
        }

        td:last-child {
            border-right: none;
        }

        /* No. 컬럼 스타일 */
        .no-column {
            text-align: center;
            color: #666;
            font-weight: 500;
        }

        /* 제목 컬럼 스타일 */
        .title-column {
            text-align: left;
        }

        .title-column a {
            color: #0066cc;
            text-decoration: none;
            transition: color 0.2s ease;
        }

        .title-column a:hover {
            color: #0052a3;
            text-decoration: underline;
        }

        /* 글쓴이 컬럼 스타일 */
        .author-column {
            text-align: center;
            color: #666;
        }

        /* 날짜 컬럼 스타일 */
        .date-column {
            text-align: center;
            color: #888;
            font-size: 13px;
        }

        /* 반응형 디자인 */
        @media (max-width: 768px) {
            .notice-board {
                margin: 10px;
                border-radius: 0;
            }

            table {
                font-size: 13px;
            }

            th, td {
                padding: 8px 10px;
            }

            th:first-child,
            .no-column {
                display: none;
            }

            th:nth-child(3),
            .author-column {
                display: none;
            }
        }
</style>
<title>자유 게시판</title>
</head>
<body>
	<!-- 게시판 글 리스트 -->
	<%
	//게시판 더미 데이터
	
	List<BoardDto> boardList = new ArrayList<BoardDto>();
	//게시글(boardDto)를 여러개 담을 ArrayList 선언
	
	boardList.add(new BoardDto(1, "안녕하세요, 첫 글입니다", "이순신", "2025-08-01"));
	boardList.add(new BoardDto(1, "안녕하세요, 두번째 글입니다", "다중이", "2025-08-02"));
	boardList.add(new BoardDto(1, "안녕하세요, 세번째 글입니다", "김유신", "2025-08-03"));
	boardList.add(new BoardDto(1, "안녕하세요, 네번째 글입니다", "윾동", "2025-08-04"));
	boardList.add(new BoardDto(1, "안녕하세요, 다섯번째 글입니다", "ㅇㅇ", "2025-08-05"));
	
	request.setAttribute("boardList", boardList);
	%>
	
	<h2>자유 게시판 목록</h2>
	<hr>
	<table>
		<tr>
			<th>No.</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>날짜</th>
		</tr>
		
		<c:forEach var="boardDto" items="${boardList }">
			<tr>
				<td>${boardDto.bnum }</td>
				<td>${boardDto.btitle }</td>
				<td>${boardDto.bwriter }</td>
				<td>${boardDto.bdate }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>