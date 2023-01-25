package 제네릭클레스;

class Product {
	private String date;
	private String name;
	private int price;
	
	public Product() {}
	public Product(String date, String name, int price) {
		this.date = date;
		this.name = name;
		this.price = price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	public String getDate() {
		return date;
	}

	public int getPrice() {
		return price;
	}
	
	public String getName() {
		return name;
	}
	
}
public class 이론09_캡슐화예제 {

	public static void main(String[] args) {
		/*
		# get과 set의 활용법
		위와 같이 setPrice 메서드만 만들어 놓고,
		제조년과 상품이름의 set메서드를 만들지 않으면
		제조년과 상품이름은 처음 저장한 이후 변경을 절대로 할 수 없다.
	 */
		Product pr = new Product("20210420", "김치", 2000);
		System.out.println(pr.getDate());
	}

}