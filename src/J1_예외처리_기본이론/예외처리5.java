package J1_����ó��_�⺻�̷�;

import java.util.Scanner;

public class ����ó��5 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// [1] Thread.sleep(�и�������)
		// [2] () �ȿ� ���� ����ŭ �Ͻ������ȴ�.
		// [3] �и��������̱⶧���� 1000 �� 1���̴�.
		// [4] �̰�Ȱ���ؼ� �������α׷��� ������ִ�. (GUI ���� Ȱ��)

		System.out.println("����");
		try {
			Thread.sleep(1000);
		} catch (Exception e) {
		}
		System.out.println("����");
	}
}
