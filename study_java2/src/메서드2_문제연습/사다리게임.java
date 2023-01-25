package 메서드2_문제연습;

import java.util.Arrays;
import java.util.Scanner;

	class Ladder{
		Scanner scan = new Scanner(System.in);
		int ladder[][]= {
				{0,0,0,0,0},
				{1,2,0,1,2},
				{0,0,0,0,0},
				{0,0,1,2,0},
				{1,2,0,1,2},
				{0,1,2,0,0},
				{0,0,1,2,0},
				{0,0,0,1,2},
				{0,0,0,0,0}};

		int size = 5;
		//String[] menu = { "", "", "", "", "" };
	   String[] menu = { "탕수육", "떡볶이", "수제비", "김밥", "짬뽕" };
	   
	   void startGame() {
		   
		   System.out.print("번호 입력>> ");
		   int num = scan.nextInt()-1;
		   
			for (int i = 0; i < ladder.length; i++) {
				if(ladder[i][num]== 0) {
					ladder[i][num] = 3;
				}else if(ladder[i][num]== 1){
					ladder[i][num] = 3;
					ladder[i][num+1] = 3;
					num++;
				}else {
					ladder[i][num] = 3;
					ladder[i][num-1] = 3;
					num--;
				}
			}
			
	   }
	   
	   void  printLadder() {
			 for(int i =0; i<ladder.length; i++) {
				   for(int k =0; k<ladder[i].length; k++) {
					   
					  if(ladder[i][k]== 0) {
						  System.out.print(" │ ");
					  }else if(ladder[i][k]== 1) {
						  System.out.print(" ├─");
					  }else if(ladder[i][k]== 2){
						  System.out.print("─┤ ");
					  }else {
						  System.out.print(" * ");
					  }
				   }
				   System.out.println();
			   }
	   }
	   void run() {
		   System.out.println("사다리출력");
		   printLadder();
		   System.out.println(Arrays.toString(menu));
		   startGame();
		   printLadder();
	   }
	}

// 1오른쪽 , 2 왼쪽
public class 사다리게임 {

	public static void main(String[] args) {

	   
	   Ladder a = new Ladder();
	   a.run();




		
	   
	   
	}

}
