<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>My Coupon</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
<center>
<h2>Coupon 교환</h2>
<table style="border:1px solid #ccc">
	<colgroup>
		<col width="*" align="center"/>
	</colgroup>
	<thead>
		<tr>
			<th scope="col">쿠폰 번호</th>

		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(coupon) > 0}">
				<c:forEach items="${coupon}" var="row">
					<tr>
						<td align="center">${row.couponSerialNumber }</td>
					</tr>
				</c:forEach>
				<center>쿠폰번호를 꼭 백업 해 주세요!</center>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		<a href="home">홈으로</a>
	</tbody>
</table>
</center>



</body>
</html>
