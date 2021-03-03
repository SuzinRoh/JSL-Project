import javax.sql.DataSource;

import org.springframework.test.context.*;
import lombok.extern.log4k.Log4j;
@Log4j

@RunWith(SprignJUnit4ClassRunner.class)
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
