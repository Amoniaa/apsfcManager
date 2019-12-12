package com.hpe.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hpe.pojo.Types;
import com.hpe.service.ITypesService;
import com.hpe.service.impl.TypesServiceImpl;

/**
 * Servlet implementation class TypesServlet
 */
@WebServlet("/typesServlet")
public class TypesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ITypesService typeService=new TypesServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TypesServlet() {
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
		if(action.equals("findAll")){
			//查询所有
			findAll(request, response);
		}else if(action.equals("add")){
			addTypes(request, response);
		}else if(action.equals("update")){
			update(request, response);
		}else if(action.equals("findTypeById")){
			findTypeById(request, response);
		}else if(action.equals("delete")){
			delete(request, response);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String idStr = request.getParameter("id");
		int id = Integer.parseInt(idStr);
		int result = typeService.deleteTypes(id);
		if (result == 1) {
			out.print("<script>" 
					+ "alert('删除成功');" 
					+ "window.location.href='" + request.getContextPath()+"/typesServlet?action=findAll';"
					+ "</script>");
		} else {
			out.write("<script>"
					+ "alert('删除失败');"
					+ "window.location.href='" + request.getContextPath()+"/typesServlet?action=findAll';"
					+ "</script>");	
		}
	}
	
	protected void findAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1.获取所有类别
		List<Types> types=typeService.getTypesAll();
		//2.将查询结果放到request域中
		request.setAttribute("types", types);
		//3.转发给jsp页面
		request.getRequestDispatcher("/admin/types.jsp").forward(request, response);
	}
	
	protected void addTypes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//获取name
		String name=request.getParameter("name");
		Types type=new Types();
		type.setName(name);
		int result=typeService.addTypes(type);
		if(result==1){
			out.write("<script>"
					+ "alert('恭喜你，添加成功');"
					+ "window.location.href='"+request.getContextPath()+"/typesServlet?action=findAll';"
					+ "</script>");
		}else{
			if(result==-1){
				out.write("<script>"
						+ "alert('类别名重复');"
						+ "window.location.href='"+request.getContextPath()+"/admin/type_add.jsp';"
						+ "</script>");
			}else{
				out.write("<script>"
						+ "alert('添加失败');"
						+ "window.location.href='"+request.getContextPath()+"/admin/type_add.jsp';"
						+ "</script>");
			}
		}
	}
	
	protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		//获取类别信息
		String name=request.getParameter("name");
		int id=Integer.parseInt(request.getParameter("id"));
		Types types=new Types();
		types.setId(id);
		types.setName(name);
		int result=typeService.updateTypes(types);
		if(result==1){
			out.write("<script>"
					+ "alert('恭喜你，修改成功');"
					+ "window.location.href='"+request.getContextPath()+"/typesServlet?action=findAll';"
					+ "</script>");
		}else{
			if(result==-1){
				out.write("<script>"
						+ "alert('类别名重复');"
						+ "window.location.href='"+request.getContextPath()+"/typesServlet?action=findTypeById&&id="+types.getId()+"';"
						+ "</script>");
			}else{
				out.write("<script>"
						+ "alert('修改失败');"
						+ "window.location.href='"+request.getContextPath()+"/typesServlet?action=findTypeById&&id="+types.getId()+"';"
						+ "</script>");
			}
		}
	}
	
	protected void findTypeById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取id
		int id=Integer.parseInt(request.getParameter("id"));
		Types type=typeService.getTypesById(id);
		request.setAttribute("type", type);
		request.getRequestDispatcher("/admin/type_update.jsp").forward(request, response);
	}
	
}
