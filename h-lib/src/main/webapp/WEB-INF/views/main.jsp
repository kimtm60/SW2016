
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
</head>
<style>
table, td{
	border: 1px solid black;
	border-collapse: collapse;

}
</style>
<body>
<table>
	<colgroup>
	<col width="40%" align="center"/>
	<col width="50%" align="center"/>
	<col width="50%" align="center"/>
	</colgroup>
<tr>
<td><a href="/WEB-INF/views/login.jsp">로그인</a></td>
<td><a href="<c:url value='/bookList.do'/>">대여</a></td>
<td><a href="<c:url value='/memberInfo.do'/>">회원 정보</a></td>
</tr>
</table>
<p>
<p>
H_LIB
</body>
</html>