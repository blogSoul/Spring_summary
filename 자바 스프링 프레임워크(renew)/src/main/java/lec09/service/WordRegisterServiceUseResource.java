package lec09.service;

import lec09.WordSet;
import lec09.dao.WordDao;

import javax.annotation.Resource;

public class WordRegisterServiceUseResource {

	@Resource
	// 주입하려고 하는 객체의 타입이 일치하는 객체를 자동으로 주입한다.
//	@Qualifier("usedDao")

	private WordDao wordDao;
	
	public WordRegisterServiceUseResource() {
		
	}
	
	//@Resource
	public WordRegisterServiceUseResource(WordDao wordDao) {
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
	
	//@Resource
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}