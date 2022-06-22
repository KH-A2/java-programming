package com.conn.db;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.data.vo.EmpVO;

public class DBConn {

	public static SqlSession getSqlSession() {
		SqlSession sess = null;
		
		String config = "resources/mybatis-config.xml";
		try {
			InputStream is = Resources.getResourceAsStream(config);
			SqlSessionFactory ssf = new SqlSessionFactoryBuilder().build(is);
			sess = ssf.openSession();
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
	}

}










