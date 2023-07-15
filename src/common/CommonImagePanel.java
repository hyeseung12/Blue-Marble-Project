package common;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.JPanel;

/**
 * 패널에 그림을 올려주는 클래스입니다.
 * @version : 1.0
 * @author  : https://eunbc-2020.tistory.com/54
 */
public class CommonImagePanel extends JPanel {
    private Image img;

    /**
     * 이미지의 환경을 구성해주는 메소드 입니다.
     * @param img
     */
    public CommonImagePanel(Image img) {
        this.img = img;
        setSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        setPreferredSize(new Dimension(img.getWidth(null), img.getHeight(null)));
        setLayout(null);
    }

    /**
     * 이미지를 그리는 메소드 입니다.
     * @param g the <code>Graphics</code> object to protect
     */
    public void paintComponent(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }
}