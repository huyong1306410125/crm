<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/zui/js/zui.min.js"></script>
<link href="${pageContext.request.contextPath }/zui/css/zui.min.css"
	rel="stylesheet">
</head>
<body >
	<b>当前位置：联系人管理 &gt; 新增联系人</b>

	<br />
	<hr />


	<form class="form-inline" action="${pageContext.request.contextPath }/LinkManAction_saveLinkMan" method="post">
		<table align="center">
			<tr>
				<td colspan="2">
					<div class="input-group">
						<span class="input-group-btn"><button class="btn btn-default" type="button">所属客户</button></span> 
						<select class="form-control" name="customer.cid">
							<c:forEach items="${customerList}" var="customer">
								<option value="${customer.cid}">${customer.cname}</option>
							</c:forEach>
						</select>
					</div>
				</td>
			</tr>
			
			<tr>
				<td>
					<div class="form-group">
						<label>联系人姓名:</label> <input type="text" class="form-control"
							name="lname" placeholder="联系人姓名">
					</div>
				</td>
				<td>
					<div class="form-group">
						<label>联系人性别:</label> <input type="text" class="form-control"
							name="lgender" placeholder="联系人性别">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label>联系人电话:</label> <input type="text" class="form-control"
							name="lphone" placeholder="联系人电话">
					</div>
				</td>
				<td>
					<div class="form-group">
						<label>联系人地址:</label> <input type="text" class="form-control"
							name="laddress" placeholder="联系人地址">
					</div>
				</td>
			</tr>
			<tr>
				<td align="center">
					<button class="btn" type="submit"><i class="icon icon-save"></i>保存</button>
				</td>
				<td align="center">
					<a href="${pageContext.request.contextPath}/welcome.htm" target="main"><button class="btn" type="button"><i class="icon icon-reply"></i>返回</button></a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>