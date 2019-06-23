import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.rmi.server.SocketSecurityException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

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
	
	//������, ����, ���۹�� ��ư
	private JButton Endbtn = new JButton(End[0]);
	private JButton Lbtn=new JButton(Startbtn[0]);
	private JButton Rbtn=new JButton(HowToPlaybtn[0]);
	private JButton Bbtn=new JButton(Backbtn[0]);
	private JButton Cbtn=new JButton(Checkbtn[0]);
	
	
	private JTextField Name = new JTextField(20);
	private JTextField SName = new JTextField(20);
	
	Intro(){
		setTitle("������� ����!!");
	
		setUndecorated(true); //�������� �� �⺻������ ���̴� �޴��ٰ� �� ����.
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //â �����, ���α׷��� ������ �����ϰ� ����.	
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //â ȭ�� ũ������
		
		setResizable(false); //�� �� ����� â ũ�� ���� �Ұ����ϰ� ��.
		setLocationRelativeTo(null); //�������� �� â�� ��ǻ���� ���߾ӿ� �߰� ��.
		setVisible(true); //â�� ���̰� ���ִ� ��
		
		setBackground(new Color(0, 0, 0, 0)); //PaintComponent�� ���� �� ����� ȸ���� �ƴ� ������� ����.
		setLayout(null); //��ư�̳� ���� �־��� �� �� ��ġ�� �����ϵ��� ����.
		
		//<�����ư>
		Endbtn.setRolloverIcon(End[1]);
		Endbtn.setBounds(1250, 10, 100, 80);
		Endbtn.setBorderPainted(false);
		Endbtn.setFocusPainted(false);
		Endbtn.setContentAreaFilled(false);
		Endbtn.addMouseListener(new MouseAdapter(){ 
			@Override
			public void mousePressed(MouseEvent e) { //������ �� ���α׷� ����
				System.exit(0); 
			}
		});
		add(Endbtn); //��ư ����
		
		//<���۹�ư>
		Lbtn.setPressedIcon(Startbtn[1]); //������ ���� �̹���
		Lbtn.setRolloverIcon(Startbtn[2]); //�̹��� ���� ���콺 �÷��� ���� �̹���
		Lbtn.setBounds(350, 620, 220, 100); //��ư�� ��ġ �� ũ�� ����
		Lbtn.setBorderPainted(false); 
		Lbtn.setFocusPainted(false);
		Lbtn.setContentAreaFilled(false); 
		Lbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Background = Toolkit.getDefaultToolkit().createImage("images/Initbackground.jpg"); // ����̹��� ����
				Rbtn.setVisible(false); 
				Lbtn.setVisible(false); //�����������Բ� �����
				
				//�̸� �Է�
				add(Name);
				Name.setVisible(true); 
				Name.setBounds(590, 250, 400, 80);
				Name.setFont(new Font("BOLD", Font.BOLD, 50));
				
				Cbtn.setPressedIcon(Checkbtn[1]); //������ ���� �̹���
				Cbtn.setRolloverIcon(Checkbtn[2]); //�̹��� ���� ���콺 �÷��� ���� �̹���
				Cbtn.setBounds(550, 620, 220, 100); //��ư�� ��ġ �� ũ�� ����
				Cbtn.setBorderPainted(false); 
				Cbtn.setFocusPainted(false);
				Cbtn.setContentAreaFilled(false); 
				add(Cbtn);

				Cbtn.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						String name = Name.getText();
						String sname = SName.getText();
					}
				});
				
				//���� �̸� �Է�
				add(SName);
				SName.setVisible(true);
				SName.setBounds(590, 420, 400, 80);
				SName.setFont(new Font("BOLD", Font.BOLD, 50));
					
			}
		});
		
		
		add(Lbtn);
		
		
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
				Lbtn.setVisible(false); // ���۹�ư�� ������ �ʰ� ��
				Rbtn.setVisible(false); // ���۹�ư�� ������ �ʰ� ��
				Background = Toolkit.getDefaultToolkit().createImage("images/HowToPlaybackground.jpg"); // ����̹��� ����
				Bbtn.setBounds(1050, 610, 180, 110); //��ư�� ��ġ �� ũ�� ����
				Bbtn.setBorderPainted(false); 
				Bbtn.setFocusPainted(false);
				Bbtn.setContentAreaFilled(false); 
				add(Bbtn);
			} 
		}); 

		//#2 <�ڷΰ����ư>
		Bbtn.setPressedIcon(Backbtn[1]); //������ ���� �̹���
		Bbtn.setRolloverIcon(Backbtn[2]); //�̹��� ���� ���콺 �÷��� ���� �̹��� 	
		Bbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				Bbtn.setVisible(false); 
				Lbtn.setVisible(true);  // ���۹�ư�� ����
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