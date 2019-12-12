package com.hpe.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.pojo.MenusRocking;
import com.hpe.service.IMenusRockingService;
import com.hpe.service.impl.MenusRockingServiceImpl;

/**
 * Servlet implementation class MenusRockingServlet
 */
@WebServlet("/menusRockingServlet")
public class MenusRockingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMenusRockingService menusRockingService=new MenusRockingServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenusRockingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		doSum(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void doSum(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取所有类别
		List<MenusRocking> menus=menusRockingService.getRocking();
		//2.将查询结果放到request域中
		request.setAttribute("menus1", menus);
		//3.转发给jsp页面
		request.getRequestDispatcher("/qiantai/index.jsp").forward(request, response);
	}
}
