package J2_���������_�⺻�̷�;

import java.io.File;
import java.io.FileReader;

public class ���������_�⺻�̷�2_�ҷ�����2_���Ȯ�� {

	public static void main(String[] args) {
		String fileName = "src/J2_���������_�⺻�̷�/file01.txt";
		FileReader fr = null;
		String data = "";

		File file = new File(fileName); // ������ �ִ��������� ��θ� Ȯ���Ҽ��ִ�.
		if (file.exists()) {
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

				System.out.println(data);

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			System.out.println("�ҷ����� ����");
		}

	}

}
