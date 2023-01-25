package 메서드2_문제연습;

import java.util.Arrays;

/*
(0북) (1동) (2남) (3서)
input의 데이터는 1은 한칸전진이고 2는 좌회전(90도) 3은 우회전(90도)이다.
 회전은 방향만 바뀌고 움직이는건 없다.
*/

class Node{
	int y;
	int x;
}

class Game2{
	int[][] map;
	int[] key;
	int dir;
	Node player = new Node();
	Node wall = new Node();
	void init() {
		int[][] temp= {
				{0,0,0,0,0,0,0},	
				{0,7,7,7,7,0,0},	
				{0,7,0,0,7,0,0},	
				{0,7,0,8,7,0,0},	
				{0,0,0,0,7,0,0},	
				{0,0,0,0,7,7,0},	
				{0,0,0,0,0,0,0}
		};
		map = temp;
		 int input[] = {1,1,2,1,1,2,1,1,3,1,1};
		 key = input;
		 // 플레이어 초기값 입력
		for(int i =0; i<map.length; i++) {
			for(int k =0; k<map[i].length; k++) {
				if(map[i][k] == 8) {
					player.y = i;
					player.x = k;
				}
			}
		}
	}
	
	Node moveRight(Node node) {
		node.x++;
	  return node;
	}
	
	Node moveLeft(Node node) {
		node.x--;
		return node;
	}
	Node moveUp(Node node) {
		node.y--;
		return node;
	}
	Node moveDown(Node node) {
		node.y++;
		return node;
	}
	
	void printMap() {
		for(int i =0; i<map.length; i++) {
			System.out.println(Arrays.toString(map[i]));
		}
	}
	
	boolean isRoad(Node node) {
		if(node.x <0 || node.y <0 || node.x>= map.length ||  node.y>= map.length) {
			System.out.println("벽넘어 이동 할 수 없습니다");
			return false;
		}
		return true;
	}
	boolean checkWall(Node node) {
		
		if(map[node.y][node.x] == 7) {
			System.out.println("이동 할 수 없습니다");
			return false;
		}
		return true;
	}
	
	void updatePlayer(Node node) {
		map[player.y][player.x] = 0;
		player.x = node.x;
		player.y = node.y;
		map[player.y][player.x] = 8;
		
	}
	
	void run() {
		init();
		int cnt =0;
		
		System.out.printf("=== Y위치[%d] X위치[%d] ====\n",player.y , player.x);
		printMap();
		
		while (cnt != key.length) {
			Node now = new Node();
				now.y = player.y;
				now.x = player.x;
			if (key[cnt] == 1) {
				if (dir == 0) {
				   now = moveUp(now);		
				} else if (dir == 1) {
					now = moveRight(now);
				} else if (dir == 2) {
					now = moveDown(now);
				} else if (dir == 3) {
					now = moveLeft(now);
				}
				
			}				
			 else if (key[cnt] == 2) {
				if (dir > 0 && dir <= 3) {
					dir--;
				} else if(dir == 0) {
					dir = 3;
				}
			} else if (key[cnt] == 3) {
				if (dir < 3 && dir>=0 ) {
					dir++;
				} else if(dir ==3) {
					dir = 0;
				}
			}
			
			
			System.out.printf("==[%d 턴]Y위치[%d] X위치[%d] 방향%d==\n",cnt+1,player.y , player.x,dir);
			if(isRoad(now) && checkWall(now)) {
				updatePlayer(now); // 체크 완료한 플레이어 인덱스 변경 
			}
			printMap();
			cnt++;
		}
		
	

		
	}
	
}

public class 여행변형 {

	public static void main(String[] args) {
		
		Game2 g = new Game2();
		g.run();
		

	}

}
