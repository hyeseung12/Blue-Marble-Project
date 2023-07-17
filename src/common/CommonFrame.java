package common;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;

/**
 * frame클래스가 공통적으로 가지고 있어야 할 것들을 갖고 있는 클래스입니다.
 * 
 * @version : 1.0
 * @author : MsEmily1020
 */
public class CommonFrame extends JFrame {

	static Connection con;
	static Statement stmt;

	/**
	 * DB 연결해줍니다.
	 */
	static {
		try {
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1/blue-marble?serverTimezone=UTC", "user", "1234");
			stmt = con.createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	/**
	 * JFrame을 생성해주는 CommonFrame의 생성자입니다. (extends로 상속 받았을 때 super()를 가장 먼저 불러와서 제목과
	 * 크기를 지정해줘야 합니다.)
	 * 
	 * @param title, String - Frame의 제목
	 * @param w,     int - Frame 가로 길이
	 * @param h,     int - Frame 세로 길이
	 */
	public CommonFrame(String title, int w, int h) {
		setTitle(title);
		setSize(w, h);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setLayout(null);
	}

	/**
	 * String sql로 받은 sql 쿼리문을 돌려 값을 리턴해주는 메소드입니다.
	 * 
	 * @param sql, String - 쿼리문
	 * @param Object... - 쿼리문 ?의 데이터값
	 * @return ResultSet
	 */
	public static ResultSet getRs(String sql, Object... p) {
		int pLength = p.length;
		try {
			var pst = con.prepareStatement(sql);
			for (int i = 0; i < pLength; i++) {
				pst.setObject(i + 1, p[i]);
			}

			return pst.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * String 값을 DB에 업데이트해줍니다. 해당 DB의 업데이트 generated key를 반환합니다.
	 * 
	 * @param sql, String - 쿼리문
	 * @param Object... - 쿼리문 ?의 데이터값
	 * @return ResultSet
	 */
	public static ResultSet update(String sql, Object... p) {
		int pLength = p.length;
		try {
			var pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			for (int i = 0; i < pLength; i++) {
				pst.setObject(i + 1, p[i]);
			}

			pst.executeUpdate();
			return pst.getGeneratedKeys();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 오디오 파일 생성 후 실행 시켜주는 메소드 입니다.
	 * 
	 * @param filePath, String - 오디오 파일 경로
	 * @return Clip
	 */
	public Clip audio(String filePath) {
		try {
			File file = new File(filePath);
			Clip clip = AudioSystem.getClip();
			clip.open(AudioSystem.getAudioInputStream(file));
			clip.loop(0);
			return clip;
		} catch (Exception e) {
			System.err.println("파일을 찾을 수 없습니다.");
			return null;
		}
	}
}