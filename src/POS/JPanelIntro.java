package POS;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


public class JPanelIntro extends JPanel{
	private Image screenImage;
	private Graphics screenGraphic; // ��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg");
	
	private frame win;
	
	// ������ ��ư �̹���
	private ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
	// ���۹�ư �̹���
	private ImageIcon Startbtn[] = { new ImageIcon("images/BeforeStart.png"), // ��[0] ����, ��[1] ���콺 �÷��� ��, ��[2] ���콺 ���� ��
			new ImageIcon("images/AfterStart.png"), new ImageIcon("images/OnStart.png") };
	// ���۹�� �̹���
		private ImageIcon HowToPlaybtn[] = { new ImageIcon("images/BeforeHowToPlay.png"),
				new ImageIcon("images/AfterHowToPlay.png"), new ImageIcon("images/OnHowToPlay.png") };
		
	
	// ������, ����, ���۹�� ��ư
	private JButton Endbtn = new JButton(End[0]);
	private JButton Lbtn = new JButton(Startbtn[0]);
	private JButton Rbtn = new JButton(HowToPlaybtn[0]);
		
	public JPanelIntro(frame win)
	{
		this.win=win;
		setLayout(null);
		
		// �����ư
			Endbtn.setRolloverIcon(End[1]);
			Endbtn.setBounds(1250, 10, 100, 80);
			Endbtn.setBorderPainted(false);
			Endbtn.setFocusPainted(false);
			Endbtn.setContentAreaFilled(false);
			add(Endbtn);
			Endbtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mousePressed(MouseEvent e) {
					System.exit(0);
				}
			});

			// ���۹�ư
			Lbtn.setPressedIcon(Startbtn[1]);
			Lbtn.setRolloverIcon(Startbtn[2]);
			Lbtn.setBounds(350, 620, 220, 100);
			Lbtn.setBorderPainted(false);
			Lbtn.setFocusPainted(false);
			Lbtn.setContentAreaFilled(false);
			add(Lbtn);
//				Lbtn.addMouseListener(new ConfigMouseAdapter());
			Lbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					win.change("story");
					
				}
			});

			// ���۹�� ��ư
			Rbtn.setPressedIcon(HowToPlaybtn[1]);
			Rbtn.setRolloverIcon(HowToPlaybtn[2]);
			Rbtn.setBounds(810, 620, 220, 100);
			Rbtn.setBorderPainted(false);
			Rbtn.setFocusPainted(false);
			Rbtn.setContentAreaFilled(false);
			add(Rbtn);
			Rbtn.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					win.change("howto");
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
