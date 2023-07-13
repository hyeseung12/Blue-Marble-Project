package main;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
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
	JButton[] button = new JButton[24];

	public MainBoardFrame() {
		super("부루마불", 900, 900);
		drawCountryBoard();				// 보드 기본 틀 그리기
		drawCountryIcon();				// 보드 이미지 추가
		panel.setBounds(0, 0, 890, 865);
		add(panel);
	}

	/**
	 * 보드의 기본 틀을 그리는 메소드 입니다.
	 */
	public void drawCountryBoard() {
		for (int i = 0; i < button.length; i++) {
			button[i] = new JButton();
			button[i].setPreferredSize(new Dimension(60, 60));
		}

		// 빨간색 라인 보드 그리기
		for (int i = 6; i >= 0; i--)
			componentLayoutPosition(button[i], i, 8);

		// 주황색 라인 보드 그리기
		for (int i = 11; i > 6; i--)
			componentLayoutPosition(button[i], 0, i - 4);

		// 초록색 라인 보드 그리기
		for (int i = 12; i < 19; i++)
			componentLayoutPosition(button[i], i - 12, 2);

		// 파랑색 라인 보드 그리기
		for (int i = 19; i < button.length; i++)
			componentLayoutPosition(button[i], 6, i - 16);
	}

	void componentLayoutPosition(Component component, int x, int y) {
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.BOTH;
		constraints.weightx = 0.1;
		constraints.weighty = 0.1;
		constraints.gridx = x;
		constraints.gridy = y;
		panel.add(component, constraints);
	}

	/**
	 * 보드에 이미지를 삽입하는 메소드입니다.
	 */
	public void drawCountryIcon() {
		
		// TODO : 각 사진의 프레임이 깨지는 현상 고치기
		
		// 빨간색 라인 이미지 추가
		for (int i = 6; i >= 0; i--) {
			if (i == 3) {
				Image goldenKeyImg = new ImageIcon("./images/황금열쇠1.png").getImage();
				Image goldenKeyNewImg = goldenKeyImg.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
				button[i].setIcon(new ImageIcon(goldenKeyNewImg));
			}
			
			else {
				Image img = new ImageIcon("./images/" + (6 - i) + ".png").getImage();
				Image newimg = img.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
				button[i].setIcon(new ImageIcon(newimg));
			}
		}

		// 주황색 라인 이미지 추가
		for (int i = 7; i <= 11; i++) {
			if (i == 9) {
				Image goldenKeyImg = new ImageIcon("./images/황금열쇠2.png").getImage();
				Image goldenKeyNewImg = goldenKeyImg.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
				button[i].setIcon(new ImageIcon(goldenKeyNewImg));
			}
			else {
				Image img = new ImageIcon("./images/" + (18 - i) + ".png").getImage();
				Image newimg = img.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
				button[i].setIcon(new ImageIcon(newimg));
			}
		}
		
		// 초록색 라인 이미지 추가
		for (int i = 12; i < 19; i++) {
			if (i == 15) {
				Image goldenKeyImg = new ImageIcon("./images/황금열쇠3.png").getImage();
				Image goldenKeyNewImg = goldenKeyImg.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
				button[i].setIcon(new ImageIcon(goldenKeyNewImg));
			}
			else {
				Image img = new ImageIcon("./images/" + i + ".png").getImage();
				Image newimg = img.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
				button[i].setIcon(new ImageIcon(newimg));
			}
		}

		// 파랑색 라인 이미지 추가
		for (int i = 19; i < button.length; i++) {
			if (i == 21) {
				Image goldenKeyImg = new ImageIcon("./images/황금열쇠4.png").getImage();
				Image goldenKeyNewImg = goldenKeyImg.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
				button[i].setIcon(new ImageIcon(goldenKeyNewImg));
			}
			else {
				Image img = new ImageIcon("./images/" + i + ".png").getImage();
				Image newimg = img.getScaledInstance(130, 130, java.awt.Image.SCALE_SMOOTH);
				button[i].setIcon(new ImageIcon(newimg));
			}
		}
	}

	public static void main(String[] args) {
		new MainBoardFrame().setVisible(true);
	}
}
