package 예외처리;

class Person{
	String name;
	int age;
	String gender;
	// 생성자는 메서드의 한 종류 
	// 공통점 : 메서드 호출 , 오버로딩 가능하다 
   // 차이점 : 생성자는 항상 클래스 이름으로만 만들어진다, 기본생성자 클래스이름(){} , 생성자는 리턴은 고정으로 객체 생성후 주소값을 준다 
	
	// 기본 생성자 => 우리가 만들지 않아도 자동으로 만들어진다 
	Person(){
		System.out.println("기본생성자 호출");
		name="무명이";
	
	}
	// 생성자 오버로딩
	Person(String name){
		System.out.println("오버로딩 생성자 호출");
		this.name=name;
	}

	
	 Person(String name, int age, String gender) {
		this.name = name;
		this.age = age;
		this.gender = gender;
	}
	void printPerson() {
		System.out.printf("%s %d세 (%s) \n",name,age,gender);
	}
	
	// 오버로딩 : 같은 클래스에서 같은이름의 메서드를 여러개 사용하고 싶을때 
	// 오버라이딩 : 부모클래스에 있는 같은 메서드를 자식이 바꿔서(재정의) 메서드를 사용하고 싶을때 
	
	// 원래는 클래스 객체(인스턴스)를 그냥 출력하면 주소값이 나오는데 
	// 부모인 Object 클래스의 toString() 메서드를 제정의를 하면 : 원래는 주소값 출력 
	// 즉 오버로딩을 통해서 주소값이 아니라 내가 원하는 String 값으로 변경시켜주면
	// 객체를 그냥 출력시에 주소값이 아니라 내가 설정한 값이 나온다. 
//	@Override
//	public String toString() {
//		return name+" "+age+"세 (" + gender +")";
//	}


}

public class 생성자오버로딩toString오버라이딩 {

	public static void main(String[] args) {

    Person jamse = new Person(); // 기본 생성자 호출 
		jamse.printPerson();
		System.out.println("================");
		jamse.name ="제임스";
		jamse.age = 25;
		jamse.gender="남성";
		jamse.printPerson();
		System.out.println("================");
		Person tom = new Person("톰"); // 오버로딩된 생성자 호출 
		tom.printPerson();
		System.out.println("================");
		Person jenny = new Person("제니",21,"여성");
		jenny.printPerson();
		System.out.println("=============");
		System.out.println(jamse);
		System.out.println(tom);
		System.out.println(jenny);
		
		String names[] = {"제임스","톰","제니","킴"};
		String genders[] = {"남자","여자"};
		
		Person kim = new Person(names[3],20,genders[1]);	
		System.out.println(kim);

	}

}