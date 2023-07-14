package test;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SettingTest {

	@Test
	@DisplayName("DB 커넥션에 성공했는지")
	void testDBConnect() throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		assertNotEquals(con, null);
	}
	
}
