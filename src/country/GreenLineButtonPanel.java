package country;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import common.CommonCountry;

/**
 * 초록색 라인의 나라들을 표시할 패널입니다.
 * 
 * @version 1.0
 * @author MsEmily1020
 *
 */
public class GreenLineButtonPanel extends JPanel {
	public GreenLineButtonPanel() {
		setLayout(new BorderLayout());
		add(CommonCountry.setCountryButtonImage(
				/* panelW */900,
				/* panelH */145,
				/* buttonW */119,
				/* buttonH */145,
				/* buttonIdx */7,
				/* start */12));
	}
}
