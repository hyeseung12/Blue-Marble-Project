package list;

import java.util.ArrayList;

import javax.swing.JButton;

public class ButtonList {
	private static ArrayList<JButton> arr = new ArrayList<>();

	public static ArrayList<JButton> getArr() {
		return arr;
	}

	public void setArr(ArrayList<JButton> arr) {
		ButtonList.arr = arr;
	}
	
	public static void insertArr(JButton btn) {
		arr.add(btn);
	}
	
	public static JButton findButtonArr(int index) {
		return arr.get(index);
	}
}
