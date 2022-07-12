package J2_���������_������Ʈ1_���;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class MemberDAO {
	int max;
	Member[] memberList;
	int memberCount;
	Scanner scan;
	String path;
	
	void init(String path , int size) {
		this.path =  path;
		max = size;
		memberList = new Member[max];
		memberCount = 0;
		scan = new Scanner(System.in);
	}
	
	void insertMember(Member member) {
		memberList[memberCount] = member;
		memberCount += 1;
	}
	
	boolean checkMemberId(String id) {
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				return true;
			}
		}		
		return false;
	}
	boolean checkMemberIdAndPw(String id , String pw) {
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id) &&
					memberList[i].pw.equals(pw)) {
				return true;
			}
		}		
		return false;
	}
	void updateMember(int index , Member member) {
		memberList[index] = member;		
	}
	int getMemberIndex(String id) {
		int index = 0;
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				index = i;
				break;
			}
		}
		return index;
	}
	void removeMember(int index) {
		for(int i = index; i < memberCount - 1 ; i++) {
			memberList[i] = memberList[i + 1];
		}
		memberCount -= 1;
	}
	
	Member getMember(String id) {
		Member member = null;
		for(int i = 0; i < memberCount; i++) {
			if(memberList[i].id.equals(id)) {
				member = memberList[i];
				break;
			}
		}
		return member;
	}
	void printMemberList() {
		for(int i = 0; i < memberCount; i++) {
			memberList[i].printMember();
		}
	}
	
	String getSaveFile() {
		String data = "";
		if(memberCount == 0) {
			return null;
		}
		for(int i = 0; i < memberCount; i++) {
			data += memberList[i].id;
			data += ",";
			data += memberList[i].pw;
			data += ",";
			data += memberList[i].name;
			data += "\n";
		}
		System.out.println(data);		
		data = data.substring(0 , data.length()-1);		
		return data;
	}
	
	boolean saveMember() {
		String data = getSaveFile();		
		if(data == null) {
			return false;
		}
		FileWriter fw = null;
		try {
			fw = new FileWriter(path);
			fw.write(data);
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}
		
	boolean loadMember() {			
		
		File file =new File(path);
		if(file.exists() == false) {
			return false;
		}
		
		String data = "";	
		FileReader fr = null;
		
		try {
			fr = new FileReader(path); //  ����� ������ �о�´�.			
			while(true) {
				int read = fr.read(); 		// �ѱ��ھ�  int �� �����´�. 
				if(read != -1) {
					data += (char)read; 	// read���� int�� char�� ����ȯ�� ����				
				}
				else {
					break;
				}				
			}			
			fr.close();  		
			
			if(data.equals("")) {
				return false;
			}
			
			String [] tokens = data.split("\n");
			memberCount = tokens.length;
			
			for(int i = 0; i < memberCount; i++) {
				String[] tokens2 = tokens[i].split(",");
				
				memberList[i] = new Member();				
				memberList[i].id = tokens2[0];
				memberList[i].pw = tokens2[1];
				memberList[i].name = tokens2[2];
			}
								
		} catch (Exception e) {
			e.printStackTrace();
		}		
		return true;
	}
	
	void join() {
		System.out.println("[�߰�] ���̵��Է� : ");
		String id = scan.next();
		boolean result = checkMemberId(id);
		if (result == true) {
			System.out.println("[�ߺ����̵�]");
		} else {
			System.out.println("[�߰�] ��й�ȣ�Է� : ");
			String pw = scan.next();
			System.out.println("[�߰�] �̸��Է� : ");
			String name = scan.next();
			Member member = new Member();
			member.id = id;
			member.pw = pw;
			member.name = name;
			insertMember(member);
			System.out.println("[�߰�����]");
		}
	}

	void delete() {
		System.out.println("[����] ���̵��Է� : ");
		String id = scan.next();
		boolean result = checkMemberId(id);
		if (result == false) {
			System.out.println("[���̵� ã���� �����ϴ�]");
		} else {
			int index = getMemberIndex(id);
			removeMember(index);
			System.out.println("[��������]");
		}
	}

	void update() {
		System.out.println("[����] ���̵��Է� : ");
		String id = scan.next();
		System.out.println("[����] ��й�ȣ�Է� : ");
		String pw = scan.next();
		boolean result = checkMemberIdAndPw(id, pw);
		if (result == false) {
			System.out.println("[���̵� ã���� �����ϴ�]");
		} else {

			System.out.println("[����] �̸��Է� : ");
			String name = scan.next();
			Member member = getMember(id);
			member.name = name;
			System.out.println("[�����Ϸ�]");
		}
	}
	
	void save() {
		boolean result = saveMember();
		if(result == false) {
			System.out.println("[�������]");
		}else {
			System.out.println("[���强��]");
		}
	}
	void load() {
		boolean result = loadMember();
		if(result == false) {
			System.out.println("[�ҷ����� ����]");
		}else {
			System.out.println("[�ҷ����� ����]");
		}
	}

}
