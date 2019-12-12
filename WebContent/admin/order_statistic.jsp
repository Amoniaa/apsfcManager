<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

  <head>
  <base href="${pageContext.request.contextPath }/admin/">
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Home</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="robots" content="all,follow">
    <!-- Bootstrap CSS-->
    <link rel="stylesheet" href="vendor/bootstrap/css/bootstrap.min.css">
    <!-- Font Awesome CSS-->
    <link rel="stylesheet" href="vendor/font-awesome/css/font-awesome.min.css">
    <!-- Fontastic Custom icon font-->
    <link rel="stylesheet" href="css/fontastic.css">
    <!-- Google fonts - Poppins -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Poppins:300,400,700">
    <!-- theme stylesheet-->
    <link rel="stylesheet" href="css/style.default.css" id="theme-stylesheet">
    <!-- Custom stylesheet - for your changes-->
    <link rel="stylesheet" href="css/custom.css">
    <!-- Favicon-->
    <link rel="shortcut icon" href="img/favicon.ico">
    <!-- Tweaks for older IEs--><!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script><![endif]-->
  </head>
  <body>
    <div class="page">
      <!-- Main Navbar-->
      <header class="header">
        <nav class="navbar">
          <div class="container-fluid">
            <div class="navbar-holder d-flex align-items-center justify-content-between">
              <!-- Navbar Header-->
              <div class="navbar-header">
                <!-- Navbar Brand --><a href="index.html" class="navbar-brand d-none d-sm-inline-block">
                  <div class="brand-text d-none d-lg-inline-block">网上订餐管理平台</div>
                  <div class="brand-text d-none d-sm-inline-block d-lg-none"><strong>BD</strong></div></a>
                <!-- Toggle Button--><a id="toggle-btn" href="#" class="menu-btn active"><span></span><span></span><span></span></a>
              </div>
              <!-- Navbar Menu -->
              <ul class="nav-menu list-unstyled d-flex flex-md-row align-items-md-center">
                <!-- Search-->
                <li class="nav-item d-flex align-items-center"><a id="search" href="#"><i class="icon-search"></i></a></li>
                
                <!-- Logout    -->
                <li class="nav-item"><a href="${pageContext.request.contextPath }/adminServlet?action=logout" class="nav-link logout">退出<i class="fa fa-sign-out"></i></a></li>
              </ul>
            </div>
          </div>
        </nav>
      </header>
      <div class="page-content d-flex align-items-stretch"> 
        <!-- Side Navbar -->
        <nav class="side-navbar">
          <!-- Sidebar Header-->
          <div class="sidebar-header d-flex align-items-center">
            <div class="avatar"><img src="img/avatar-1.jpg" alt="..." class="img-fluid rounded-circle"></div>
            <div class="title">
              <h1 class="h4">管理员:${sessionScope.admin.name }</h1>
              <p>欢迎使用!</p>
            </div>
          </div>
          <!-- Sidebar Navidation Menus--><span class="heading">Main</span>
          <ul class="list-unstyled">
                    <li class="active"><a href="mainindex.jsp"> <i class="icon-home"></i>功能</a></li>
                    <li><a href="#exampledropdownDropdown1" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>菜单管理</a>
                      <ul id="exampledropdownDropdown1" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/menusServlet?action=findTypeAll" target="main">添加新菜单</a></li>
        				<li><a href="${pageContext.request.contextPath }/menusServlet?action=all" target="main">菜单信息列表</a></li>
                      </ul>
                    </li>
                    <li><a href="#exampledropdownDropdown2" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>菜单类别管理</a>
                      <ul id="exampledropdownDropdown2" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/admin/type_add.jsp" target="main">添加新类别</a></li>
            			<li><a href="${pageContext.request.contextPath }/typesServlet?action=findAll" target="main">类别信息列表</a></li>
                      </ul>
                    </li>
                    <li><a href="#exampledropdownDropdown3" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>公告信息管理</a>
                      <ul id="exampledropdownDropdown3" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/admin/notice_add.jsp" target="main">添加新公告</a></li>
           				<li><a href="${pageContext.request.contextPath }/noticeServlet?action=findAll" target="main">公告信息列表</a></li>
                      </ul>
                    </li>
                    <li><a href="#exampledropdownDropdown4" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>销售订单管理</a>
                      <ul id="exampledropdownDropdown4" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/ordersServlet?action=infolist" target="main">销售订单信息列表</a></li>
          				<li><a href="${pageContext.request.contextPath }/ordersServlet?action=adminSearch" target="main">销售订单查询</a></li>
          				<li><a href="${pageContext.request.contextPath }/ordersServlet?action=findSales" target="main">本日销售额统计</a></li>
                      </ul>
                    </li>
                    <li><a href="#exampledropdownDropdown5" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>辅助功能</a>
                      <ul id="exampledropdownDropdown5" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/deliveryServlet?action=find" target="main">更新配送说明</a></li>
                        <li><a href="${pageContext.request.contextPath }/oursServlet?action=find" target="main">更新关于我们</a></li>
                        <li><a href="${pageContext.request.contextPath }/boardServlet?action=find" target="main">管理留言板</a></li>
                      </ul>
                    </li>
                    
                    <li><a href="#exampledropdownDropdown7" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>预览前台</a>
                      <ul id="exampledropdownDropdown7" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/IndexServlet" target="main">预览前台</a></li>
                      </ul>
                    </li>
                    <li><a href="#exampledropdownDropdown8" aria-expanded="false" data-toggle="collapse"> <i class="icon-interface-windows"></i>账号管理</a>
                      <ul id="exampledropdownDropdown8" class="collapse list-unstyled ">
                        <li><a href="${pageContext.request.contextPath }/admin/admin_update.jsp" target="main">修改账户</a></li>
                        <li><a href="${pageContext.request.contextPath }/adminServlet?action=logout" target="main">注销退出</a></li>
                      </ul>
                    </li>
          </ul>
          <ul class="list-unstyled">
                    <li></li>
                    <li></li>
                    <li></li>
                    
        <li></li>
          </ul>
        </nav>
        <div class="content-inner">
          <!-- Page Header-->
          <header class="page-header">
            <div class="container-fluid">
              <h2 class="no-margin-bottom">销售订单管理</h2>
            </div>
          </header>
          
           <div class="col-lg-6">
					<div class="card" style="width: 1200px;">
						<div class="card-close">
							<div class="dropdown">
								<button type="button" id="closeCard4" data-toggle="dropdown"
									aria-haspopup="true" aria-expanded="false"
									class="dropdown-toggle">
									<i class="fa fa-ellipsis-v"></i>
								</button>
								<div aria-labelledby="closeCard4"
									class="dropdown-menu dropdown-menu-right has-shadow">
									<a href="#" class="dropdown-item remove"> <i
										class="fa fa-times"></i>Close
									</a><a href="#" class="dropdown-item edit"> <i
										class="fa fa-gear"></i>Edit
									</a>
								</div>
							</div>
						</div>
						<div class="card-header d-flex align-items-center">
							<h3 class="h4">本日销售额统计</h3>
						</div>
                    
                    
                    
                    <div class="table-body" >
                      <div>   
                        <table  class="table table-striped table-sm" >
                          <c:choose>
							<c:when test="${not empty requestScope.statistic}">
                          <div class="card-header d-flex align-items-center">
                      <h3 class="h4">销售订单查询结果信息列表</h3>
                    </div>
                          <thead>
                          
                            <tr>
                              <th style="text-align:center;">菜品名称</th>
                              <th style="text-align:center;">订购数量</th>
                              <th style="text-align:center;">单价</th>
                              <th style="text-align:center;">合计</th>
                              </tr>
                          </thead>
                          	<tbody>
                          <c:forEach items="${requestScope.statistic }" var="statistic">
					
							<tr>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${statistic.menuname }	</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt"><fmt:formatNumber type="number" value="${statistic.sum}" maxFractionDigits="0"/></span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt">${statistic.price }</span></td>
								<td class="line_table" align="center" width="25%"><span
									class="left_txt"><fmt:formatNumber type="number" value="${statistic.price*statistic.sum}" maxFractionDigits="0"/></span></td>
							</tr>
							<c:set var="sums" value="${sums+statistic.sum*statistic.price }"></c:set>
							</c:forEach>
							
							<tr>
								<td class="line_table" align="center" colspan="8"><span
									class="left_bt2">本日销售总额：<fmt:formatNumber type="number" value="${sums}" maxFractionDigits="0"/>元
								</span></td>
							</tr>
							</c:when>
							<c:otherwise>
								<tr>
								<td class="line_table" align="center" colspan="8" rowspan="2">
										<span class="left_bt2" style="font-size:20px">今日无订单</span>
									</td>
								</tr>
								<tr height="50px"></tr>
							</c:otherwise>
							</c:choose>

								</td>
							</tr>
							</tbody>
                        </table>
                      </div>
                    </div>
                  </div>
            
            </div>
          <!-- Dashboard Counts Section-->
          <section class="dashboard-counts no-padding-bottom"></section>
          <!-- Dashboard Header Section    -->
          <section class="dashboard-header"> </section>
          <!-- Projects Section-->
          <section class="projects no-padding-top"> </section>
          <!-- Client Section-->
          <!-- Feeds Section-->
          <!-- Updates Section                                                -->
          <!-- Page Footer-->
          <footer class="main-footer">
            <div class="container-fluid">
              <div class="row">
                <div class="col-sm-6">
                  <p>Copyright &copy; 2019.Company name All rights reserved.More Templates</p>
                </div>
                <div class="col-sm-6 text-right">
                  <p></p>
                  <!-- Please do not remove the backlink to us unless you support further theme's development at https://bootstrapious.com/donate. It is part of the license conditions. Thank you for understanding :)-->
                </div>
              </div>
            </div>
          </footer>
        </div>
      </div>
    </div>
    <!-- JavaScript files-->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="vendor/popper.js/umd/popper.min.js"> </script>
    <script src="vendor/bootstrap/js/bootstrap.min.js"></script>
    <script src="vendor/jquery.cookie/jquery.cookie.js"> </script>
    <script src="vendor/chart.js/Chart.min.js"></script>
    <script src="vendor/jquery-validation/jquery.validate.min.js"></script>
    <script src="js/charts-home.js"></script>
    <!-- Main File-->
    <script src="js/front.js"></script>
  </body>
</html>