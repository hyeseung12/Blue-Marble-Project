package player;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import common.CommonFrame;
import main.MainBoardFrame;

/**
 * 플레이어에게 표시되는 점수 프레임과 보유 도시 프레임입니다.
 * 
 * @author phinsso
 * @version 1.0
 */

public class playerView extends CommonFrame {
	JFrame cityListFrame = new JFrame("플레이어 나라 목록");

    public playerView(MainBoardFrame mainBoardFrame) {
        super("플레이어 목록", 400, 800);
        setLocation(mainBoardFrame.getLocation().x + mainBoardFrame.getWidth(), mainBoardFrame.getLocation().y);
        setLayout(new BorderLayout());
        playerListView();
    }

	public void playerListView() {
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

		add(cityBtnPanel);
		add(playerPanel);
	}

	public void CityListView() {

		cityListFrame.setSize(400, 800);
		cityListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel cityListPanel = new JPanel();
		// BoxLayout: 위에서 아래로, 혹은 왼쪽에서 오른쪽으로 차례로 컴포넌트를 배치
		cityListPanel.setLayout(new BoxLayout(cityListPanel, BoxLayout.Y_AXIS)); // 상 -> 하 배치

		List<List<String>> playerCityList = getPlayerCityList(); // 각 플레이어의 도시 목록을 가져옴

		for (int i = 0; i < playerCityList.size(); i++) { // 4
			JPanel playerPanel = new JPanel(); // 각 플레이어의 Panel
			playerPanel.setLayout(new BoxLayout(playerPanel, BoxLayout.Y_AXIS));
			JLabel playerLabel = new JLabel("플레이어 " + (i + 1));
			playerLabel.setFont(new Font("GOTHIC", Font.BOLD, 25));
			playerPanel.setAlignmentX(Component.CENTER_ALIGNMENT); // 플레이어 라벨을 중앙 정렬
			playerPanel.add(Box.createVerticalStrut(40)); // 40 픽셀의 빈 공간이 추가
            playerPanel.add(playerLabel);
            playerPanel.add(Box.createVerticalStrut(20));
            
			List<String> cityList = playerCityList.get(i); // 해당 플레이어의 도시 목록을 가져옴

			for (String city : cityList) {
				ImageIcon icon = new ImageIcon("./images/" + city + ".png");
				Image resizedImage = icon.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH); // 이미지 크기 설정
				ImageIcon resizedIcon = new ImageIcon(resizedImage);
				JLabel cityImageLabel = new JLabel(resizedIcon); // 도시 카드 이미지 Label
				
				cityImageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // 도시 이미지를 중앙 정렬
				playerPanel.add(cityImageLabel);
				playerPanel.add(Box.createVerticalStrut(10));
			}

			cityListPanel.add(playerPanel);
		}

		JScrollPane scrollPane = new JScrollPane(cityListPanel);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		cityListFrame.add(scrollPane);
		cityListFrame.setVisible(true);
	}

	private List<List<String>> getPlayerCityList() {
		// TODO: 각 플레이어가 획득한 나라 add하는 로직 구현
		// 임시로 지정하여 add함
		List<List<String>> playerCityList = new ArrayList<>();

		// 플레이어 1의 나라 목록
		List<String> player1CityList = new ArrayList<>();
		player1CityList.add("1");
		player1CityList.add("4");
		player1CityList.add("5");
		playerCityList.add(player1CityList);

		// 플레이어 2의 나라 목록
		List<String> player2CityList = new ArrayList<>();
		player2CityList.add("7");
		playerCityList.add(player2CityList);

		// 플레이어 3의 나라 목록
		List<String> player3CityList = new ArrayList<>();
		player3CityList.add("8");
		player3CityList.add("10");
		playerCityList.add(player3CityList);

		// 플레이어 4의 나라 목록
		List<String> player4CityList = new ArrayList<>();
		playerCityList.add(player4CityList);

		return playerCityList;
	}
}
