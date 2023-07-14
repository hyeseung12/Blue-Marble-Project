package common;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import list.ButtonList;

/**
 * LinePanel클래스의 공통 부분을 모아놓은 클래스입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 */
public class CommonPanel {
	public static JPanel setCountryButtonImage(int panelW, int panelH, int buttonW, int buttonH, int buttonIdx,
			int start) {
		// panel 생성
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel.setPreferredSize(new Dimension(panelW, panelH));

		// button 생성
		var buttons = new JButton[buttonIdx];
		int buttonWCopy = buttonW;
		int buttonHCopy = buttonH;

		for (var btn : buttons) {
			buttonW = buttonWCopy;
			buttonH = buttonHCopy;

			// 가장 사이드에 있는 출발지, 무인도, 사회복지기금, 우주여행 칸일때
			if (start == 0 || start == 6 || start == 12 || start == 18) {
				buttonW = 145;
				buttonH = 145;
			}

			// 이미지 크기 조정
			Image img = new ImageIcon("./images/" + (start++) + ".png").getImage().getScaledInstance(145, 145,
					java.awt.Image.SCALE_SMOOTH);
			
			// 각 버튼 생성 후 list에 해당 버튼 추가
			btn = new JButton(new ImageIcon(img));
			ButtonList.insertArr(btn);
			
			btn.setPreferredSize(new Dimension(buttonW, buttonH));
			panel.add(btn);
		}

		return panel;
	}
}
