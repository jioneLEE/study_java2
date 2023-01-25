package 메서드2_문제;

import java.util.Random;

// VO DTO value object data transfer
class ranNum {
	int num;
	boolean check ;
}

// DAO data account object
class ranNumManager {
	
	ranNum[] rn;
	
	//초기화
	void init() {
		rn = new ranNum[5];
		for(int i =0; i<rn.length; i++) {
			rn[i] = new ranNum();
		}
	}
	
	// 랜덤값 삽입
	void inputRan() {
		
		Random rd = new Random();
		int ran = 0;

		for (int i = 0; i < rn.length; ) {
			ran = rd.nextInt(rn.length);
			if (!isDuplicate(ran)) {
				rn[i].num = ran + 1;
				rn[ran].check = true;
				i++;
			}
		}
	}

	// 중복값 확인
	boolean isDuplicate(int ranVal) {
		return rn[ranVal].check;
	}
	
	void printValue() {		
		for(int i =0; i<rn.length; i++) {
			System.out.print(rn[i].num+" ");
		}
	}
	
	void run() {
		init();
		inputRan();
		printValue();
	}
	
}


public class 클배문제06_중복숫자 {

	public static void main(String[] args) {
		ranNumManager manager = new ranNumManager();
		manager.run();
	}

}
