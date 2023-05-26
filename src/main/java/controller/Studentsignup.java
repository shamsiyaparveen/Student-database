package controller;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import dao.StudentDao;
import dto.StudentDto;

@WebServlet("/Studentsignup")
public class Studentsignup extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
	{
		
		
		    	 StudentDto studentDto=new StudentDto();
		    	 studentDto.setName(req.getParameter("name"));
		    	 studentDto.setEmail(req.getParameter("email"));
		    	 studentDto.setPassword(req.getParameter("password"));
		    	 studentDto.setMobile(Long.parseLong(req.getParameter("mobile")));
		    	 studentDto.setGender(req.getParameter("gender"));
		    	 StudentDao studentDao=new StudentDao();
		    	 studentDao.save(studentDto);
		    	 resp.getWriter().print("<h1> Data saved succesfully</h1>");
		    	 req.getRequestDispatcher("./login.html").include(req, resp);
		    	

		     }
	}

