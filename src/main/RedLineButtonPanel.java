package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import common.CommonPanel;

/**
 * 빨강색 라인의 나라들을 표시할 패널입니다.
 * 
 * @version 1.0
 * @author MsEmily1020
 *
 */
public class RedLineButtonPanel extends JPanel {
	public RedLineButtonPanel() {
		setLayout(new BorderLayout());
		add(CommonPanel.setCountryButtonImage(
				/*panelW*/900,
				/*panelH*/141,
				/*buttonW*/119,
				/*buttonH*/141,
				/*buttonIdx*/7,
				/*start*/0));
	}
}
