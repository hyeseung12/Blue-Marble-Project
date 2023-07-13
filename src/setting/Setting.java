package setting;

import java.sql.DriverManager;

public class Setting {
	static void initDB() throws Exception {
		// 서버 연결, 파일 허용 (클라이언트 쪽)
		var con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/?serverTimezone=UTC&allowLoadLocalInfile=true", "root", "1234");
		var stmt = con.createStatement();
		
		// 파일 허용 (서버 쪽)
		stmt.execute("SET GLOBAL local_infile = 1");
		
		// 스키마 삭제
		stmt.execute("DROP SCHEMA IF EXISTS `blue-marble`");
		
		// 스키마 생성
		stmt.execute("CREATE SCHEMA `blue-marble` DEFAULT CHARACTER SET utf8 ;");
		
		// player 테이블 생성
		stmt.execute("CREATE TABLE `blue-marble`.`player` (\r\n"
				+ "  `player_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `player_name` VARCHAR(50) NULL,\r\n"
				+ "  `player_money` INT NULL,\r\n"
				+ "  PRIMARY KEY (`player_no`));\r\n"
				+ "");

		// country 테이블 생성
		stmt.execute("CREATE TABLE `blue-marble`.`country` (\r\n"
				+ "  `country_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `player_no` INT NULL,\r\n"
				+ "  `country_name` VARCHAR(100) NULL,\r\n"
				+ "  `country_price` INT NULL,\r\n"
				+ "  PRIMARY KEY (`country_no`),\r\n"
				+ "  INDEX `fk_country_player_idx` (`player_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_country_player`\r\n"
				+ "    FOREIGN KEY (`player_no`)\r\n"
				+ "    REFERENCES `blue-marble`.`player` (`player_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		// country_price_toll 테이블 생성
		stmt.execute("CREATE TABLE `blue-marble`.`country_price_toll` (\r\n"
				+ "  `country_price_toll_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `country_no` INT NULL,\r\n"
				+ "  `country_price_toll_villa` INT NULL,\r\n"
				+ "  `country_price_toll_building` INT NULL,\r\n"
				+ "  `country_price_toll_hotel` INT NULL,\r\n"
				+ "  PRIMARY KEY (`country_price_toll_no`),\r\n"
				+ "  INDEX `fk_blue-marble_country_idx` (`country_no` ASC) VISIBLE,\r\n"
				+ "  CONSTRAINT `fk_blue-marble_country`\r\n"
				+ "    FOREIGN KEY (`country_no`)\r\n"
				+ "    REFERENCES `blue-marble`.`country` (`country_no`)\r\n"
				+ "    ON DELETE CASCADE\r\n"
				+ "    ON UPDATE CASCADE);\r\n"
				+ "");
		
		stmt.execute("CREATE TABLE `blue-marble`.`golden_key` (\r\n"
				+ "  `golden_key_no` INT NOT NULL AUTO_INCREMENT,\r\n"
				+ "  `golden_key_name` VARCHAR(500) NULL,\r\n"
				+ "  `golden_key_content` VARCHAR(1000) NULL,\r\n"
				+ "  PRIMARY KEY (`golden_key_no`));\r\n"
				+ "");
		
		// 유저 삭제
		stmt.execute("DROP USER IF EXISTS 'user'@'127.0.0.1'");
		
		// 유저 생성 + 비밀번호 생성
		stmt.execute("CREATE USER 'user'@'127.0.0.1' IDENTIFIED BY '1234'");
		
		// 유저 권한 GRANT + 권한
		stmt.execute("GRANT SELECT, INSERT, UPDATE, DELETE ON `blue-marble`.* TO 'user'@'127.0.0.1'");
		
		System.out.println("사용자 생성");
		
		stmt.execute("USE `blue-marble`");
		
		// 파일 적용
		stmt.execute("LOAD DATA LOCAL INFILE 'datafiles/황금열쇠.txt'"
				+ " INTO TABLE `blue-marble`.`golden_key`"
				+ " LINES TERMINATED BY '\\r\n'"
				+ " IGNORE 1 LINES");
		
	}
	
	public static void main(String[] args) {
		try {
			initDB();
			System.out.println("세팅 성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
