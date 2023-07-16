package country;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import common.CommonCountry;

/**
 * 파랑색 라인의 나라들을 표시할 패널입니다.
 * 
 * @version 1.0
 * @author MsEmily1020
 *
 */
public class BlueLineButtonPanel extends JPanel {
	public BlueLineButtonPanel() {
		setLayout(new BorderLayout());
		add(CommonCountry.setCountryButtonImage(
				/*panelW*/145,
				/*panelH*/640,
				/*buttonW*/151,
				/*buttonH*/116,
				/*buttonIdx*/5,
				/*start*/19));
	}
}
