package main;

import java.awt.BorderLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

import common.CommonImagePanel;
import dice.DicePanel;

/**
 * 나라의 자세한 정보(통행료, 대지료 등)를 보여주는 패널 클래스입니다.
 * 
 * @author MsEmily1020
 * @version 1.0
 */
public class CountryDetailPanel extends JPanel {
	/**
	 * 기본 패널은 보드 이미지를 보여줍니다.
	 */
	public CountryDetailPanel() {
        setLayout(new BorderLayout());

        // 이미지 패널 생성
        CommonImagePanel img = new CommonImagePanel(new ImageIcon("./images/부루마불.png").getImage());

        // 주사위 패널 생성
        DicePanel dicePanel = new DicePanel();
        dicePanel.setOpaque(false); // DicePanel을 투명하게 설정

        // 이미지 패널을 추가
        add(img, BorderLayout.CENTER);

        // 주사위 패널을 이미지 패널 위에 추가
        img.setLayout(new GridBagLayout()); // 이미지 패널에 GridBagLayout 설정
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.anchor = GridBagConstraints.CENTER;
        img.add(dicePanel, constraints);
    }

	/**
	 * 나라의 인덱스를 생성자에 넣어주면 인덱스에 해당하는 나라의 자세한 정보를 보여줍니다.
	 * 
	 * @param index, int
	 */
	public CountryDetailPanel(int index) {

	}
}
