package player;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
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

public class PlayerView extends CommonFrame {
	private MainBoardFrame mainBoardFrame;
	public static JLabel[] playerIconLabel = new JLabel[4];

	public PlayerView(MainBoardFrame mainBoardFrame) {
		super("플레이어 목록", 400, 900);
		this.mainBoardFrame = mainBoardFrame;
		setLocation(mainBoardFrame.getLocation().x + mainBoardFrame.getWidth(), mainBoardFrame.getLocation().y);
		setLayout(new FlowLayout());
		playerListView();
	}

	/**
	 * 플레이어 목록을 보여주는 메소드입니다.
	 */
	public void playerListView() {
		JPanel playerPanel = new JPanel(new GridLayout(0, 1));

		JButton cityOpenBtn = new JButton("플레이어 나라");
		cityOpenBtn.setPreferredSize(new Dimension(400, 70));
		cityOpenBtn.setBackground(Color.YELLOW);

		for (int i = 0; i < 4; i++) {
			Image img = new ImageIcon("./images/플레이어점수" + (i + 1) + ".png").getImage().getScaledInstance(400, 154,
					java.awt.Image.SCALE_SMOOTH);
			playerIconLabel[i] = new JLabel(new ImageIcon(img));
			playerPanel.add(playerIconLabel[i]);
		}

		cityOpenBtn.addActionListener(e -> CityListView());

		add(cityOpenBtn);
		add(playerPanel);
	}

	/**
	 * 플레이어의 나라 목록을 보여주는 메소드입니다.
	 */
	public void CityListView() {
		JFrame cityListFrame = new JFrame("플레이어 나라 목록");
		JPanel cityListPanel = new JPanel(new GridLayout(0, 1));

		List<List<Integer>> playerCityList = getPlayerCityList(); // 각 플레이어의 도시 목록을 가져옴

		for (int i = 0; i < playerCityList.size(); i++) { // 4
			// 플레이어 라벨 지정
			JLabel playerLabel = new JLabel("플레이어 " + (i + 1));
			playerLabel.setFont(new Font("GOTHIC", Font.BOLD, 25));
			playerLabel.setBorder(BorderFactory.createEmptyBorder(/*위*/30, /*왼쪽*/50, /*아래*/30, /*오른쪽*/50));
			playerLabel.setHorizontalAlignment(0); 
			cityListPanel.add(playerLabel);

			List<Integer> cityList = playerCityList.get(i); // 해당 플레이어의 도시 목록을 가져옴

			// 각 플레이어의 도시 목록 보여주기
			for (int city : cityList) {
				Image resizedImage = new ImageIcon("./images/" + city + ".png").getImage().getScaledInstance(200, 250,
						Image.SCALE_SMOOTH); // 이미지 크기 설정
				JLabel cityImageLabel = new JLabel(new ImageIcon(resizedImage)); // 도시 카드 이미지 Label

				cityImageLabel.setBorder(BorderFactory.createEmptyBorder(/*위*/20, /*왼쪽*/50, /*아래*/100, /*오른쪽*/50));
				cityListPanel.add(cityImageLabel);
			}
		}

		cityListFrame.add(new JScrollPane(cityListPanel));
		cityListFrame.setSize(400, 900);
		cityListFrame.setLocation(mainBoardFrame.getLocation().x - cityListFrame.getWidth(),
				mainBoardFrame.getLocation().y);
		cityListFrame.setVisible(true);
	}

	/**
	 * 각 플레이어가 획득한 나라를 보여주는 리스트입니다.
	 * 
	 * @return List<List<Integer>>
	 */
	private List<List<Integer>> getPlayerCityList() {
		// TODO: 각 플레이어가 획득한 나라 add하는 로직 구현
		// 임시로 지정하여 add함
		List<List<Integer>> playerCityList = new ArrayList<>();

		// 플레이어 1의 나라 목록
		List<Integer> player1CityList = new ArrayList<>(List.of(1));
		playerCityList.add(player1CityList);

		// 플레이어 2의 나라 목록
		List<Integer> player2CityList = new ArrayList<>(List.of(4, 5));
		playerCityList.add(player2CityList);

		// 플레이어 3의 나라 목록
		List<Integer> player3CityList = new ArrayList<>(List.of(7, 8, 10));
		playerCityList.add(player3CityList);

		// 플레이어 4의 나라 목록
		List<Integer> player4CityList = new ArrayList<>(List.of(20));
		playerCityList.add(player4CityList);

		return playerCityList;
	}
}
