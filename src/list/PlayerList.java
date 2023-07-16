package list;

import java.util.ArrayList;
import java.util.List;

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
	private static ArrayList<Integer> playerPositionList = new ArrayList<>(List.of(0, 0, 0, 0));

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
	public static void setPlayerList(ArrayList<JLabel> playerList) {
		PlayerList.playerList = playerList;
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
	 * 해당 index에 맞는 player를 찾아 반환하는 메소드입니다.
	 * 
	 * @param index, int - 해당 list값의 인덱스
	 * @return JLabel
	 */
	public static JLabel findPlayer(int index) {
		return playerList.get(index);
	}

	/**
	 * player position list를 반환하는 메소드입니다.
	 * 
	 * @return ArrayList<Integer>
	 */
	public static ArrayList<Integer> getPlayerPositionList() {
		return playerPositionList;
	}

	/**
	 * player position list를 초기화하는 메소드입니다.
	 * 
	 * @param playerPositionList, ArrayList<Integer> - 초기화 할 list
	 */
	public static void setPlayerPositionList(ArrayList<Integer> playerPositionList) {
		PlayerList.playerPositionList = playerPositionList;
	}

	/**
	 * 해당 index에 맞는 player의 위치 값을 변경하는 메소드입니다.
	 * 
	 * @param index,    int - 변경할 플레이어 index
	 * @param position, int - 변경할 위치 값
	 */
	public static void setPlayerPosition(int index, int position) {
		PlayerList.playerPositionList.set(index, position);
	}

	/**
	 * 해당 index에 맞는 player의 위치 값을 반환하는 메소드입니다.
	 * 
	 * @param index - 위치 값 찾을 플레이어 index
	 * @return int
	 */
	public static int findPlayerPosition(int index) {
		return playerPositionList.get(index);
	}
}
