package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.pojo.Menus;
import com.hpe.pojo.Types;
import com.hpe.service.IMenusService;
import com.hpe.service.ITypesService;
import com.hpe.service.impl.MenusServiceImpl;
import com.hpe.service.impl.TypesServiceImpl;
import com.hpe.util.Page;
import com.jspsmart.upload.SmartFile;
import com.jspsmart.upload.SmartUpload;

/**
 * Servlet implementation class MenusServlet
 */
@WebServlet("/menusServlet")
public class MenusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IMenusService menusService=new MenusServiceImpl();
	private ITypesService typesService=new TypesServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MenusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//请求转码
		request.setCharacterEncoding("utf-8");
		//相应转码
		response.setContentType("text/html;charset=utf-8");
		//获取请求参数action
		String action=request.getParameter("action");
		//判断action的值，来决定调用什么方法
		if(action.equals("all")){
			MenusPage(request, response);
		}else if(action.equals("add")){
			addMenus(request, response);
		}else if(action.equals("findTypeAll")){
			findTypeAll(request, response);
		}else if(action.equals("delete")) {
			delete(request, response);
		}else if(action.equals("update")) {
			update(request, response);
		}else if(action.equals("findMenusById")){
			findMenusById(request, response);
		}else if(action.equals("updateMenusPre")){
			updateMenusPre(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void findMenusById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		Menus menu = menusService.getMenusById(id);
		request.setAttribute("menu", menu);
		request.getRequestDispatcher("/admin/menus_update.jsp").forward(request, response);
	}
	
	protected void delete(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {	
		PrintWriter out = response.getWriter();
		int curPage = Integer.parseInt(request.getParameter("curPage"));
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		int result = menusService.delete(id);
		if (result == 1) {
			out.print("<script>" 
					+ "alert('删除成功');" 
					+ "window.location.href='" + request.getContextPath()+"/menusServlet?action=all&&curPage="+curPage+"';"
					+ "</script>");
		} else {
			out.write("<script>"
					+ "alert('删除失败');"
					+ "window.location.href='" + request.getContextPath()+"/menusServlet?action=all&&curPage="+curPage+"';"
					+ "</script>");	
		}
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int curPage = Integer.parseInt(request.getParameter("curPage"));
		SmartUpload smartUpload = new SmartUpload();
		smartUpload.initialize(this.getServletConfig(), request, response);
		try {
			smartUpload.upload();
			int id=Integer.parseInt(smartUpload.getRequest().getParameter("id"));
			String name = smartUpload.getRequest().getParameter("name");
			String burden = smartUpload.getRequest().getParameter("burden");
			String price = smartUpload.getRequest().getParameter("price");
			String price1 = smartUpload.getRequest().getParameter("price1");
			String brief = smartUpload.getRequest().getParameter("brief");
			String typeid = smartUpload.getRequest().getParameter("typeid");
			SmartFile file = smartUpload.getFiles().getFile(0);
			String imgpath=null;
			if(file.getFileName().length()!=0){
				 imgpath = "img/" + file.getFileName();
			}else{
				Menus menu = menusService.getMenusById(id);
				imgpath=menu.getImgpath();
			}
			Menus menus = new Menus(id, name, typeid, burden, brief, price, price1, imgpath);

			int result = menusService.update(menus);
			if(result == 1) {
				smartUpload.save("/img");
				out.write("<script>"
						+ "alert('修改成功');"
						+ "window.location.href='"+request.getContextPath()+"/menusServlet?action=all&&curPage="+curPage+"';"
						+ "</script>");
			}else {
				out.write("<script>"
						+ "alert('修改失败');"
						+"window.location.href='"+request.getContextPath()+"/menusServlet?action=updateMenusPre&&id="+id+"&&curPage="+curPage+"';"
						+ "</script>");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	protected void MenusPage(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取当前页码
		String curPage=request.getParameter("curPage");
		int curPageStr=0;
		if(curPage==null || "".equals(curPage)){
			curPageStr=1;
		}else{
			curPageStr=Integer.parseInt(curPage);
		}
		
		//创建page
		Page page=new Page();
		page.setCurPage(curPageStr);
		page.setPageNumber(8);
		//调用查询方法
		page=menusService.getMenus(page);
		request.setAttribute("page", page);
		request.getRequestDispatcher("/admin/menu.jsp").forward(request, response);
	}
	
	protected void addMenus(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//1.创建对象
		SmartUpload smartUpload=new SmartUpload();
		//2.执行上传初始化
		smartUpload.initialize(this.getServletConfig(), request, response);
		try {
			//3.执行文件上传
			smartUpload.upload();
			//4.获取参数
			String name = smartUpload.getRequest().getParameter("name");
			String burden = smartUpload.getRequest().getParameter("burden");
			String price = smartUpload.getRequest().getParameter("price");
			String price1 = smartUpload.getRequest().getParameter("price1");
			String brief = smartUpload.getRequest().getParameter("brief");
			String typeid = smartUpload.getRequest().getParameter("typeid");
			//获取上传文件
			SmartFile file = smartUpload.getFiles().getFile(0);
			//获取文件名
			String imgpath = "img/" + file.getFileName();
			Menus menus = new Menus(name, typeid, burden, brief, price, price1, imgpath);
			int result = menusService.addMenus(menus);
			if (result == 1) {
				//5.执行保存
				smartUpload.save("/img");
				out.write("<script>" + "alert('恭喜你，添加成功');" + "window.location.href='" + request.getContextPath()
						+ "/menusServlet?action=all';" + "</script>");
			} else {
				if (result == -1) {
					out.write("<script>" + "alert('类别名重复');" + "window.location.href='" + request.getContextPath()
							+ "/menusServlet?action=findTypeAll';" + "</script>");
				} else {
					out.write("<script>" + "alert('添加失败');" + "window.location.href='" + request.getContextPath()
							+ "/menusServlet?action=findTypeAll';" + "</script>");
				}
			} 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void findTypeAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Types> list=typesService.getTypesAll();
		request.setAttribute("types", list);
		request.getRequestDispatcher("/admin/menus_add.jsp").forward(request, response);
	}
	
	protected void updateMenusPre(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Types> types = typesService.getTypesAll();
		int id=Integer.parseInt(request.getParameter("id"));
		String curPage = request.getParameter("curPage");
		Menus menus = menusService.getMenusById(id);
		request.setAttribute("types", types);
		request.setAttribute("menus", menus);
		request.setAttribute("curPage", curPage);
		request.getRequestDispatcher("/admin/menus_update.jsp").forward(request, response);
	}
}
