package player;

import java.awt.Image;
import java.lang.reflect.InvocationTargetException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import list.CountryButtonList;
import list.DiceNumberList;
import list.PlayerList;

/**
 * 각각의 플레이어 패널입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 */
public class PlayerPanel extends JPanel {
	private static JLabel[] label = new JLabel[4];
	public static int playerOrder;
	private static int totalMovePosition;

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
		int length = label.length;
		for (int i = 0; i < length; i++) {
			Image img = new ImageIcon("./images/플레이어_" + (i + 1) + ".png").getImage().getScaledInstance(110, 120,
					java.awt.Image.SCALE_SMOOTH);
			label[i] = new JLabel(new ImageIcon(img));
			PlayerList.insertPlayer(label[i]);
			CountryButtonList.findCountryButton(0).add(PlayerList.findPlayer(i));
		}
	}
	
	/**
	 * 플레이어를 주사위 수만큼 이동시키는 메소드입니다.
	 * index는 0부터 시작합니다.
	 */
	public static void movePlayer() {
		int position = PlayerList.findPlayerPosition(playerOrder);	// 현재 위치
		System.out.println(playerOrder + " " + PlayerList.findPlayerPosition(playerOrder));
		
		int diceNum = DiceNumberList.getDiceNum1() + DiceNumberList.getDiceNum2();	// 주사위 수
		
		totalMovePosition = position + diceNum;	// 최종으로 가야 하는 위치
		
		// 한바퀴(총 24칸) 돌았을 경우 -> 해당 플레이어의 위치는 한바퀴를 뺀 나머지 
		totalMovePosition = (totalMovePosition > 23) ? totalMovePosition - 24 : totalMovePosition;
		PlayerList.setPlayerPosition(playerOrder, totalMovePosition);
		
		System.out.println(totalMovePosition);
	    Thread playerMoveThread = new Thread() {
	        @Override
	        public void run() {
	            int currentPosition = position + 1; // 현재 위치

	            while (currentPosition != totalMovePosition) {
	            	currentPosition = (currentPosition % 23) + 1; // 다음 위치 계산
	                PlayerList.setPlayerPosition(playerOrder, currentPosition); // 플레이어 위치 업데이트
	                try {
	                    SwingUtilities.invokeAndWait(() -> {
	                    	CountryButtonList.findCountryButton(PlayerList.findPlayerPosition(playerOrder)).add(PlayerList.findPlayer(playerOrder));
	                    });
	                    Thread.sleep(100); // 이동 간격 (0.5초)
	                } catch (InterruptedException | InvocationTargetException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	    };
	    
	    playerMoveThread.start();
		
	}
}
