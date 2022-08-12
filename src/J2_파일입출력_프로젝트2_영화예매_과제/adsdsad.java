package J2_파일입출력_프로젝트2_영화예매_과제;

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
