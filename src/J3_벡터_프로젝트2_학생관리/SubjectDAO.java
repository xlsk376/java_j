package J3_����_������Ʈ2_�л�����;

import java.util.Scanner;

public class SubjectDAO {
	Subject[] subjectList;
	int subjectCount;
	Scanner scan;
	void init() {
		scan = new Scanner(System.in);
		subjectCount = 0;
		subjectList = null;
	}

	boolean checkSubject(int studentNum, String subject) {
		for (int i = 0; i < subjectCount; i++) {
			Subject sub = subjectList[i];
			if (sub.studentNum == studentNum && sub.subject.equals(subject)) {
				return true;
			}
		}
		return false;
	}

	void addSubject(Subject subject) {
		if (subjectCount == 0) {
			subjectList = new Subject[1];
			subjectList[0] = subject;
		}else {
			Subject[] temp = subjectList;
			subjectList = new Subject[subjectCount + 1];
			for(int i = 0; i < subjectCount; i++) {
				subjectList[i] = temp[i];
			}
			subjectList[subjectCount] = subject;
			temp = null;
		}
		subjectCount += 1;
	}

	Subject[] getOneStudentSubjectList(int studentNum) {
		int count = 0;
		for (int i = 0; i < subjectCount; i++) {
			Subject sub = subjectList[i];
			if (sub.studentNum == studentNum) {
				count += 1;
			}
		}
		if (count == 0) {
			return null;
		}

		Subject[] oneStudentSubjectList = new Subject[count];
		int index = 0;
		for (int i = 0; i < subjectCount; i++) {
			Subject sub = subjectList[i];
			if (sub.studentNum == studentNum) {
				oneStudentSubjectList[index] = sub;
				index += 1;
			}
		}
		return oneStudentSubjectList;
	}

	void printSubjectList(Subject[] subjectList) {
		for (int i = 0; i < subjectList.length; i++) {
			subjectList[i].printSubject();
		}
	}
	void subjectInsert(StudentDAO studentDAO) {
		System.out.println("[�����߰�] �л� ���̵� �Է� : ");
		String id = scan.next();
		Student student = studentDAO.checkId(id);
		if (student == null) {
			System.out.println("ã�� �л��� �����ϴ�. ");
		} else {
			System.out.println("[�����߰�] ���� �̸� �Է� : ");
			String subjectName = scan.next();
			boolean check = checkSubject(student.studentNum, subjectName);
			if (check == true) {
				System.out.println("[�޼���] �ߺ� �����Դϴ�.");
			} else {
				Subject subject = new Subject();
				System.out.println("[�����߰�] ���� �Է� : ");
				int score = scan.nextInt();
				subject.score = score;
				subject.studentNum = student.studentNum;
				subject.subject = subjectName;
				addSubject(subject);
				System.out.println("�����߰� ����.");
			}
		}
	}
}
