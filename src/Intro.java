import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

class Intro extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic; // ��üȭ�鿡 ���� �� �ν��Ͻ�
	private Image Background = Toolkit.getDefaultToolkit().createImage("images/Introbackground.jpg");

	// ������ ��ư �̹���
	private ImageIcon End[] = { new ImageIcon("images/End.png"), new ImageIcon("images/OnEnd.png") };
	// ���۹�ư �̹���
	private ImageIcon Startbtn[] = { new ImageIcon("images/BeforeStart.png"), // ��[0] ����, ��[1] ���콺 �÷��� ��, ��[2] ���콺 ���� ��
			new ImageIcon("images/AfterStart.png"), new ImageIcon("images/OnStart.png") };
	// ���۹�� �̹���
	private ImageIcon HowToPlaybtn[] = { new ImageIcon("images/BeforeHowToPlay.png"),
			new ImageIcon("images/AfterHowToPlay.png"), new ImageIcon("images/OnHowToPlay.png") };
	// �ڷΰ��� ��ư
	public ImageIcon Backbtn[] = { new ImageIcon("images/BeforeBack.png"), new ImageIcon("images/AfterBack.png"),
			new ImageIcon("images/OnBack.png") };

	private ImageIcon Checkbtn[] = { new ImageIcon("images/BeforeCheck.png"), new ImageIcon("images/AfterCheck.png"),
			new ImageIcon("images/OnCheck.png") };

	private ImageIcon Nextbtn[] = { new ImageIcon("images/ANext.png"), new ImageIcon("images/BNext.png"),
			new ImageIcon("images/OnNext.png") };

	ImageIcon monster[] = { new ImageIcon("images/monster1.png"), new ImageIcon("images/monster2.png"),
			new ImageIcon("images/monster3.png"), new ImageIcon("images/monster4.png"),
			new ImageIcon("images/monster5.png") };

	private JLabel order[] = { new JLabel("���� �� �� ����ũ 3�� "), new JLabel("ġŰġŰ ���� ��ī�� 3��"),
			new JLabel("���� ���丮���� ����ũ 6��") };

	JLabel story[] = { new JLabel("����� ����л� ����"), new JLabel("����� �ϻ�."), new JLabel("��ҿ� �Ȱ��� ���� ������ ������ ���δ�."),
			new JLabel("������ ������ ������ �ٽ� �� ������ ���������忡 �ִ�."), new JLabel("���������忡�� �� ����� �Ⱬ�ϰ� ���� �ܰ����� �ִ�."),
			new JLabel("������ ó���� �ܰ����� ���� �ʹ� ��� �� �� �����߾���."),
			new JLabel("������ �ٽ� ������ ���� �� ���� �������Ѽ� �ܰ������� ���Ⱑ ������� ������ ����Ѵ�."), new JLabel("�����.. ���� �� ���嵵 �ǳ���..?"),
			new JLabel("���� ���̳�? �߻��Ѳ�") };

	private JLabel monsterLa = new JLabel(monster[1]);

	// ������, ����, ���۹�� ��ư
	private JButton Endbtn = new JButton(End[0]);
	private JButton Lbtn = new JButton(Startbtn[0]);
	private JButton Rbtn = new JButton(HowToPlaybtn[0]);

	private JButton Bbtn = new JButton(Backbtn[0]);
	private JButton Cbtn = new JButton(Checkbtn[0]);
	private JButton Nbtn = new JButton(Nextbtn[0]);

	private JButton clickbtn = new JButton("Click!");

	private JTextField Name = new JTextField(20);
	private JTextField SName = new JTextField(20); // ���� ����

	Intro() {
		setTitle("������� ����!!");

		setUndecorated(true); // �������� �� �⺻������ ���̴� �޴��ٰ� �� ����.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
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
		Lbtn.addMouseListener(new StartMouseAdapter());

		// ���۹�� ��ư
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

		// �ڷΰ����ư
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

	// �����ϱ� ��ư�� ���� ����� (���� �Է� ȭ��)
	class StartMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Background = Toolkit.getDefaultToolkit().createImage("images/Initbackground.jpg");
			Rbtn.setVisible(false);
			Lbtn.setVisible(false);

			// �̸� �Է�
			add(Name);
			Name.setVisible(true);
			Name.setBounds(640, 175, 400, 80);
			Name.setFont(new Font("BOLD", Font.BOLD, 50));

			// Ȯ�ι�ư
			Cbtn.setPressedIcon(Checkbtn[1]);
			Cbtn.setRolloverIcon(Checkbtn[2]);
			Cbtn.setBounds(560, 620, 220, 100);
			Cbtn.setBorderPainted(false);
			Cbtn.setFocusPainted(false);
			Cbtn.setContentAreaFilled(false);
			add(Cbtn);

			SName.setVisible(true);
			SName.setBounds(640, 415, 400, 80);
			SName.setFont(new Font("BOLD", Font.BOLD, 50));
			add(SName);

			Cbtn.addMouseListener(new ConfigtMouseAdapter());
		}
	}

	// �̸�, ���� �̸� �Է� ȭ���� Ȯ�� ��ư�� ���� ����� (���丮 ȭ��)
	class ConfigtMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Background = Toolkit.getDefaultToolkit().createImage("images/Storybackground.jpg");

			String name = Name.getText();
			String sname = SName.getText();

			Name.setVisible(false);
			SName.setVisible(false);
			Cbtn.setVisible(false);

			story[7].setBounds(100, 450, 400, 400);
			story[7].setFont(new Font("����ǹ��� �־�", Font.CENTER_BASELINE, 30));
			add(story[7]);

			add(Nbtn);
			Nbtn.setPressedIcon(Nextbtn[1]);
			Nbtn.setRolloverIcon(Nextbtn[2]);
			Nbtn.setBounds(1170, 625, 180, 110);
			Nbtn.setBorderPainted(false);
			Nbtn.setFocusPainted(false);
			Nbtn.setContentAreaFilled(false);

			Nbtn.addMouseListener(new NextMouseAdapter());

		}
	}

	// Next ��ư�� ���� ����� (�ֹ� ȭ��)
	class NextMouseAdapter extends MouseAdapter {
		@Override
		public void mousePressed(MouseEvent e) {
			Background = Toolkit.getDefaultToolkit().createImage("images/Menubackground.jpg");
			monsterLa.setBounds(10, 160, 400, 400);
			add(monsterLa);
			Nbtn.setVisible(false);
			story[7].setVisible(false);

			order[0].setBounds(520, 0, 400, 160);
			order[0].setFont(new Font("����ǹ��� ����", Font.CENTER_BASELINE, 25));
			add(order[0]);
			order[1].setBounds(520, 30, 400, 160);
			order[1].setFont(new Font("����ǹ��� ����", Font.CENTER_BASELINE, 25));
			add(order[1]);

			// click ��ư �ֱ�
			clickbtn.setBounds(927, 315, 130, 80);
			clickbtn.setBorderPainted(false);
			clickbtn.setFocusPainted(false);
			clickbtn.setContentAreaFilled(false);
			clickbtn.setFont(new Font("����ǹ��� ����", Font.BOLD, 30));
			clickbtn.setForeground(Color.BLUE);
			add(clickbtn);
			clickbtn.addMouseListener(new MouseAdapter() {
				public void mousePressed(MouseEvent e2) {
					new Pos();
				}
			});
		}
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