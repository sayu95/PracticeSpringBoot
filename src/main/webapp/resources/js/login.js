document.addEventListener('DOMContentLoaded', function() {
    const loginBtn = document.querySelector('#loginBtn');

    loginBtn.addEventListener('click', function() {
        // 1. 입력값 가져오기
        const memId = document.querySelector('#memId').value;
        const memPassword = document.querySelector('#memPassword').value;

        // 2. 서버로 보낼 데이터 준비 (URLSearchParams 사용 시 컨트롤러의 DTO로 쏙 들어감)
        const formData = new URLSearchParams();
        formData.append('memId', memId);
        formData.append('memPassword', memPassword);

        // 3. fetch 요청
        fetch('/login', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/x-www-form-urlencoded'
            },
            body: formData
        })
        .then(response => response.text()) // 서버에서 success/fail 문자열을 받음
        .then(data => {
            if (data === "success") {
                alert("로그인 성공!");
                location.href = "/upload";
            } else {
                alert("아이디 또는 비밀번호가 틀렸습니다.");
            }
        })
        .catch(error => {
            console.error('Error:', error);
            alert("통신 중 오류가 발생했습니다.");
        });
    });
});