<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
	<%@ page session="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<center><h1>welcome H_LIB</h1>
</br>
<h2>�α��� ���� </h2>
        ���̵� : ${sessionScope.userLoginInfo.memberId}
 </br>
        <a href="bookList">�뿩</a>
        <a href="logout">�α׾ƿ�</a>
        <a href="borrowList">�뿩 ���</a>
        <a href="showMyCouponList">���� ���</a>
        <a href="showCoupon">���� ��ȯ</a>
</body>
</html>