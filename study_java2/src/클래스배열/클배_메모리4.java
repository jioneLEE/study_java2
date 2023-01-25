package 클래스배열;



class DD {
	int a;
	int b;
}

public class 클배_메모리4 {

	public static void main(String[] args) {
		
		DD[] ddList = new DD[3];
		
		DD d1 = new DD();
		d1.a = 100;	
		ddList[0] = d1;
		
		d1 = new DD();
		d1.a = 200;
		ddList[1] = d1;
		
		d1 = new DD();
		d1.a = 300;
		ddList[2] = d1;
		
		// 실행전 예상하기
		for(int i = 0; i < ddList.length; i++) {
			System.out.println(ddList[i].a);
		}
		
	}

}