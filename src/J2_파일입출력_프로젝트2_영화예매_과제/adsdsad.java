package J2_���������_������Ʈ2_��ȭ����_����;

import java.io.FileWriter;

public class adsdsad {
	public static void main(String[] args) {
		String fileName = "UserData.txt";
		FileWriter fw = null;
		
		try {
			fw = new FileWriter(fileName);
			fw.write("a,a,a\nb,b,b\nc,c,c\nhg,hg,hg\n");
			fw.close();
		}catch(Exception e) {
			e.printStackTrace();
		}		
	}
}
