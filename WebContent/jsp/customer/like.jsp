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

	<b>当前位置：客户管理 &gt; 客户列表</b>

	<br />
	<hr />
	<form  class="form-inline" action="${pageContext.request.contextPath}/CustomerAction_findCustomerByName"  method="post" width="200px">
		<input type="hidden" name="currentPage" value="1">
		<label >客户姓名:</label> <input type="text" class="form-control"
				 name="cname" placeholder="客户姓名">
		<button class="btn " type="submit">
			<i class="icon icon-search"></i>搜索
		</button>
	</form>
	<table class="table table-hover">

		<thead>
			<tr>
				<th>客户姓名</th>
				<th>客户级别</th>
				<th>客户来源</th>
				<th>客户地址</th>
				<th>客户联系方式</th>
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
			<s:iterator value="pageBean.list"  var="customer">
				<tr>
					<td><s:property value="#customer.cname"/></td>
					<td><s:property value="#customer.clevel"/></td>
					<td><s:property value="#customer.csource"/></td>
					<td><s:property value="#customer.caddress"/></td>
					<td><s:property value="#customer.cphone"/></td>
					<td>
					<a href="${pageContext.request.contextPath }/CustomerAction_editCustomer.action?cid=<s:property value="#customer.cid"/>"><i class="icon icon-pencil"></i></a>&nbsp;&nbsp; 
					<a href="${pageContext.request.contextPath }/CustomerAction_deleteCustomer.action?cid=<s:property value="#customer.cid"/>"><i class="icon icon-trash"></i></a></td>
					
				</tr>
				
			</s:iterator>
			
		</tbody>
	</table>
	<div align="center">
	<ul class="pager pager-pills" >
		
		<li class="previous <s:if test="pageBean.currentPage == 1">disabled</s:if>"><a href="${pageContext.request.contextPath }/CustomerAction_findCustomerByName.action?currentPage=<s:property value="pageBean.currentPage -1"/>&cname=${cname}">上一页</a></li>
		
			<s:iterator begin="1" end="pageBean.totalPage" var="i">
			<s:if test="#i != pageBean.currentPage">
				<li><a href="${pageContext.request.contextPath }/CustomerAction_findCustomerByName.action?currentPage=<s:property value="#i"/>&cname=${cname}"><s:property value="#i"/></a></li>
			</s:if>
			
			<s:if test="#i == pageBean.currentPage">
				<li class="active"><a><s:property value="#i"/></a></li>
			</s:if>
		</s:iterator>
		
		<li class="next <s:if test=" pageBean.currentPage == pageBean.totalPage">disabled</s:if>"><a href="${pageContext.request.contextPath }/CustomerAction_findCustomerByName.action?currentPage=<s:property value="pageBean.currentPage +1"/>&cname=${cname}">下一页</a></li>
		
	</ul>
	</div>

</body>
</html>