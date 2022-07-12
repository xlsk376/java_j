package J1_예외처리_기본이론;

public class 예외처리3 {

	public static void main(String[] args) {
		// 에러의 종류 (참고사이트)
		// https://butter-shower.tistory.com/87

		// 에러의 종류가 너무 많기 때문에
		// 모든에러를 다잡아주는 Exception 을 보통 사용한다.

		int arr[] = new int[3];
		try {
			arr[100] = 100;

		} catch (Exception e) {

			e.printStackTrace();
		}

		int a = 10;
		
		try {
			int b = a / 0;

		} catch (Exception e) {
			e.printStackTrace();
		}

		String str = "aaa";
		try {
			int num = Integer.parseInt(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
