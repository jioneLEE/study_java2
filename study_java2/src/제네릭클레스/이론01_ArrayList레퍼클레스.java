package 제네릭클레스;

import java.util.ArrayList;

class MyArrayList{
int[] list;
int size() {
		if(list == null) return 0;
		return list.length;
	}

	// size() :int 길이출력
 //add(int idx) :void 값 추가
//add(int idx, int val) :void 값 삽입 
// get(int idx) : int 값 : 값 꺼내오기 
//set(int idx, int val): void 값 수정  
//remove(int idx):void 값 삭제 
//clear() : void 값 전부 삭제 
	void add(int num) {
	}
}
public class 이론01_ArrayList레퍼클레스 {

	public static void main(String[] args) {
		// 래퍼 클래스 원시타입의 자료형을 감싼 클래스 
		// int 하는 원시타입 : 순수하게 값만 저장 
		// Interger 클래스 : 값 저장 + 기능
		int num = 10;
	
      // 고정된 배열을 가변배열로 활요할 수 있게 하는 클래스다 
		ArrayList<Integer> numlist = new ArrayList<Integer>();
		System.out.println(numlist.size()); // length : 길이값을 출력
		numlist.add(10);
		numlist.add(20);
		System.out.println(numlist.size()); // length : 길이값을 출력
		numlist.add(30);
		numlist.add(40);
		System.out.println(numlist.size()); // length : 길이값을 출력
		System.out.println(numlist);
		// 삭제 
		numlist.remove(0);
		System.out.println(numlist);
		// 수정 
		numlist.set(1, 10000);
		System.out.println(numlist);
		// 삽입
		numlist.add(2, 100);
		// 배열 값 접근 
		System.out.println(numlist.get(0)); //numlist[0] 
		System.out.println(numlist);
		numlist.clear(); // 초기화 
		System.out.println(numlist);
		
		
			MyArrayList myList = new MyArrayList();
		int[] arr = null;
//	  myList.add(10, arr); // [10]
//    System.out.println(myList.size()); // 1 
//		myList.add(20, arr); // [10, 20]
//		System.out.println(myList.size()); // 2 
		
	}

}