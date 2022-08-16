package J3_����_�⺻�̷�;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
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
			if(sel == 1) { // �߰�
				if(count == 0) {
					numberList = new int[1];
					scoreList = new int[1][3];
				}else if(count > 0) {
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
					System.out.println("����" + (i+1) + " ���� : ");
					scoreList[count][i] = scan.nextInt();
				}
				num += 1;
				count += 1;
			}else if(sel == 2) { // ����(�ε���)
				System.out.println("������ �ε��� �Է�");
				int delIdx = scan.nextInt();
				
				if(count-1 < delIdx || delIdx < 0) {
					System.out.println("�ش���ġ�� ������ �� �����ϴ�");
					continue;
				}
				
				if(count == 1) {
					numberList = null;
					scoreList = null;
				}else if(count > 1) {
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
				System.out.println("������ ��ȣ�� �Է��ϼ���");
				int delNum = scan.nextInt();
				
				int delIdx = -1;
				for(int i = 0; i < count; i++) {
					if(delNum == numberList[i]) {
						delIdx = i;
					}
				}
				if(delIdx == -1) {
					System.out.println("�ش� ��ȣ�� �������� �ʽ��ϴ�.");
					continue;
				}
				
				if(count == 1) {
					numberList = null;
					scoreList = null;
				}else if(count > 1) {
					int[] numTemp = numberList;
					int[][] scoreTemp = scoreList;
					numberList = new int[count-1];
					scoreList = new int[count-1][];
					
					int j = 0;
					for(int i = 0; i < count; i++) {
						if(i != delIdx) {
							numberList[j] = numTemp[i];
							scoreList[j] = scoreTemp[i];
							j += 1;
						}
					}
					numTemp = null;
					scoreTemp = null;
				}
				count -= 1;
			}else if(sel == 4) { // ����
				System.out.println("������ �ε��� �Է�");
				int insertIdx = scan.nextInt();
				
				if(count < insertIdx || insertIdx < 0) {
					System.out.println("�ش� ��ġ�� ������ �� �����ϴ�");
					continue;
				}
				
				if(count == 0) {
					numberList = new int[1];
					scoreList = new int[1][3];
				}else if(count > 0) {
					int[] numTemp = numberList;
					int[][] scoreTemp = scoreList;
					numberList = new int[count+1];
					scoreList = new int[count+1][];
					scoreList[count] = new int[3];
					
					for(int i = 0; i < count; i++) {
						numberList[i] = numTemp[i];
					}
					
					int j = 0;
					for(int i = 0; i < count+1; i++) {
						if(i != insertIdx) {
							scoreList[i] = scoreTemp[j];
							j += 1;
						}
					}
					scoreTemp = null;
					scoreList[insertIdx] = new int[3];
				}
				numberList[count] = num;
				for(int i = 0; i < 3; i++) {
					System.out.println("����" + (i+1) + " ���� : ");
					scoreList[insertIdx][i] = scan.nextInt();
				}
				num += 1;
				count += 1;
				
			}else if(sel == 5) { // ����
				String data = "";
				for(int i = 0; i < count; i++) {
					data += numberList[i];
					data += ",";
					data += scoreList[i][0];
					data += ",";
					data += scoreList[i][1];
					data += ",";
					data += scoreList[i][2];
					data += "\n";
				}
				
				data = data.substring(0, data.length()-1);
				
				String path = "member.txt";
				FileWriter fw = null;
				
				try {
					fw = new FileWriter(path);
					fw.write(data);
					fw.close();
					System.out.println("���强��");
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("�������");
				}
				
			}else if(sel == 6) { // �ε�
				String data = "";
				File file = new File("member.txt");
				
				if(file.exists() == false) {
					System.out.println("������ Ȯ�����ּ���");
				}else {
					FileReader fr = null;
					try {
						fr = new FileReader("member.txt");
						while(true) {
							int read = fr.read();
							if(read != -1) {
								data += (char)read;
							}else {
								break;
							}
						}
						fr.close();
						String[] tokens = data.split("\n");
						numberList = new int[tokens.length];
						scoreList = new int[tokens.length][3];
						for(int i = 0; i < tokens.length; i++) {
							String[] tokens2 = tokens[i].split(",");
							numberList[i] = Integer.parseInt(tokens2[0]);
							scoreList[i][0] = Integer.parseInt(tokens2[1]);
							scoreList[i][1] = Integer.parseInt(tokens2[2]);
							scoreList[i][2] = Integer.parseInt(tokens2[3]);
						}
						count = tokens.length;
						num += tokens.length;
						System.out.println("�ҷ����� ����");
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}else if(sel == 0) { // ����
				System.out.println("����");
				break;
			}
		}

	}

}
