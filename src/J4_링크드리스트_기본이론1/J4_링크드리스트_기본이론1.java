package J4_��ũ�帮��Ʈ_�⺻�̷�1;

// ���� : �ε��� �˻� (�迭), ���� : �����Ͱ� �������� �߰� ������ ��������.
// ����Ʈ : �ε��� �˻� �ȵ�, ���� : �߰� ������ �δ��� ����.


class Node{
	int data;
	Node next;
}

public class J4_��ũ�帮��Ʈ_�⺻�̷�1 {

	public static void main(String[] args) {
		// ����Ʈ ó������
		// �ڷᱸ�� �� 3��
		// 1) �迭 ==> ���ѹ迭
		
		int[] arr = new int[3];
		
		// 2) ���� ==> �����迭, ���� : ���簡 �ʿ��ϴ�.
		int[] vec = new int[1000];
		int temp[] = vec;
		vec = new int[1001];
		for(int i = 0; i < 1000; i++) {
			vec[i] = temp[i];
		}
		
		// 3) ����Ʈ ==>
		Node node1 = new Node();
		Node node2 = new Node();
		Node node3 = new Node();
		node1.data = 10;
		node2.data = 20;
		node3.data = 30;
		node1.next = node2;
		node2.next = node3;
		
		System.out.println(node1.data);
		System.out.println(node1.next.data);
		System.out.println(node1.next.next.data);

	}

}
