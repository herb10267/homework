package com.emp.model;

import org.springframework.orm.hibernate3.HibernateTemplate;
import java.util.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpHibernateDAO implements EmpDAO_interface {

	private static final String GET_ALL_STMT = "from EmpVO order by empno";

	private HibernateTemplate hibernateTemplate;    
    public void setHibernateTemplate(HibernateTemplate hibernateTemplate) { 
        this.hibernateTemplate = hibernateTemplate;
    }

	@Override
	public void insert(EmpVO empVO) {
		hibernateTemplate.saveOrUpdate(empVO);
	}

	@Override
	public void update(EmpVO empVO) {
		hibernateTemplate.update(empVO);
	}

	@Override
	public void delete(Integer empno) {
		//EmpVO empVO = (EmpVO) hibernateTemplate.get(EmpVO.class, empno);
		EmpVO empVO = new EmpVO(); //●●●去除關聯關係後，再刪除
		empVO.setEmpno(empno);
		hibernateTemplate.delete(empVO);
	}

	@Override
	public EmpVO findByPrimaryKey(Integer empno) {
		EmpVO empVO = (EmpVO) hibernateTemplate.get(EmpVO.class, empno);
		return empVO;
	}

	@Override
	public List<EmpVO> getAll() {
		List<EmpVO> list = null;
		list = hibernateTemplate.find(GET_ALL_STMT);//可封裝查詢條件,必須使用find方法.
		return list;
	}

	public static void main(String[] args) {

		//EmpHibernateDAO dao = new EmpHibernateDAO();
		//為方便一般應用程式main方的測試,所以底下的model-config1-DriverManagerDataSource.xml內部dataSource設定是採用org.springframework.jdbc.datasource.DriverManagerDataSource
		ApplicationContext context = new ClassPathXmlApplicationContext("model-config1-DriverManagerDataSource.xml");
        
        // 建立DAO物件
		EmpDAO_interface dao =(EmpDAO_interface) context.getBean("empDAO");

		//● 新增
		com.dept.model.DeptVO deptVO = new com.dept.model.DeptVO(); // 部門POJO
		deptVO.setDeptno(10);

//		EmpVO empVO1 = new EmpVO();
//		empVO1.setEname("吳永志1");
//		empVO1.setJob("MANAGER");
//		empVO1.setHiredate(java.sql.Date.valueOf("2005-01-01"));
//		empVO1.setSal(new Double(50000));
//		empVO1.setComm(new Double(500));
//		empVO1.setDeptVO(deptVO);
//		dao.insert(empVO1);



		//● 修改
//		EmpVO empVO2 = new EmpVO();
//		empVO2.setEmpno(7001);
//		empVO2.setEname("吳永志2");
//		empVO2.setJob("MANAGER2");
//		empVO2.setHiredate(java.sql.Date.valueOf("2002-01-01"));
//		empVO2.setSal(new Double(20000));
//		empVO2.setComm(new Double(200));
//		empVO2.setDeptVO(deptVO);
//		dao.update(empVO2);



		//● 刪除(小心cascade - 多方emp2.hbm.xml如果設為 cascade="all"或
		// cascade="delete"將會刪除所有相關資料-包括所屬部門與同部門的其它員工將會一併被刪除)
//		dao.delete(7014);



		//● 查詢-findByPrimaryKey (多方emp2.hbm.xml必須設為lazy="false")(優!)
//		EmpVO empVO3 = dao.findByPrimaryKey(7001);
//		System.out.print(empVO3.getEmpno() + ",");
//		System.out.print(empVO3.getEname() + ",");
//		System.out.print(empVO3.getJob() + ",");
//		System.out.print(empVO3.getHiredate() + ",");
//		System.out.print(empVO3.getSal() + ",");
//		System.out.print(empVO3.getComm() + ",");
//		// 注意以下三行的寫法 (優!)
//		System.out.print(empVO3.getDeptVO().getDeptno() + ",");
//		System.out.print(empVO3.getDeptVO().getDname() + ",");
//		System.out.print(empVO3.getDeptVO().getLoc());
//		System.out.println("\n---------------------");



		//● 查詢-getAll (多方emp2.hbm.xml必須設為lazy="false")(優!)
		List<EmpVO> list = dao.getAll();
		for (EmpVO aEmp : list) {
			System.out.print(aEmp.getEmpno() + ",");
			System.out.print(aEmp.getEname() + ",");
			System.out.print(aEmp.getJob() + ",");
			System.out.print(aEmp.getHiredate() + ",");
			System.out.print(aEmp.getSal() + ",");
			System.out.print(aEmp.getComm() + ",");
			// 注意以下三行的寫法 (優!)
			System.out.print(aEmp.getDeptVO().getDeptno() + ",");
			System.out.print(aEmp.getDeptVO().getDname() + ",");
			System.out.print(aEmp.getDeptVO().getLoc());
			System.out.println();
		}
	}
}
