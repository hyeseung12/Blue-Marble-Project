package common;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * 모든 클래스가 공통적으로 가지고 있어야 할 것들을 갖고 있는 클래스입니다.
 * @version : 1.0
 * @author  : MsEmily1020
 */
public class CommonFrame extends JFrame {
	/**
	 * JFrame을 생성해주는 CommonFrame의 생성자입니다. 
	 * (extends로 상속 받았을 때 super()를 가장 먼저 불러와서 제목과 크기를 지정해줘야 합니다.)
	 * @param title, String
	 * @param w, int
	 * @param h, int
	 */
    public CommonFrame(String title, int w, int h) {
        setTitle(title);
        setSize(w, h);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
    }

    /**
     * 기존 setBounds 메서드를 실행시킨 후 해당 객체를 리턴시켜주는 메소드입니다.
     * @param comp, JComponent
     * @param x, int
     * @param y, int
     * @param width, int
     * @param height, int
     * @return JComponent
     */
    public static JComponent setBounds(JComponent comp, int x, int y, int width, int height) {
        comp.setBounds(x, y, width, height);
        return comp;
    }

    /**
     * 오디오 파일 생성 후 실행 시켜주는 메소드 입니다.
     * @param filePath, String
     * @return Clip
     */
    public Clip audio(String filePath) {
        try {
            File file = new File(filePath);
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(file));
            clip.loop(0);
            return clip;
        } catch (Exception e) {
            System.err.println("파일을 찾을 수 없습니다.");
            return null;
        }
    }
}

/**
 * 패널에 그림을 올려주는 클래스입니다.
 * @version : 1.0
 * @author  : https://eunbc-2020.tistory.com/54
 */
class ImagePanel extends JPanel {
    private Image img;

    /**
     * 이미지의 환경을 구성해주는 메소드 입니다.
     * @param img, Image
     */
    public ImagePanel(Image img) {
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