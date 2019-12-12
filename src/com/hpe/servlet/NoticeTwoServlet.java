package com.hpe.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.pojo.NoticeRocking;
import com.hpe.service.INoticeRockingService;
import com.hpe.service.impl.NoticeRockingServiceImpl;

/**
 * Servlet implementation class NoticeTwoServlet
 */
@WebServlet("/noticeTwoServlet")
public class NoticeTwoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private INoticeRockingService noticeRockingService=new NoticeRockingServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NoticeTwoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action=request.getParameter("action");
		if(action.equals("searchNotice")){
			searchNotice(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void searchNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		NoticeRocking notice=noticeRockingService.getNoticeById(id);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/qiantai/notice.jsp").forward(request, response);
	}
	
}
