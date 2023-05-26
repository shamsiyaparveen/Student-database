package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.StudentDto;
@WebServlet("/update")
public class Update  extends HttpServlet{
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
{
int id =Integer.parseInt(req.getParameter("id"));
String name =req.getParameter("name");
long mobile=Long.parseLong(req.getParameter("mobile"));
String email =req.getParameter("email");
String password =req.getParameter("password");
StudentDto studentDto=new StudentDto();
studentDto.setId(id);
studentDto.setName(name);
studentDto.setEmail(email);
studentDto.setPassword(password);
studentDto.setMobile(mobile);
StudentDao studentDao=new StudentDao();
studentDao.update(studentDto);

resp.getWriter().print("<h1> Data Updated succesfully</h1>");
req.getRequestDispatcher("Home.html").include(req, resp);

}
}