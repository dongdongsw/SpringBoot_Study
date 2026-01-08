package com.sist.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmpDAO {

	private Connection conn;
	private PreparedStatement ps;
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	
	public void EmpDao(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public  void getConnection() {
		try {
			conn = DriverManager.getConnection(url,"hr", "happy");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public void  disConnection() {
		try {
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		} catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public List<EmpVO> empAllData(){
		List<EmpVO> list = new ArrayList<>();
		try {
			getConnection();
			
			String sql = "SELECT empno, ename, job, sal, TO_CHAR(hiredate, 'yyyy-mm-dd') as dbday "
					+ "FROM emp";
			ps = conn.prepareStatement(sql);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				// <resulMap>
				EmpVO vo = new EmpVO();	// <select resultType = "EmpVO">
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setSal(rs.getInt(4));
				vo.setDbday(rs.getString(5));
				
				list.add(vo);
			}
			rs.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return list;
	}
}
