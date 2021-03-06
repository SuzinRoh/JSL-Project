import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;
@Log4j

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/Webapp/WEB-INF/spring/root-context.xml")
public class DataSourcesTest {
	/*
	@Setter(onMethod_=@Autowired) //주입하다
	private DataSource dataSource;
	*/
	
	@Inject
	private DataSource dataSource;
	
	@Test
	public void testConnection() {
		try {
			Connection con = dataSource.getConnection();
			log.info(con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
