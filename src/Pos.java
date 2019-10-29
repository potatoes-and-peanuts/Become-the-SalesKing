import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")

class Pos extends JFrame{
	private ImageIcon B_menu[] = {new ImageIcon("images/B_menu1.png"),new ImageIcon("images/B_menu2.png"),new ImageIcon("images/B_menu3.png"),
			new ImageIcon("images/B_menu4.png"),new ImageIcon("images/B_menu5.png"),new ImageIcon("images/B_menu6.png"),
			new ImageIcon("images/B_menu7.png"),new ImageIcon("images/B_menu8.png"),new ImageIcon("images/B_menu9.png")};

	private ImageIcon A_menu[] = {new ImageIcon("images/A_menu1.png"),new ImageIcon("images/A_menu2.png"),new ImageIcon("images/A_menu3.png"),
			new ImageIcon("images/A_menu4.png"),new ImageIcon("images/A_menu5.png"),new ImageIcon("images/A_menu6.png"),
			new ImageIcon("images/A_menu7.png"),new ImageIcon("images/A_menu8.png"),new ImageIcon("images/A_menu9.png")};
	
	private ImageIcon On_menu[] = {new ImageIcon("images/On_menu1.png"),new ImageIcon("images/On_menu2.png"),new ImageIcon("images/On_menu3.png"),
				new ImageIcon("images/On_menu4.png"),new ImageIcon("images/On_menu5.png"),new ImageIcon("images/On_menu6.png"),
				new ImageIcon("images/On_menu7.png"),new ImageIcon("images/On_menu8.png"),new ImageIcon("images/On_menu9.png")};
	
	private ImageIcon Inventory[]= {new ImageIcon("images/B_Inventory_btn.png"),new ImageIcon("images/A_Inventory_btn.png"),new ImageIcon("images/On_Inventory_btn.png")};
	
	private ImageIcon Init[]= {new ImageIcon("images/B_init.png"),new ImageIcon("images/A_init.png"),new ImageIcon("images/On_init.png")};
	
	private JButton Menu1 = new JButton(B_menu[0]);
	private JButton Menu2 = new JButton(B_menu[1]);
	private JButton Menu3 = new JButton(B_menu[2]);
	private JButton Menu4 = new JButton(B_menu[3]);
	private JButton Menu5 = new JButton(B_menu[4]);
	private JButton Menu6 = new JButton(B_menu[5]);
	private JButton Menu7 = new JButton(B_menu[6]);
	private JButton Menu8 = new JButton(B_menu[7]);
	private JButton Menu9 = new JButton(B_menu[8]);
	
	private JButton Inventory_btn = new JButton(Inventory[0]);
	
	private JButton Init_btn = new JButton(Init[0]);
	
	private JLabel total_label = new JLabel("���� : ");
//	private JTextField total_cost = new JTextField("0",10);
//	private JTextField total_cost2 = new JTextField("0",10);

	// MyTableModel model;

	DefaultTableModel dmodel;
	JTable table;
	JScrollPane scroll;
	Vector colName = new Vector();
	int selRow; // ������ ��
	String bar = "";
	int no = 1;
	Vector record;
	Vector vec;

	Pos(){
        // ����, ���⼭ setDefaultCloseOperation() ���Ǹ� ���� ���ƾ� �Ѵ�
        // �����ϰ� �Ǹ� �� â�� ������ ��� â�� ���α׷��� ���ÿ� ������
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 1340, 780);
        
        Menu1.setBounds(660, 40,200,150);
		Menu1.setBorderPainted(false);
		Menu1.setFocusPainted(false);
		Menu1.setContentAreaFilled(false);
		Menu1.setPressedIcon(A_menu[0]);
		Menu1.setRolloverIcon(On_menu[0]);
		add(Menu1);
		panel.add(Menu1);
		Menu1.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=4000;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("���� �� �� ����ũ")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("���� �� �� ����ũ");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("���� �� �� ����ũ");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu2.setBounds(870, 40,200,150);
		Menu2.setBorderPainted(false);
		Menu2.setFocusPainted(false);
		Menu2.setContentAreaFilled(false);
		Menu2.setPressedIcon(A_menu[1]);
		Menu2.setRolloverIcon(On_menu[1]);
		add(Menu2);
		panel.add(Menu2);
		Menu2.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=2500;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("�������� ��纣�� ��ī��")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("�������� ��纣�� ��ī��");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("�������� ��纣�� ��ī��");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu3.setBounds(1080, 40,200,150);
		Menu3.setBorderPainted(false);
		Menu3.setFocusPainted(false);
		Menu3.setContentAreaFilled(false);
		Menu3.setPressedIcon(A_menu[2]);
		Menu3.setRolloverIcon(On_menu[2]);
		add(Menu3);
		panel.add(Menu3);
		Menu3.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=2500;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("ġŰġŰ ���� ��ī��")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("ġŰġŰ ���� ��ī��");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("ġŰġŰ ���� ��ī��");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu4.setBounds(660, 200,200,150);
		Menu4.setBorderPainted(false);
		Menu4.setFocusPainted(false);
		Menu4.setContentAreaFilled(false);
		Menu4.setPressedIcon(A_menu[3]);
		Menu4.setRolloverIcon(On_menu[3]);
		add(Menu4);
		panel.add(Menu4);
		Menu4.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=5500;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("�ƺ��� ���� �ܰ��� ��")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("�ƺ��� ���� �ܰ��� ��");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("�ƺ��� ���� �ܰ��� ��");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu5.setBounds(870, 200,200,150);
		Menu5.setBorderPainted(false);
		Menu5.setFocusPainted(false);
		Menu5.setContentAreaFilled(false);
		Menu5.setPressedIcon(A_menu[4]);
		Menu5.setRolloverIcon(On_menu[4]);
		add(Menu5);
		panel.add(Menu5);
		Menu5.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=5000;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("�߸��߸� �����༺�� ���̵�")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("�߸��߸� �����༺�� ���̵�");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("�߸��߸� �����༺�� ���̵�");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu6.setBounds(1080, 200,200,150);
		Menu6.setBorderPainted(false);
		Menu6.setFocusPainted(false);
		Menu6.setContentAreaFilled(false);
		Menu6.setPressedIcon(A_menu[5]);
		Menu6.setRolloverIcon(On_menu[5]);
		add(Menu6);
		panel.add(Menu6);
		Menu6.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=4000;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("���� ��Ʈ�κ��� ����ũ")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("���� ��Ʈ�κ��� ����ũ");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("���� ��Ʈ�κ��� ����ũ");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu7.setBounds(660, 360,200,150);
		Menu7.setBorderPainted(false);
		Menu7.setFocusPainted(false);
		Menu7.setContentAreaFilled(false);
		Menu7.setPressedIcon(A_menu[6]);
		Menu7.setRolloverIcon(On_menu[6]);
		add(Menu7);
		panel.add(Menu7);
		Menu7.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=3000;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("��� ���̳��� �Ƹ޸�ī��")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("��� ���̳��� �Ƹ޸�ī��");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("��� ���̳��� �Ƹ޸�ī��");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu8.setBounds(870, 360,200,150);
		Menu8.setBorderPainted(false);
		Menu8.setFocusPainted(false);
		Menu8.setContentAreaFilled(false);
		Menu8.setPressedIcon(A_menu[7]);
		Menu8.setRolloverIcon(On_menu[7]);
		add(Menu8);
		panel.add(Menu8);
		Menu8.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=3500;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("�Ž� �ּ� �������� ���")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("�Ž� �ּ� �������� ���");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("�Ž� �ּ� �������� ���");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
		
