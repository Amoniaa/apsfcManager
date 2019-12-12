package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.pojo.Board;
import com.hpe.service.IBoardService;
import com.hpe.service.impl.BoardServiceImpl;
import com.hpe.util.Page;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/boardServlet")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IBoardService boardService = new BoardServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		if(action.equals("add")) {
			addBoard(request, response);
		} else if(action.equals("find")) {
			findAll(request, response);
		} else if(action.equals("delete")) {
			delete(request, response);
		} else if(action.equals("showAll")) {
			showAll(request, response);
		} else if(action.equals("show")) {
			showBoard(request, response);
		} else if(action.equals("update")) {
			updateBoard(request, response);
		} else if(action.equals("updatePre")) {
			updateBoardPre(request, response);
		} else if(action.equals("adminDelete")) {
			adminDelete(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void addBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		String times = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Board board = new Board(username, content, times);
		int result = boardService.addBoard(board);
		if(result == 1){
			out.write("<script>"
					+ "alert('恭喜你，添加留言成功');"
					+ "window.location.href='"+request.getContextPath()+"/boardServlet?action=showAll';"
					+ "</script>");	
		}else {
			out.write("<script>"
					+ "alert('添加失败');"
					+ "window.location.href='"+request.getContextPath()+"/qiantai/board_add.jsp';"
					+ "</script>");	
		}
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取当前页码
		String curPage=request.getParameter("curPage");
		int curPageStr=0;
		if(curPage==null || "".equals(curPage)){
			curPageStr=1;
		}else{
			curPageStr=Integer.parseInt(curPage);
		}
				
		//创建page
		Page page=new Page();
		page.setCurPage(curPageStr);
		page.setPageNumber(10);
		
		//调用查询方法
		page = boardService.getBoard(page);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin/board.jsp").forward(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//获取当前页码
		String curPage=request.getParameter("curPage");
		String username=request.getParameter("username");
		int curPageStr=0;
		if(curPage==null || "".equals(curPage)){
			curPageStr=1;
		}else{
			curPageStr=Integer.parseInt(curPage);
		}
		
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		int result = boardService.deleteBoard(id);
		if (result == 1) {
			out.print("<script>" 
					+ "alert('删除成功');" 
					+ "window.location.href='" + request.getContextPath()+"/boardServlet?action=show&&username="+username+"&&curPage="+curPageStr+"';"
					+ "</script>");
		} else {
			out.write("<script>"
					+ "alert('删除失败');"
					+ "window.location.href='" + request.getContextPath()+"/boardServlet?action=show&&username="+username+"&&curPage="+curPageStr+"';"
					+ "</script>");	
		}
	}
	
	protected void adminDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		//获取当前页码
		String curPage=request.getParameter("curPage");
		int curPageStr=0;
		if(curPage==null || "".equals(curPage)){
			curPageStr=1;
		}else{
			curPageStr=Integer.parseInt(curPage);
		}
		
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		int result = boardService.deleteBoard(id);
		if (result == 1) {
			out.print("<script>" 
					+ "alert('删除成功');" 
					+ "window.location.href='" + request.getContextPath()+"/boardServlet?action=find&&curPage="+curPageStr+"';"
					+ "</script>");
		} else {
			out.write("<script>"
					+ "alert('删除失败');"
					+ "window.location.href='" + request.getContextPath()+"/boardServlet?action=find&&curPage="+curPageStr+"';"
					+ "</script>");	
		}
	}
	
	protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取当前页码
		String curPage=request.getParameter("curPage");
		int curPageStr=0;
		if(curPage==null || "".equals(curPage)){
			curPageStr=1;
		}else{
			curPageStr=Integer.parseInt(curPage);
		}
				
		//创建page
		Page page=new Page();
		page.setCurPage(curPageStr);
		page.setPageNumber(10);
		
		//调用查询方法
		page = boardService.getBoard(page);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/qiantai/board.jsp").forward(request, response);
	}
	
	protected void showBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String username = request.getParameter("username");
		//获取当前页码
		String curPage=request.getParameter("curPage");
		int curPageStr=0;
		if(curPage==null || "".equals(curPage)){
			curPageStr=1;
		}else{
			curPageStr=Integer.parseInt(curPage);
		}
						
		//创建page
		Page page=new Page();
		page.setCurPage(curPageStr);
		page.setPageNumber(3);
				
		//调用查询方法
		page = boardService.getBoardByName(page, username);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/qiantai/myboard.jsp").forward(request, response);
	}
	
	protected void updateBoard(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		
		//获取当前页码
		String curPage=request.getParameter("curPage");
		int curPageStr=0;
		if(curPage==null || "".equals(curPage)){
			curPageStr=1;
		}else{
			curPageStr=Integer.parseInt(curPage);
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		String content = request.getParameter("content");
		String times = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		Board board = new Board( id, username, content, times);
		int result = boardService.updateBoard(board);
		if(result == 1){
			out.write("<script>"
					+ "alert('恭喜你，修改留言成功');"
					+ "window.location.href='"+request.getContextPath()+"/boardServlet?action=show&&username="+username+"&&curPage="+curPageStr+"';"
					+ "</script>");	
		}else {
			out.write("<script>"
					+ "alert('修改失败');"
					+ "window.location.href='"+request.getContextPath()+"/boardServlet?action=updatePre&&id="+id+"';"
					+ "</script>");	
		}
	}
	
	protected void updateBoardPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		Board board = boardService.getBoardById(id);
		request.setAttribute("board", board);
		request.getRequestDispatcher("qiantai/board_update.jsp").forward(request, response);
		
	}
}
