package main;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import common.CommonPanel;

/**
 * 주황색 라인의 나라들을 표시할 패널입니다.
 * 
 * @version 1.0
 * @author MsEmily1020
 *
 */
public class OrangeLineButtonPanel extends JPanel {
	public OrangeLineButtonPanel() {
		setLayout(new BorderLayout());
		add(CommonPanel.setCountryButtonImage(
				/*panelW*/145,
				/*panelH*/640,
				/*buttonW*/151,
				/*buttonH*/116,
				/*buttonIdx*/5,
				/*start*/7));
	}
}
