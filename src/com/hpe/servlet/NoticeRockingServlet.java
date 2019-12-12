package com.hpe.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.pojo.NoticeRocking;
import com.hpe.service.INoticeRockingService;
import com.hpe.service.impl.NoticeRockingServiceImpl;

/**
 * Servlet implementation class NoticeRockingServlet
 */
@WebServlet("/noticeRockingServlet")
public class NoticeRockingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private INoticeRockingService noticeRockingService=new NoticeRockingServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeRockingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		doNotice(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void doNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取所有类别
		List<NoticeRocking> notice=noticeRockingService.getRocking();
		//2.将查询结果放到request域中
		request.setAttribute("notice", notice);
		//3.转发给jsp页面
		request.getRequestDispatcher("/qiantai/index.jsp").forward(request, response);
	}
	
}
