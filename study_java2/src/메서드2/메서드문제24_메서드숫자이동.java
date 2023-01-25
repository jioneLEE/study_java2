package 메서드2;

import java.util.Scanner;

class NumberGame{
	// 심화는 격파까지 구현하시오 
	Scanner scan = new Scanner(System.in);

	int[] move = {0, 0, 0, 0, 8, 0, 0, 0, 0, 0};
	int pidx = 4;
	
	void printPlay() {
		for(int i =0; i<move.length; i++) {
			if(move[i] == 0) {
				System.out.print("ㅡ");				
			}else if (move[i]==1) {
				System.out.print("[]");
			}else {
			System.out.print("옷");
			}
		}
		System.out.println();
	}
	
	void showMenu() {
		String menu = 	 "1)좌로 이동\n"
						+"2)우로 이동\n"
						+"3)종료";
		System.out.println(menu);
	}
	
	void moveLeft(int choice) {
		int idx = checkIdx(choice);
		
		if( pidx > 0 && move[idx]==0) {
			move[idx] = move[pidx];
			move[pidx] = 0;
			pidx--;
		}else if(pidx == 0) {
			move[pidx] = 0;
			pidx=move.length-1;
			move[pidx] = 8;
		}
		else if(move[pidx-1]==1){
			System.err.println("벽이 존재해서 이동불가");
		}
		
		
		
	}
	
	void moveRight(int choice) {
		int idx = checkIdx(choice);
		
		if( pidx < move.length-1 && move[idx]==0) {
			move[idx] = move[pidx];
			move[pidx] = 0;
			pidx++;
		}else if(pidx == move.length-1) {
			move[pidx] = 0;
			pidx=0;
			move[pidx] = 8;
		}
		else if(move[pidx+1]==1){
			System.err.println("벽이 존재해서 이동불가");
		}
	}
	
	int checkIdx(int choice) {
		int idx = pidx;
		if(choice == 1) {
			idx -= 1;
		}else if(choice ==2) {
			idx += 1;
		}
			
		return idx;
	}
	
	
	
	
   void run() {
 		while(true) {
			// 게임화면 출력
			printPlay();
			// 메뉴 출력
			showMenu();
			// 메뉴 선택
			System.out.print(": ");
			int choice = scan.nextInt();
			
			// 좌로 이동
			if(choice == 1) {
				moveLeft(choice); 
				}
			// 우로 이동
			else if(choice == 2) {
				moveRight(choice); 
				}
			// 종료
			else if(choice == 3) {
				System.out.println("게임 종료");
				break;
			}else {
				System.err.println("===[ 입 력 오 류]===");
			}
		}
	}
}

public class 메서드문제24_메서드숫자이동 {

	public static void main(String[] args) {
		
		NumberGame g = new NumberGame();
		g.run();
		
	}

}
