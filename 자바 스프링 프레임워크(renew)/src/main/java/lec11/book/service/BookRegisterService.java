package lec11.book.service;

import lec11.book.Book;
import lec11.book.dao.BookDao;
import org.springframework.beans.factory.annotation.Autowired;

public class BookRegisterService{

	@Autowired
	private BookDao bookDao;
	
	public BookRegisterService() { }
	
	public void register(Book book) {
		bookDao.insert(book);
	}
	// 아래와 같이 메소드를 선언하는 방법도 존재합니다.
	// Ex) <bean id="bookRegisterService" class="lec11.book.service.BookRegisterService"
	//		  init-method="initMethod" destroy-method="destroyMethod"/>
	public void initMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 생성 단계");
	}
	
	public void destroyMethod() {
		System.out.println("BookRegisterService 빈(Bean)객체 소멸 단계");
	}
}