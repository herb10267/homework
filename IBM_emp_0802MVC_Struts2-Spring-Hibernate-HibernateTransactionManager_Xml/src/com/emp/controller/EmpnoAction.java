package com.emp.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.dept.model.DeptService;
import com.emp.model.EmpService;
import com.emp.model.EmpVO;

public class EmpnoAction extends ActionSupport {
	private Integer empno;

	public Integer getEmpno() {
		return empno;
	}

	public void setEmpno(Integer empno) {
		this.empno = empno;
	}

	public String getOne_For_Display() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Display 成功");
			return "success";
		} else {
			super.addFieldError("empno", "查無資料");
			return "input";
		}
	}

	public String getOne_For_Update() {
		if (getOne()) {
			System.out.println("資料庫 getOne_For_Update 成功");
			return "success";
		} else {
			super.addFieldError("empno", "查無資料");  //事實上, getOne_For_Update時, 並不會發生查無資料的情況
			return "input";
		}
	}

	public boolean getOne() {
		EmpService empSvc = new EmpService();
		EmpVO empVO = empSvc.getOneEmp(empno);
		if (empVO != null) {
			HttpServletRequest request = ServletActionContext.getRequest();
			request.setAttribute("empVO", empVO);
			return true;
		} else
			return false;
	}

	public String delete() {
		HttpServletRequest request = ServletActionContext.getRequest();
		String requestURL = request.getParameter("requestURL"); // 送出刪除的來源網頁路徑: 可能為【/emp/listAllEmp.jsp】 或  【/dept/listEmps_ByDeptno.jsp】 或 【 /dept/listAllDept.jsp】
		System.out.println("requestURL="+requestURL);
		
		// Perform business logic
		EmpService empSvc = new EmpService();
		EmpVO empVO = empSvc.getOneEmp(empno);
		empSvc.deleteEmp(empno);
		System.out.println("資料庫 delete 成功");
		
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
