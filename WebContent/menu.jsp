<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户关系管理系统</title>
	<script type="text/javascript"  src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
	<script type="text/javascript"  src="${pageContext.request.contextPath }/zui/js/zui.min.js"></script>
	<link href="${pageContext.request.contextPath }/zui/css/zui.min.css" rel="stylesheet">
</head>
<body>
	<nav class="menu" data-ride="menu" style="width: 200px">
  <ul class="nav nav-primary">
   
    <li class="nav-parent">
      <a> 客户管理</a>
      <ul class="nav">
        <li><a href="${pageContext.request.contextPath }/jsp/customer/add.jsp" target="main"><i class="icon icon-plus"></i>新增客户</a></li>
        <li > <a href="${pageContext.request.contextPath }/CustomerAction_findCustomerByPage.action?currentPage=1" target="main"><i class="icon icon-table"></i>客户列表</a></li>
 
      </ul>
    </li>
    
    <li class="nav-parent">
      <a>联系人管理</a>
      <ul class="nav">
        <li><a href="${pageContext.request.contextPath}/LinkManAction_toAddLinkManPage.action" target="main"><i class="icon icon-plus"></i>新增联系人</a></li>
        <li><a href="${pageContext.request.contextPath}/LinkManAction_findLinkManByPage.action?currentPage=1" target="main""><i class="icon icon-table"></i>联系人列表</a></li>
 
      </ul>
    </li>
   
	<li class="nav-parent">
      <a href="javascript:;"><i class="icon "></i> 客户拜访管理</a>
      <ul class="nav">
        <li><a href="${pageContext.request.contextPath}/VisitAction_toAddVisitPage.action" target="main"><i class="icon icon-plus"></i>新增客户拜访</a></li>
        <li><a href="${pageContext.request.contextPath}/VisitAction_findVisitByPage.action?currentPage=1" target="main" ><i class="icon icon-table"></i>客户拜访列表</a></li>
 
      </ul>
    </li> 
    
    <li class="nav-parent">
      <a href="javascript:;"><i class="icon "></i> 综合查询</a>
      <ul class="nav">
        <li><a href="javascript:;">客户信息查询</a></li>
        <li><a href="javascript:;">联系人信息查询</a></li>
 		<li><a href="javascript:;">客户拜访记录查询</a></li>
      </ul>
    </li>
    
    <li class="nav-parent">
      <a href="javascript:;"><i class="icon "></i> 统计分析</a>
      <ul class="nav">
        <li><a href="javascript:;">客户行业统计</a></li>
        <li><a href="javascript:;">客户来源统计</a></li>
 
      </ul>
    </li>
      
    <li class="nav-parent">
      <a href="javascript:;"><i class="icon "></i> 系统管理</a>
      <ul class="nav">
        <li><a href="javascript:;">角色管理</a></li>
        <li><a href="javascript:;">用户管理</a></li>
 		<li><a href="javascript:;">数据字典</a></li>
      </ul>
    </li>  
      
  </ul>
</nav>
</body>
</html>