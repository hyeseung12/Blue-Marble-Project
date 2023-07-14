package main;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 나라의 자세한 정보(통행료, 대지료 등)를 보여주는 패널 클래스입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 */
public class CountryDetailPanel extends JPanel {
	/**
	 * 기본 패널은 보드 이미지를 보여줍니다.
	 */
	public CountryDetailPanel() {
		CountryDetailPanel.this.add(new JLabel(new ImageIcon("./images/부루마불.png")));
	}

	/**
	 * 나라의 인덱스를 생성자에 넣어주면 인덱스에 해당하는 나라의 자세한 정보를 보여줍니다.
	 * 
	 * @param index, int
	 */
	public CountryDetailPanel(int index) {

	}
}
