package lec09.service;

import lec09.WordSet;
import lec09.dao.WordDao;

import javax.annotation.Resource;

public class WordSearchServiceUseResource {
	
	@Resource
//	@Qualifier("usedDao")
	private WordDao wordDao;
	
	public WordSearchServiceUseResource() {
		
	}
	
	//@Resource
	public WordSearchServiceUseResource(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
	public WordSet searchWord(String wordKey) {
		if(verify(wordKey)) {
			return wordDao.select(wordKey);
		} else {
			System.out.println("WordKey information is available.");
		}
		
		return null;
	}
	
	public boolean verify(String wordKey){
		WordSet wordSet = wordDao.select(wordKey);
		return wordSet != null ? true : false;
	}
	
	//@Resource
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
