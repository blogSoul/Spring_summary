package lec11.book.service;

import lec11.book.Book;
import lec11.book.dao.BookDao;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;

public class BookSearchService implements InitializingBean, DisposableBean {

	@Autowired
	private BookDao bookDao;
	
	public BookSearchService() { }
	
	public Book searchBook(String bNum) {
		Book book = bookDao.select(bNum);
		return book;
	}
	// 아래와 같이 implements InitializingBean, DisposableBean를 선언하는 방법도 존재합니다.
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("BookSearchService 빈(Bean)객체 생성 단계");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("BookSearchService 빈(Bean)객체 소멸 단계");
	}
}
