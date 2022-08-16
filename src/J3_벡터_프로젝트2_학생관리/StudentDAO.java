package J3_����_������Ʈ2_�л�����;

import java.util.Scanner;

public class StudentDAO {
	int num;
	Student[] studentList;
	int studentCount;
	Scanner scan;
	void init() {
		scan = new Scanner(System.in);
		num = 1000;
		studentCount = 0;
		studentList = null;
	}

	Student checkId(String id) {
		for (int i = 0; i < studentCount; i++) {
			if (studentList[i].studentId.equals(id)) {
				return studentList[i];
			}
		}
		return null;
	}
	int getNextNum() {
		num += 1;
		return num;
	}
	

	void addStudent(Student student) {
		
		if (studentCount == 0) {
			studentList = new Student[1];
			studentList[0] = student;

		} else {
			Student[] temp = studentList;
			studentList = new Student[studentCount + 1];
			for (int i = 0; i < studentCount; i++) {
				studentList[i] = temp[i];
			}
			studentList[studentCount] = student;
			temp = null;
		}
		studentCount += 1;
	}
	void printStudentList() {
		for(int i = 0; i < studentCount; i++) {
			studentList[i].printStudent();
		}
	}
	void join() {
		System.out.println("[�л��߰�] ���̵� �Է� : ");
		String id = scan.next();
		Student student = checkId(id);
		if (student == null) {
			student = new Student();
			student.studentId = id;
			student.studentNum = getNextNum();
			addStudent(student);
			printStudentList();
			System.out.println("ȸ������ ����.");

		} else {
			System.out.println("�ߺ����̵��Դϴ�. ");
		}
	}
	void printList(SubjectDAO subjectDAO) {
		
		if (studentCount == 0) {
			System.out.println("��ϵ� �л��� �����ϴ�.");
			return;
		}
		for (int i = 0; i < studentCount; i++) {
			Student student = studentList[i];
			student.printStudent();
			Subject[] subjectList = subjectDAO.getOneStudentSubjectList(student.studentNum);
			if (subjectList == null) {
				System.out.println("������ �����ϴ�.");
				continue;
			}
			subjectDAO.printSubjectList(subjectList);
		}
	}
}
