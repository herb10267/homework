<%@ page contentType="text/html; charset=UTF-8" pageEncoding="Big5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>IBM Emp: Home</title>
<s:head theme="xhtml" /><!-- 預設 -->
</head>
<body bgcolor='white'>

	<table border='1' cellpadding='5' cellspacing='0' width='400'>
		<tr bgcolor='#CCCCFF' align='center' valign='middle' height='20'>
			<td><h3>IBM Emp: Home</h3>	<font color=red>( Struts2-Spring-Hibernate  MVC )</font></td></tr></table>

	<p>This is the Home page for IBM Emp: Home</p>

	<h3>資料查詢:</h3>
	<%-- 錯誤表列 --%>
    <s:fielderror cssStyle="color: red" />

	<ul>
		<li><a href='<%=request.getContextPath()%>/emp/listAllEmp.jsp'>List</a> all Emps.</li><br>

		<li>
            <s:form action="getOne_For_DisplayEmp" namespace="/emp" theme="simple">  【<font color=blue>theme="simple"</font>】
               <b>輸入員工編號 (如7001):</b> 
                <s:textfield name="empno" />
				<s:submit	 value="送出"  method="getOne_For_Display" />
            </s:form>
		</li>

        <s:bean id="empSvc" name="com.emp.model.EmpService" />     <%-- 相當於  <jsp:useBean id="empSvc" scope="request" class="com.emp.model.EmpService" /> --%>

		<li>
			<s:form action="getOne_For_DisplayEmp" namespace="/emp" theme="simple">  【<font color=blue>theme="simple"</font>】
				<b>選擇員工編號:</b>
				<s:select name="empno" labelposition="center" list="#empSvc.all" listKey="empno" listValue="empno" /> 
				<s:submit value="送出"  method="getOne_For_Display" />
			</s:form>
		</li>
		
		<li>
			<s:form action="getOne_For_DisplayEmp" namespace="/emp" theme="simple">  【<font color=blue>theme="simple"</font>】
				<b>選擇員工姓名:</b>
				<s:select name="empno" labelposition="center" list="#empSvc.all" listKey="empno" listValue="ename" /> 
				<s:submit value="送出"  method="getOne_For_Display" />
			</s:form>
		</li>
		
        <s:bean id="deptSvc" name="com.dept.model.DeptService" />     <%-- 相當於  <jsp:useBean id="deptSvc" scope="page" class="com.dept.model.DeptService" /> --%>
		
		<li>
			<s:form action="listEmpsByDeptno" namespace="/dept" theme="simple">  【<font color=blue>theme="simple"</font>】
				<b><font color=orange>選擇部門:</font></b>
				<s:select name="deptno" labelposition="center" list="#deptSvc.all" listKey="deptno" listValue="dname" />
				<s:submit value="送出"   method="listEmps_ByDeptno" />
				<input type="hidden" name="action" value="listEmps_ByDeptno_A">
			</s:form>
		</li>
		
	</ul>


	<h3>員工管理</h3>
	
	<ul>
		<li><a href='<%=request.getContextPath()%>/emp/addEmp.jsp'>Add</a> a new Emp.</li>
	</ul>
	
	<h3><font color=orange>部門管理</font></h3>

    <ul>
        <li><a href='<%=request.getContextPath()%>/dept/listAllDept.jsp'>List</a> all Depts. </li>
    </ul>

</body>
</html>
