package test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * DB Setting 테스트 코드 작성하는 클래스입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 */
public class SettingTest {

	@Test
	@DisplayName("DB 커넥션에 성공했는지")
	void testDBConnect() throws Exception {
		Connection con = DriverManager
				.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		assertNotEquals(con, null);
	}

}
