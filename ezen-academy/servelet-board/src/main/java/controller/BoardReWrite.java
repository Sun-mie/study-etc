package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

/**
 * Servlet implementation class BoardReWrite
 */
@WebServlet("/BoardReWrite")
public class BoardReWrite extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public BoardReWrite() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//System.out.println("RE_step 번호" + re_step);
		request.setAttribute("name", request.getParameter("num").trim());
		request.setAttribute("ref", request.getParameter("ref").trim());
		request.setAttribute("re_step", request.getParameter("re_step"));
		request.setAttribute("re_level", request.getParameter("re_level"));
		
		//System.out.println("num: "+request.getParameter("num"));
		//System.out.println("ref: "+request.getParameter("ref"));
		//System.out.println("re_step: "+request.getParameter("re_step"));
		//System.out.println("re_level: "+request.getParameter("re_level"));
		
		
		request.getRequestDispatcher("BoardReWriteForm.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		BoardBean bean = new BoardBean();
		bean.setWriter((String) request.getParameter("writer"));
		bean.setEmail((String) request.getParameter("email"));
		bean.setSubject((String) request.getParameter("subject"));
		bean.setPassword((String) request.getParameter("password"));
		bean.setContent((String) request.getParameter("content"));
		bean.setRef(Integer.parseInt(request.getParameter("ref").trim()));
		bean.setRe_step(Integer.parseInt(request.getParameter("re_step").trim()));
		bean.setRe_level(Integer.parseInt(request.getParameter("re_level").trim()));
		
		BoardDAO dao = new BoardDAO();
		
		dao.reWriteBoard(bean);
		response.sendRedirect("BoardList");
	}

}
