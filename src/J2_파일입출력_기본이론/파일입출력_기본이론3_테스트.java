package J2_���������_�⺻�̷�;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class ���������_�⺻�̷�3_�׽�Ʈ {

	public static void main(String[] args) {
		/*
	    String nameData = "��ö��,�̸���,�̿���";
		String ageData ="20,30,40";
		*/

		// ����1) ��ö��/20\n�̸���/30\n�̿���/40
		// �̷��� ����� ��������

		// ����2) ������ �ҷ��ͼ� �Ʒ� �迭�� ����
		String nameData = "��ö��,�̸���,�̿���";
		String ageData ="20,30,40";
		String fileName = "src/J2_���������_�⺻�̷�/file_test.txt";
		String data = "";
		
		String[] nameList = null;
		int[] ageList = null;
		FileWriter fw = null;
		FileReader fr = null;
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.println("[0] ���� [1] ���� [2] �ε�");
			int sel = scan.nextInt();
			if(sel == 0) {
				System.out.println("����");
				break;
			}else if(sel == 1) {
				String nameSample[] = nameData.split(",");
				String ageSample[] = ageData.split(",");
				try {
					data = "";
					fw = new FileWriter(fileName);
					
					for(int i = 0; i < nameSample.length; i++) {
						data += nameSample[i];
						data += ",";
						data += ageSample[i];
						data += "\n";
					}
					data = data.substring(0, data.length()-1);
					fw.write(data);
					fw.close();
					
				}catch(Exception e){
					
				}
				System.out.println(data);
			}else if(sel == 2) {
				data ="";
				try {
					fr = new FileReader(fileName);
					while(true) {
						int read = fr.read(); // �ѱ��ھ� int �� ������
						if(read != -1) {
							data += (char)read; // read���� int�� -> char�� ����ȯ�� ����
						}else {
							break;
						}
					}
				}catch(Exception e) {
					
				}
				System.out.println(data); // ���� �ε��Ͽ� data�� ����
				
				// ���� �ε��Ͽ� �����ѵ� ���� ���� �°� �迭�� ����
				String token[] = data.split("\n");
				int size = token.length;
				nameList = new String[size];
				ageList = new int[size];
				
				for(int i = 0; i < size; i ++) {
					String token2[] = token[i].split(",");
					nameList[i]= token2[0];
					ageList[i] = Integer.parseInt(token2[1]);
				}
				System.out.println("---------------------------");
				
				for(int i = 0; i < size; i++) {
					System.out.println(nameList[i] + " " + ageList[i]);
				}
			}
		}

	}

}
