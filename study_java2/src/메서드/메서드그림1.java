package 메서드;

class Ex003{
	void setValue(int x) {
		x = 100;
	}
}
public class 메서드그림1 {

	public static void main(String[] args) {

	    int x = 56;
		
		Ex003 e = new Ex003();
		e.setValue(x);

		System.out.println(x);
		
		// 아래 예제와 같은 상황이다.
		int y = 20;
		int z = y;
		z = 100;
	}

}