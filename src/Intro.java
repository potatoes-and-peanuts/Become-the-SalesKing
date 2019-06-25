import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class Intro extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic; //��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image Background=Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg"); 

	//<������ ��ư �̹���>
	private ImageIcon End[] = {new ImageIcon("images/End.png"),
								new ImageIcon("images/OnEnd.png")};
	//���۹�ư �̹���
	private ImageIcon Startbtn[] = {new ImageIcon("images/BeforeStart.png"), //��[0] ����, ��[1] ���콺 �÷��� ��, ��[2] ���콺 ���� ��
									new ImageIcon("images/AfterStart.png"),
									new ImageIcon("images/OnStart.png") };
	//���۹�� �̹���
	private ImageIcon HowToPlaybtn[] = {new ImageIcon("images/BeforeHowToPlay.png"),
									    new ImageIcon("images/AfterHowToPlay.png"),
									    new ImageIcon("images/OnHowToPlay.png")};
	//�ڷΰ��� ��ư
	public ImageIcon Backbtn[] = {new ImageIcon("images/BeforeBack.png"),
								  new ImageIcon("images/AfterBack.png"),
								  new ImageIcon("images/OnBack.png")};
	
	private ImageIcon Checkbtn[]= {new ImageIcon("images/BeforeCheck.png"),
								   new ImageIcon("images/AfterCheck.png"),
								   new ImageIcon("images/OnCheck.png")};
	
	private ImageIcon Nextbtn[] = {new ImageIcon("images/ANext.png"),
								   new ImageIcon("images/BNext.png"),
								   new ImageIcon("images/OnNext.png")};
	
	//������, ����, ���۹�� ��ư
	private JButton Endbtn = new JButton(End[0]);
	private JButton Lbtn=new JButton(Startbtn[0]);
	private JButton Rbtn=new JButton(HowToPlaybtn[0]);
	private JButton Bbtn=new JButton(Backbtn[0]);
	private JButton Cbtn=new JButton(Checkbtn[0]);
	private JButton Nbtn=new JButton(Nextbtn[0]);
	
	private JTextField Name = new JTextField(20);
	private JTextField SName = new JTextField(20);
	
	Intro(){
		setTitle("������� ����!!");
	
		setUndecorated(true); //�������� �� �⺻������ ���̴� �޴��ٰ� �� ����.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); 
		setResizable(false); 
		setLocationRelativeTo(null); 
		setVisible(true); 
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null); 
		
		//<�����ư>
		Endbtn.setRolloverIcon(End[1]);
		Endbtn.setBounds(1250, 10, 100, 80);
		Endbtn.setBorderPainted(false);
		Endbtn.setFocusPainted(false);
		Endbtn.setContentAreaFilled(false);
		add(Endbtn); 
		Endbtn.addMouseListener(new MouseAdapter(){ 
			@Override
			public void mousePressed(MouseEvent e) { 
				System.exit(0); 
			}
		});
		
		//<���۹�ư>
		Lbtn.setPressedIcon(Startbtn[1]);
		Lbtn.setRolloverIcon(Startbtn[2]);
		Lbtn.setBounds(350, 620, 220, 100); 
		Lbtn.setBorderPainted(false); 
		Lbtn.setFocusPainted(false);
		Lbtn.setContentAreaFilled(false); 
		add(Lbtn);
		Lbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Background = Toolkit.getDefaultToolkit().createImage("images/Initbackground.jpg"); 
				Rbtn.setVisible(false); 
				Lbtn.setVisible(false);
				
				//�̸� �Է�
				add(Name);
				Name.setVisible(true); 
				Name.setBounds(640, 175, 400, 80);
				Name.setFont(new Font("BOLD", Font.BOLD, 50));
				
				Cbtn.setPressedIcon(Checkbtn[1]);
				Cbtn.setRolloverIcon(Checkbtn[2]); 
				Cbtn.setBounds(560, 620, 220, 100); 
				Cbtn.setBorderPainted(false); 
				Cbtn.setFocusPainted(false);
				Cbtn.setContentAreaFilled(false); 
				add(Cbtn);
				Cbtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
							String name = Name.getText();
							System.out.println(name);
							String sname = SName.getText();
							System.out.println(sname);
							Background = Toolkit.getDefaultToolkit().createImage("images/Storybackground.jpg"); 
							Name.setVisible(false);
							SName.setVisible(false);
							Cbtn.setVisible(false);
							add(Nbtn);
							Nbtn.setPressedIcon(Nextbtn[1]);
							Nbtn.setRolloverIcon(Nextbtn[2]); 
							Nbtn.setBounds(1170, 625, 180, 110);
							Nbtn.setBorderPainted(false); 
							Nbtn.setFocusPainted(false);
							Nbtn.setContentAreaFilled(false); 
							Nbtn.addMouseListener(new MouseAdapter() {
								@Override
							public void mousePressed(MouseEvent e) {
								Background = Toolkit.getDefaultToolkit().createImage("images/Menubackground.jpg"); 
								Nbtn.setVisible(false);
							} });
				} });
				//���� �̸� �Է�
				add(SName);
				SName.setVisible(true);
				SName.setBounds(640, 415, 400, 80);
				SName.setFont(new Font("BOLD", Font.BOLD, 50));	
			} });
		
		//<���۹�� ��ư>
		Rbtn.setPressedIcon(HowToPlaybtn[1]);
		Rbtn.setRolloverIcon(HowToPlaybtn[2]);

		Rbtn.setBounds(810, 620, 220, 100);
		Rbtn.setBorderPainted(false);
		Rbtn.setFocusPainted(false);
		Rbtn.setContentAreaFilled(false);
		add(Rbtn);
		Rbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Bbtn.setVisible(true); 
				Lbtn.setVisible(false); 
				Rbtn.setVisible(false); 
				Background = Toolkit.getDefaultToolkit().createImage("images/HowToPlaybackground.jpg"); 
				Bbtn.setBounds(1050, 610, 180, 110); 
				Bbtn.setBorderPainted(false); 
				Bbtn.setFocusPainted(false);
				Bbtn.setContentAreaFilled(false); 
				add(Bbtn);
			} 
		}); 

		//#2 <�ڷΰ����ư>
		Bbtn.setPressedIcon(Backbtn[1]); 
		Bbtn.setRolloverIcon(Backbtn[2]); 
		Bbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Bbtn.setVisible(false); 
				Lbtn.setVisible(true); 
				Rbtn.setVisible(true);  
				Background = Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg"); 	
			} 
		});  	
	}
	

	public void paint(Graphics g) { //GUIȭ�� �� ���� ù��° ȭ���� �׷��ִ� �Լ�
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //ScreenImage�� 1200X700�� �̹����� �־���
		screenGraphic = screenImage.getGraphics(); //�ٱ׷����� �̿��ؼ� ��ũ���׷����� ���� 
		screenDraw(screenGraphic); //screenDraw ȣ��
		g.drawImage(screenImage, 0, 0, null); //screenImage�� �̹����� (0,0)��ġ�� �׷���.
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(Background, 0, 0, null); //Background�� �̹����� (0,0)��ġ�� �׷���.
		paintComponents(g); //������Ʈ ����
		this.repaint(); //��üȭ�� �̹����� �� �������� �׷���, ���α׷� ����~������� �ݺ��Ǹ� ȭ�鿡 �׷���.
	}
}