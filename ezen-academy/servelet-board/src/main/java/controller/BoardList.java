package controller;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardBean;
import model.BoardDAO;

/**
 * Servlet implementation class BoardList
 */
@WebServlet("/BoardList")
public class BoardList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//화면에 보여질 게시글의 개수
		int pageSize = 10;
		
		String pageNum = request.getParameter("pageNum");
		
		if(pageNum == null){
			pageNum = "1";
		}
		
		int count=0; 
		int number=0;
		
		int currentPage = Integer.parseInt(pageNum);
		
		BoardDAO dbao = new BoardDAO();
		
		count=dbao.getAllCount();
		
		
		int startRow = (currentPage-1)*pageSize +1; //11
		int endRow = currentPage*pageSize;
		
		Vector<BoardBean> vec = dbao.getAllBoard(startRow, endRow);
		
		number=count-(currentPage-1)*pageSize; // 한 페이지에 10개이상 들어가면 안되기에 체크하는 변수 
		
		request.setAttribute("v", vec);
		request.setAttribute("number", number);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("count", count);
		request.setAttribute("currentPage", currentPage);
		request.getRequestDispatcher("BoardList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
