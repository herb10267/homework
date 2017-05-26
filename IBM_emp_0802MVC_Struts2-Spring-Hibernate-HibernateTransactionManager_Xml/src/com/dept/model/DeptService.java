package com.dept.model;

import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.emp.model.EmpVO;

public class DeptService {

	private DeptDAO_interface dao;

	public DeptService() {
		//dao = new DeptHibernateDAO();
		//註1: 雖然model-config1-DriverManagerDataSource.xml也可以用
		//註2: 但為了使用連線池,以提高效能,所以底下的model-config2-JndiObjectFactoryBean.xml內部dataSource設定是採用org.springframework.jndi.JndiObjectFactoryBean
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config2-JndiObjectFactoryBean.xml");
		dao =(DeptDAO_interface) context.getBean("deptDAO");
	}

	public List<DeptVO> getAll() {
		return dao.getAll();
	}

	public DeptVO getOneDept(Integer deptno) {
		return dao.findByPrimaryKey(deptno);
	}

	public Set<EmpVO> getEmpsByDeptno(Integer deptno) {
		return dao.getEmpsByDeptno(deptno);
	}

	public void deleteDept(Integer deptno) {
		dao.delete(deptno);
	}
	
	public DeptVO addDept(String dname, String loc) {
		DeptVO deptVO = new DeptVO();
		deptVO.setDname(dname);
		deptVO.setLoc(loc);
		dao.insert(deptVO);
		return deptVO;
	}

	public DeptVO updateEmp(Integer deptno, String dname, String loc) {
		DeptVO deptVO = new DeptVO();
		deptVO.setDeptno(deptno);
		deptVO.setDname(dname);
		deptVO.setLoc(loc);
		dao.update(deptVO);
		return deptVO;
	}
}
