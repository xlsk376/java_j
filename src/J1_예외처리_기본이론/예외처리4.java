package J1_����ó��_�⺻�̷�;

import java.util.Scanner;

public class ����ó��4 {

	public static void main(String[] args) {
		// ������ ���� (�������Ʈ)
		// https://butter-shower.tistory.com/87

		// try catch finally

		Scanner scan = new Scanner(System.in);
		// finally �� ���� ���� ������� ������ ����ȴ�.
		// �ڵ尡 �� �۵��ߴ��� Ȯ�� �Ҷ� ����. (�ȳ�������)

		int num1 = 10;
		int num2 = 0;

		try {
			System.out.println(num1 / num2);
		} catch (Exception e) {
			System.out.println("0���� ���� �� �����ϴ�.");
		} finally {
			System.out.println("���ܹ߻��� ������� ������ ������ ������ ���´�.");
			scan.close();
		}

	}

}
