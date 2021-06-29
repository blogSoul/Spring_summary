package lec12.configration;

import lec12.dao.StudentDao;
import lec12.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// Dao와 Service를 묶어줍니다.
@Configuration
public class MemberConfigDaoAndService {

	@Bean
	public StudentDao studentDao() {
		return new StudentDao();
	}
	
	@Bean
	public StudentRegisterService registerService() {
		return new StudentRegisterService(studentDao());
	}
	
	@Bean
	public StudentModifyService modifyService() {
		return new StudentModifyService(studentDao());
	}
	
	@Bean
	public StudentSelectService selectService() {
		return new StudentSelectService(studentDao());
	}
	
	@Bean
	public StudentDeleteService deleteService() {
		return new StudentDeleteService(studentDao());
	}
	
	@Bean
	public StudentAllSelectService allSelectService() {
		return new StudentAllSelectService(studentDao());
	}
	
}