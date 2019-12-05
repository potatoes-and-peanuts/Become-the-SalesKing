package POS;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelHowTo extends JPanel{
	private Image screenImage;
	private Graphics screenGraphic;
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/howto.jpg");
	
	private ImageIcon Backbtn[] = { new ImageIcon("images/BeforeBack.png"), new ImageIcon("images/AfterBack.png"),
			new ImageIcon("images/OnBack.png") };
	private JButton Bbtn = new JButton(Backbtn[0]);

	public JPanelHowTo(frame win) {
		setLayout(null);
		Bbtn.setBounds(1050, 630, 180, 110);
		Bbtn.setBorderPainted(false);
		Bbtn.setFocusPainted(false);
		Bbtn.setContentAreaFilled(false);
		add(Bbtn);
		Bbtn.setPressedIcon(Backbtn[1]);
		Bbtn.setRolloverIcon(Backbtn[2]);
		Bbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				win.change("intro");
			}
		});
	}
	
	public void paint(Graphics g) { // GUI화면 중 제일 첫번째 화면을 그려주는 함수
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // ScreenImage에 1200X700의 이미지를 넣어줌
		screenGraphic = screenImage.getGraphics(); // 겟그래픽을 이용해서 스크린그래픽을 얻어옴
		screenDraw(screenGraphic); // screenDraw 호출
		g.drawImage(screenImage, 0, 0, null); // screenImage의 이미지를 (0,0)위치에 그려줌.
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null); // Background의 이미지를 (0,0)위치에 그려줌.
		paintComponents(g); // 컴포넌트 삽입
		this.repaint(); // 전체화면 이미지를 매 순간마다 그려줌, 프로그램 시작~종료까지 반복되며 화면에 그려줌.
	}
}
