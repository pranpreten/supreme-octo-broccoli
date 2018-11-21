package kr.or.ddit.member.dao;

import java.sql.SQLException;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.ibatis.sqlmap.client.SqlMapClient;

import kr.or.ddit.db.ibatis.CustomSqlMapClientBuilder;
import kr.or.ddit.vo.MemberVO;

public class MemberDAOImpl implements IMemberDAO {

	SqlMapClient SqlMapClient = CustomSqlMapClientBuilder.getSqlMapClient();
	
	@Override
	public MemberVO selectMember(String mem_id) {
		try {
			MemberVO member = (MemberVO) SqlMapClient.queryForObject("Member.selectMember", mem_id);
			return member;
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int insertMember(MemberVO member) {
		try {
			return SqlMapClient.update("Member.insertMember", member);
			
		}catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public List<MemberVO> selectMemberList() {
		try {
			List<MemberVO> memberList = SqlMapClient.queryForList("Member.selectMemberList");
			return memberList;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public int updateMember(MemberVO member) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteMember(String mem_id) {
		// TODO Auto-generated method stub
		return 0;
	}


}
