package player;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 * 플레이어에게 표시되는 점수 프레임과 보유 도시 프레임입니다.
 * 
 * @author phinsso
 * @version 1.0
 */

public class playerView {
	JFrame playerListFrame = new JFrame("플레이어 목록");

	JFrame cityListFrame = new JFrame("플레이어 나라 목록");

	public playerView() {
		playerListView();
	}

	public void playerListView() {
		playerListFrame.setSize(400, 800);
		playerListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel cityBtnPanel = new JPanel(null);
		JPanel playerPanel = new JPanel(null);

		JButton cityOpenBtn = new JButton("나라");
		cityOpenBtn.setSize(400, 60);
		cityOpenBtn.setVisible(true);
		cityOpenBtn.setBackground(Color.YELLOW);
		cityBtnPanel.setBounds(0, 5, 400, 60);
		cityBtnPanel.add(cityOpenBtn);

		for (int i = 0; i < 4; i++) {
			ImageIcon icon = new ImageIcon("./images/플레이어점수" + (i + 1) + ".png");
			JLabel iconLabel = new JLabel(icon);
			iconLabel.setBounds(0, (i + 1) * 62 + (i * 113), 400, 180);
			playerPanel.add(iconLabel);
		}

		cityOpenBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CityListView();
			}
		});

		playerListFrame.add(cityBtnPanel);
		playerListFrame.add(playerPanel);
		playerListFrame.setVisible(true);
	}

	public static void main(String[] args) {
		new playerView();
	}
}
