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

@WebServlet("/BoardDelete")
public class BoardDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public BoardDelete() {
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO();
		
		int num=Integer.parseInt(request.getParameter("num").trim());
		BoardBean bean = dao.getOneUpdateBoard(num);
		request.setAttribute("bean", bean);
		request.setAttribute("num", num);
		request.getRequestDispatcher("/BoardDeleteFrom.jsp").forward(request,response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao= new BoardDAO();
		String pass=request.getParameter("password");
		
		int num = Integer.parseInt(request.getParameter("num").trim());
		
		
		String dbpass= dao.getPass(num);
		
		
		if(pass.equals(dbpass)){
			dao.deleteBoard(num);
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('해당 게시물이 삭제되었습니다.');");
			out.println("location.href='BoardList';");
			out.println("</script>");
			out.close();
			//response.sendRedirect("BoardList");
			
		}else{
			
			//BoardBean bean = dao.getOneUpdateBoard(num);
			//request.setAttribute("bean", bean);
			//request.setAttribute("num", num);
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script language='javascript'>");
			out.println("alert('패스워드가 일치하지 않습니다. 다시 확인 후 삭제해 주세요.');");
			out.println("history.back();");
			out.println("</script>");
			
			//request.getRequestDispatcher("BoardDeleteFrom.jsp").forward(request,response);
			
			out.close(); 
					
		}
	}

}
