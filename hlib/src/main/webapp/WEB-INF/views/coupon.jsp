<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body> 
<%Object v = request.getAttribute("value"); %>
<center><h1>welcome H_LIB</h1>
</br>
<h2>���� ��ȯ �ϱ�</h2>
</br>
<form action="requsetExchange" method="post"> 
<select name="couponNum"> 

 <option value="coupon">���� �� ��</option> 
 <% for(int i=1;i<=((Integer)v).intValue();i++){ %>
 <option value="<%=i%>"><%=i %></option> 
<%} %>


</select> 

<td align="center"><input type="submit" value="��ȯ�ϱ�"></td>
</form>
</center>
 

</body>
</html>

