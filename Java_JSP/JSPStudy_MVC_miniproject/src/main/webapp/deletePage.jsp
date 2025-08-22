<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="utf-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1" />
  <title>삭제된 게시글 - Clean Board</title>
  <link rel="stylesheet" href="css/boardStyle.css" />
</head>
<body>
  <!-- 헤더 -->
  <%@ include file="include/header.jsp" %>

  <!-- 본문 -->
    <main class="container">
        <section class="post-deleted">
            <div class="deleted-card">
                <!-- 삭제 유형에 따른 메시지 구분 -->
                <c:choose>
                    <c:when test="${param.type == 'deleted'}">
                        <h2 class="section-title">게시글이 삭제되었습니다</h2>
                        <p class="deleted-message">
                            게시글이 성공적으로 삭제되었습니다.<br />
                            게시판 목록으로 돌아가겠습니다.
                        </p>
                    </c:when>
                    <c:otherwise>
                        <h2 class="section-title">삭제된 게시글입니다</h2>
                        <p class="deleted-message">
                            선택하신 게시글은 이미 삭제되었거나 존재하지 않습니다.<br />
                            게시판 목록에서 다른 글을 확인해주세요.
                        </p>
                    </c:otherwise>
                </c:choose>
                
                <div class="form-actions">
                    <a href="list.do" class="btn btn-primary">게시판으로 돌아가기</a>
                </div>
            </div>
        </section>
    </main>

  <!-- 푸터 -->
  <%@ include file="include/footer.jsp" %>
  
  <!-- 자동 리다이렉트 (선택사항) -->
    <c:if test="${param.type == 'deleted'}">
        <script>
            // 3초 후 자동으로 목록으로 이동
            setTimeout(function() {
                window.location.href = 'list.do';
            }, 3000);
        </script>
    </c:if>
</body>
</html>