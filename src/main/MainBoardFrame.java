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
	private JPanel panel = new JPanel(new GridBagLayout());
	private JButton[] button = new JButton[24];

	public MainBoardFrame() {
		super("부루마불", 900, 900);
		drawBoardFrame(); // 보드 기본 틀 그리기
		drawBoardIcon(); // 보드 이미지 추가
		panel.setBounds(0, 0, 890, 865);
		add(panel);
	}

	/**
	 * 보드의 기본 틀을 그리는 메소드 입니다.
	 */
	public void drawBoardFrame() {
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

	/**
	 * GridBagLayout에 해당 component를 그리는 메소드입니다.
	 * 
	 * @param component, Component
	 * @param x,         int
	 * @param y,         int
	 */
	private void componentLayoutPosition(Component component, int x, int y) {
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
	public void drawBoardIcon() {
		int[] goldenKeyImgPosition = { 3, 9, 15, 21 };

		// 황금열쇠 이미지 삽입
		for (int i = 0; i < 4; i++) {
			Image goldenKeyImg = new ImageIcon("./images/황금열쇠" + i + ".png").getImage();
			Image goldenKeyNewImg = goldenKeyImg.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
			button[goldenKeyImgPosition[i]].setIcon(new ImageIcon(goldenKeyNewImg));
		}

		// 나라 및 나머지 이미지 삽입
		for (int i = 0; i < button.length; i++) {
			if (button[i].getIcon() == null) {
				Image img = new ImageIcon("./images/" + getImageFileName(i) + ".png").getImage();
				Image newimg = img.getScaledInstance(130, 130, Image.SCALE_SMOOTH);
				button[i].setIcon(new ImageIcon(newimg));
			}
		}
	}

	/**
	 * 인덱스에 따른 파일의 이름을 리턴해주는 메소드입니다.
	 * 
	 * @param index, int
	 * @return String
	 */
	private String getImageFileName(int index) {
		if (index >= 0 && index <= 6)
			return Integer.toString(6 - index);
		else if (index >= 7 && index <= 11)
			return Integer.toString(18 - index);
		else
			return Integer.toString(index);
	}

	public static void main(String[] args) {
		new MainBoardFrame().setVisible(true);
	}
}