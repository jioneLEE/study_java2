package 메서드;
class Test05{
	String name="홍길동";
	
	void setName(String name) {
		// 지역변수와 멤버변수가 동일하면 
		// 지역변수가 우선시된다 
		
		System.out.println("name=" + name);
		System.out.println("this.name=" + this.name);
	}
	
	String getName() {
		return name;
	}
	
     void printThis() {
    	 System.out.println("Test05 객체주소 this =" + this);
     }
	
}
public class 기본이론05 {

	public static void main(String[] args) {

		Test05 t = new Test05(); 
		t.setName("홍길순");
		
		System.out.println("t = " + t);
		
		t.printThis();
		Test05 t2 = new Test05(); 
		
		t2.setName("아이유");
		
		System.out.println("t2 = " + t2);
		t2.printThis();
		
	}
	
}