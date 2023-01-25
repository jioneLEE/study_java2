package 문자열심화;

import java.util.Arrays;
import java.util.Scanner;

public class 문제03_장바구니검색TEST {

	public static void main(String[] args) {
			
		/*
		[문제1] 
			회원별로 아이템 구매목록을 출력하시오.
		[정답1] 
			이만수(고래밥 3개 칸쵸 1개)
			김철민(고래밥 1개)
			이영희(고래밥 1개 새우깡 2개)
		
		[문제2]
			아이템별로 구입한 회원이름을 출력하시오.
		[정답2]
			고래밥(이만수 김철민 이영희)
			새우깡(이영희)
			칸쵸(이만수)
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
		
		String items[] = itemData.split(",");
		String users[] = userData.split(",");
		String carts[] = cartData.split("\n");

		
		String itemList[][] = new String[items.length][2];
		String userList[][] = new String[users.length][2];
		String cartList[][] = new String[carts.length][2];
		
		System.out.println("===== 아이템 목록 =====");
		int cnt =0;
		for(String item : items) {
			//System.out.println(item);
			String temp[] = item.split("/");
			itemList[cnt][0] = temp[0];
			itemList[cnt][1] = temp[1];
			System.out.println(Arrays.toString(itemList[cnt]));
			cnt++;
		}
		
		System.out.println("===== 유저 목록 =====");
		 cnt =0;
		for(String user : users) {
			//System.out.println(user);
			String temp[] = user.split("/");
			userList[cnt][0] = temp[0];
			userList[cnt][1] = temp[1];
			System.out.println(Arrays.toString(userList[cnt]));
			cnt++;
		}
		
		
		System.out.println("===== 장바구니 목록 =====");
		 cnt =0;
		for(String cart : carts) {
			//System.out.println(cart);
			String temp[] =cart.split("/");
			cartList[cnt][0] = temp[0];
			cartList[cnt][1] = temp[1];
			System.out.println(Arrays.toString(cartList[cnt]));
			cnt++;
		}
		
		for(String[] user: userList) {
			//System.out.println(user[0] +" " + user[1]);
			
			System.out.printf("%s( " , user[1]);
			
			int[] itemCnt = new int[items.length];
			int idx =0;
			for(String[] item: itemList) {
				for(String[] cart: cartList) {
					if(item[0].equals(cart[1])&&user[0].equals(cart[0])) {
						itemCnt[idx]++;
					}
				}
				
				if(itemCnt[idx]>0) {
					System.out.printf("%s %d개 " , item[1], itemCnt[idx]);
				}
				
				idx++;
			}
			System.out.println(")");
		}
		
		
		System.out.println("====================");

		for(String[] item: itemList) {
			System.out.printf("%s( " , item[1]);
			for(String[] user: userList) {
				for(String[] cart: cartList) {
					if(item[0].equals(cart[1])&&user[0].equals(cart[0])) {
						System.out.print(user[1] +" ");
						break;
					}
				}
			}
			
			System.out.println(")");
		}
		
		
	}

}
