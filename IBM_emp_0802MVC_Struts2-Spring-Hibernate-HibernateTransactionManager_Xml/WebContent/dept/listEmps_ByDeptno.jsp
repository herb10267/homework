<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%-- 此頁採用 JSTL 與 EL 取值 --%>

<jsp:useBean id="listEmps_ByDeptno" scope="request" type="java.util.Set" />

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>部門員工 - listEmps_ByDeptno.jsp</title>
<s:head theme="xhtml"  /><!-- 預設 -->
</head>
<body bgcolor='white'>

<b><font color=red>此頁練習採用 EL 的寫法取值:</font></b>
<table border='1' cellpadding='5' cellspacing='0' width='800'>
	<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
		<td><h3>部門員工 - listEmps_ByDeptno.jsp</h3>
		          <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a>	</td></tr></table>

<table border='1' bordercolor='#CCCCFF' width='800'>
	<tr>
		<th>員工編號</th>
		<th>員工姓名</th>
		<th>職位</th>
		<th>雇用日期</th>
		<th>薪水</th>
		<th>獎金</th>
		<th>部門</th>
		<th>修改</th>
		<th>刪除</th>
	</tr>
	
	<c:forEach var="empVO" items="${listEmps_ByDeptno}" >
		<tr align='center' valign='middle' ${(empVO.empno==param["empVO.empno"]) ? 'bgcolor=#CCCCFF':''}><!--將修改的那一筆加入對比色而已-->
			<td>${empVO.empno}</td>
			<td>${empVO.ename}</td>
			<td>${empVO.job}</td>
			<td>${empVO.hiredate}</td>
			<td>${empVO.sal}</td>
			<td>${empVO.comm}</td>			
			<td>
	          ${empVO.deptVO.deptno}【<font color=orange>${empVO.deptVO.dname}</font> - ${empVO.deptVO.loc}】               
			</td>
			<td>
			  <s:form action="getOne_For_UpdateEmp" namespace="/emp"  method="getOne_For_Update">
			     <s:submit value="修改" />
			        <input type="hidden" name="empno" value="${empVO.empno}">
			        <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     </s:form>
			</td>
			<td>
			  <s:form action="deleteEmp" namespace="/emp"  method="delete">
			     <s:submit value="刪除" />
			        <input type="hidden" name="empno" value="${empVO.empno}">
			        <input type="hidden" name="requestURL"	value="<%=request.getServletPath()%>"><!--送出本網頁的路徑給Controller-->
			     </s:form>
			</td>
		</tr>
	</c:forEach>
</table>

<br>本網頁的路徑:<br><b>
   <font color=blue>request.getServletPath():</font> <%= request.getServletPath()%><br>
   <font color=blue>request.getRequestURI(): </font> <%= request.getRequestURI()%> </b>
</body>
</html>
