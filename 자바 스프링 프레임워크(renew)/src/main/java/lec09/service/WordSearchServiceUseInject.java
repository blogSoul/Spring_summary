package lec09.service;

import lec09.WordSet;
import lec09.dao.WordDao;

import javax.inject.Inject;
import javax.inject.Named;

public class WordSearchServiceUseInject {
	
	@Inject
	@Named(value="wordDao1") // Named로 bean의 id를 구별해 의존 객체를 집어넣을 수 있습니다.
	private WordDao wordDao;
	
	public WordSearchServiceUseInject() {
		
	}
	
//	@Inject
	public WordSearchServiceUseInject(WordDao wordDao) {
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
	
//	@Inject
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
