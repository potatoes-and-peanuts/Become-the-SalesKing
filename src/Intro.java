import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Intro extends JFrame {
	
	private Image screenImage;
	private Graphics screenGraphic; //��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image IntroBackground=Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg"); 
	
	//�������ư �̹���
	private ImageIcon End=new ImageIcon("images/End.png");
	private ImageIcon OnEnd=new ImageIcon("images/OnEnd.png");
	
	//���۹�ư �̹���
	private ImageIcon BStartbtn = new ImageIcon("images/BeforeStart.png");
	private ImageIcon AStartbtn = new ImageIcon("images/AfterStart.png");
	private ImageIcon OnStartbtn = new ImageIcon("images/OnStart.png");
	
	//���۹�� �̹���
	private ImageIcon BHowToPlaybtn = new ImageIcon("images/BeforeHowToPlay.png");
	private ImageIcon AHowToPlaybtn = new ImageIcon("images/AfterHowToPlay.png");
	private ImageIcon OnHowToPlaybtn = new ImageIcon("images/OnHowToPlay.png");
	
	//������, ����, ���۹�� ��ư
	private JButton Endbtn = new JButton(End);
	private JButton Lbtn=new JButton(BStartbtn);
	private JButton Rbtn=new JButton(BHowToPlaybtn);
	
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
		Endbtn.setRolloverIcon(OnEnd);
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
		Lbtn.setPressedIcon(AStartbtn); //������ ���� �̹���
		Lbtn.setRolloverIcon(OnStartbtn); //�̹��� ���� ���콺 �÷��� ���� �̹��� 
		
		Lbtn.setBounds(350, 620, 220, 100); //��ư�� ��ġ �� ũ�� ����
		Lbtn.setBorderPainted(false); 
		Lbtn.setFocusPainted(false);
		Lbtn.setContentAreaFilled(false); 
		//Lbtn.addMouseListener(new MyMouse());
		add(Lbtn);
		
		//<���۹�� ��ư>
		Rbtn.setPressedIcon(AHowToPlaybtn);
		Rbtn.setRolloverIcon(OnHowToPlaybtn);

		Rbtn.setBounds(810, 620, 220, 100);
		Rbtn.setBorderPainted(false);
		Rbtn.setFocusPainted(false);
		Rbtn.setContentAreaFilled(false);
		add(Rbtn);	
	}

	public void paint(Graphics g) { //GUIȭ�� �� ���� ù��° ȭ���� �׷��ִ� �Լ�
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); //ScreenImage�� 1200X700�� �̹����� �־���
		screenGraphic = screenImage.getGraphics(); //�ٱ׷����� �̿��ؼ� ��ũ���׷����� ���� 
		screenDraw(screenGraphic); //screenDraw ȣ��
		g.drawImage(screenImage, 0, 0, null); //screenImage�� �̹����� (0,0)��ġ�� �׷���.
	}
	
	public void screenDraw(Graphics g) {
		g.drawImage(IntroBackground, 0, 0, null); //IntroBackground�� �̹����� (0,0)��ġ�� �׷���.
		paintComponents(g); //������Ʈ ����
		this.repaint(); //��üȭ�� �̹����� �� �������� �׷���, ���α׷� ����~������� �ݺ��Ǹ� ȭ�鿡 �׷���.
	}
	
}