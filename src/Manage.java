import java.awt.Color;
import java.awt.Font;
import java.util.Vector;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

class Manage extends JFrame{
	JPanel panel = new JPanel();
	DefaultTableModel dmodel;
	JTable table;
	JScrollPane scroll;
	Vector colName = new Vector();
	
	Manage(){
		
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
		
		add(panel);
		setSize(1500,500); 
        setResizable(false);
        setVisible(true);
	}
}
