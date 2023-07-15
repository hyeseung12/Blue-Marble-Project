package dice;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

/**
 * 주사위를 돌릴 패널입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 */
public class DicePanel extends JPanel {
	public static int diceNum1 = (int)(Math.random() * 6 + 1);
	public static int diceNum2 = (int)(Math.random() * 6 + 1);

	public DicePanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 48, 30));
		setPreferredSize(new Dimension(400, 200));
		setBackground(new Color(255, 255, 255, 255));
		
		JButton[] diceBtn = new JButton[2];

		for(var dice : diceBtn) {
			dice = new JButton();
			dice.setOpaque(true);
			dice.setContentAreaFilled(true);
			dice.setBorderPainted(false);
			dice.setFocusPainted(false);
			dice.setPreferredSize(new Dimension(110, 100));
			add(dice);
		}
		
		int imgSize = 188;
		Image img1 = new ImageIcon("./images/dice" + diceNum1 + ".png").getImage().getScaledInstance(imgSize, imgSize,
				java.awt.Image.SCALE_SMOOTH);
		
		Image img2 = new ImageIcon("./images/dice" + diceNum2 + ".png").getImage().getScaledInstance(imgSize, imgSize,
				java.awt.Image.SCALE_SMOOTH);
		
		diceBtn[0].setIcon(new ImageIcon(img1));
		diceBtn[1].setIcon(new ImageIcon(img2));
	}
}
