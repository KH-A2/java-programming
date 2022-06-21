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
		// List<Object> result = session.selectList("testMapper.test");
		// List<EmpVO> result = session.selectList("testMapper.employee");
		Map<String, Integer> data = new HashMap<String, Integer>();
		data.put("id1", 100);
		data.put("id2", 110);
		List<EmpVO> result = session.selectList("testMapper.employee", data);
		System.out.println(result);
		
		for(EmpVO d: result) {
			System.out.println(d.getEmpId() + ", " + d.getfName());
		}
	}

}










