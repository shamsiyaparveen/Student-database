package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.StudentDto;
@WebServlet(urlPatterns="/Login")
public class Studentlogin extends HttpServlet {
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
{
	StudentDto studentDto;
	StudentDao studentDao=new StudentDao();
	
	String email=req.getParameter("email");
	String password=req.getParameter("password");
	try{
		long mobile=Long.parseLong(email);
		studentDto=studentDao.fetch(mobile);
		
		
	}catch(NumberFormatException e){
		studentDto=studentDao.fetch(email);
	}
	if(studentDto==null){
		resp.getWriter().print("<h1>Invalid email/Mobile</h1>");
	req.getRequestDispatcher("login.html").include(req, resp);
}else{
		if(studentDto.getPassword().equals(password)){
		resp.getWriter().print("<h1>Login Succesfully</h1>");
	req.setAttribute("studentDto", studentDto);
		req.setAttribute("list",studentDao.fetch());
		
		req.getRequestDispatcher("/Success.jsp").include(req, resp);
	

		}
	else{
		resp.getWriter().print("<h1>Invalid password</h1>");
		req.getRequestDispatcher("login.html").include(req, resp);
	}
}
}
}
