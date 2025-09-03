<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ include file="../common/header.jsp" %>
<div class="board-container">
    <div class="board-header">
        <h2>자유게시판</h2>
        <a href="${pageContext.request.contextPath}/write" class="btn">글쓰기</a>
    </div>
    <table class="board-table">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${boardList}" var="board" varStatus="status">
            <tr>
          		<td>${boardCount - (board.rnum - 1) }</td>
          		<td><a href="contentView?bnum=${board.bnum}">${board.btitle }</a></td>
          		<td>${board.memberDto.membername }</td>
          		<td>${board.bdate }</td>
        	</tr>
        </c:forEach>
        </tbody>
    </table>
    <div class="pagination">
    	<c:if test="${pageNum > 1 }">
      		<a href="list?pageNum=1">&laquo;</a>
      		<a href="list?pageNum=${startPage-1}">&lsaquo;</a>
      	</c:if>
      	<c:forEach var="i" begin="${startPage }" end="${endPage }">
      		<c:choose>
      			<c:when test="${i == pageNum}">
      				<a href="list?pageNum=${i}" class="active">${i}</a>
      			</c:when>
      			<c:otherwise>
      				<a href="list?pageNum=${i}">${i}</a>
      			</c:otherwise>
      		</c:choose>
      	</c:forEach>
      	<c:if test="${pageNum < totalPage }">
      		<a href="list?pageNum=${endPage+1}">&rsaquo;</a>
      		<a href="list?pageNum=${totalPage}">&raquo;</a>
      	</c:if>
    </div>
</div>
<%@ include file="../common/footer.jsp" %>