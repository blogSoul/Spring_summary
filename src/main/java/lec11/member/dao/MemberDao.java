package lec11.member.dao;

import lec11.member.Member;

import java.util.HashMap;
import java.util.Map;

public class MemberDao {

	
	private Map<String, Member> memberDB = 
			new HashMap<String, Member>();
	
	public void insert(Member member) {
		memberDB.put(member.getmId(), member);
	}
	
	public Member select(String mId){
		return memberDB.get(mId);
		
	}
	
	public void update(Member member) {
		
	}
	
	public void delete(String mId){
		
	}
	
	public Map<String, Member> getMemberDB() {
		return memberDB;
	}
	
}
