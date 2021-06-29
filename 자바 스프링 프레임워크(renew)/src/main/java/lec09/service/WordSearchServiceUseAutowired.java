package lec09.service;

import lec09.WordSet;
import lec09.dao.WordDao;
import org.springframework.beans.factory.annotation.Autowired;

public class WordSearchServiceUseAutowired {
	
	@Autowired
//	@Qualifier("usedDao") ->Autowired로 의존객체 구분해서 넣으려면 Qualifier
	// @Autowired(required = false)로 둬서 의존 객체에 대한 오류를 피할 수 있습니다.(거의 쓰는 사람 없다.)
	private WordDao wordDao;
	
	public WordSearchServiceUseAutowired() {
		// TODO Auto-generated constructor stub
	}
	
//	@Autowired
	public WordSearchServiceUseAutowired(WordDao wordDao) {
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
	
//	@Autowired
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
