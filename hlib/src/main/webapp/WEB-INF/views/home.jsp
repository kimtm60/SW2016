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
<h2>로그인 성공 </h2>
        아이디 : ${sessionScope.userLoginInfo.memberId}
 </br>
        <a href="bookList">대여</a>
        <a href="logout">로그아웃</a>
        <a href="borrowList">대여 목록</a>
        <a href="showMyCouponList">쿠폰 목록</a>
        <a href="showCoupon">쿠폰 교환</a>
</body>
</html>