document.querySelector('#uploadBtn').addEventListener('click', function() {
    const fileInput = document.querySelector('#fileItem');
    const files = fileInput.files;

    if (files.length === 0) {
        alert("파일을 선택해주세요.");
        return;
    }

    // 파일 데이터를 담을 바구니
    const formData = new FormData();
    // 컨트롤러의 파라미터명(MultipartFile 이름)과 'uploadFile'이 일치해야 함
    formData.append("uploadFile", files[0]);

    fetch('/upload/action', {
        method: 'POST',
        body: formData
        // 주의: FormData를 보낼 때는 'Content-Type' 헤더를 직접 설정하지 않습니다. 
        // 브라우저가 알아서 boundary가 포함된 multipart/form-data로 설정합니다.
    })
    .then(response => response.text())
    .then(data => {
        if (data === "ok") {
            alert("서버에 파일 저장 성공!");
        } else {
            alert("저장 실패");
        }
    })
    .catch(error => {
        console.error('Error:', error);
        alert("업로드 중 통신 오류 발생");
    });
});