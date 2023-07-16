package list;

import java.util.ArrayList;

import javax.swing.JLabel;

/**
 * player를 모아놓은 리스트 클래스입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 *
 */
public class PlayerList {
	private static ArrayList<JLabel> playerList = new ArrayList<>();

	/**
	 * player list를 반환하는 메소드입니다.
	 * 
	 * @return ArrayList<JLabel>
	 */
	public static ArrayList<JLabel> getPlayerList() {
		return playerList;
	}

	/**
	 * player list를 초기화하는 메소드입니다.
	 * 
	 * @param ArrayList<JLabel> - 초기화 할 list
	 */
	public static void setPlayerList(ArrayList<JLabel> player) {
		PlayerList.playerList = player;
	}

	/**
	 * player list에 player를 추가하는 메소드입니다.
	 * 
	 * @param JLabel - 추가할 player
	 */
	public static void insertPlayer(JLabel player) {
		playerList.add(player);
	}

	/**
	 * 해당 index에 맞는 player를 찾아 반환합니다.
	 * 
	 * @param index, int - 해당 list값의 인덱스
	 * @return JLabel
	 */
	public static JLabel findPlayer(int index) {
		return playerList.get(index);
	}
}
