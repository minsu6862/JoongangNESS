<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../common/header.jsp" %>
<section class="location-section">
    <div class="location-title">📍 오시는 길</div>

    <div class="location-content">
      <!-- 회사 정보 -->
      <div class="location-info">
        <h3>주소</h3>
        서울특별시 마포구 신촌로 176, 중앙빌딩<br>

        <h3>연락처</h3>
        전화: 02-1234-5678<br>
        이메일: manyBooks@example.com<br>

        <h3>대중교통</h3>
        - 2호선 이대역 6번 출구 도보 1분<br>
        - 버스: 172, 146, 740번 승차 후 '이대역' 하차
      </div>

      <!-- 지도 자리 -->
      <div class="map-box">
        <div id="map" style="width:500px;height:400px;"></div>
			<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=60bbb8abc9dd0ab93e645b1876511f39&libraries=services"></script>
			<script>
				var container = document.getElementById('map');
				var options = {
					center: new kakao.maps.LatLng(37.556501, 126.945212),
					level: 3
				};

				var map = new kakao.maps.Map(container, options);
				
				//주소-좌표 변환 객체 생성
			      var geocoder = new kakao.maps.services.Geocoder();
			      
			      var address = "서울특별시 마포구 신촌로 176, 중앙빌딩";
			      
			      geocoder.addressSearch(address, function(result, status) {
			            if (status === kakao.maps.services.Status.OK) {
			                // 검색된 좌표 (위도: y, 경도: x)
			                var coords = new kakao.maps.LatLng(result[0].y, result[0].x);

			                // 지도 중심 이동
			                map.setCenter(coords);

			                // 마커 생성
			                var marker = new kakao.maps.Marker({
			                    map: map,
			                    position: coords
			                });

			                // 인포윈도우 생성 (주소 표시)
			                var infowindow = new kakao.maps.InfoWindow({
			                    content: '<div style="padding:5px;">' + address + '</div>'
			                });
			                infowindow.open(map, marker);

			                // 콘솔에 위도 경도 출력
			                console.log("위도: " + result[0].y + ", 경도: " + result[0].x);
			            } else {
			                alert("주소 검색 실패: " + status);
			            }
			        });
			</script>
      </div>
    </div>
  </section>

<%@ include file="../common/footer.jsp" %>