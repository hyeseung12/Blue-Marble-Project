package main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import common.CommonFrame;

/**
 * 메인 게임 보드를 그리는 클래스입니다.
 * 
 * @version 1.0
 * @author MsEmily1020
 *
 */
public class MainBoardFrame extends CommonFrame {
	JPanel panel = new JPanel(new GridBagLayout());

	public MainBoardFrame() {
		super("부루마불", 900, 900);
		drawCountryBoard();
		panel.setBounds(0, 0, 890, 865);
		add(panel);
	}

	/**
	 * 보드의 기본 틀을 그리는 메소드 입니다.
	 */
	public void drawCountryBoard() {
		JButton[] button = new JButton[24];
		for (int i = 6; i >= 0; i--) {
			button[i] = new JButton(String.valueOf(6 - i + 1));
			componentLayoutPosition(button[i], i, 8);
		}

		for (int i = 11; i > 6; i--) {
			button[i] = new JButton(String.valueOf(11 - i + 8));
			componentLayoutPosition(button[i], 0, i - 4);
		}

		for (int i = 12; i < 19; i++) {
			button[i] = new JButton(String.valueOf(i + 1));
			componentLayoutPosition(button[i], i - 12, 2);
		}

		for (int i = 19; i < button.length; i++) {
			button[i] = new JButton(String.valueOf(i + 1));
			componentLayoutPosition(button[i], 6, i - 16);
		}

		for (var btn : button)
			btn.setPreferredSize(new Dimension(60, 60));
	}

	void componentLayoutPosition(Component component, int x, int y) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill=GridBagConstraints.BOTH;
		constraints.weightx=0.1;
		constraints.weighty=0.1;
		constraints.gridx = x;
		constraints.gridy = y;
		panel.add(component, constraints);
	}

	public static void main(String[] args) {
		new MainBoardFrame().setVisible(true);
	}
}
