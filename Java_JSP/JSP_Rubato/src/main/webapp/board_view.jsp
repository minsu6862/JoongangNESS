<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="css/common.css">
    <link rel="stylesheet" type="text/css" href="css/header.css">    
    <link rel="stylesheet" type="text/css" href="css/boardlist_aside.css">
    <!-- <link rel="stylesheet" type="text/css" href="css/boardlist_main.css"> -->
    <link rel="stylesheet" type="text/css" href="css/board_view.css">
    <link rel="stylesheet" type="text/css" href="css/footer.css">
    <title>클래식 기타 커뮤니티</title>
</head>
<body>
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
            <div id="view_title_box">
                <span>까스통님의 선물인 보드카가 정말 독하네요!!!</span>
                <span id="info">루바토 | 조회 : 15 | 2025-07-15 (09:20)</span>
            </div>                         
            <div id="view_content">
                까스통님 고맙습니다.<br>
                까스통님 고맙습니다.<br>
                까스통님 고맙습니다.<br>
                까스통님 고맙습니다.<br>
                까스통님 고맙습니다.<br>
            </div>
            <div id="comment_box">
                <img id="title_comment" src="images/title_comment.gif">
                <textarea></textarea>
                <img id="ok_ripple" src="images/ok_ripple.gif">
            </div>
            <div id="buttons">
                <a href="#"><img src="images/delete.png"></a>
                <a href="board_list.html"><img src="images/list.png"></a>
                <a href="board_write.html"><img src="images/write.png"></a>
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