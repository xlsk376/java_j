package J3_����_�˰���;

import java.util.Scanner;

public class ����_�˰���_�Խ���_���� {

	public static void main(String[] args) {
		/*
		 * # �ܼ� �Խ���
		 * - [����] �Ǵ� [����] ��ư�� ������ ������ ��ȣ�� ����ȴ�.
		 * - ����ȭ�鿡�� [��ȣ][����] �� ǥ�õǰ� �ش��ȣ�� �����ϸ� [����]�� �����ִ�.
		 * - ���� ������ ��ȣ�� �ش�Ǵ� �Խñ۸� �� �� �ִ�.
		 * - numberList ==> ��ȣ , subjectList ==> ���� , contentList ==> ����
		 * - ����������� ���� �����Ͱ� ����ȴ�.
		 * - ����Ǿ� �ִ� ������ �����Ѵٸ�, ������ �ҷ������� �����Ѵ�.
		 */
		
		
		Scanner scan = new Scanner(System.in);
		String fileName = "board.txt";
		
		int[] numberList = null;
		String[] subjectList = null;
		String[] contentList = null;
		
		int count = 0;				// ��ü �Խñ� ��
		int pageSize = 5;			// �� �������� ������ �Խñ� ��
		int curPageNum = 1;			// ���� ������ ��ȣ
		int pageCount = 0;			// ��ü ������ ����
		int startRow = 0;			// ���� �������� �Խñ� ���� ��ȣ
		int endRow = 0;				// ���� �������� �Խñ� ������ ��ȣ
		
		while(true) {
			System.out.println("[1]����");
			System.out.println("[2]����");
			System.out.println("[3]�߰��ϱ�");
			System.out.println("[4]�����ϱ�");
			System.out.println("[5]����Ȯ��");
			System.out.println("[6]����");
			System.out.println("[7]�ε�");

			int choice = scan.nextInt();
			
			if(choice == 1) {
				
			}
			else if(choice == 2) {
				
			}
			else if(choice == 3) {
				
			}
			else if(choice == 4) {
				
			}
			else if(choice == 5) {
				
			}
		}
	}

}
