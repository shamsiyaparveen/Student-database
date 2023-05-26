<%@page import="dto.StudentDto"%>
<%@page import="dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% int id =Integer.parseInt(request.getParameter("id"));
%>
<%StudentDao studentDao=new StudentDao();
StudentDto studentDto= studentDao.fetch(id);
%>
<form action="update" method="post">
Id: <input type="text" name="id" value="<%=studentDto.getId()%>" readonly="readonly"><br>
Name: <input type="text" name="name"value="<%=studentDto.getName()%>" ><br><br>
Email: <input type="email" name="email" value="<%=studentDto.getEmail()%>"><br><br>
Mobile: <input type="number" name="mobile"value="<%=studentDto.getMobile()%>"><br><br>
Password: <input type="text" name="password" value="<%=studentDto.getPassword()
%>"><br><br>
<button type="reset">CANCEL</button><button>Update</button>
</form>

</body>
</html>