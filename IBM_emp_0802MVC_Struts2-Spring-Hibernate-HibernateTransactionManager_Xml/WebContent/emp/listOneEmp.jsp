<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>員工資料 - listOneEmp.jsp</title>
<s:head theme="xhtml" /><!-- 預設 -->
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='1000'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>員工資料 - ListOneEmp.jsp</h3>
		              <a href="<%=request.getContextPath()%>/select_page.jsp"><img src="images/back1.gif" width="100" height="32" border="0">回首頁</a></td></tr></table>

	<table border='1' bordercolor='#CCCCFF' width='1000'>
		<tr>
			<th align="left">EL 或 OGNL(Object-Graph Navigation Language)</th>
			<th>員工編號</th>
			<th>員工姓名</th>
			<th>職位</th>
			<th>雇用日期</th>
			<th>薪水</th>
			<th>獎金</th>
			<th>部門</th>
		</tr>
		<tr align='center' valign='middle'>
		     <td align="left">EL</td>
		     <td>${empVO.empno}</td>
			 <td>${empVO.ename}</td>
             <td>${empVO.job}</td>
             <td>${empVO.hiredate}</td>
             <td>${empVO.sal}</td>
             <td>${empVO.comm}</td>
             <td>${empVO.deptVO.deptno}【${empVO.deptVO.dname} - ${empVO.deptVO.loc}】</td>
		</tr>
		<tr align='center' valign='middle'>
		     <td align="left">OGNL-  #request.empVO.xxx</td>
			 <td><s:property value="#request.empVO.empno" /></td>
			 <td><s:property value="#request.empVO.ename" /></td>
             <td><s:property value="#request.empVO.job" /></td>
             <td><s:property value="#request.empVO.hiredate" /></td>
             <td><s:property value="#request.empVO.sal" /></td>
             <td><s:property value="#request.empVO.comm" /></td>
             <td><s:property value="#request.empVO.deptVO.deptno" />【<s:property value="#request.empVO.deptVO.dname" /> - <s:property value="#request.empVO.deptVO.loc" />】</td>
		</tr>
	</table>

</body>
</html>
