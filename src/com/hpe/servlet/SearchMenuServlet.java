package com.hpe.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.service.IMenusService;
import com.hpe.service.impl.MenusServiceImpl;
import com.hpe.util.Page;

/**
 * Servlet implementation class SearchMenuServlet
 */
@WebServlet("/searchMenuServlet")
public class SearchMenuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMenusService menusService=new MenusServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMenuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String menuname=request.getParameter("menuname");
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
		page = menusService.searchMenu(page, menuname);
		request.setAttribute("page", page);
		request.setAttribute("menunameSearch", menuname);
		request.getRequestDispatcher("/qiantai/search.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
