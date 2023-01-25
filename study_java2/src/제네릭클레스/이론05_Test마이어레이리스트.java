package 제네릭클레스;

import java.util.Arrays;

public class 이론05_Test마이어레이리스트 {

	public static void main(String[] args) {
		int fsd = 0;
		Integer ddd = new Integer(1);
		
    MyArrayListG<이론04_User> list = new MyArrayListG();
		
		list.add(new 이론04_User("박연미",30));
		list.add(new 이론04_User("아이유",33));
		list.add(new 이론04_User("홍길동",13));
		
		System.out.println(list);
		System.out.println("========1==========");
		System.out.println(list.get(0));
		list.remove(0);
		System.out.println("=========2=========");
		System.out.println(list);
		System.out.println("==========3========");
		
		list.set(0, new 이론04_User("테스트",35));
		System.out.println(list);
	
		System.out.println(ddd);
		
	}

}