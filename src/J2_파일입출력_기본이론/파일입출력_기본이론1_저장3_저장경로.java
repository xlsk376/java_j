package J2_파일입출력_기본이론;

import java.io.FileWriter;
import java.io.IOException;

public class 파일입출력_기본이론1_저장3_저장경로 {

	public static void main(String[] args) {
		String fileName = "src/J2_파일입출력_기본이론/file01.txt"; // 경로를지정하면 폴더에 저장가능
		FileWriter fw = null; 
		try {
			fw = new FileWriter(fileName);
			fw.write("김철수,10\n이영희,30\n박만수,50");
            fw.close(); // close를 해줘야 하드에 저장이 됨 , 안해주면 롤백됨
		}catch(IOException e) { // Exception 을 사용해도되고 IOException 을사용해도된다.
			e.printStackTrace();
		}

	}

}
