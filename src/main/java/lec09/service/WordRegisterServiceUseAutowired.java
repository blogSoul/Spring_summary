package lec09.service;

import lec09.WordSet;
import lec09.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;

public class WordRegisterServiceUseAutowired {

	@Autowired
	// Autowired를 사용하기 위해선 생성자가 default로 설정되어 있어야만 합니다.
	// 주입하려고 하는 객체의 타입이 일치하는 객체를 자동으로 주입한다.

//	@Qualifier("usedDao")
	private WordDao wordDao;
	
	public WordRegisterServiceUseAutowired() {
		// TODO Auto-generated constructor stub
	}
	
//	@Autowired
	public WordRegisterServiceUseAutowired(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public void register(WordSet wordSet) {
		String wordKey = wordSet.getWordKey();
		if(verify(wordKey)) {
			wordDao.insert(wordSet);
		} else {
			System.out.println("The word has already registered.");
		}
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet == null ? true : false;
	}
	
//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
