package dice;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
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
	public static int diceNum1 = (int) (Math.random() * 6 + 1);
	public static int diceNum2 = (int) (Math.random() * 6 + 1);

	public DicePanel() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 48, 30));
		setPreferredSize(new Dimension(400, 200));

		JButton[] diceBtn = new JButton[2];

		int imgSize = 190;

		Image[] img = {
				new ImageIcon("./images/dice" + diceNum1 + ".png").getImage().getScaledInstance(imgSize, imgSize,
						java.awt.Image.SCALE_SMOOTH),

				new ImageIcon("./images/dice" + diceNum2 + ".png").getImage().getScaledInstance(imgSize, imgSize,
						java.awt.Image.SCALE_SMOOTH) };

		for (int i = 0; i < diceBtn.length; i++) {
			diceBtn[i] = new JButton();
			diceBtn[i].setOpaque(true);
			diceBtn[i].setContentAreaFilled(true);
			diceBtn[i].setBorderPainted(false);
			diceBtn[i].setFocusPainted(false);
			diceBtn[i].setPreferredSize(new Dimension(100, 100));
			add(diceBtn[i]);
			diceBtn[i].setIcon(new ImageIcon(img[i]));
		}
	}
}
