package 클래스배열;

import java.util.Arrays;

class EE {
	int arr[] = {1,2,3};
}
public class 클배_메모리5 {

	public static void main(String[] args) {

	EE ee[] = new EE[3];
		
		for(int i = 0; i < ee.length; i++) {
			ee[i] = new EE();
		}
		
		EE test1 = new EE();
		int arr[] = {4,5,6};
		
		
		test1.arr = arr;
		
		ee[1] = test1;
		
		arr[1] = 100;
		
		for(int i = 0; i < ee.length; i++) {
			System.out.println(Arrays.toString(ee[i].arr));
		}
		
	}

}