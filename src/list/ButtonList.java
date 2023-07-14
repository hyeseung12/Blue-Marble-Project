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

	// list 반환
	public static ArrayList<JButton> getArr() {
		return arr;
	}

	// list 초기화
	public static void setArr(ArrayList<JButton> arr) {
		ButtonList.arr = arr;
	}

	// list에 값 추가
	public static void insertArr(JButton btn) {
		arr.add(btn);
	}

	// 해당 index에 맞는 list 값 반환
	public static JButton findButtonArr(int index) {
		return arr.get(index);
	}
}
