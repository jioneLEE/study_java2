package 제네릭클레스;

import java.util.ArrayList;
import java.util.Arrays;

public class 이론06_어레이리스트주의사항 {

	public static void main(String[] args) {
		
int[] arr = {1, 1, 3, 2, 2, 3, 3, 4, 4, 5, 5, 4};	
		
//		int cnt =0;
    	int val = 3;
//		for(int num : arr) {
//			if(num == 3) {
//				cnt++;
//			}
//		}
//		int[] temp = arr;
//		arr = new int[arr.length-cnt];
//		int idx=0;
//		for(int i =0;i < temp.length;i++) {
//			if(temp[i] != val) {
//				arr[idx] = temp[i];
//				idx++;
//			}
//		}
		
		System.out.println(Arrays.toString(arr));
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		
		for(int num : arr) {
			list.add(num);
		}
		
		System.out.println(list);
		
		for(int i =0;i <list.size();i++) {
			if(list.get(i) == val) {
				list.remove(i);
				i--;
			}
		}
		System.out.println(list);

	}

}
