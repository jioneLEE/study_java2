package 메서드;

class Exx001 {
	void printEvenOrOdd(int a) {

		if (a == -100) {
			System.out.println("종료");
			return; // 메서드 즉시 종료 : 반복문 break; 비슷
		}

		if (a % 2 == 0) {
			System.out.println("짝수");
		} else {
			System.out.println("홀수");
		}

		return;
	}

	void sumBetweenValues(int x, int y) {
		int sum = 0;
		for (int i = x; i <= y; i++) {
			sum += i;
		}

		System.out.printf("%d ~ %d 총합 = %d \n", x, y, sum);
	}

	void findPrimeNumbers(int num) {
		System.out.print(num + " 까지의 소수는 => \n");
		for (int i = 2; i <= num; i++) {

			int cnt = 0;
			for (int k = 1; k < i; k++) {
				if (i % k == 0) {
					cnt++;
				}
			}
			if (cnt == 1) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
	}

}

public class 기본예제01_정답 {

	public static void main(String[] args) {

		Exx001 e = new Exx001();

		// 문제 1) a 가 홀수인지 짝수인지 출력
		int a = 19;
		e.printEvenOrOdd(a);
		e.printEvenOrOdd(a + 1);
		e.printEvenOrOdd(-100);

		// 문제 2) x부터 y까지의 합을 출력하는 메서드
		int x = 1;
		int y = 10;
		e.sumBetweenValues(x, y);

		// 문제3) 숫자 1개를 인자로 사용해서 2부터 인자까지의 소수 전부 출력
		int primeNumber = 20;
		e.findPrimeNumbers(primeNumber);

	}

}