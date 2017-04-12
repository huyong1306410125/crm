<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<b>当前位置：客户管理 &gt; 新增客户</b>

	<br />
	<hr />


	<form class="form-inline" action="${pageContext.request.contextPath }/CustomerAction_addCustomer.action" method="post">
		<table align="center">
			<tr>
				<td>
					<div class="form-group"> 
						<label>客户姓名:</label> <input type="text" class="form-control"
							name="cname" placeholder="客户姓名">
					</div>
				</td>
			</tr>
			
			<tr>
				<td>
					<div class="form-group">
						<label>客户级别:</label> <input type="text" class="form-control"
							name="clevel" placeholder="客户级别">
					</div>
				</td>
				<td>
					<div class="form-group">
						<label>客户来源:</label> <input type="text" class="form-control"
							name="csource" placeholder="客户来源">
					</div>
				</td>
			</tr>
			<tr>
				<td>
					<div class="form-group">
						<label>客户地址:</label> <input type="text" class="form-control"
							name="caddress" placeholder="客户地址">
					</div>
				</td>
				<td>
					<div class="form-group">
						<label>联系方式:</label> <input type="text" class="form-control"
							name="cphone" placeholder="联系方式">
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