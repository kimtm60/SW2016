<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/include/include-header.jspf" %>
</head>
<body>
<form id="frm">
아이디 : <input type="text" id="memberId" name="memberId"></input><br>
패스워드 : <input type="text" id="password" name="password"></input><br>
<a href="#this" class="btn" id="login" >로그인하기</a>
<a href="#this" class="btn" id="cancel" >취소</a>
</form>

    <%@ include file="/WEB-INF/include/include-body.jspf" %>

 <script type="text/javascript">
        $(document).ready(function(){
        	$("#login").on("click", function(e){
                e.preventDefault();
                fn_loginCheck();
            });          
        	$("#cancel").on("click", function(e){
                e.preventDefault();
                fn_openindex();
            });
        });
        
        function fn_loginCheck(){
            var comSubmit = new ComSubmit("frm");
            comSubmit.setUrl("<c:url value='/loginCheck.do' />");
            comSubmit.submit();
        }

        
        function fn_openindex(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("<c:url value='/main.do' />");
            comSubmit.submit();
        }
 
        
    </script>

</body>
</html>