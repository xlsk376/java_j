package J3_����_�⺻�̷�;

import java.util.Scanner;

public class ����_�⺻�̷�2_�л����� {

	public static void main(String[] args) {
		// 2�����迭 ��Ʈ�ѷ�
		// ������ ���� ��� : ��ȣ + ����3�� 
		// ��) 1001, 20, 30, 40
		// ��) 1002, 40, 60, 60
		// ��) 1003, 10, 20, 30
		
		Scanner scan = new Scanner(System.in);
		
		int[] numberList = null;
		int[][] scoreList = null;
		int count = 0;
		int num = 1001;
		while(true) {
			for(int i = 0; i < count; i++) {
				System.out.print(numberList[i] + " ");
				for(int j = 0; j < 3; j++) {
					System.out.print(scoreList[i][j] + " ");
				}
				System.out.println();
			}
			
			System.out.println("[���� ��Ʈ�ѷ�]");
			System.out.println("[0]����");
			System.out.println("[1]�߰�");
			System.out.println("[2]����(�ε���)");
			System.out.println("[3]����(�л���ȣ)");
			System.out.println("[4]����");
			System.out.println("[5]����");
			System.out.println("[6]�ε�");
			
			System.out.println("�޴� ���� : ");
			int sel = scan.nextInt();
			if(sel == 1) {
				if(count == 0) {
					numberList = new int[1];
					scoreList = new int[1][3];
				}else {
					int[] numTemp = numberList;
					int[][] scoreTemp = scoreList;
					
					numberList = new int[count+1];
					scoreList = new int[count+1][];
					scoreList[count] = new int[3];
					
					for(int i = 0; i < count; i++) {
						numberList[i] = numTemp[i];
						scoreList[i] = scoreTemp[i];
					}
					
				}
				numberList[count] = num;
				for(int i = 0; i < 3; i++) {
					System.out.println("����" + (i+1) + "���� : ");
					scoreList[count][i] = scan.nextInt();
				}
				num += 1;
				count += 1;
			}else if(sel == 2) { // ����(�ε���)
				System.out.println("������ �ε��� �Է�");
				int delIdx = scan.nextInt();
				if(count-1 < delIdx || delIdx < 0) {
					System.out.println("�ش� ��ġ�� ������ �� �����ϴ�.");
					continue;
				}
				if(count == 1) {
					numberList = null;
					scoreList = null;
				}else if(count > 1){
					int[] numTemp = numberList;
					int[][] scoreTemp = scoreList;
					numberList = new int[count-1];
					scoreList = new int[count-1][];
					
					for(int i = 0; i < delIdx; i++) {
						numberList[i] = numTemp[i];
						scoreList[i] = scoreTemp[i];
					}
					for(int i = delIdx; i < count-1; i++) {
						numberList[i] = numTemp[i+1];
						scoreList[i] = scoreTemp[i+1];
					}
					numTemp = null;
					scoreTemp = null;
				}
				count -= 1;
			}else if(sel == 3) { // ����(�л���ȣ)
				System.out.println("������ ��ȣ�� �Է�");
				int delNumber = scan.nextInt();
				int delIdx = -1;
				for(int i = 0; i < count; i++) {
					if(numberList[i] == delNumber) {
						delIdx = i;
					}
				}
				if(delIdx == -1) {
					System.out.println("�Է��� ���� �������� �ʽ��ϴ�.");
					continue;
				}
				if(count == 1) {
					numberList = null;
					scoreList = null;
				}else if(count > 1) {
					
				}
				
				
			}else if(sel == 4) { // ����
				
			}else if(sel == 5) { // ����
				
			}else if(sel == 6) { // �ε�
				
			}else if(sel == 0) {
				System.out.println("����");
				break;
			}
		}

	}

}
