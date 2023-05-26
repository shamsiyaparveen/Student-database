<%@page import="java.util.List"%>
<%@page import="dto.StudentDto"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%StudentDto studentDto=(StudentDto)request.getAttribute("studentDto");
%>
<div style="background-color:cyan">
<table border="1">
<tr> 
<th>Id</th><th>Name</th><th>Email</th><th>Mobile</th><th>Password</th><th>Delete</th><th>Edit</th>
</tr>
<th><%=studentDto.getId() %></th><th><%=studentDto.getName() %></th><th><%=studentDto.getEmail() %></th><th><%=studentDto.getMobile() %></th><th><%=studentDto.getPassword() %></th>
<th><a href="delete?id=<%=studentDto.getId() %>"><button>Delete</button></a></th>
<th><a href="Edit.jsp?id=<%=studentDto.getId() %>"><button>Edit</button></a></th>
</table>

</div>

<%List<StudentDto>list=(List<StudentDto>)request.getAttribute("list"); %>
<div style="background-color:pink">
<table border="1">
<tr>
<th>Id</th><th>Name</th><th>Email</th><th>Mobile</th><th>Password</th><th>Delete</th><th>Edit</th>
</tr>
<%for(StudentDto studentDto1:list){ %>
<tr>
<th><%=studentDto1.getId() %></th><th><%=studentDto1.getName() %></th><th><%=studentDto1.getEmail() %></th><th><%=studentDto1.getMobile() %></th><th><%=studentDto1.getPassword() %></th>
<th><a href="delete?id=<%=studentDto1.getId() %>"><button>Delete</button></a></th>
<th><a href="Edit.jsp?id=<%=studentDto1.getId() %>"><button>Edit</button></a></th>
</tr>
<%} %>
</table>
</div>
</body>
</html>