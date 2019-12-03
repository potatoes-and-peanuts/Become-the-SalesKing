package POS;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class JPanelEnding extends JPanel{
	private frame win;
	private Image screenImage;
	private Graphics screenGraphic; // ��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image Background;
	
	private ImageIcon close[] = {new ImageIcon("images/CloseBtn.png"), new ImageIcon("images/OnCloseBtn.png")};
	private JButton GoHome = new JButton(close[0]);
	
	JPanelEnding(frame win){
		setLayout(null);
		if(win.money<0) Background = Toolkit.getDefaultToolkit().createImage("images/fail.jpg");
		else Background=Toolkit.getDefaultToolkit().createImage("images/success.jpg");
		
		add(GoHome);
		GoHome.setBounds(600,360,250,250);
		GoHome.setBorderPainted(false);
		GoHome.setFocusPainted(false);
		GoHome.setContentAreaFilled(false);
		GoHome.setRolloverIcon(close[1]);
		GoHome.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
	}
	
	public void paint(Graphics g) { // GUIȭ�� �� ���� ù��° ȭ���� �׷��ִ� �Լ�
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // ScreenImage�� 1200X700�� �̹����� �־���
		screenGraphic = screenImage.getGraphics(); // �ٱ׷����� �̿��ؼ� ��ũ���׷����� ����
		screenDraw(screenGraphic); // screenDraw ȣ��
		g.drawImage(screenImage, 0, 0, null); // screenImage�� �̹����� (0,0)��ġ�� �׷���.
	}

	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null); // Background�� �̹����� (0,0)��ġ�� �׷���.
		paintComponents(g); // ������Ʈ ����
		this.repaint(); // ��üȭ�� �̹����� �� �������� �׷���, ���α׷� ����~������� �ݺ��Ǹ� ȭ�鿡 �׷���.
	}
}

