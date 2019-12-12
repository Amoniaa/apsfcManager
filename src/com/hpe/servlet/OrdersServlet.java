package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.pojo.OrdersInfo;
import com.hpe.service.IOrderService;
import com.hpe.service.impl.OrderServiceImpl;
import com.hpe.util.Page;

/**
 * Servlet implementation class OrdersServlet
 */
@WebServlet("/ordersServlet")
public class OrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IOrderService orderService = new OrderServiceImpl();
    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdersServlet() {
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
		if(action.equals("search")) {
			search(request, response);
		}else if(action.equals("infolist")) {
			infolist(request, response);
		}else if(action.equals("confirm")) {
			confirm(request, response);
		}else if(action.equals("delete")) {
			delete(request, response);
		}else if(action.equals("findSales")) {
			statistic(request, response);
		}else if(action.equals("adminSearch")) {
			adminSearch(request, response);
		} 
	}
		
	protected void search(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String menuname = request.getParameter("menuname");
		String date = request.getParameter("date");
		String curPage = request.getParameter("curPage");
		String delivery=request.getParameter("delivery");
		int curPageStr = 0;
		if(curPage == null || curPage.equals("")){
			curPageStr = 1;
		}else{
			curPageStr = Integer.parseInt(curPage);
		}
		if(delivery == null){
			delivery="-1";
		}
		//传入页码
		Page page = new Page();
		page.setCurPage(curPageStr);
		//传入搜索条件
		OrdersInfo ordersInfo = new OrdersInfo();
		ordersInfo.setUserid(Integer.parseInt(userid));
		ordersInfo.setMenuname(menuname);
		ordersInfo.setDate(date);
		ordersInfo.setDelivery(Integer.valueOf(delivery));
		//调用方法
		page = orderService.getOrderSearch(page, ordersInfo);
		request.setAttribute("page", page);
		request.setAttribute("delivery", delivery);
		request.setAttribute("orderInfo", ordersInfo);
		request.getRequestDispatcher("/qiantai/order.jsp").forward(request, response);
	}

	protected void adminSearch(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String menuname = request.getParameter("menuname");
		String date = request.getParameter("date");
		String curPage = request.getParameter("curPage");
		int curPageStr = 0;
		if(curPage == null || curPage.equals("")){
			curPageStr = 1;
		}else{
			curPageStr = Integer.parseInt(curPage);
		}
		if(userid == null || userid.equals("")){
			userid = "0";
		}
		//传入页码
		Page page = new Page();
		page.setCurPage(curPageStr);
		page.setPageNumber(6);
		//传入搜索条件
		OrdersInfo ordersInfo = new OrdersInfo();
		ordersInfo.setUserid(Integer.parseInt(userid));
		ordersInfo.setMenuname(menuname);
		ordersInfo.setDate(date);
		ordersInfo.setDelivery(-1);
		//调用方法
		page = orderService.getOrderSearch(page, ordersInfo);
		request.setAttribute("page", page);
		request.setAttribute("orderInfo", ordersInfo);
		request.getRequestDispatcher("/admin/order_search.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	protected void statistic(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		List statistic = orderService.getStatistics();
		request.setAttribute("statistic", statistic);
		request.getRequestDispatcher("/admin/order_statistic.jsp").forward(request, response);
	}
	
	protected void confirm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取id
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String curPage = request.getParameter("curPage");
		// 删除id对应的项目
		int result = orderService.confirm(id);
		// 获取输出流
		PrintWriter out = response.getWriter();
		if (result == 1) { // 成功
			// 弹出对话框 跳转到查询所有界面
			out.print("<script>" 
					+ "alert('确认成功');" 
					+ "window.location.href='" + request.getContextPath()
					+ "/ordersServlet?action=infolist&&curPage=" + curPage + "';" + "</script>");
		} else { // 失败
			out.print("<script>" + "alert('确认失败');" 
					+ "window.location.href='" + request.getContextPath()
					+ "/ordersServlet?action=infolist&&curPage=" + curPage + "';" + "</script>");
		}
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取id
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		String curPage = request.getParameter("curPage");
		// 删除id对应的项目
		int result = orderService.delete(id);
		// 获取输出流
		PrintWriter out = response.getWriter();
		if (result == 1) { // 删除成功
			// 弹出对话框 跳转到查询所有界面
			out.print("<script>" + "alert('删除成功');" 
					+ "window.location.href='" + request.getContextPath()
					+ "/ordersServlet?action=infolist&&curPage="+ curPage +"';" + "</script>");
		} else { // 删除失败
			out.print("<script>" + "alert('删除失败');" 
					+ "window.location.href='" + request.getContextPath()
					+ "/ordersServlet?action=infolist&&curPage="+ curPage +"';" + "</script>");
		}
	}
	
	protected void infolist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String menuname = request.getParameter("menuname");
		String date = request.getParameter("date");
		String curPage = request.getParameter("curPage");
		int curPageStr = 0;
		if(curPage == null || curPage.equals("")){
			curPageStr = 1;
		}else{
			curPageStr = Integer.parseInt(curPage);
		}
		if(userid == null || userid.equals("")){
			userid = "0";
		}
		//传入页码
		Page page = new Page();
		page.setCurPage(curPageStr);
		page.setPageNumber(12);
		//传入搜索条件
		OrdersInfo ordersInfo = new OrdersInfo();
		ordersInfo.setUserid(Integer.parseInt(userid));
		ordersInfo.setMenuname(menuname);
		ordersInfo.setDate(date);
		ordersInfo.setDelivery(-1);
		//调用方法
		page = orderService.getOrderSearch(page, ordersInfo);
		request.setAttribute("page", page);
		request.setAttribute("orderInfo", ordersInfo);
		request.getRequestDispatcher("/admin/orders.jsp").forward(request, response);
	}
}
