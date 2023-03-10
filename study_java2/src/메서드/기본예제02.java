package 메서드;

class Ex002{

	void printSum(int[] arr) {
		int sum =0;
		int sum1 =0;
		for(int i =0; i<arr.length; i++) {
			sum += arr[i];
			if(arr[i]%4==0) {
				sum1 += arr[i];
			}
		}
		System.out.println(sum);
		System.out.println(sum1);
		System.out.println("===================");
		
	}
	
	void printSumMultiple4(int[] arr) {
		
		int sum =0;
		for(int i =0; i<arr.length; i++) {
			if(arr[i]%4==0) {
				sum += arr[i];
			}
		}
		System.out.println(sum);
		System.out.println("===================");
	}
	
	
	void printCountMultiple4(int[] arr) {
		
		int cnt =0;
		for(int i =0; i<arr.length; i++) {
			if(arr[i]%4==0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println("===================");
	}
		
	void printCountEven(int[] arr) {
		
		int cnt =0;
		for(int i =0; i<arr.length; i++) {
			if(arr[i]%2==0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		System.out.println("===================");
		
	}

}

public class 기본예제02 {

	public static void main(String[] args) {
		Ex002 e =new Ex002();
		// main 에서는 메서드만 호출하시오 
		
		int[] arr = { 87, 100, 11, 72, 92 };

		// 문제 1) 전체 합 출력
		// 정답 1) 362
		
		e.printSum(arr);

		// 문제 2) 4의 배수의 합 출력
		// 정답 2) 264
		e.printSumMultiple4(arr);
		// 문제 3) 4의 배수의 개수 출력
		// 정답 3) 3
		e.printCountMultiple4(arr);
		// 문제 4) 짝수의 개수 출력
		// 정답 4) 3
		e.printCountEven(arr);
	}

}