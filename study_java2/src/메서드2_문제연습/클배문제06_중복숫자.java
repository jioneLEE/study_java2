package 메서드2_문제연습;

import java.util.Random;

//VO , DTO : value object, data transfer object 
//필드(전역 변수)만 가지고 있는 클래스 
//사용자 지정 자료형 
//데이터 저장 클래스 
//3
//0 0 0 1 0
//3 0 0 0 0
class RanNum {
	int num; // 0 
	boolean check; // false
}

//DAO : 데이터 처리 클래스 => 배열리스트에 추가 삭제 변경 
//VO 클래스의 배열이 들어가 있다 
class RanNumManger {
	RanNum[] arr = new RanNum[5]; // null null null null null

	// 랜덤 숫자 생성
	boolean creatNum(int idx) {
		Random rd = new Random();
		int num = rd.nextInt(arr.length); // 0 ~ 4

		if(!isUsed(num)) {
			arr[idx].num = num+1;
			arr[num].check = true;
			return true;
		}
		return false;
	}

	// 초기화 
	void init() {
		for(int i =0; i < arr.length;i++) {
			arr[i] = new RanNum();
		}
		for(int i =0; i < arr.length;) {
			if(creatNum(i)) {
				i++;
			}
		}
	}
	// 중복체크
	boolean isUsed(int idx) {
		
		if(arr[idx].check == true) {
			return true;
		}
		
		return false;
	}

	// 랜덤 숫자 출력
	void printArr() {
		for(RanNum num : arr) {
			System.out.print(num.num + " ");
		}
	}
	
	void run() {
		init();
		 printArr();
	}
}


public class 클배문제06_중복숫자 {

	public static void main(String[] args) {
//1 ~ 5 
		RanNumManger rg = new RanNumManger();
		rg.run();

	}

}