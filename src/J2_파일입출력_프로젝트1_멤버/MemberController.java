package J2_���������_������Ʈ1_���;

import java.util.Scanner;

public class MemberController {
	MemberDAO memberDAO;
	Scanner scan = new Scanner(System.in);

	void init() {
		memberDAO = new MemberDAO();
		memberDAO.init("src/J2_���������_������Ʈ1_���/memberList.txt" , 100);
		mainMenu();
	}
	void mainMenu() {
		while (true) {
			System.out.println("[0]���� [1]�߰� [2]���� [3]���� [4]��� "
					+ "[5]���� [6]�ε� ");
			int sel = scan.nextInt();
			if(sel == 0) {
				break;
			}else if (sel == 1) {
				memberDAO.join();
			} else if (sel == 2) {
				memberDAO.delete();
			} else if (sel == 3) {
				memberDAO.update();
			} else if (sel == 4) {
				memberDAO.printMemberList();
			} else if (sel == 5) {
				memberDAO.save();
			} else if (sel == 6) {
				memberDAO.load();
			}
		}
	}
}
