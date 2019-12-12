package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hpe.pojo.Menus;
import com.hpe.pojo.ShoppingCart;
import com.hpe.pojo.Users;
import com.hpe.service.IMenusService;
import com.hpe.service.impl.MenusServiceImpl;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/shoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMenusService menusService=new MenusServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoppingCartServlet() {
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
		if(action.equals("add")){
			addCart(request, response);
		}else if(action.equals("delAll")){
			delAll(request, response);
		}else if(action.equals("delCart")){
			delCart(request, response);
		}else if(action.equals("addTwo")) {
			addCartTwo(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void delCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int menuid=Integer.parseInt(request.getParameter("menuid"));
		//获取购物车
		HttpSession session=request.getSession();
		List<ShoppingCart> cartList=(List<ShoppingCart>) session.getAttribute("shoppingCart");
		for(ShoppingCart cart:cartList){
			if(cart.getMenuid()==menuid){
				cartList.remove(cart);
				break;
			}
		}
		//把购物车添加到session域中
		session.setAttribute("shoppingCart", cartList);
		String curpage=request.getParameter("pageIndex");
		if(curpage==null){
			response.sendRedirect(request.getContextPath()+"/qiantai/shoppingcar.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/IndexServlet?pageIndex="+curpage);
		}
	}
	
	protected void delAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		session.removeAttribute("shoppingCart");
		String curpage=request.getParameter("pageIndex");
		if(curpage==null){
			response.sendRedirect(request.getContextPath()+"/qiantai/shoppingcar.jsp");
		}else{
			response.sendRedirect(request.getContextPath()+"/IndexServlet?pageIndex="+curpage);
		}
	}
	
	protected void addCart(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取菜品id
		int menuid=Integer.parseInt(request.getParameter("menuid"));
		String curpage=request.getParameter("pageIndex");
		//获取购物车
		HttpSession session=request.getSession();
		Users user=(Users) session.getAttribute("user");
		List<ShoppingCart> cartList=(List<ShoppingCart>) session.getAttribute("shoppingCart");
		//标识购物车是否存在
		boolean flag=false;
		//判断购物车是否存在
		if(cartList==null){
			//创建购物车
			cartList=new ArrayList<ShoppingCart>();
		}else{
			//购物车存在，判断是否有该菜品.如果有数量加1
			for(ShoppingCart cart:cartList){
				if(cart.getMenuid()==menuid&&user==null){
					cart.setSum(cart.getSum()+1);
					flag=true;
					break;
				}else if(cart.getMenuid()==menuid&&user!=null){
					cart.setSum1(cart.getSum1()+1);
					flag=true;
					break;
				}
			}
		}
		//创建一个新的菜品
		if(!flag){
			//创建购物车实例
			ShoppingCart cart=new ShoppingCart();
			Menus menus = menusService.getMenusById(menuid);
			cart.setMenuid(menuid);
			cart.setName(menus.getName());
			if (user==null) {
				//根据id查询
				cart.setSum(1);
				cart.setPrice(Float.parseFloat(menus.getPrice()));
			}else if(user!=null){
				cart.setSum1(1);
				cart.setPrice1(Float.parseFloat(menus.getPrice1()));
			}
			//把菜品信息添加到list中
			cartList.add(cart);
		}
		//把购物车添加到session域中
		session.setAttribute("shoppingCart", cartList);
		response.sendRedirect(request.getContextPath()+"/IndexServlet?pageIndex="+curpage);
		
	}
	
	protected void addCartTwo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//获取菜品id
		int menuid=Integer.parseInt(request.getParameter("menuid"));
		String curpage=request.getParameter("curPage");
		String menunameSearch = request.getParameter("menunameSearch");
		//获取购物车
		HttpSession session=request.getSession();
		Users user=(Users) session.getAttribute("user");
		List<ShoppingCart> cartList=(List<ShoppingCart>) session.getAttribute("shoppingCart");
		//标识购物车是否存在
		boolean flag=false;
		//判断购物车是否存在
		if(cartList==null){
			//创建购物车
			cartList=new ArrayList<ShoppingCart>();
		}else{
			//购物车存在，判断是否有该菜品.如果有数量加1
			for(ShoppingCart cart:cartList){
				if(cart.getMenuid()==menuid&&user==null){
					cart.setSum(cart.getSum()+1);
					flag=true;
					break;
				}else if(cart.getMenuid()==menuid&&user!=null){
					cart.setSum1(cart.getSum1()+1);
					flag=true;
					break;
				}
			}
		}
		Menus menus = null;
		//创建一个新的菜品
		if(!flag){
			//创建购物车实例
			ShoppingCart cart=new ShoppingCart();
			menus = menusService.getMenusById(menuid);
			cart.setMenuid(menuid);
			cart.setName(menus.getName());
			if (user==null) {
				//根据id查询
				cart.setSum(1);
				cart.setPrice(Float.parseFloat(menus.getPrice()));
			}else if(user!=null){
				cart.setSum1(1);
				cart.setPrice1(Float.parseFloat(menus.getPrice1()));
			}
			//把菜品信息添加到list中
			cartList.add(cart);
		}
		//把购物车添加到session域中
		session.setAttribute("shoppingCart", cartList);
		request.getRequestDispatcher("/searchMenuServlet?menuname="+menunameSearch+"&&curPage="+curpage).forward(request, response);
		
	}


}
