package country;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import common.CommonImage;
import dice.DicePanel;

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
		setLayout(new BorderLayout());

		// 이미지 패널 생성
		CommonImage img = new CommonImage(new ImageIcon("./images/부루마불.png").getImage());

		// 이미지 패널을 추가
		add(img, BorderLayout.CENTER);

		// 주사위 돌리기 버튼 생성
		JButton diceClickBtn = new JButton("주사위 돌리기");
		diceClickBtn.setBackground(Color.red);
		diceClickBtn.setForeground(Color.white);
		diceClickBtn.setBounds(210, 470, 150, 50);
		img.add(diceClickBtn);

		// 주사위 돌리기 버튼을 클릭했을 경우
		diceClickBtn.addActionListener(e -> {
			diceClickBtn.setVisible(false);
			// 주사위 패널 생성
			DicePanel dicePanel = new DicePanel();
			dicePanel.setOpaque(false); // DicePanel을 투명하게 설정
			dicePanel.setBounds(100, 210, 400, 200);

			// 주사위 패널을 이미지 패널 위에 추가
			img.add(dicePanel);
		});
	}

	/**
	 * 나라의 인덱스를 생성자에 넣어주면 인덱스에 해당하는 나라의 자세한 정보를 보여줍니다.
	 * 
	 * @param index, int - 해당 나라 인덱스
	 */
	public CountryDetailPanel(int index) {

	}
}
