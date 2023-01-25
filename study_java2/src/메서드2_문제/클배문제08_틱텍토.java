package 메서드2_문제;

import java.util.Scanner;

class Tic{
	int [] line = new int[3];
	
	void printLine() {
		for(int i = 0; i < 3; i++) {
			if(line[i] == 0) {
				System.out.print("[ ]");
			}else if(line[i] == 1) {
				System.out.print("[o]");
			}else if(line[i] == 2) {
				System.out.print("[x]");
			}
		}
		System.out.println();
	}
	
}
class Game{
	Tic[] tics;
	int p1 = 1; // "O"
	int p2 = 2; // "X"
	boolean win;
	void init() {
		tics = new Tic[3];
		for(int i =0; i<tics.length; i++) {
			tics[i] = new Tic();			
		}
		
		for(int i =0; i<tics.length; i++) {
			for(int k =0; k<tics[i].line.length; k++) {
			tics[i].line[k] = 0;
			}
		}
		
	}
	void printGame() {
		
	}
	
	void run() {
		init();
		
		for(int i =0; i<tics.length; i++) {
			tics[i].printLine();
		}
	}
	
}


public class 클배문제08_틱텍토 {

	public static void main(String[] args) {
		
		Game g = new Game();
		g.run();
		

	}

}
