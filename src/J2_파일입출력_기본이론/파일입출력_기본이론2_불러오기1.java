package J2_���������_�⺻�̷�;

import java.io.FileReader;

public class ���������_�⺻�̷�2_�ҷ�����1 {

	public static void main(String[] args) {
		// 1) FileReader fr = null; ��������
		// 1) fr = new FileReader(fileName); // ����� ������ �о�´�.
		// 2) fr.read(); // �ѱ��ھ� int �� �����´�.
		// 3) ������ ������ ������ -1�� ����ȴ�.
		// 3) fr.close(); // ����� �ݵ�� �ݾƾߵȴ�.

		String fileName = "src/J2_���������_�⺻�̷�/file01.txt";
		FileReader fr = null;
		String data = "";
		//Write �Ҷ��� �ѹ��� ���������� Read �Ҷ��� �ѱ��ڸ� �����´�
		try { 
			fr = new FileReader(fileName); // ����� ������ �о�´�.
			while (true) {
				int read = fr.read(); // �ѱ��ھ� int �� �����´�.
				if (read != -1) {
					data += (char) read; // read���� int�� char�� ����ȯ�� ����
				} else {
					break;
				}
			}
			fr.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(data);

	}

}
