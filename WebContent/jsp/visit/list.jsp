<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>客户列表</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/zui/js/zui.min.js"></script>
<link href="${pageContext.request.contextPath }/zui/css/zui.min.css"
	rel="stylesheet">
</head>
<body>

	<b>当前位置：客户拜访管理 &gt; 客户拜访列表</b>

	<br />
	<hr />
	
	<table class="table table-hover">

		<thead>
			<tr>
				<th>拜访人</th>
				<th>拜访客户</th>
				<th>拜访地址</th>
				<th>拜访内容</th>
				<th>拜访时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody>
			<%-- <c:forEach items="${CustomerList }" var="customer">
				<tr>
					<td>${customer.custName }</td>
					<td>${customer.custLevel }</td>
					<td>${customer.custSource }</td>
					<td>${customer.custLinkman }</td>
					<td><a><i class="icon icon-pencil"></i></a>&nbsp;&nbsp; <a><i
							class="icon icon-trash"></i></td>
					</a>
				</tr>
			</c:forEach> --%>
			<s:iterator value="pageBean.list"  var="visit">
				<tr>
					<td><s:property value="#visit.visitUser.nikeName"/></td>
					<td><s:property value="#visit.visitCustomer.cname"/></td>
					<td><s:property value="#visit.visitAddress"/></td>
					<td><s:property value="#visit.visitConent"/></td>
					<td><s:property value="#visit.visitTime"/></td>
					<td>
					<a href="${pageContext.request.contextPath }/VisitAction_editVisit.action?vid=<s:property value="#visit.vid"/>"><i class="icon icon-pencil"></i></a>&nbsp;&nbsp; 
					<a href="${pageContext.request.contextPath }/VisitAction_deleteVisit.action?vid=<s:property value="#visit.vid"/>"><i class="icon icon-trash"></i></a></td>
					
				</tr>
				
			</s:iterator>
			
		</tbody>
	</table>
	<div align="center">
	<ul class="pager pager-pills" >
		
		<li class="previous <s:if test="pageBean.currentPage == 1">disabled</s:if>"><a href="${pageContext.request.contextPath }/VisitAction_findVisitByPage.action?currentPage=<s:property value="pageBean.currentPage -1"/>">上一页</a></li>
		
			<s:iterator begin="1" end="pageBean.totalPage" var="i">
			<s:if test="#i != pageBean.currentPage">
				<li><a href="${pageContext.request.contextPath }/VisitAction_findVisitByPage.action?currentPage=<s:property value="#i"/>"><s:property value="#i"/></a></li>
			</s:if>
			
			<s:if test="#i == pageBean.currentPage">
				<li class="active"><a><s:property value="#i"/></a></li>
			</s:if>
		</s:iterator>
		
		<li class="next <s:if test=" pageBean.currentPage == pageBean.totalPage">disabled</s:if>"><a href="${pageContext.request.contextPath }/VisitAction_findVisitByPage.action?currentPage=<s:property value="pageBean.currentPage +1"/>">下一页</a></li>
		
	</ul>
	</div>

</body>
</html>