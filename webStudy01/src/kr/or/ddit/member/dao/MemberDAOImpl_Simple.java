package kr.or.ddit.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ddit.db.ConnectionFactory;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl_Simple implements IMemberDAO{

	@Override
	public MemberVO selectMember(String mem_id) {
		MemberVO member = null;
		StringBuffer sql = new StringBuffer();
		sql.append("select                                                      ");
	    sql.append("mem_id, mem_pass, mem_name, mem_regno1,                     ");
	    sql.append("mem_regno2, to_char(mem_bir,'yyyy-mm-dd') mem_bir, mem_zip, mem_add1,                     ");
	    sql.append("mem_add2, mem_hometel, mem_comtel, mem_hp,                  ");
	    sql.append("mem_mail, mem_job, mem_like, mem_memorial, to_char(mem_memorialday,'yyyy-mm-dd') mem_memorialday, ");
	    sql.append("mem_mileage, mem_delete                                     ");
	    sql.append("from member                                                 ");
	    sql.append("where mem_id=?                                              ");
		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql.toString());) {
			pstmt.setString(1, mem_id);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				member = new MemberVO();
				// 조회된 결과(ResultSet)를 Java Object 로 변환
				member.setMem_id(rs.getString("MEM_ID"));
				member.setMem_pass(rs.getString("MEM_PASS"));
				member.setMem_name(rs.getString("MEM_NAME"));
				member.setMem_regno1(rs.getString("MEM_REGNO1"));
				member.setMem_regno2(rs.getString("MEM_REGNO2"));
				member.setMem_bir(rs.getString("MEM_BIR"));
				member.setMem_zip(rs.getString("MEM_ZIP"));
				member.setMem_add1(rs.getString("MEM_ADD1"));
				member.setMem_add2(rs.getString("MEM_ADD2"));
				member.setMem_hometel(rs.getString("MEM_HOMETEL"));
				member.setMem_comtel(rs.getString("MEM_COMTEL"));
				member.setMem_hp(rs.getString("MEM_HP"));
				member.setMem_mail(rs.getString("MEM_MAIL"));
				member.setMem_job(rs.getString("MEM_JOB"));
				member.setMem_like(rs.getString("MEM_LIKE"));
				member.setMem_memorial(rs.getString("MEM_MEMORIAL"));
				member.setMem_memorialday(rs.getString("MEM_MEMORIALDAY"));
				member.setMem_mileage(rs.getLong("MEM_MILEAGE"));
				member.setMem_delete(rs.getString("MEM_DELETE"));
			}
			return member;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	
	
}
