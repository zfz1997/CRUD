<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
 <form:form action="emp" method="POST" modelAttribute="employee">
    <!-- path 属性对应html表单标签的name属性 -->
    LastName: <form:input path="lastName"></form:input><br>
    Email:<form:input path="email"></form:input><br>
    <%
        Map<String, String> genders = new HashMap<String, String>();
        genders.put("1", "male");
        genders.put("0", "female");
        request.setAttribute("genders", genders);
    %>
    Gender:<form:radiobuttons path="gender" items="${genders }"/><br>
    Department:<form:select path="department.id" items="${departments }" itemLabel="departmentName" itemValue="id"></form:select><br>
    <input type="submit" value="Submit"/>
 </form:form>
 
</body>
</html>