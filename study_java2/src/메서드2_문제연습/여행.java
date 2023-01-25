package 메서드2_문제연습;

import java.util.Arrays;

/*
(0북) (1동) (2남) (3서)
input의 데이터는 1은 한칸전진이고 2는 좌회전(90도) 3은 우회전(90도)이다.
 회전은 방향만 바뀌고 움직이는건 없다.
*/



class Game1{
	int map[][] = {
			{0,0,0,0,0,0,0},	
			{0,7,7,7,7,0,0},	
			{0,7,0,0,7,0,0},	
			{0,7,0,8,7,0,0},	
			{0,0,0,0,7,0,0},	
			{0,0,0,0,7,7,0},	
			{0,0,0,0,0,0,0}
	};		
	int dir = 0;		
	int input[] = {1,1,2,1,1,2,1,1,3,1,1};
	
	int y;
	int x;
	
	//
	void initPos() {
		for(int i =0; i<map.length; i++) {
			for(int k=0; k<map[i].length;k++) {
				if(map[i][k] == 8) {
					y = i;
					x = k;
				}
			}
		}
	}
	
	// 출력
	void printGame() {
		for(int i =0; i<map.length ; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	// 입력
	void inputVal() {
		for(int i =0; i<input.length; i++) {
			if(input[i] == 1) {
				System.out.printf("===[%d]위치 [%d]방향===\n",i+1,dir);
				moveCha();
				printGame();
			}else {
				setDir(input[i]);
			}
			
			
		}
	}
	
	// 방향
	void setDir(int input) {
		if(input == 2) {
			if(dir>=0 && dir<3) {
				dir++; 				
			}else if(dir == 3) {
				dir = 0;
			}
		}else if(input == 3) {
			if(dir<=3 && dir >0) {
				dir--;
			}else if(dir == 0) {
				dir = 3;
			}
		}
	}
	
	//이동
	void moveCha() {
		int by = y;
		int bx = x;
		if(dir == 0) { //북
			y--;
		}else if(dir == 1) {//동
			x--;
		}else if(dir == 2) {//남
			y++;
		}else if(dir == 3) {//서
			x++;
		}
		int errNum = moveCheck(y, x);
		
		if(errNum < 0) {
		map[y][x] = map[by][bx];
		map[by][bx] = 0;
		}else {
			x = bx;
			y = by;
		}
	}
	
	//이동가능 체크
	int moveCheck(int y, int x) {
		
		if(y<0 || y > map.length-1) {
			System.out.println("[Y축 범위를 벗어났습니다.]");
			return 1;			
		}else if(x<0 || x > map.length-1) {
			System.out.println("[X축 범위를 벗어났습니다.]");
			return 2;
		}
		else if(map[y][x]==7) {	
			System.out.println("[벽으로 막혀서 이동불가능]");
			return 3;
		}
		
		if(map[y][x]==0) {
			return -1;
		}
		return -2;
	}
	
	
	
	
	void run()	{
		initPos();
		System.out.print("=======스타트 위치=======  ");
		System.out.println(y+" "+x);
		printGame();
		inputVal();
		
	}
	
}

public class 여행 {

	public static void main(String[] args) {
		
		Game1 g = new Game1();
		g.run();
		

	}

}
