package J3_벡터_기본이론;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Scanner;

public class 벡터_기본이론2_학생관리 {

	public static void main(String[] args) {
		// 2차원배열 컨트롤러
		// 데이터 저장 방식 : 번호 + 점수3개 
		// 예) 1001, 20, 30, 40
		// 예) 1002, 40, 60, 60
		// 예) 1003, 10, 20, 30
		
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
			
			System.out.println("[벡터 컨트롤러]");
			System.out.println("[0]종료");
			System.out.println("[1]추가");
			System.out.println("[2]삭제(인덱스)");
			System.out.println("[3]삭제(학생번호)");
			System.out.println("[4]삽입");
			System.out.println("[5]저장");
			System.out.println("[6]로드");
			
			System.out.println("메뉴 선택 : ");
			int sel = scan.nextInt();
			if(sel == 1) { // 추가
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
					System.out.println("과목" + (i+1) + " 점수 : ");
					scoreList[count][i] = scan.nextInt();
				}
				num += 1;
				count += 1;
			}else if(sel == 2) { // 삭제(인덱스)
				System.out.println("삭제할 인덱스 입력");
				int delIdx = scan.nextInt();
				
				if(count-1 < delIdx || delIdx < 0) {
					System.out.println("해당위치는 삭제할 수 업습니다");
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
			}else if(sel == 3) { // 삭제(학생번호)
				System.out.println("삭제할 번호를 입력하세요");
				int delNum = scan.nextInt();
				
				int delIdx = -1;
				for(int i = 0; i < count; i++) {
					if(delNum == numberList[i]) {
						delIdx = i;
					}
				}
				if(delIdx == -1) {
					System.out.println("해당 번호는 존재하지 않습니다.");
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
			}else if(sel == 4) { // 삽입
				System.out.println("삽입할 인덱스 입력");
				int insertIdx = scan.nextInt();
				
				if(count < insertIdx || insertIdx < 0) {
					System.out.println("해당 위치엔 삽입할 수 없습니다");
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
					System.out.println("과목" + (i+1) + " 점수 : ");
					scoreList[insertIdx][i] = scan.nextInt();
				}
				num += 1;
				count += 1;
				
			}else if(sel == 5) { // 저장
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
					System.out.println("저장성공");
				}catch(Exception e) {
					e.printStackTrace();
					System.out.println("저장실패");
				}
				
			}else if(sel == 6) { // 로드
				String data = "";
				File file = new File("member.txt");
				
				if(file.exists() == false) {
					System.out.println("파일을 확인해주세요");
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
						System.out.println("불러오기 성공");
					}catch(Exception e) {
						e.printStackTrace();
					}
				}
			}else if(sel == 0) { // 종료
				System.out.println("종료");
				break;
			}
		}

	}

}
