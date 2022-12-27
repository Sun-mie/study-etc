package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

/**
 * Servlet implementation class BoardUpdate
 */
@WebServlet("/BoardUpdate")
public class BoardUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public BoardUpdate() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num=Integer.parseInt(request.getParameter("num").trim());
		BoardDAO bdao = new BoardDAO();
		BoardBean bean = bdao.getOneUpdateBoard(num);
		request.setAttribute("bean", bean);
		
		request.getRequestDispatcher("/BoardUpdateFrom.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		//System.out.println("UTF-8변환 성공");

		int num=Integer.parseInt(request.getParameter("num").trim());
		
		//System.out.println("num값 받음: "+num);
		
		BoardDAO dao = new BoardDAO();
		
		BoardBean bean = dao.getOneUpdateBoard(num);
		
		bean.setSubject((String)request.getParameter("subject"));
		bean.setContent((String)request.getParameter("content"));
		
		String pass= dao.getPass(bean.getNum());
		String passcon = (String)request.getParameter("password");
		

		if(pass.equals(passcon)){
			dao.updateBoard(bean);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('수정이 완료되었습니다.');");
			out.println("location.href='BoardList';");
			out.println("</script>");
			out.close();
			
		}else{
			
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('패스워드가 일치하지 않습니다. 다시 확인 후 수정해 주세요.');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
			
		}
		}
}
