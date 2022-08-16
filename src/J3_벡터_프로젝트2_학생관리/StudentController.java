package J3_����_������Ʈ2_�л�����;

import java.util.Scanner;

public class StudentController {
	Scanner scan;
	StudentDAO studentDAO;
	SubjectDAO subjectDAO;

	void init() {
		scan = new Scanner(System.in);
		studentDAO = new StudentDAO();
		subjectDAO = new SubjectDAO();
		mainMenu();
	}

	void mainMenu() {
		while (true) {
			System.out.println("1)�л��߰�");
			System.out.println("2)�л�����"); // ���� ���� ����
			System.out.println("3)�����߰�");
			System.out.println("4)�������");
			System.out.println("5)��ü���");
			System.out.println("6)����");
			System.out.println("7)�ε�");
			
			System.out.println("0)����");
			int sel = scan.nextInt();
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				studentDAO.join();
			} else if (sel == 3) {
				subjectDAO.subjectInsert(studentDAO);
			} else if (sel == 5) {			
				studentDAO.printList(subjectDAO);			
			}
		}
	}
	
}
