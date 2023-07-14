package common;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * LinePanel클래스의 공통 부분을 모아놓은 클래스입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 */
public class CommonPanel {
	public static JPanel setCountryButtonImage(int panelW, int panelH, int buttonW, int buttonH, int buttonIdx,
			int start) {
		JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 0, 0));
		panel.setPreferredSize(new Dimension(panelW, panelH));

		var buttons = new JButton[buttonIdx];
		int buttonWCopy = buttonW;
		int buttonHCopy = buttonH;

		for (var btn : buttons) {
			buttonW = buttonWCopy;
			buttonH = buttonHCopy;

			if (start == 0 || start == 6 || start == 12 || start == 18) {
				buttonW = 145;
				buttonH = 145;
			}

			Image img = new ImageIcon("./images/" + (start++) + ".png").getImage().getScaledInstance(145, 145,
					java.awt.Image.SCALE_SMOOTH);
			btn = new JButton(new ImageIcon(img));

			btn.setPreferredSize(new Dimension(buttonW, buttonH));
			panel.add(btn);
		}

		return panel;
	}
}
