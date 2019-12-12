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

import com.hpe.pojo.Ours;
import com.hpe.service.IOursService;
import com.hpe.service.impl.OursServiceImpl;

/**
 * Servlet implementation class OursServlet
 */
@WebServlet("/oursServlet")
public class OursServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IOursService oursService = new OursServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OursServlet() {
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
		}else if(action.equals("findOur")) {
			findOur(request, response);
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
		Ours ours = new Ours(name, content, times);
		int result = oursService.updateOurs(ours);
		if(result == 1) {
			out.write("<script>"
					   + "alert('恭喜你，更新成功');"
					   + "window.location.href='"+request.getContextPath()+"/oursServlet?action=find';"
					   + "</script>");
		} else {
			out.write("<script>"
					   + "alert('更新失败');"
					   +"window.location.href='"+request.getContextPath()+"/oursServlet?action=find';"
					   + "</script>");
		}
	}
	
	protected void find(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ours ours = oursService.getOurs();
		request.setAttribute("ours", ours);
		request.getRequestDispatcher("/admin/ours.jsp").forward(request, response);
	}
	
	protected void findOur(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Ours ours = oursService.getOurs();
		request.setAttribute("ours", ours);
		request.getRequestDispatcher("/qiantai/our.jsp").forward(request, response);
	}

}
