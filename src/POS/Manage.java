package POS;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.PreparedStatement;

class Manage extends JFrame{
	
	Connection conn = null;
	PreparedStatement pstmt = null;
	private ResultSet viewRS;
	
	private ImageIcon m_menu[] = {new ImageIcon("images/M_menu1.png"),new ImageIcon("images/M_menu2.png"),new ImageIcon("images/M_menu3.png"),
			new ImageIcon("images/M_menu4.png"),new ImageIcon("images/M_menu5.png"),new ImageIcon("images/M_menu6.png"),
			new ImageIcon("images/M_menu7.png"),new ImageIcon("images/M_menu8.png"),new ImageIcon("images/M_menu9.png")};

	private ImageIcon On_menu[] = {new ImageIcon("images/M_OnMenu1.png"),new ImageIcon("images/M_OnMenu2.png"),new ImageIcon("images/M_OnMenu3.png"),
				new ImageIcon("images/M_OnMenu4.png"),new ImageIcon("images/M_OnMenu5.png"),new ImageIcon("images/M_OnMenu6.png"),
				new ImageIcon("images/M_OnMenu7.png"),new ImageIcon("images/M_OnMenu8.png"),new ImageIcon("images/M_OnMenu9.png")};
	
	private JButton M_menuBtn[] = new JButton[9];

	
	private ImageIcon Order[] = {new ImageIcon("images/order.png"), new ImageIcon("images/OnOrder.png")};
	private ImageIcon Cancel[] = { new ImageIcon("images/cancel.png"), new ImageIcon("images/OnCancel.png")};
	
	private JButton OrderBtn = new JButton(Order[0]);
	private JButton CancelBtn = new JButton(Cancel[0]);
	
	final String[] btn_Title= {"���� �� �� ����ũ","�������� ��纣�� ��ī��","ġŰġŰ ���� ��ī��",
								"�ƺ��� ���� �ܰ��� ��","�߸��߸� �����༺�� ���̵�","���� ��Ʈ�κ��� ����ũ",
								"��� ���̳��� �Ƹ޸�ī��","�Ž� �ּ� �������� ��Ű","���ܾ��� ����ϱ�� ��Ű"};
	final int[] menu_price= {4000,2500,2500,5500,5000,4000,3000,3500,3500};
	

	JPanel panel = new JPanel();
	JLabel label1 = new JLabel("�� �ֹ��Ͻðڽ��ϱ�?");
	JLabel label2 = new JLabel("?");
	JLabel label3 = new JLabel("�ֹ� ���� �Է� : ");
	JTextField tf = new JTextField();
	DefaultTableModel dmodel;
	JTable table;
	JScrollPane scroll;
	Vector colName = new Vector();
	Vector record;
	
	int num_index;//������ ��ư�� ���� btn_Title �����ִ� ����
	
	Manage(frame win, Pos pos){
		
		
		colName.add("���� �� �� ����ũ"); //0

		colName.add("�������� ��纣�� ��ī��"); //1
		
		colName.add("ġŰġŰ ���� ��ī��"); //2

		colName.add("�ƺ��� ���� �ܰ��� ��"); //3
		
		colName.add("�߸��߸� �����༺�� ���̵�"); //4
		
		colName.add("���� ��Ʈ�κ��� ����ũ"); //5
		
		colName.add("��� ���̳��� �Ƹ޸�ī��"); //6
		
		colName.add("�Ž� �ּ� �������� ��Ű"); //7
		
		colName.add("���ܾ��� ����ϱ�� ��Ű"); //8

		// model = new MyTableModel();
		
		
		

		dmodel = new DefaultTableModel(colName, 0) {

			public boolean isCellEditable(int row, int column) {
	
			return false;
	
			}

		};
		
		table = new JTable(dmodel);

		scroll = new JScrollPane(table);

		scroll.setBounds(60,30,1350,100);
		add(scroll);
	
		panel.setLayout(null);
		for(int i =0; i<btn_Title.length; i++){
			panel.add(M_menuBtn[i]=new JButton(m_menu[i]));
			M_menuBtn[i].setRolloverIcon(On_menu[i]);
			M_menuBtn[i].setSize(220,120);
			M_menuBtn[i].setLocation(60+(250*i), 130);
			M_menuBtn[i].setBorderPainted(false);
			M_menuBtn[i].setFocusPainted(false);
			M_menuBtn[i].setContentAreaFilled(false);
			
			if(i>4) {
				M_menuBtn[i].setLocation(60+(250*(i-5)), 210);
			}
		}
		
		for(int i=0; i<btn_Title.length; i++) {
			int num=i;
			M_menuBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
						label2.setText(btn_Title[num]);
						
				}});
		}
		
		label2.setBounds(580, 320, 200, 50);
		add(label2);
		
		label1.setBounds(750, 320, 200, 50);
		add(label1);
		
		label3.setBounds(600,370,100,50);
		add(label3);
		
		tf.setBounds(700,380,200,30);
		add(tf);
		
		OrderBtn.setBounds(900,340,170,110);
		OrderBtn.setBorderPainted(false);
		OrderBtn.setFocusPainted(false);
		OrderBtn.setContentAreaFilled(false);
		OrderBtn.setRolloverIcon(Order[1]);
		add(OrderBtn);
		OrderBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {	
					Class.forName("org.gjt.mm.mysql.Driver").newInstance();	
					conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/become_selling_king", "root", "mirim2");     
					System.out.println("DB ���� �Ϸ�");			
				}catch(Exception ex) {
			        System.out.println("Exception:" + ex);
			    }
				
				for(int i=0; i<9; i++) {
					if(label2.getText().equals(btn_Title[i])){
						num_index=i+1;
						break;
					}
				}
				
				try {
					int add = Integer.parseInt(tf.getText());
					win.money -= menu_price[num_index-1]*add;
					//System.out.println(win.money);
					if(win.money<0) {
						dispose();
						pos.dispose();
						win.change("ending"); //������ ���â���� ������. ���������� ���ߵ�
					}else { 
						String sql = "select * from inventory";
						pstmt = (PreparedStatement) conn.prepareStatement(sql);
						ResultSet rs = pstmt.executeQuery();
						String sql2 = "update inventory set m?=?";
						pstmt = (PreparedStatement) conn.prepareStatement(sql2);
						while(rs.next()) {
							pstmt.setInt(1, num_index);
							pstmt.setInt(2, rs.getInt(num_index)+add);
						}
						pstmt.executeUpdate();
						
						JOptionPane.showMessageDialog(null, 
								"�ֹ��� �Ϸ�Ǿ����ϴ�.", "�˸�", 
								JOptionPane.ERROR_MESSAGE);
					}
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		
		CancelBtn.setBounds(1350,350,150,110);
		CancelBtn.setBorderPainted(false);
		CancelBtn.setFocusPainted(false);
		CancelBtn.setContentAreaFilled(false);
		CancelBtn.setRolloverIcon(Cancel[1]);
		add(CancelBtn);
		CancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		add(panel);
		
		
		setSize(1500,500); 
        setResizable(false);
        setVisible(true);
	}
}
