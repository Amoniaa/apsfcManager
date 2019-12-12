package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.pojo.MenusInfo;
import com.hpe.service.IMenusService;
import com.hpe.service.impl.MenusServiceImpl;

/**
 * Servlet implementation class MenusTwoServlet
 */
@WebServlet("/menusTwoServlet")
public class MenusTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMenusService menusService=new MenusServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenusTwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求转码
		request.setCharacterEncoding("utf-8");
		//相应转码
		response.setContentType("text/html;charset=utf-8");
		//获取请求参数action
		String action=request.getParameter("action");
		//判断action的值，来决定调用什么方法
		if(action.equals("searchMenus")){
			searchMenus(request, response);
		}else if(action.equals("searchMenusTwo")){
			searchMenusTwo(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void searchMenus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		MenusInfo menus=menusService.getMenusInfoById(id);
		request.setAttribute("menus", menus);
		request.getRequestDispatcher("/qiantai/show.jsp").forward(request, response);
	}
	
	protected void searchMenusTwo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id=Integer.parseInt(request.getParameter("id"));
		String curPage = request.getParameter("curPage");
		String menunameSearch = request.getParameter("menunameSearch");
		MenusInfo menus=menusService.getMenusInfoById(id);
		request.setAttribute("menus", menus);
		request.setAttribute("curPage", curPage);
		request.setAttribute("menuname", menunameSearch);
		request.getRequestDispatcher("/qiantai/search_show.jsp").forward(request, response);
	}

}
