package 제네릭클레스;

public class 이론04_User {

	   String name;
	   int age;
	public 이론04_User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "" + name + ":" + age ;
	}
	   
	   
	   

	}