
class Menu {
	public static void main(String[] args) {

		String menu_name[]= {"���˳װ�����ũ","����������纣����ī��","ġŰġŰ���ڸ�ī��","�ƺ��� �ܰ��� ��","�߸��߸������༺�� ���̵�",
				"�������丮���� ����ũ","��ܸ��̳���Ƹ޸�ī��","���ܾ��ܻ���̾ƴϹ��̴���Ű","�Ž��ּ��������� ��Ű"};
		
		int menu_number[]=new int[9];
		
		int found, input_number=0;
		
		System.out.println("�մ��� �ֹ��Ͻ� �޴���?");
		for (int i = 0; i < 9;){
			while (true){
				menu_number[i] = (int)(Math.random()*10);
				found = 0;
				for (int j = 0; j < i; ++j) {
					if (menu_number[j] == menu_number[i]){
						found = 1;
						break;
					}
					if (found==0) 	
						break;
				}
			}
		}

			for (int k = 0; k < 9; k++) {
				input_number = menu_number[k];
				if (k % 3 == 0) {
					System.out.println("");
					System.out.println("");
					System.out.println("------------------------------------------------------------------------------------------");
					System.out.println("");
				}
				System.out.println("    "+menu_name[input_number]+"	");
			}
			System.out.println("");
			System.out.println("");
			System.out.println("------------------------------------------------------------------------------------------");		
			}
	}
