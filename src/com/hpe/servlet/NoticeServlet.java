package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.pojo.Notice;
import com.hpe.service.INoticeService;
import com.hpe.service.impl.NoticeServiceImpl;

/**
 * Servlet implementation class NoticeServlet
 */
@WebServlet("/noticeServlet")
public class NoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private INoticeService noticeService = new NoticeServiceImpl();

    public NoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	private void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取所有类别
		List<Notice> notice = noticeService.getNoticeAll();
		//2.将结果放到request域中
		request.setAttribute("notice", notice);
		//3.转发给jsp界面
		request.getRequestDispatcher("/admin/notices.jsp").forward(request, response);
	}	
    
	protected void addNotice(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String content = request.getParameter("content");
		Notice notice = new Notice();
		notice.setName(name);
		notice.setContent(content);
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		notice.setTimes(df.format(new Date()));
		int result = noticeService.addNotice(notice);
		if(result == 1){
			out.write("<script>"
					+ "alert('添加成功');"
					+ "window.location.href='"+request.getContextPath()+"/noticeServlet?action=findAll';"
					+ "</script>");	
		}else {
			out.write("<script>"
					+ "alert('添加失败');"
					+ "window.location.href='"+request.getContextPath()+"/admin/notice_add.jsp';"
					+ "</script>");	
		}
		
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		int result = noticeService.deleteNotice(id);

		if (result == 1) {
			out.print("<script>" 
					+ "alert('删除成功');" 
					+ "window.location.href='" + request.getContextPath()+"/noticeServlet?action=findAll';"
					+ "</script>");
		} else {
			out.write("<script>"
					+ "alert('删除失败');"
					+ "window.location.href='" + request.getContextPath()+"/noticeServlet?action=findAll';"
					+ "</script>");	
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String action = request.getParameter("action");
		
		if(action.equals("findAll")){
			findAll(request, response);
		}else if(action.equals("add")){
			addNotice(request, response);
		}else if(action.equals("delete")){
			delete(request, response);
		}
//			else if(action.equals("update")){
//			update(request, response);
//		}else if(action.equals("delete")){
//			delete(request, response);
//		}else if(action.equals("findTypeById")){
//			findTypeById(request, response);
//		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
