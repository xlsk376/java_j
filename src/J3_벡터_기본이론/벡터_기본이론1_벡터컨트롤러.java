package J3_����_�⺻�̷�;

import java.util.Scanner;

public class ����_�⺻�̷�1_������Ʈ�ѷ� {

	public static void main(String[] args) {
		/*
		 * # �迭 ��Ʈ�ѷ�(���ѹ迭) : ����(Vector)
		 * 1. �߰�
		 * . ���� �Է¹޾� ���������� �߰�
		 * 2. ����(�ε���)
		 * . �ε����� �Է¹޾� �ش� ��ġ�� �� ����
		 * 3. ����(��)
		 * . ���� �Է¹޾� ����
		 * 
		 * . ���� �� �Է� �� ����ó��
		 * 4. ����
		 * . �ε����� ���� �Է¹޾� ����
		 */
		Scanner scan = new Scanner(System.in);
		int[] score = null;
		int count = 0;
		
		while(true) {
			for(int i = 0; i < count; i++) {
				System.out.println(score[i] + " ");
			}
			System.out.println();
			
			System.out.println("[���� ��Ʈ�ѷ�]");
			System.out.println("[1]�߰�");
			System.out.println("[2]����(�ε���)");
			System.out.println("[3]����(��)");
			System.out.println("[4]����");
			System.out.println("[0]����");
			
			System.out.print("�޴� ���� : ");
			int sel = scan.nextInt();
			
			if(sel == 1) {
				if(count == 0) {
					score = new int[count + 1];
				}else if(count > 0) {
					int[] temp = score;
					score = new int[count+1];
					
					for(int i = 0; i < count; i++) {
						score[i] = temp[i];
					}
					temp = null;
				}
				System.out.println("�߰����� �Է� : ");
				int data = scan.nextInt();
				
				score[count] = data;
				count += 1;
			}else if(sel == 2) {
				System.out.println("���� �ε��� �Է� : ");
				int delIdx = scan.nextInt();
				
				if(count-1 < delIdx || delIdx < 0) {
					System.out.println("�ش� ��ġ�� ������ �� �����ϴ�.");
					continue;
				}
				if(count == 1) {
					score = null;
				}else if(count > 1) {
					int[] temp = score;
					score = new int[count - 1];
					
					for(int i = 0; i < delIdx; i++) {
						score[i] = temp[i];
					}
					for(int i = delIdx; i < count-1; i++) {
						score[i] = temp[i + 1];
					}
					temp = null;
				}
				count -= 1;
			}else if(sel == 3) {
				System.out.println("������ �Է� : ");
				int delData = scan.nextInt();
				
				int delIdx = -1;
				for(int i = 0; i < count; i++) {
					if(score[i] == delData) {
						delIdx = i;
					}
				}
				if(delIdx == -1) {
					System.out.println("�Է��Ͻ� ���� �������� �ʽ��ϴ�");
					continue;
				}
				if(count == 1) {
					score = null;
				}else if(count > 1) {
					int[] temp = score;
					score = new int[count - 1];
					
					int j = 0;
					for(int i = 0; i < count; i++) {
						if(i != delIdx) {
							score[j] = temp[i];
							j += 1;
						}
					}
					temp = null;
				}
				count -= 1;
			}else if(sel == 4) {
				System.out.println("���� �ε��� �Է�");
				int insertIdx = scan.nextInt();
				
				if(count < insertIdx || insertIdx < 0) {
					System.out.println("�ش� ��ġ�� ������ �� �����ϴ�.");
					continue;
				}
				System.out.println("�� �Է� : ");
				int insertData = scan.nextInt();
				
				if(count == 0) {
					score = new int[count +1];
				}else if(count > 0) {
					int[] temp = score;
					score = new int[count + 1];
					
					int j = 0;
					for(int i = 0; i < count; i++) {
						if(i != insertIdx) {
							score[i] = temp[j];
							j += 1;
						}
					}
					temp = null;
				}
				score[insertIdx] = insertData;
				count += 1;
				
			}else if(sel == 0) {
				System.out.println("����");
				break;
			}
		}

	}

}
