<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>BookList</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
</head>
<body>
<center>
<h2>책 목록</h2>
<table style="border:1px solid #ccc">
	<colgroup>
		<col width="10%" align="center"/>
		<col width="*" align="center"/>
		<col width="15%" align="center"/>
		<col width="20%" align="center"/>
	</colgroup>
	<thead>
		<tr>
			<th scope="col">책 번호</th>
			<th scope="col">제목</th>
			<th scope="col">잔여 권 수</th>
			<th scope="col">추천</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${fn:length(books) > 0}">
				<c:forEach items="${books}" var="row">
					<tr>
						<td align="center">${row.bookId }</td>
						<td align="center">
								<a href="borrow/${row.bookId}">${row.bookName }</a></td>
						<td align="center">${row.bookCount }</td>
						<td align="center">${row.bookType }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="4">조회된 결과가 없습니다.</td>
				</tr>
			</c:otherwise>
		</c:choose>
		
	</tbody>
</table>
</center>



</body>
</html>





