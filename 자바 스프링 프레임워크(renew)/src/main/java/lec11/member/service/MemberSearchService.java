package lec11.member.service;

import lec11.member.Member;
import lec11.member.dao.MemberDao;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberSearchService {

	@Autowired
	private MemberDao memberDao;
	
	public MemberSearchService() { }
	
	public Member searchMember(String mId) {
		return memberDao.select(mId);
	}
	
}