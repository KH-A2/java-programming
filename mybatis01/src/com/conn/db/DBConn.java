package com.conn.db;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.data.vo.EmpSelectVO;
import com.data.vo.EmpVO;
import com.data.vo.TestVO;

public class DBConn {

	public static SqlSession getSqlSession() {
		SqlSession sess = null;
		
		String config = "resources/mybatis-config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(config);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			sess = ssf.openSession(false);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return sess;
	}
	
	public static void main(String[] args) {
		SqlSession session = DBConn.getSqlSession();
		
		int res1 = session.selectOne("testMapper.test1");
		System.out.println(res1);
		
		String res2 = session.selectOne("testMapper.test2");
		System.out.println(res2);
		
		List<Map<String, Object>> res3 = session.selectList("testMapper.test3");
		for(Map<String, Object> data: res3) {
			System.out.println(data.get("EMPLOYEE_ID") + ", " + data.get("FIRST_NAME"));
		}
		
		List<EmpVO> res4 = session.selectList("testMapper.test4");
		for(EmpVO data: res4) {
			System.out.println(data.getEmpId() + ", " + data.getfName());
		}
		
		List<EmpVO> res5 = session.selectList("testMapper.test5");
		for(EmpVO data: res5) {
			System.out.println(data.getEmpId() + ", " + data.getfName());
		}
		
		for(int idx = 100; idx < 110; idx++) {
			EmpVO res6 = session.selectOne("testMapper.test6", idx);
			System.out.println(res6.getEmpId() + ", " + res6.getfName());
		}
		
		List<EmpVO> res7 = session.selectList("testMapper.test7", "Steven");
		for(EmpVO data: res7) {
			System.out.println(data.getEmpId() + ", " + data.getfName());
		}
		
		List<EmpVO> res8 = session.selectList("testMapper.test8", "on");
		for(EmpVO data: res8) {
			System.out.println(data.getEmpId() + ", " + data.getfName());
		}
		
		Map<String, Integer> mapData = new HashMap<String, Integer>();
		mapData.put("start", 100);
		mapData.put("end", 109);
		List<EmpVO> res9 = session.selectList("testMapper.test9", mapData);
		for(EmpVO data: res9) {
			System.out.println(data.getEmpId() + ", " + data.getfName());
		}
		
		EmpVO empData = new EmpVO();
		empData.setEmpId(200);
		EmpVO res10 = session.selectOne("testMapper.test10", empData);
		System.out.println(res10.getEmpId() + ", " + res10.getfName());
		
//		테스트를 위해 임시로 주석 함, 필요한 경우 주석을 제거하여 테스트 진행하면 됨
//		TestVO insertData = new TestVO();
//		insertData.setId(4); insertData.setName("test"); insertData.setToday(new java.sql.Date(new Date().getTime()));
//		
//		int res11 = session.insert("testMapper.test11", insertData);
//		session.commit();
//		System.out.println(res11 + " 개의 행이 추가 되었습니다.");
		
//		시퀸스 객체를 사용하면 동일한 id 값이 저장되었는지 확인할 필요가 없다.
//		TestVO checkData = session.selectOne("testMapper.test15", insertData.getId());
//		if(checkData == null) {
//			int res11 = session.insert("testMapper.test11", insertData);
//			System.out.println(res11 + " 개의 행이 추가 되었습니다.");
//			session.commit();
//		} else {
//			System.out.println("동일한 ID 가 존재합니다.");
//			session.rollback();
//		}
		
//		Map<String, Object> updateData = new HashMap<String, Object>();
//		updateData.put("id", 1);
//		updateData.put("name", "change");
//		int res12 = session.update("testMapper.test12",  updateData);
//		System.out.println(res12 +  " 개의 행이 업데이트 되었습니다.");
//		
//		TestVO objectData = new TestVO();
//		objectData.setId(1); objectData.setName("object");
//		int res13 = session.update("testMapper.test13",  objectData);
//		System.out.println(res13 +  " 개의 행이 업데이트 되었습니다.");
//		
//		int res14 = session.delete("testMapper.test14", 1);
//		System.out.println(res14 +  " 개의 행이 삭제 되었습니다.");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		Date stDate = null;
		Date edDate = null;
		try {
			stDate = sdf.parse("1990/01/01");
			edDate = sdf.parse("1995/12/31");
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		EmpSelectVO dynamicData = new EmpSelectVO();
		dynamicData.setSalary(10000);
		dynamicData.setStartDate(new java.sql.Date(stDate.getTime()));
		dynamicData.setEndDate(new java.sql.Date(edDate.getTime()));
		// dynamicData.setDeptId(80);
//		dynamicData.setStrStartDate("1990/01/01");
//		dynamicData.setStrEndDate("2000/12/31");
		List<EmpVO> res15 = session.selectList("testMapper.test16", dynamicData);
		System.out.println(res15.size() + "개 행 데이터가 조회되었습니다.");
	}

}










