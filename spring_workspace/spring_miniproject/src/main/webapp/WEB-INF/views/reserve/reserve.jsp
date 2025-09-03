<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="../common/header.jsp" %>
<style>
.seat-container {
    display: grid;
    grid-template-columns: repeat(5, 1fr);
    gap: 15px;
    max-width: 500px;
    margin: 40px auto;
    padding: 20px;
}
.seat-btn {
    width: 80px;
    height: 80px;
    border-radius: 8px;
    border: 2px solid;
    font-weight: bold;
    font-size: 1rem;
    cursor: pointer;
    transition: all 0.3s;
}
.seat-btn.available {
    background: #fff;
    border-color: #ffcc00;
    color: #333;
}
.seat-btn.available:hover {
    background: #ffcc00;
    color: #fff;
    transform: scale(1.05);
}
.seat-btn.reserved {
    background: #666;
    color: #fff;
    border-color: #333;
    cursor: pointer;
}
.seat-btn.my-reservation {
    background: #4CAF50;
    color: #fff;
    border-color: #45a049;
    cursor: pointer;
}
.seat-btn.my-reservation:hover {
    background: #45a049;
    transform: scale(1.05);
}
.legend {
    display: flex;
    justify-content: center;
    gap: 20px;
    margin-bottom: 20px;
}
.legend-item {
    display: flex;
    align-items: center;
    gap: 8px;
}
.legend-color {
    width: 20px;
    height: 20px;
    border-radius: 4px;
    border: 2px solid;
}
.legend-available { background: #fff; border-color: #ffcc00; }
.legend-reserved { background: #666; border-color: #333; }
.legend-my { background: #4CAF50; border-color: #45a049; }
</style>
<section class="reservation-section">
    <div class="board-container">
        <h2 class="title">좌석 예약</h2>
        
        <!-- 범례 -->
        <div class="legend">
            <div class="legend-item">
                <div class="legend-color legend-available"></div>
                <span>예약 가능</span>
            </div>
            <div class="legend-item">
                <div class="legend-color legend-reserved"></div>
                <span>예약됨</span>
            </div>
            <div class="legend-item">
                <div class="legend-color legend-my"></div>
                <span>내 예약</span>
            </div>
        </div>
        
        <div class="seat-container">
            <c:forEach var="seat" items="${seats}">
                <button class="seat-btn ${seat.reserved == 1 ? (seat.reserveid == sessionScope.sessionId ? 'my-reservation' : 'reserved') : 'available'}" 
                        data-seat="${seat.seatname}">
                    ${seat.seatname}
                </button>
            </c:forEach>
        </div>
    </div>
</section>
<script>
document.querySelectorAll('.seat-btn').forEach(btn => {
    btn.addEventListener('click', () => {
        const seatId = btn.dataset.seat;
        
        // 먼저 좌석 상태 확인
        fetch('${pageContext.request.contextPath}/reservation/check', {
            method: 'POST',
            headers: {'Content-Type':'application/x-www-form-urlencoded'},
            body: 'seatId=' + seatId
        })
        .then(res => res.text())
        .then(status => {
            if (status === 'login_required') {
                alert('로그인이 필요합니다.');
                location.href = '${pageContext.request.contextPath}/login';
                return;
            }
            
            if (status === 'available') {
                // 빈 좌석 - 예약 처리
                if(confirm(seatId + " 좌석을 예약하시겠습니까?")) {
                    bookSeat(seatId, btn);
                }
            } else if (status === 'my_reservation') {
                // 내 예약 - 취소 확인
                if(confirm(seatId + " 좌석 예약을 취소하시겠습니까?")) {
                    cancelSeat(seatId, btn);
                }
            } else if (status === 'others_reservation') {
                // 다른 사람 예약
                alert('이미 예약된 좌석입니다.');
            } else {
                alert('좌석 상태를 확인할 수 없습니다.');
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert('오류가 발생했습니다.');
        });
    });
});

function bookSeat(seatId, btn) {
    fetch('${pageContext.request.contextPath}/reservation/reserve', {
        method: 'POST',
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        body: 'seatId=' + seatId
    })
    .then(res => res.text())
    .then(result => {
        if(result === 'success') {
            btn.classList.remove('available');
            btn.classList.add('my-reservation');
            alert(seatId + ' 좌석이 예약되었습니다!');
        } else if(result === 'already_reserved') {
            alert('이미 예약된 좌석입니다.');
            location.reload();
        } else {
            alert('예약 실패');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('예약 중 오류가 발생했습니다.');
    });
}

function cancelSeat(seatId, btn) {
    fetch('${pageContext.request.contextPath}/reservation/cancel', {
        method: 'POST',
        headers: {'Content-Type':'application/x-www-form-urlencoded'},
        body: 'seatId=' + seatId
    })
    .then(res => res.text())
    .then(result => {
        if(result === 'success') {
            btn.classList.remove('my-reservation');
            btn.classList.add('available');
            alert(seatId + ' 좌석 예약이 취소되었습니다!');
        } else if(result === 'not_your_reservation') {
            alert('본인이 예약한 좌석이 아닙니다.');
        } else {
            alert('예약 취소 실패');
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert('취소 중 오류가 발생했습니다.');
    });
}
</script>
<%@ include file="../common/footer.jsp" %>