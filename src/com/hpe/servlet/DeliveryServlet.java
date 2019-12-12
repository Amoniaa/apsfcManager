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

import com.hpe.pojo.Delivery;
import com.hpe.service.IDeliveryService;
import com.hpe.service.impl.DeliveryServiceImpl;

/**
 * Servlet implementation class DeliveryServlet
 */
@WebServlet("/deliveryServlet")
public class DeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IDeliveryService deliveryService = new DeliveryServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeliveryServlet() {
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
		if(action.equals("update")) {
			update(request, response);
		}else if(action.equals("find")) {
			find(request, response);
		}else if(action.equals("findDelivery")) {
			findDelivery(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		String times = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		String lunchtime = request.getParameter("lunchtime");
		String dinnertime =  request.getParameter("dinnertime");
		String phone =  request.getParameter("phone");
		String contacts =  request.getParameter("contacts");
		Delivery delivery = new Delivery(name, content, times, lunchtime, dinnertime, phone, contacts);
		int result = deliveryService.updateDelivery(delivery);
		if(result == 1) {
			out.write("<script>"
					   + "alert('恭喜你，更新成功');"
					   + "window.location.href='"+request.getContextPath()+"/deliveryServlet?action=find';"
					   + "</script>");
		} else {
			out.write("<script>"
					   + "alert('更新失败');"
					   +"window.location.href='"+request.getContextPath()+"/deliveryServlet?action=find';"
					   + "</script>");
		}
	}
	
	protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Delivery delivery = deliveryService.getDelivery();
		request.setAttribute("delivery", delivery);
		request.getRequestDispatcher("/admin/delivery.jsp").forward(request, response);
	}
	
	protected void findDelivery(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Delivery delivery = deliveryService.getDelivery();
		request.setAttribute("delivery", delivery);
		request.getRequestDispatcher("/qiantai/carry.jsp").forward(request, response);
	}

}
