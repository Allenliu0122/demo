<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />
<jsp:include page="layout/navbar.jsp" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>EMP</h1>

<p/>
<div class="container">

<input id="myMessage" />
<button id ="submitBtn">GO</button>

<div>
 <table class="mytable" id="list_table_json">
   <thead>
   <tr>
     <th>id</th>
     <th>name</th>
     <th>birth</th>
     <th>Department</th>
     <th>gender</th>
     <th>Position</th>
   </tr>
   </thead>
 </table>
</div>
</div>

<script>
  $(document).ready(function(){
      $('#submitBtn').click(function(){

         var inputText = document.getElementById('getAllEmp').value;
         var dtoObject = {"Emp": inputText}
         var dtoJsonString = JSON.stringify(dtoObject);

         $.ajax({
           url:'http://localhost:8080/my-app/api/postEmp',
           contentType: 'application/json; charset=UTF-8',  // 送過去的格式
           dataType: 'json', // 傳回來的
           method: 'post',
           data: dtoJsonString,
           success: function(result){
        	   $('#list_table_json tr td').remove()
             console.log(result)
             var emp_data = '';
             $.each(result, function(index, value){
            	 emp_data += '<tr>'
            		 emp_data += '<td>' + value.id + '</td>'
            		 emp_data += '<td>' + value.name + '</td>'
            		 emp_data += '<td>' + value.birth + '</td>'
            		 emp_data += '<td>' + value.Department + '</td>'
            		 emp_data += '<td>' + value.gender + '</td>'
            		 emp_data += '<td>' + value.Position + '</td>'
            	 emp_data += '<tr>'
             })
             $('#list_table_json').append(emp_data)
           },
           error: function(err){
             console.log(err)
             alert('發生錯誤')
           }

         })



      })



  } )


</script>
</body>
</html>