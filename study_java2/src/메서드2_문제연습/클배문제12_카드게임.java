package 메서드2_문제연습;

import java.util.Random;

class Player {
	String name;
	Card c1;
	Card c2;
	boolean win; 
	
	void setPlayer(String name, Card c1, Card c2) {
		this.name = name;
		this.c1 = c1;
		this.c2 = c2;
	}
	void printPlayer() {
		System.out.printf(" %s : %s , %s \n", name, c1.cardInfo() , c2.cardInfo());
	}
}

class Card {
	String shape;
	int num;
	void printCard() {
		System.out.printf("[%s:%d]\n" , shape,num);
	}
	void setCard(String shape, int num) {
		this.shape = shape;
		this.num = num;
	}
	String cardInfo() {
		return "["+shape + " :" + num + "]"; 
	}
}
class CardGame{
		Card deck[];
		Player p1;
		Player p2;
		void init(){
			String shapes[] = { "◇", "♡", "♣", "♠" };
			deck = new Card[40];
			int idx =0;
			int num = 1;
			for(int i =0; i < deck.length; i++) {
				Card c = new Card();
				if(i%10 == 0 && i!= 0) {
					idx++;
					num = 1;
				}
				c.num = num;
				c.shape = shapes[idx];
				deck[i] = c;
				num++;
			}
			p1 = new Player();
			p2 = new Player();

		}
		void suffleCard() {
			Random rd = new Random();
			for(int i =0; i < 500; i++) {
				int idx = rd.nextInt(deck.length);
				Card temp = deck[0];
				deck[0] = deck[idx];
				deck[idx] = temp;
			}
		}
		void printDeck() {
			for(Card c : deck) {
				c.printCard();
			}
		}
		
		void checkWinner() {
			int sum1 = p1.c1.num + p1.c2.num;
			int sum2 = p2.c1.num + p2.c2.num;
			if(sum1 > sum2) {
				p1.win = true;
			}else if(sum2 > sum1) {
				p2.win = true;
			}else {
				checkWinner2();
			}
			
			System.out.print(p1.win? p1.name : p2.name );
			System.out.println("승리");
		}
		int getBinnerNum(Card c1, Card c2) {
			return c1.num > c2.num ? c1.num: c2.num;
		}
		
		void checkWinner2() {
			int num1 = getBinnerNum(p1.c1, p1.c2);
			int num2 = getBinnerNum(p2.c1, p2.c2);
			if(num1 > num2) {
				p1.win =true;
			}else if(num2 > num1) {
				p2.win = true;
			}else {
				System.out.println("두 숫자 합이 같음 ");
			}
		}

		
		void run(){
			init();
			//printDeck();
			suffleCard();
			printDeck();
			Card c1= new Card();
			c1.setCard("◇", 5);
			Card c2= new Card();
			c2.setCard("♡", 5);
			Card c3= new Card();
			c3.setCard("♡", 3);
			Card c4= new Card();
			c4.setCard("♠", 7);
			p1.setPlayer("player1", c1, c2);
			p2.setPlayer("player2", c3, c4);
			//p1.setPlayer("player1", deck[0], deck[1]);
			//p2.setPlayer("player2", deck[2], deck[3]);
			p1.printPlayer();
			p2.printPlayer();
			checkWinner();
		}

}

public class 클배문제12_카드게임 {

	public static void main(String[] args) {

		CardGame game = new CardGame();
		game.run();
		
	}

}


/////////////////////  풀이 2번째 방법

