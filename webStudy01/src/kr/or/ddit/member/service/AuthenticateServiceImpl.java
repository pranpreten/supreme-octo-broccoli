package kr.or.ddit.member.service;

import kr.or.ddit.ServiceResult;
import kr.or.ddit.member.dao.IMemberDAO;
import kr.or.ddit.member.dao.MemberDAOImpl;
import kr.or.ddit.vo.MemberVO;

public class AuthenticateServiceImpl implements IAuthenticateService{
	IMemberDAO memberDAO = new MemberDAOImpl();
	// 아이디가 존재 x
	// 아이디 o 비번 x
	// 성공
	
	@Override
	public Object authenticate(MemberVO member) {
		Object result = null;
		MemberVO savedMember = memberDAO.selectMember(member.getMem_id());
		if(savedMember!=null) {
			if(savedMember.getMem_pass().equals(member.getMem_pass())) {
				return savedMember;
			}else {
				result = ServiceResult.valueOf("INVALIDPASSWORD") ;
			}
		}else {
			result = ServiceResult.valueOf("PKNOTFOUND");
		}
		return result;
	}

}
