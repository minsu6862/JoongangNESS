<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/header.css">
    <!-- <link rel="stylesheet" type="text/css" href="css/main.css"> -->
    <link rel="stylesheet" type="text/css" href="css/boardlist_aside.css">
    <link rel="stylesheet" type="text/css" href="css/boardlist_main.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    <title>클래식 기타 커뮤니티</title>
</head>
<body>
	<%
		String sid = (String) session.getAttribute("memberId");
		if(sid == null) {
			response.sendRedirect("login.jsp");
		}
		//로그인 하지 않으면 본 페이지를 볼수 없음.
	%>
    <div id="wrap">
        <header>
            <a href="index.html"><img id="logo" src="images/logo.png"></a>
            <nav id="top_menu">
                HOME  |  LOGIN  |  JOIN  |  NOTICE
            </nav>
            <nav id="main_menu">
                <ul>
                    <li><a href="board_list.html">자유게시판</a></li>
                    <li><a href="#">기타 연주</a></li>
                    <li><a href="#">공동 구매</a></li>
                    <li><a href="#">연주회 안내</a></li>
                    <li><a href="#">회원 게시판</a></li>
                </ul>
            </nav>
        </header>

        <aside>
            <article id="login_box"> <!-- 로그인 박스 -->
                <img id="login_title" src="images/ttl_login.png">
                <div id="input_button">
                    <form>
                        <ul id="login_input">
                            <li><input type="text"></li>
                            <li><input type="password"></li>
                        </ul>
                        <input id="login_btn" type="image" src="images/btn_login.gif">
                    </form>
                </div>
                <div class="clear"></div>
                <div id="join_search">
                    <img src="images/btn_join.gif">
                    <img src="images/btn_search.gif">
                </div>
            </article> <!-- 로그인 박스 끝 -->

            <nav id="sub_menu">
                <ul>
                    <li><a href="#">+ 자유 게시판</a></li>
                    <li><a href="#">+ 방명록</a></li>
                    <li><a href="#">+ 공지사항</a></li>
                    <li><a href="#">+ 등업 요청</a></li>
                    <li><a href="#">+ 포토갤러리</a></li>
                </ul>
            </nav>

            <article id="sub_banner">
                <ul>
                    <li><img src="images/banner1.png"></li>
                    <li><img src="images/banner2.png"></li>
                    <li><img src="images/banner3.png"></li>
                </ul>
            </article>
            
        </aside>

        <main>
            <img src="images/comm.gif">
            <h2 id="board_title">자유 게시판</h2>
            <div id="total_search">
                <div id="total">▷ 총 3개의 게시물이 있습니다.</div>
                <div id="search">
                    <div id="search_img">
                        <img src="images/select_search.gif">
                    </div>
                    <div id="search_select">
                        <select>
                            <option>제목</option>
                            <option>내용</option>
                            <option>글쓴이</option>
                        </select>
                    </div>
                    <div id="search_input">
                        <input type="text">
                    </div>
                    <div id="search_btn">
                        <img src="images/search_button.gif">
                    </div>
                </div>
            </div> <!-- total_search 끝 -->
            
            <table> <!-- 게시판 글 목록 테이블 -->
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>글쓴이</th>
                    <th>일시</th>
                    <th>조회수</th>
                </tr>
                <tr>
                    <td class="col1">1</td>
                    <td class="col2"><a href="board_view.html">까스통님의 선물인 보드카가 정말 독하네요!!</a></td>
                    <td class="col3">루바토</td>
                    <td class="col4">2025-07-15</td>
                    <td class="col5">15</td>
                </tr>
                <tr>
                    <td class="col1">2</td>
                    <td class="col2"><a href="board_view.html">까스통님의 선물인 보드카가 정말 독하네요!!</a></td>
                    <td class="col3">루바토</td>
                    <td class="col4">2025-07-15</td>
                    <td class="col5">45</td>
                </tr>
                <tr>
                    <td class="col1">3</td>
                    <td class="col2"><a href="board_view.html">까스통님의 선물인 보드카가 정말 독하네요!!</a></td>
                    <td class="col3">루바토</td>
                    <td class="col4">2025-07-15</td>
                    <td class="col5">57</td>
                </tr>
            </table> <!-- 게시판 글 목록 끝 -->
            <div id="buttons">
                <div class="buttons_col1">
                    ◀ 이전 1 다음 ▶
                </div>
                <div class="buttons_col2">
                    <img src="images/list.png">
                    <a href="board_write.html"><img src="images/write.png"></a>
                </div>
            </div>                    
        </main>
        <div class="clear"></div>
        
        <footer>
            <img id="footer_logo" src="images/footer_logo.gif">
            <ul id="address">
                <li>서울시 강남구 삼성동  1234 우 : 123-1234</li>
                <li>TEL : 02-123-1234  Email : email@domain.com</li>
                <li>copyright&copy; 루바토 All Rights Reserved</li>
            </ul>
            <ul id="footer_sns">
                <li><img src="images/facebook.gif"></li>
                <li><img src="images/blog.gif"></li>
                <li><img src="images/twitter.gif"></li>
            </ul>
        </footer>
    </div>
</body>
</html>