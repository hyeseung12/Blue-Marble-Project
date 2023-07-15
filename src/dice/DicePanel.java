package dice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import list.DiceNumberList;

/**
 * 주사위를 돌릴 패널입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 */
public class DicePanel extends JPanel {
	private static JButton[] diceBtn = new JButton[2];

	public DicePanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 48, 30));

		for (int i = 0; i < diceBtn.length; i++) {
			diceBtn[i] = new JButton();
			diceBtn[i].setOpaque(true);
			diceBtn[i].setContentAreaFilled(true);
			diceBtn[i].setBorderPainted(false);
			diceBtn[i].setFocusPainted(false);
			diceBtn[i].setPreferredSize(new Dimension(100, 100));
			add(diceBtn[i]);
		}

		randomThreadDice();
	}

	/**
	 * 주사위를 랜덤으로 돌리는 메소드입니다.
	 */
	public static void randomThreadDice() {
		int imgSize = 190;

		int diceNum1 = (int)(Math.random() * 6 + 1);
		int diceNum2 = (int)(Math.random() * 6 + 1);
		
		DiceNumberList.setDiceNum1(diceNum1);
		DiceNumberList.setDiceNum2(diceNum2);
		
		Image[] img = {
				new ImageIcon("./images/dice" + diceNum1 + ".png").getImage().getScaledInstance(imgSize, imgSize,
						java.awt.Image.SCALE_SMOOTH),

				new ImageIcon("./images/dice" + diceNum2 + ".png").getImage().getScaledInstance(imgSize, imgSize,
						java.awt.Image.SCALE_SMOOTH) };

		Timer timer = new Timer();
		int delay = 100; // 이미지 변경 간격 (0.2초)
		int duration = 2000; // 전체 동작 시간 (2초)
		int steps = duration / delay; // 이미지 변경 횟수

		TimerTask task = new TimerTask() {
			int stepCount = 0;

			@Override
			public void run() {
				if (stepCount < steps) {
					// 이미지 무작위로 선택 후 버튼에 적용
					int randomImageIndex = (int) (Math.random() * 6 + 1);
					Image img = new ImageIcon("./images/dice" + randomImageIndex + ".png").getImage()
							.getScaledInstance(imgSize, imgSize, java.awt.Image.SCALE_SMOOTH);
					diceBtn[0].setIcon(new ImageIcon(img));
					diceBtn[1].setIcon(new ImageIcon(img));
					stepCount++;
				} else {
					// 최종 이미지 선택 후 버튼에 적용
					diceBtn[0].setIcon(new ImageIcon(img[0]));
					diceBtn[1].setIcon(new ImageIcon(img[1]));

					// TimerTask 종료
					cancel();
				}
			}
		};

		// 이미지 변경 간격(delay)마다 TimerTask 실행
		timer.schedule(task, delay, delay);
	}
}
