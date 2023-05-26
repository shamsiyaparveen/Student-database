package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
@WebServlet("/delete")
public class Delete extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException,IOException
	{
	int id =Integer.parseInt(req.getParameter("id")); 
		StudentDao studentDao=new StudentDao();
		studentDao.delete(id);

		resp.getWriter().print("<h1> Deleted succesfully</h1>");
		req.getRequestDispatcher("Home.html").include(req, resp);
}
}