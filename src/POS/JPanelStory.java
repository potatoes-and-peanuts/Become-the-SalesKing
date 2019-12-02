package POS;

import java.awt.Font;
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
import javax.swing.JTextField;

public class JPanelStory extends JPanel{
	
	private frame win;
	private Image screenImage;
	private Graphics screenGraphic; // ��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/Storybackground.jpg");
	
	private ImageIcon Nextbtn[] = { new ImageIcon("images/ANext.png"), new ImageIcon("images/BNext.png"),
			new ImageIcon("images/OnNext.png") }; 
	
	private JButton Nbtn = new JButton(Nextbtn[0]);
	
	private JTextField Name = new JTextField(20);
	
	// ������ ��ư �̹���
	public static ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
	public static JButton Endbtn = new JButton(End[0]);
		
	public JPanelStory(frame win)
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
				
		add(Nbtn);
		Nbtn.setPressedIcon(Nextbtn[1]);
		Nbtn.setRolloverIcon(Nextbtn[2]);
		Nbtn.setBounds(1170, 625, 180, 110);
		Nbtn.setBorderPainted(false);
		Nbtn.setFocusPainted(false);
		Nbtn.setContentAreaFilled(false);
		Nbtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				win.change("order");
			}
		});
		
		add(Name);
		Name.setVisible(true);
		Name.setBounds(140, 600, 400, 80);
		Name.setFont(new Font("����ǹ��� �־�", Font.BOLD, 45));
		Name.setOpaque(false);

		String name = Name.getText(); 
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
