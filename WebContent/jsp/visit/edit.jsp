<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>添加客户</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.11.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/zui/js/zui.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/zui/lib/datetimepicker/datetimepicker.min.js"></script>
<link href="${pageContext.request.contextPath }/zui/css/zui.min.css"
	rel="stylesheet">
<link href="${pageContext.request.contextPath }/zui/lib/datetimepicker/datetimepicker.min.css"
	rel="stylesheet">
<script type="text/javascript">
$(function(){
	$(".form-date").datetimepicker(
			{
			    language:  "zh-CN",
			    weekStart: 1,
			    todayBtn:  1,
			    autoclose: 1,
			    todayHighlight: 1,
			    startView: 2,
			    minView: 2,
			    forceParse: 0,
			    format: "yyyy-mm-dd"
			});
	
});
</script>	

</head>
<body >
	<b>当前位置：客户拜访 &gt; 客户拜访信息修改</b>

	<br />
	<hr />


	<form class="form-inline" action="${pageContext.request.contextPath }/VisitAction_updateVisit.action" method="post">
		<input type="hidden" name="vid" value="${visit.vid}">
		<table align="center">
			<tr>
				<td>
					<div class="input-group">
						<span class="input-group-btn"><button class="btn btn-default" type="button">拜访客户</button></span> 
						<select class="form-control" name="visitCustomer.cid">
							<c:forEach items="${customerList}" var="customer">
							
								<option value="${customer.cid}" <c:if test="${customer.cid eq visit.visitCustomer.cid}">selected</c:if>>${customer.cname}</option>
							</c:forEach>
						</select>
					</div>
				</td>
				<td>
					<div class="input-group">
						<span class="input-group-btn"><button class="btn btn-default" type="button">拜访人</button></span> 
						<select class="form-control" name="visitUser.uid">
							<c:forEach items="${userList}" var="user">
								<option value="${user.uid}"  <c:if test="${user.uid eq visit.visitUser.uid}">selected</c:if>>${user.nikeName}</option>
							</c:forEach>
						</select>
					</div>
				</td>
			</tr>
			
			<tr>
				<td>
					<div class="form-group">
						<label>拜访地址:</label> <input type="text" class="form-control"
							name="visitAddress" value="${visit.visitAddress}">
					</div>
				</td>
				<td>
					<div class="form-group">
						<label>拜访内容:</label> <input type="text" class=" form-control"
							name="visitConent" value="${visit.visitConent}">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label>拜访时间:</label> <input type="text" class="form-control form-date "
							name="visitTime" value="${visit.visitTime }">
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