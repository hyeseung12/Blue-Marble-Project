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
	
	public void CityListView() {

		cityListFrame.setSize(400, 800);
	    cityListFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    JPanel cityListPanel1 = new JPanel(null);
		JButton cityListBtn = new JButton("나라 List");
		cityListBtn.setSize(400, 60);
		cityListBtn.setVisible(true);
		cityListBtn.setBackground(Color.YELLOW);
		cityListPanel1.setBounds(0, 5, 400, 60);
		cityListPanel1.add(cityListBtn);

	    JPanel cityListPanel = new JPanel();
	    cityListPanel.setLayout(new BoxLayout(cityListPanel, BoxLayout.Y_AXIS));

	    List<String> cityList = getCityList();

	 // TODO: 나라를 획득할 때마다 해당 나라가 추가되게 하기
	    
	    for (int i = 0; i < cityList.size(); i++) {
	        JPanel playerCityPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
	        
	        ImageIcon icon = new ImageIcon("./images/" + cityList.get(i) + ".png");
	        Image resizedImage = icon.getImage().getScaledInstance(200, 250, Image.SCALE_SMOOTH);
	        ImageIcon resizedIcon = new ImageIcon(resizedImage);
	        JLabel cityImageLabel = new JLabel(resizedIcon);

	        playerCityPanel.add(cityImageLabel);
	        playerCityPanel.add(cityImageLabel);
	        cityListPanel.add(playerCityPanel);
	    }

	    JScrollPane scrollPane = new JScrollPane(cityListPanel);
	    scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

	    cityListFrame.add(cityListPanel1);
	    cityListFrame.add(scrollPane);
	    cityListFrame.setVisible(true);
	}
	
	private List<String> getCityList() {
		// TODO: 필요한 나라 목록을 가져오는 로직 구현
		List<String> cityList = new ArrayList<>();
		cityList.add("1");
		cityList.add("4");
		cityList.add("5");
		cityList.add("7");
		return cityList;
	}

	public static void main(String[] args) {
		new playerView();
	}
}
