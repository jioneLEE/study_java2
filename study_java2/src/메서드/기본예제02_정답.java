package 메서드;
class Exx002{
	void printSum(int[] arr, int number) {
		int sum =0;
		
		for(int num : arr) {
			if(num % number == 0) {
				sum+=num;
			}
		}
		if(number == 1) {
		System.out.println("전체 합 출력 =" + sum);
		}else {
			System.out.println(number+ "배수 합 출력 =" + sum);
		}
	}
	
	void printCountByNum(int[] arr , int number) {
		int count = 0;
		for(int num : arr) {
			if(num % number == 0) {
				count++;
			}
		}
		System.out.println( number +"의 배수 갯수 출력 =" + count);
	}

}

public class 기본예제02_정답 {

	public static void main(String[] args) {

		// main 에서는 메서드만 호출하시오 
		Exx002 e = new Exx002();
		int[] arr = { 87, 100, 11, 72, 92 };

		// 문제 1) 전체 합 출력
		// 정답 1) 362
		e.printSum(arr,1);

		// 문제 2) 4의 배수의 합 출력
		// 정답 2) 264
		e.printSum(arr, 4);

		// 문제 3) 4의 배수의 개수 출력
		// 정답 3) 3
        e.printCountByNum(arr,4);
		// 문제 4) 짝수의 개수 출력
		// 정답 4) 3
        e.printCountByNum(arr,2);
	}

}