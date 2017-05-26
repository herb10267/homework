package com.emp.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;

import com.dept.model.DeptService;
import com.emp.model.EmpService;
import com.emp.model.EmpVO;
import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
	private EmpVO empVO;

	public EmpVO getEmpVO() {
		return empVO;
	}

	public void setEmpVO(EmpVO empVO) {
		this.empVO = empVO;
	}

	public String add() {
		EmpService empSvc = new EmpService();
		empSvc.addEmp(empVO);
		System.out.println("資料庫 insert 成功");
		return "success";
	}
	
	public String update() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestURL = request.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		System.out.println("requestURL="+requestURL);
		
		// Perform business logic
		EmpService empSvc = new EmpService();
		empSvc.updateEmp(empVO);
		System.out.println("資料庫 update 成功");
		
		// Send the Success view
		if(requestURL.equals("/emp/listAllEmp.jsp"))
			return "success1";
		else if(requestURL.equals("/dept/listEmps_ByDeptno.jsp")){
			DeptService deptSvc = new DeptService();
			request.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(empVO.getDeptVO().getDeptno())); // 資料庫取出的list物件,存入request
			return "success2";
		}else if(requestURL.equals("/dept/listAllDept.jsp")){
			DeptService deptSvc = new DeptService();
			request.setAttribute("listEmps_ByDeptno",deptSvc.getEmpsByDeptno(empVO.getDeptVO().getDeptno())); // 資料庫取出的list物件,存入request
			return "success3";
		}else return null;
	}

}
