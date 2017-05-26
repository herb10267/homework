package com.dept.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.dept.model.DeptService;
import com.emp.model.EmpService;
import com.emp.model.EmpVO;

public class DeptnoAction extends ActionSupport {
	private Integer deptno;

	public Integer getDeptno() {
		return deptno;
	}

	public void setDeptno(Integer deptno) {
		this.deptno = deptno;
	}


	public String listEmps_ByDeptno() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String action = request.getParameter("action");
		
		// Perform business logic
		DeptService deptSvc = new DeptService();
		Set<EmpVO> set = deptSvc.getEmpsByDeptno(deptno);
		request.setAttribute("listEmps_ByDeptno", set);
		
		// Send the Success view
		if ("listEmps_ByDeptno_A".equals(action))
			return "success1";              // 來自select_page.jsp的請求, 成功轉交 dept/listEmps_ByDeptno.jsp
		else if ("listEmps_ByDeptno_B".equals(action))
			return "success2";              // 來自 dept/listAllDept.jsp的請求, 成功轉交 dept/listAllDept.jsp
	    else return null;
		
	}

	public String delete_Dept() {
		// Perform business logic
		DeptService deptSvc = new DeptService();
		deptSvc.deleteDept(deptno);
		return "success";
	}

}
