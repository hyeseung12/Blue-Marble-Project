package list;

import java.util.ArrayList;

import javax.swing.JButton;

/**
 * 보드 판 버튼을 모아놓은 리스트 클래스입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 *
 */
public class ButtonList {
	private static ArrayList<JButton> arr = new ArrayList<>();

	/**
	 * 나라 button list를 반환하는 메소드입니다.
	 * 
	 * @return ArrayList<JButton>
	 */
	public static ArrayList<JButton> getArr() {
		return arr;
	}

	/**
	 * 나라 button list를 초기화하는 메소드입니다.
	 * 
	 * @param ArrayList<JButton> - 초기화 할 list
	 */
	public static void setArr(ArrayList<JButton> arr) {
		ButtonList.arr = arr;
	}

	/**
	 * 나라 button list에 버튼을 추가하는 메소드입니다.
	 * 
	 * @param JButton - 추가할 버튼
	 */
	public static void insertArr(JButton btn) {
		arr.add(btn);
	}

	/**
	 * 해당 index에 맞는 list값을 찾아 반환합니다.
	 * 
	 * @param index, int - 해당 list값의 인덱스
	 * @return JButton
	 */
	public static JButton findButtonArr(int index) {
		return arr.get(index);
	}
}
