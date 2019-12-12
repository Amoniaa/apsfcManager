package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.pojo.ShoppingCart;
import com.hpe.pojo.Users;
import com.hpe.service.IUsersService;
import com.hpe.service.impl.UsersServiceImpl;

/**
 * Servlet implementation class UserServlet
 */
@WebServlet("/usersServlet")
public class UsersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IUsersService usersService=new UsersServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UsersServlet() {
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
			login(request, response);
		}else if(action.equals("logout")){
			logout(request, response);
		}else if(action.equals("update")){
			update(request, response);
		}else if(action.equals("add")){
			addUsers(request, response);
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
		Users user=usersService.login(name, pwd);
		if(user!=null){
			session.setAttribute("user", user);
			out.write("<script>"
					+ "alert('恭喜你，登录成功');"
					+ "window.location.href='"+request.getContextPath()+"/qiantai/index.jsp';"
					+ "</script>");
			List<ShoppingCart> cartList=(List<ShoppingCart>) session.getAttribute("shoppingCart");
			session.removeAttribute("shoppingCart");
		}else{
			out.write("<script>"
					+ "alert('登录失败');"
					+ "window.location.href='"+request.getContextPath()+"/qiantai/login.jsp';"
					+ "</script>");
		}
	}

	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//清除session跳转登录页
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		session.removeAttribute("user");
		out.write("<script>"
				+ "alert('恭喜你，退出成功');"
				+ "window.parent.location.href='"+request.getContextPath()+"/qiantai/index.jsp';"
				+ "</script>");
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		//获取参数	
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String realname=request.getParameter("realname");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String card=request.getParameter("card");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String code=request.getParameter("code");
		Users user=new Users(id, name, pwd, realname, sex, age, card, address, phone, email, code, "1");
		//调用service修改方法
		int result=usersService.updateUsers(user);
		if(result==1){
			session.removeAttribute("user");
			out.write("<script>"
					+ "alert('恭喜你，修改成功');"
					+ "window.location.href='"+request.getContextPath()+"/qiantai/login.jsp';"
					+ "</script>");
		}else{
			if(result==-1){
				out.write("<script>"
						+ "alert('用户名重复');"
						+ "window.location.href='"+request.getContextPath()+"/qiantai/center.jsp';"
						+ "</script>");
			}else{
				out.write("<script>"
						+ "alert('修改失败');"
						+ "window.location.href='"+request.getContextPath()+"/qiantai/center.jsp';"
						+ "</script>");
			}
		}
	}
	
	protected void addUsers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String name=request.getParameter("name");
		String pwd=request.getParameter("pwd");
		String realname=request.getParameter("realname");
		String sex=request.getParameter("sex");
		String age=request.getParameter("age");
		String card=request.getParameter("card");
		String address=request.getParameter("address");
		String phone=request.getParameter("phone");
		String email=request.getParameter("email");
		String code=request.getParameter("code");
		if(realname == null || realname.equals("")){
			realname="暂无";
		}
		if(age == null || age.equals("")){
			age="暂无";
		}
		if(card == null || card.equals("")){
			card="暂无";
		}
		if(address == null || address.equals("")){
			address="暂无";
		}
		if(phone == null || phone.equals("")){
			phone="暂无";
		}
		if(email == null || email.equals("")){
			email="暂无";
		}
		if(code == null || code.equals("")){
			code="暂无";
		}
		Users user=new Users(1, name, pwd, realname, sex, age, card, address, phone, email, code, "1");
		int result=usersService.addUsers(user);
		if(result==1){
			out.write("<script>"
					+ "alert('恭喜你，注册成功');"
					+ "window.location.href='"+request.getContextPath()+"/qiantai/login.jsp';"
					+ "</script>");
		}else{
			if(result==-1){
				out.write("<script>"
						+ "alert('用户名重复');"
						+ "window.location.href='"+request.getContextPath()+"/qiantai/reg.jsp';"
						+ "</script>");
			}else{
				out.write("<script>"
						+ "alert('注册失败');"
						+ "window.location.href='"+request.getContextPath()+"/qiantai/reg.jsp';"
						+ "</script>");
			}
		}
	}
	
}
