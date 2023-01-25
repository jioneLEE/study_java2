package 제네릭클레스;

import java.util.ArrayList;
import java.util.Arrays;

class MyArrayList1{
int[] list;
int[] tempList;
int size() {
		if(list == null) return 0;
		return list.length;
	}

	// size() :int 길이출력
 //add(int idx) :void 값 추가
//add(int idx, int val) :void 값 삽입 
// get(int idx) : int 값 : 값 접근
//set(int idx, int val): void 값 수정  
//remove(int idx):void 값 삭제 
//clear() : void 값 전부 삭제 
	void add(int num) {
		tempList = new int[size()+1];
		if(size() != 0) {
			for(int i =0; i<list.length; i++) {
				tempList[i] =list[i];				
			}
		}
		tempList[size()] = num;
		list = tempList;
		tempList = new int[size()];
	}
	
	void add(int num, int idx) {
		int tempIdx =0;
		tempList = new int[size()+1];
		for(int i =0; i<list.length; i++) {
			if(idx == i) {
				tempList[tempIdx] = num;
				tempIdx++;
			}
			tempList[tempIdx] = list[i];			
			tempIdx++;			
		}
		list = tempList;

	}
}


public class 이론02_ArrayList구현 {

	public static void main(String[] args) {
		
		MyArrayList1 myList = new MyArrayList1();
		int[] arr = null;
		myList.add(10); // [10]
		System.out.println(myList.size()); // 1
		myList.add(20); // [10, 20]
		System.out.println(myList.size()); // 2
		myList.add(30); // [10, 20, 30]
		System.out.println(myList.size()); // 3
		myList.add(40, 1);  // [10, ,40, 20, 30]
		System.out.println(myList.size()); // 4
		myList.add(50, 2);  // [10, ,40, 50, 20, 30]
		System.out.println("=========");
		System.out.println(Arrays.toString(myList.list));
		System.out.println(myList.size());
	}

}