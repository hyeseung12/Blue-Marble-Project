package player;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import list.PlayerList;

/**
 * 각각의 플레이어 패널입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 */
public class PlayerPanel extends JPanel {
	private static JLabel[] label = new JLabel[4];

	public PlayerPanel() {
		setLayout(null);
		setSize(30, 30);
		setOpaque(false);

		createPlayer();
	}

	/**
	 * 플레이어를 초기화 하는 메소드입니다.
	 */
	public void createPlayer() {
		int[][] coordinates = { { 5, 10 }, { 70, 8 }, { 6, 70 }, { 70, 70 } }; // 좌표 배열

		for (int i = 0; i < label.length; i++) {
			Image img = new ImageIcon("./images/플레이어_" + (i + 1) + ".png").getImage().getScaledInstance(110, 120,
					java.awt.Image.SCALE_SMOOTH);
			label[i] = new JLabel(new ImageIcon(img));

			label[i].setBounds(coordinates[i][0], coordinates[i][1], 40, 40);
			PlayerList.insertPlayer(label[i]);
			add(label[i]);
		}
	}
}
