<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="layout/navbar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="container">
    <p/>
    <div class="row justify-content-center">
       <div class="col-9">
		<div class="card">
			<div class="card-header">請修改訊息</div>
			<div class="card-body">
				<form:form class="form" action="${contextRoot}/editMessage" modelAttribute="workMessage" method="post">
				   <form:input type="hidden" path="id"></form:input>
				   <form:input type="hidden" path="added"></form:input>
				   <form:errors path="text" />
				   <form:textarea path="text" class="form-control" />
				   
				   <input type="submit" name="submit" />
				</form:form>
			</div>
		</div>
     </div>

	</div>
	</div>
</body>
</html>