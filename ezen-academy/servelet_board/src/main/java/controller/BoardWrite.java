package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

@WebServlet("/BoardWrite")
public class BoardWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardWrite() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.sendRedirect(request.getContextPath()+"/BoardWriteForm.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		BoardDAO dbao=new BoardDAO();
		BoardBean bean = new BoardBean();
		
		bean.setWriter (request.getParameter("writer"));
		bean.setEmail (request.getParameter("email"));
		bean.setSubject (request.getParameter("subject"));
		bean.setPassword (request.getParameter("password"));
		bean.setContent (request.getParameter("content"));
		
		dbao.insertBoard(bean);
		
		
		response.sendRedirect("BoardList");
		//request.setAttribute("bean", bean);
		//request.getRequestDispatcher("BoardList.jsp").forward(request,response);
		
		
	}

}
