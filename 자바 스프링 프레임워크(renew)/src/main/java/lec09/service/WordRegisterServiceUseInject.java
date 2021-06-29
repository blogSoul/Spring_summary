package lec09.service;

import lec09.WordSet;
import lec09.dao.WordDao;

import javax.inject.Inject;
import javax.inject.Named;

public class WordRegisterServiceUseInject {

	@Inject
	// @Inject는 @Autowired와 흡사하다. 다만 자동 주입할 bean객체를 찾는 순서가 다를 뿐이다.
	// @Qualifier 어노테이션을 통해 명시적으로 어느 bean객체를 어느 속성에다 주입할 것인지를 명시하는 것이 좋습니다.

	@Named(value="wordDao1") // Named로 bean의 id를 구별해 의존 객체를 집어넣을 수 있습니다.
	private WordDao wordDao;
	
	public WordRegisterServiceUseInject() {
		
	}
	
//	@Inject
	public WordRegisterServiceUseInject(WordDao wordDao) {
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
	
//	@Inject
	public void setWordDao(WordDao wordDao) {
		this.wordDao = wordDao;
	}
	
}
