<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.util.*"%>
<%@ page import="com.emp.model.*"%>

<jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" />

<html>
<head>
<title>所有部門 - listAllDept-with-Emps.jsp</title>
</head>
<body bgcolor='white'>
<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='805'>
	<tr bgcolor='orange' align='center' valign='middle' height='20'>
		<td>
		<h3>所有部門 - listAllDept-with-Emps.jsp</h3>
		<a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td>
	</tr>
</table>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<table border='0' bordercolor='#CCCCFF'>
	<c:forEach var="deptVO" items="${deptSvc.all}">
		<tr bgcolor='orange'>
			<th>部門編號</th>
			<th>部門名稱</th>
			<th>部門基地</th>
		</tr>

		<tr bgcolor='orange' align='center' valign='middle'>
			<td><font color=red><b>${deptVO.deptno}</b></font></td>
			<td>${deptVO.dname}</td>
			<td>${deptVO.loc}</td>
		</tr>

		<tr align='center' valign='middle'>
			<td colspan="3" bordercolor='#CCCCFF'>
			<table border='1' bordercolor='black' width='800'>
				<tr>
					<th>員工編號</th>
					<th>員工姓名</th>
					<th>職位</th>
					<th>雇用日期</th>
					<th>薪水</th>
					<th>獎金</th>
				</tr>

				<c:forEach var="empVO" items="${deptVO.emps}">
					<tr align='center' valign='middle' ${(empVO.empno==param.empno)
						? 'bgcolor=#CCCCFF':''}>
						<td>${empVO.empno}</td>
						<td>${empVO.ename}</td>
						<td>${empVO.job}</td>
						<td>${empVO.hiredate}</td>
						<td>${empVO.sal}</td>
						<td>${empVO.comm}</td>
					</tr>
				</c:forEach>
			</table>
			</td>
		</tr>
	</c:forEach>
</table>

</body>
</html>
