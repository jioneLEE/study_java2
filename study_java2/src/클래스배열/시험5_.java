package 클래스배열;

import java.util.Scanner;

class User{
	String id;
}
class Seat{
	int y;
	int x;
	String userId;
	boolean check;
	int price;
}

public class 시험5_ {

	public static void main(String[] args) {
		int seatPrice = 12000;
		
		String[] userIdList = {"aaa" , "bbb" , "ccc"};
		String[][] seatUserIdList = {
			{null	,"aaa"	,"aaa"  ,null},
			{null   ,null 	,"bbb" 	,null},
			{"ccc" 	,"bbb" 	,null 	,"bbb"}
		};
		int seatSize = 12;		
		User[] userList = new User[seatSize];
		Seat[] seatList = new Seat[seatSize];
		
		
		
			for (int i = 0,j = 0; i < seatUserIdList.length; i++) {
				for (int k = 0 ; k < seatUserIdList[i].length; k++,j++) {
					Seat seatTemp = new Seat();
					seatTemp.y = i;
					seatTemp.x = k;
					seatTemp.userId = seatUserIdList[i][k];
					seatTemp.check = seatUserIdList[i][k] != null ? true : false;
					seatTemp.price = seatUserIdList[i][k] != null ? 12000 : 0;
					seatList[j] = seatTemp;
				}
			}
		
		
		
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.println("[0] 종료\n"
					+ "[1] 전체출력\n"
					+ "[2] 회원 aaa가 예약한 자리와 요금출력\n"
					+ "[3] 예약가능한자리 위치출력 \n"
					+ "[4] 예약을 가장많이한 회원출력");
			
			int sel = sc.nextInt();
			if(sel == 0) {
				System.out.println("===[종료]===");
				break;
			}else if(sel == 1) {
				System.out.println("===[좌석예매]===");
				for(int i = 0; i < seatSize; i++) {
					if(seatList[i].check) {
						System.out.printf("[%5s]", seatList[i].userId);
					}else {
						System.out.printf("[%5s]","");
					}			
					if(i % 4 == 3) {
						System.out.println();
					}
				}
			}
		}
		
	}

}