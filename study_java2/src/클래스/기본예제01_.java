package 클래스;

// 기본이론3의 클래스 score 를 사용해서 문제를 풀어보세요 
//class Score{
//	int arr[] = {87,100,11,72,92};
//}


public class 기본예제01_ {

	public static void main(String[] args) {

		Score s = new Score();
		
		// [문제1] 전체 합 출력
		// [정답1] 362
		int sum =0;
		for(int i =0 ; i<s.arr.length; i++ ) {
			sum +=s.arr[i];
		}
		System.out.println(sum);
		
		// [문제2] 4의 배수의 합 출력
		// [정답2] 264
		sum =0;
		for(int i =0 ; i<s.arr.length; i++ ) {
			if(s.arr[i]%4 ==0) {
				sum+=s.arr[i];
			}
		}
		System.out.println(sum);
		
		// [문제3] 4의 배수의 개수 출력
		// [정답3] 3
		sum =0;
		for(int i =0 ; i<s.arr.length; i++ ) {
			if(s.arr[i]%4 ==0) {
				sum++;
			}
		}
		System.out.println(sum);
		
		
		
		// [문제4] 짝수의 개수 출력
		// [정답4] 3
		sum =0;
		for(int i =0 ; i<s.arr.length; i++ ) {
			if(s.arr[i]%2 ==0) {
				sum++;
			}
		}
		System.out.println(sum);
		
	}

}