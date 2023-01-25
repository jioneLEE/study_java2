package 문자열심화;

import java.util.Arrays;
import java.util.Scanner;

public class 문제03_장바구니검색 {

	public static void main(String[] args) {

		/*
		 * [문제1] 회원별로 아이템 구매목록을 출력하시오. [정답1] 이만수(고래밥 3개 칸쵸 1개) 김철민(고래밥 1개) 이영희(고래밥 1개
		 * 새우깡 2개)
		 * 
		 * [문제2] 아이템별로 구입한 회원이름을 출력하시오. [정답2] 고래밥(이만수 김철민 이영희) 새우깡(이영희) 칸쵸(이만수)
		 */

		String itemData = "1001/고래밥,1002/새우깡,1003/칸쵸";
		String userData = "3001/이만수,3002/김철민,3003/이영희";
		String cartData = "";
		cartData += "3001/1001\n";
		cartData += "3001/1001\n";
		cartData += "3003/1002\n";
		cartData += "3001/1001\n";
		cartData += "3001/1003\n";
		cartData += "3003/1002\n";
		cartData += "3003/1001\n";
		cartData += "3002/1001";

		String itemDataBuff[] = itemData.split(",");
		String[][] item = new String[itemDataBuff.length][];

		String userDataBuff[] = userData.split(",");
		String[][] user = new String[userDataBuff.length][];

		String cartDataBuff[] = cartData.split("\n");
		String[][] cart = new String[cartDataBuff.length][];
		
		for (int i = 0; i < itemDataBuff.length; i++) {
			item[i] = itemDataBuff[i].split(",");
			item[i] = item[i][0].split("/");
			user[i] = userDataBuff[i].split(",");
			user[i] = user[i][0].split("/");
		}
		for (int i = 0; i < cartDataBuff.length; i++) {
			cart[i] = cartDataBuff[i].split(",");
			cart[i] = cart[i][0].split("/");
		}
		System.out.println("=======[아이템 목록]=======");
		for (int i = 0; i < item.length; i++) {
			System.out.println(Arrays.toString(item[i]));
		}
		System.out.println("=======[유저 목록]=======");
		for (int i = 0; i < item.length; i++) {
			System.out.println(Arrays.toString(user[i]));
		}
		System.out.println("=======[장바구니 목록]=======");
		for (int i = 0; i < cart.length; i++) {
			System.out.println(Arrays.toString(cart[i]));
		}
		System.out.println("=======[ 정 리 ]========");
		int whale = 0;
		int shrimp = 0;
		int snack = 0;
		for (int i = 0; i < user.length; i++) {
			whale = 0;
			shrimp = 0;
			snack = 0;
			System.out.printf("%s ( ", user[i][1]);
			for (int k = 0; k < cart.length; k++) {
				if (user[i][0].equals(cart[k][0])) {
					for (int j = 0; j < item.length; j++) {
						if (item[j][0].equals(cart[k][1])) {
							if (j == 0) {
								whale++;
							} else if (j == 1) {
								shrimp++;
							} else {
								snack++;
							}

						}
					}

				}
			}
			if (whale != 0) {
				System.out.printf("고래밥 %d개", whale);
			}
			if (shrimp != 0) {
				System.out.printf(" 새우깡 %d개", shrimp);
			}
			if (snack != 0) {
				System.out.printf(" 깐초 %d개", snack);
			}
			System.out.printf(" )\n");

		}
		System.out.println();
		int idx = -1;
		int t = 0;
		for (int i = 0; i < item.length; i++) {
			System.out.printf("%s ( ", item[i][1]);
			for (int k = 0; k < user.length; k++) {
				for (int j = 0; j < cart.length; j++) {
					if (item[i][0].equals(cart[j][1]) && user[k][0].equals(cart[j][0])) {
						System.out.print(user[k][1] + " ");
						break;
					}

				}

			}
			System.out.println(")");
		}
		
			
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
