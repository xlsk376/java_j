package J2_���������_�⺻�̷�;

import java.io.FileWriter;
import java.io.IOException;

public class ���������_�⺻�̷�1_����3_������ {

	public static void main(String[] args) {
		String fileName = "src/J2_���������_�⺻�̷�/file01.txt"; // ��θ������ϸ� ������ ���尡��
		FileWriter fw = null; 
		try {
			fw = new FileWriter(fileName);
			fw.write("��ö��,10\n�̿���,30\n�ڸ���,50");
            fw.close(); // close�� ����� �ϵ忡 ������ �� , �����ָ� �ѹ��
		}catch(IOException e) { // Exception �� ����ص��ǰ� IOException ������ص��ȴ�.
			e.printStackTrace();
		}

	}

}
