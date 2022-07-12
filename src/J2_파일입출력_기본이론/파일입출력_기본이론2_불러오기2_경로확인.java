package J2_파일입출력_기본이론;

import java.io.File;
import java.io.FileReader;

public class 파일입출력_기본이론2_불러오기2_경로확인 {

	public static void main(String[] args) {
		String fileName = "src/J2_파일입출력_기본이론/file01.txt";
		FileReader fr = null;
		String data = "";

		File file = new File(fileName); // 파일이 있는지없는지 경로를 확인할수있다.
		if (file.exists()) {
			try {
				fr = new FileReader(fileName); // 저장된 파일을 읽어온다.
				while (true) {
					int read = fr.read(); // 한글자씩 int 로 가져온다.
					if (read != -1) {
						data += (char) read; // read값이 int형 char로 형변환후 저장
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
			System.out.println("불러오기 실패");
		}

	}

}
