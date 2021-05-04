package lec11.member.service;

import lec11.member.Member;
import lec11.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberRegisterService {

	@Autowired
	private MemberDao memberDao;
	
	public MemberRegisterService() { }
	
	public void register(Member member) {
		memberDao.insert(member);
	}
}