		Menu9.setBounds(1080, 360,200,150);
		Menu9.setBorderPainted(false);
		Menu9.setFocusPainted(false);
		Menu9.setContentAreaFilled(false);
		Menu9.setPressedIcon(A_menu[8]);
		Menu9.setRolloverIcon(On_menu[8]);
		add(Menu9);
		panel.add(Menu9);
		Menu9.addMouseListener(new MouseAdapter() {
			int count=1;
			int price=3500;
			public void mousePressed(MouseEvent e) {
				if(table.getRowCount()!=0) {
					for(int i=0;i<table.getRowCount();i++) {
						if(table.getValueAt(i, 1).equals("���ܾ��� ����ϱ�� ��Ű")) {
							table.setValueAt(count+=1, i, 2);
							table.setValueAt(price*count, i, 3);
						}
					}
					if(count==1) {
						record = new Vector();
						record.addElement(no);
						no+=1;
						record.addElement("���ܾ��� ����ϱ�� ��Ű");
						record.addElement(count);
						record.addElement(price);
						dmodel.addRow(record);
					}
				}else {
					record = new Vector();
					record.addElement(no);
					no+=1;
					record.addElement("���ܾ��� ����ϱ�� ��Ű");
					record.addElement(count);
					record.addElement(price);
					dmodel.addRow(record);
				}
			}
		});
        
		Inventory_btn.setBounds(50,530,230,150);
		Inventory_btn.setBorderPainted(false);
		Inventory_btn.setFocusPainted(false);
		Inventory_btn.setContentAreaFilled(false);
		Inventory_btn.setPressedIcon(Inventory[1]);
		Inventory_btn.setRolloverIcon(Inventory[2]);
		add(Inventory_btn);
		panel.add(Inventory_btn); 
		Inventory_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
					new Manage();
				}
		});
			
		
		
		Init_btn.setBounds(330, 530, 230, 150);
		Init_btn.setBorderPainted(false);
		Init_btn.setFocusPainted(false);
		Init_btn.setContentAreaFilled(false);
		Init_btn.setPressedIcon(Init[1]);
		Init_btn.setRolloverIcon(Init[2]);
		add(Init_btn);
		panel.add(Init_btn);
		Init_btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				for(int i = dmodel.getRowCount() - 1; i >= 0; i--) {
					
					dmodel.removeRow(i);
					
					}
			}
		});
				
		
		/*���̺� ���� ����� �ڵ����� ���� �ݾ׳������ϴ� �̺�Ʈ*/
//		table.getModel().addTableModelListener(new TableModelListener() {
//			@Override
//			public void tableChanged(TableModelEvent e) {
//				int tcost=0;
//				int count=0;
//				// TODO Auto-generated method stub
//				for (int i = 0; i < dmodel.getRowCount(); i++) {
//					count = (Integer) table.getValueAt(i, 3);
//					tcost += count;
//				}
//				total_cost.setText(Integer.toString(tcost));
//				total_cost2.setText(total_cost.getText());
//			}
//		});
		
		colName.add("��ȣ"); //0

		colName.add("��ǰ��"); //1
		
		colName.add("����"); //2

		colName.add("�ݾ�"); //3

		// model = new MyTableModel();

		dmodel = new DefaultTableModel(colName, 0) {

		public boolean isCellEditable(int row, int column) {

		return false;

		}

		};

		table = new JTable(dmodel);

		scroll = new JScrollPane(table);

		scroll.setBounds(30,10,600,500);
		add(scroll);
		
		total_label.setBounds(600,540,300,150);
		total_label.setFont(total_label.getFont().deriveFont(40.0f));
		add(total_label);
		
		//���̺� ���� �ڵ� ��� �ڵ�
//		total_cost.setEditable(false);
//		total_cost2.setBounds(900,540,100,100);
//		add(total_cost2);
		
		add(panel);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); 
        setResizable(false);
        setVisible(true);

	}
}