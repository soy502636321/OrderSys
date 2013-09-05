package order.hq.mail;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MailUtilTest {
	private static BeanFactory factory = new ClassPathXmlApplicationContext(
			"applicationContext-*.xml");
	
	@Test
	public void testSendMail() {
		MailUtil mailUtil = (MailUtil) factory.getBean("mailUtil");
		
	}

}
