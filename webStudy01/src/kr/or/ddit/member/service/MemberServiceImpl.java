package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.CommonException;
import kr.or.ddit.ServiceResult;
import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class MemberServiceImpl implements IMemberService {
	// 의존 객체를 직접 생성하는 방식 : 결합력 최상
	IMemberDAO memberDAO = new MemberDAOImpl();
	
	// 아이디 중복체크 부터, 중복아니면 insert, 성공하면 ok 아니면 failed
	@Override
	public ServiceResult registMember(MemberVO member) {
		ServiceResult result = null;
		MemberVO check = memberDAO.selectMember(member.getMem_id());
		int cnt = 0;
		if(check==null) {
			cnt = memberDAO.insertMember(member);
			if(cnt>0) {
				result = ServiceResult.OK;
			}else {
				result = ServiceResult.FAILED;
			}
		}else {
			result = ServiceResult.PKDUPLICATED;
		}
		return result;
	}

	@Override
	public List<MemberVO> retrieveMemberList() {
		List<MemberVO> memberList = memberDAO.selectMemberList();
		return memberList;
	}

	@Override
	public MemberVO retrieveMember(String mem_id) {
		MemberVO member = memberDAO.selectMember(mem_id);
		if(member==null) {
			throw new CommonException();
		}else {
			return member;
		}
	}

	@Override
	public ServiceResult modifyMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ServiceResult removeMember(MemberVO member) {
		// TODO Auto-generated method stub
		return null;
	}

}
