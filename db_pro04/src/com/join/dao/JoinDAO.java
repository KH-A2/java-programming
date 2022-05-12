package com.join.dao;

import java.io.File;
import java.sql.ResultSet;

import com.conn.db.DBConn;
import com.join.vo.JoinVO;

/*
 * 회원 가입 처리를 위해 데이터베이스에 직접 엑세스
 * 하기 위한 객체로 활용
 */
public class JoinDAO {
	private DBConn db;
	
	public JoinDAO() {
		try {
			db = new DBConn(new File(System.getProperty("user.home") + "/oracle_db.conf"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원 가입 처리를 담당
	public boolean register(JoinVO data) {
		String query = String.format(
			"INSERT INTO accounts VALUES('%s', '%s', '%s', '%c', %d, SYSDATE)"
			, data.getUserid()
			, data.getUserpw()
			, data.getUsername()
			, data.getGender()
			, data.getAge());
		try {
			int rs = db.sendInsertQuery(query);
			if(rs == 1) {
				db.commit();
				return true;
			}
			db.rollback();
			return false;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 회원 정보 수정을 담당
	public boolean update(JoinVO data) {
		String query = "UPDATE accounts"
				+ "        SET USERPW = '" + data.getUserpw() + "'"
				+ "          , USERNAME = '" + data.getUsername() + "'"
				+ "          , GENDER = '" + data.getGender() + "'"
				+ "          , AGE = " + data.getAge()
				+ "      WHERE USERID = '" + data.getUserid() + "'";
		try {
			int rs = db.sendUpdateQuery(query);
			if(rs == 1) {
				db.commit();
				return true;
			}
			db.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// 회원 정보 삭제를 담당
	public boolean remove(JoinVO data) {
		String query = "DELETE FROM accounts WHERE USERID = '" + data.getUserid() + "'";
		try {
			int rs = db.sendDeleteQuery(query);
			if(rs == 1) {
				db.commit();
				return true;
			}
			db.rollback();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	// userid 에 해당하는 회원 정보를 반환
	public JoinVO get(String userid) {
		String query = String.format("SELECT * FROM accounts WHERE USERID = '%s'", userid);
		try {
			ResultSet rs = db.sendSelectQuery(query);
			if(rs.next()) {
				JoinVO data = new JoinVO();
				data.setUserid(rs.getString("userid"));
				data.setUserpw(rs.getString("userpw"));
				data.setUsername(rs.getString("username"));
				data.setGender(rs.getString("gender").charAt(0));
				data.setAge(rs.getInt("age"));
				data.setCreateDate(rs.getDate("createdate"));
				return data;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
