package 메서드;

class Ex001{
	
	void printEvenOrOdd(int a) {
		System.out.println(a);
		System.out.println("=================");
	}
	
	void sumBetweenValues(int x , int y) {
		int sum =0;
		for(int i =x; i<=y; i++) {
			sum += i;
		}
		System.out.println(sum);
		System.out.println("=====================");
	}
	
	void findPrimeNumbers(int primeNumber) {
		for(int i =2; i<=primeNumber ; i++) {
			if(i%2 == 0) {
				System.out.print(i +" ");
			}
		}
		System.out.println();
		System.out.println("==============");
	}
	
}

public class 기본예제01 {

	public static void main(String[] args) {

		Ex001 e = new Ex001();

		// 문제 1) a 가 홀수인지 짝수인지 출력 
		int a = 19;
		e.printEvenOrOdd(a);
		//e.printEvenOrOdd(a);

		// 문제 2) x부터 y까지의 합을 출력하는 메서드
		int x = 1;
		int y = 10;
		e.sumBetweenValues(x, y);
		//e.sumBetweenValues(x, y);

		// 문제3) 숫자 1개를 인자로 사용해서 2부터 인자(20)까지의  소수 전부 출력 
		int primeNumber = 20;
		e.findPrimeNumbers(primeNumber);
		// e.findPrimeNumbers(primeNumber);
		
	}

}