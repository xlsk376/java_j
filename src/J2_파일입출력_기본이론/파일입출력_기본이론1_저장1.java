package J2_���������_�⺻�̷�;

import java.io.FileWriter;

public class ���������_�⺻�̷�1_����1 {

	public static void main(String[] args) {
		// ���̺� ���� �����
		// 1) �������� ==> FileWriter fw = null;
		// 1) ���� ���� ==> fw = new FileWriter("�����̸�");
		// 2) ���Ͽ� ���� ���� ==> fw.write(�����ҳ���);
		// 3) ���ϴݱ� ==> fw.close();

		String fileName = "file01.txt";
		FileWriter fw = null; // try �ۿ��� ����� ���� ���� �ۿ� ������ �����.
		int a = 10;
		try {
			fw = new FileWriter(fileName);
			fw.write("��ö��,10\n�̿���,30\n�ڸ���,50");
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 1. Run : Ctrl + F11
		// 2. ������Ʈ ���� ��,
		// F5(Refresh)�� ������ ������ �޸��� ������ Ȯ���� �� �ִ�.

	}

}
