package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.pojo.Admin;
import com.hpe.service.IAdminService;
import com.hpe.service.impl.AdminServiceImpl;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/adminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IAdminService adminService=new AdminServiceImpl();   
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminServlet() {
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
		if(action.equals("login")){
			//调用方法
			login(request, response);
		}else if(action.equals("logout")){
			//退出
			logout(request, response);
		}else if(action.equals("update")){
			update(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//获取用户名
		String name=request.getParameter("name");
		//获取密码
		String pwd=request.getParameter("pwd");
		//调用service方法
		Admin admin=adminService.login(name, pwd);
		//如果admin不等于空登陆成功
		if(admin!=null){
			session.setAttribute("admin", admin);
			out.write("<script>"
					+ "alert('恭喜你，登录成功');"
					+ "window.location.href='"+request.getContextPath()+"/admin/mainindex.jsp';"
					+ "</script>");
		}else{
			out.write("<script>"
					+ "alert('登录失败');"
					+ "window.location.href='"+request.getContextPath()+"/admin/login.jsp';"
					+ "</script>");
		}
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//清除session跳转登录页
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		session.removeAttribute("admin");
		out.write("<script>"
				+ "alert('恭喜你，退出成功');"
				+ "window.parent.location.href='"+request.getContextPath()+"/admin/login.jsp';"
				+ "</script>");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//获取参数	
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		int id=Integer.parseInt(request.getParameter("id"));
		Admin admin=new Admin();
		admin.setId(id);
		admin.setName(name);
		admin.setPwd(pwd);
		//调用service修改方法
		int result=adminService.updateAdmin(admin);
		if(result==1){
			session.removeAttribute("admin");
			out.write("<script>"
					+ "alert('恭喜你，修改成功');"
					+ "window.parent.location.href='"+request.getContextPath()+"/admin/login.jsp';"
					+ "</script>");
		}else{
			if(result==-1){
				out.write("<script>"
						+ "alert('用户名重复');"
						+ "window.location.href='"+request.getContextPath()+"/admin/admin_update.jsp';"
						+ "</script>");
			}else{
				out.write("<script>"
						+ "alert('修改失败');"
						+ "window.location.href='"+request.getContextPath()+"/admin/admin_update.jsp';"
						+ "</script>");
			}
		}
	}
	
}
