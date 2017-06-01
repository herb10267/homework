package com.emp.model;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTemplate;
public class EmpHibernateDAO implements EmpDAO_interface{
	
	private static final String GET_ALL_STMT = "from EmpVO order by empno";
	
	private HibernateTemplate hibernateTemplate;
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Override
	public void insert(EmpVO empVO) {
		// TODO Auto-generated method stub
		hibernateTemplate.saveOrUpdate(empVO);		
	}

	@Override
	public void update(EmpVO empVO) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(empVO);
	}

	@Override
	public void delete(Integer empno) {
		// TODO Auto-generated method stub
		
		hibernateTemplate.delete(empno);
	}

	@Override
	public EmpVO findByPrimaryKey(Integer empno) {
		// TODO Auto-generated method stub
		EmpVO empVO = (EmpVO)hibernateTemplate.get(EmpVO.class, empno);
		return empVO;
	}

	@Override
	public List<EmpVO> getAll() {
		// TODO Auto-generated method stub
		List<EmpVO> list = null;
		list = (List<EmpVO>) hibernateTemplate.find(GET_ALL_STMT);
		return list;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
		
		EmpDAO_interface dao =(EmpDAO_interface) context.getBean("empDAO");
		com.dept.model.DeptVO deptVO = new com.dept.model.DeptVO(); // ³¡ªùPOJO
		deptVO.setDeptno(10);

		EmpVO empVO1 = new EmpVO();
		empVO1.setEname("§d¥Ã§Ó1");
		empVO1.setJob("MANAGER");
		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
		empVO1.setSal(new Double(50000));
		empVO1.setComm(new Double(500));
		empVO1.setDeptVO(deptVO);
		dao.insert(empVO1);
		
	}
}
