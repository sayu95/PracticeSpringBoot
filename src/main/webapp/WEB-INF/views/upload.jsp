<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>File Upload Page</title>
    <style>
        .upload-container { margin: 50px; padding: 20px; border: 1px solid #ccc; width: 400px; }
        .btn-group { margin-top: 15px; }
    </style>
</head>
<body>

    <div class="upload-container">
        <h2>파일 업로드</h2>
        <hr>
        <input type="file" id="fileItem" name="uploadFile">
        
        <div class="btn-group">
            <button id="uploadBtn">서버로 전송</button>
            <button onclick="location.href='/'">홈으로</button>
        </div>
    </div>

    <script src="/resources/js/upload.js"></script>
</body>
</html>