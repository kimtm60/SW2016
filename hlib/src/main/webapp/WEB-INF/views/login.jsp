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
<c:choose>
    <c:when test="${not empty sessionScope.userLoginInfo}">
        <h2>�α��� ���� </h2>
        ���̵� : ${sessionScope.userLoginInfo.memberId}
 
        <a href="bookList">�뿩</a>
        <a href="logout">�α׾ƿ�</a>
        <a href="borrowList">�뿩 ���</a>
    </c:when>
    <c:otherwise>
        <h2>�α��� </h2>
        <form name="form1" method="post" action="loginProcess">
        <table>
            <tr height="40px">
                <td>ID :</td>
                <td><input type="text" name="memberId"></td>
            </tr>
            <tr height="40px">
                <td>PASSWORD :</td>
                <td><input type="password" name="password"></td>
            </tr>
        </table>
        <table>
            <tr>
                <td align="center"><input type="submit" value="�α���"></td>
                <td align="center"><input type="reset" value="����"></td>
            </tr>
        </table>
        </form>
        <a href="signUp">ȸ������</a>
    </c:otherwise>
</c:choose>

</center>

</body>
</html>