//package 클래스배열메서드;
//
//import java.util.Random;
//
//class Player {
//	String name;
//	Card c1;
//	Card c2;
//	boolean win; 
//	Player(){} // 기본생성자 
//	Player(String name, Card c1, Card c2) {
//		super();
//		this.name = name;
//		this.c1 = c1;
//		this.c2 = c2;
//	}
//	
//	void setPlayer(String name, Card c1, Card c2) {
//		this.name = name;
//		this.c1 = c1;
//		this.c2 = c2;
//	}
//	
//	@Override
//	public String toString() {
//		return  name + " : " + c1 + " , " + c2 ;
//	}
//	void printPlayer() {
//		System.out.printf(" %s : %s , %s \n", name, c1 , c2);
//	}
//}
//
//class Card {
//	String shape;
//	int num;
//	void printCard() {
//		System.out.printf("[%s:%d]\n" , shape,num);
//	}
//	void setCard(String shape, int num) {
//		this.shape = shape;
//		this.num = num;
//	}
//	String cardInfo() {
//		return "["+shape + " :" + num + "]"; 
//	}
//	@Override
//	public String toString() {
//		return "["+shape + " :" + num + "]"; 
//	}
//	
//}
//class CardGame{
//		Card deck[];
//		Player p1;
//		Player p2;
//		void init(){
//			String shapes[] = { "◇", "♡", "♣", "♠" };
//			deck = new Card[40];
//			int idx =0;
//			int num = 1;
//			for(int i =0; i < deck.length; i++) {
//				Card c = new Card();
//				if(i%10 == 0 && i!= 0) {
//					idx++;
//					num = 1;
//				}
//				c.num = num;
//				c.shape = shapes[idx];
//				deck[i] = c;
//				num++;
//			}
//			//p1 = new Player();
//			//p2 = new Player();
//
//		}
//		void suffleCard() {
//			Random rd = new Random();
//			for(int i =0; i < 500; i++) {
//				int idx = rd.nextInt(deck.length);
//				Card temp = deck[0];
//				deck[0] = deck[idx];
//				deck[idx] = temp;
//			}
//		}
//		void printDeck() {
//			for(Card c : deck) {
//				System.out.println(c); // 오버로딩된 toString 사용해서 그냥 객체 출력해도 됨  
//				//c.printCard();
//			}
//		}
//		
//		void checkWinner() {
//			int sum1 = p1.c1.num + p1.c2.num;
//			int sum2 = p2.c1.num + p2.c2.num;
//			if(sum1 > sum2) {
//				p1.win = true;
//			}else if(sum2 > sum1) {
//				p2.win = true;
//			}else {
//				checkWinner2();
//			}
//			
//			System.out.print(p1.win? p1.name : p2.name );
//			System.out.println("승리");
//		}
//		int getBinnerNum(Card c1, Card c2) {
//			return c1.num > c2.num ? c1.num: c2.num;
//		}
//		
//		void checkWinner2() {
//			int num1 = getBinnerNum(p1.c1, p1.c2);
//			int num2 = getBinnerNum(p2.c1, p2.c2);
//			if(num1 > num2) {
//				p1.win =true;
//			}else if(num2 > num1) {
//				p2.win = true;
//			}else {
//				System.out.println("두 숫자 합이 같음 ");
//			}
//		}
//
//		void testWinner2() {
//			Card c1= new Card();
//			c1.setCard("◇", 5);
//			Card c2= new Card();
//			c2.setCard("♡", 5);
//			Card c3= new Card();
//			c3.setCard("♡", 3);
//			Card c4= new Card();
//			c4.setCard("♠", 7);
//			p1.setPlayer("player1", c1, c2);
//			p2 = new Player("player2",c3,c4);
//		}
//		
//		void setPlayers() {   
//			//p1.setPlayer("player1", deck[0], deck[1]);
//			//p2.setPlayer("player2", deck[2], deck[3]);
//			//p1.printPlayer();
//			//p2.printPlayer();
//
//			  p1 = new Player("player1",deck[0],deck[1]);
//			  p2 = new Player("player2",deck[2],deck[3]);
//			System.out.println(p1);
//			System.out.println(p2);
//		}
//		
//		void run(){
//			init();
//			//printDeck();
//			suffleCard();
//			printDeck();
//			//testWinner2();
//			setPlayers();
//
//			checkWinner();
//		}
//
//}
//
//public class 카드게임 {
//
//	public static void main(String[] args) {
//
//		CardGame game = new CardGame();
//		game.run();
//		
//	}
//
//}
