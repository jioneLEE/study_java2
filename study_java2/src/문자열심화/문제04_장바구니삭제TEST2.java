package 문자열심화;

import java.util.Arrays;
import java.util.Scanner;

public class 문제04_장바구니삭제TEST2 {

	public static void main(String[] args) {
	

		String item = "칸초/새우깡/고래밥/콜라/사이다";
		String id = "qwer/abcd/java";

		String cart = "";
		cart += "qwer/고래밥\n";
		cart += "qwer/새우깡\n";
		cart += "abcd/콜라\n"; // 삭제 2
		cart += "java/칸쵸\n";
		cart += "qwer/칸쵸\n"; // 삭제 1
		cart += "java/고래밥\n";
		cart += "abcd/사이다";

		String[][] input = { { "qwer", "3" }, { "abcd", "1" } };

		String itemList[] = item.split("/");
		String idList[] = id.split("/");
		String data[] = cart.split("\n");

		String cartList[][] = new String[data.length][2];

		System.out.println(" === 삭제 전 데이타 ===");

		int idx = 0;
		for (String val : data) {
			// System.out.println(val);
			String temp[] = val.split("/");
			cartList[idx][0] = temp[0];
			cartList[idx][1] = temp[1];
			System.out.println(Arrays.toString(cartList[idx]));
			idx++;
		}

		System.out.println("=== 삭제 후 데이타 ===");

		for (String[] del : input) {
			int cnt = 0;
			int delIdx = 0;
			for (String[] temp : cartList) {
				if (temp[0].equals(del[0])) {
					cnt++;
				}
				if (cnt == Integer.parseInt(del[1])) {
					break;
				}
				delIdx++;
			}
			System.out.println("==========");
			System.out.println(delIdx);

			String tempList[][] = new String[cartList.length - 1][2];
			int index = 0;
			for (int i = 0; i < cartList.length; i++) {
				if (i != delIdx) {
					// 매우 중요 : 주소값 이동되는 개념
					tempList[index] = cartList[i];
					index++;
				}
			}
			cartList = tempList;
			tempList = null;
		}

		cart = "";
		for (String[] temp : cartList) {
			//System.out.println(Arrays.toString(temp));
			cart += temp[0]+"/"+temp[1]+"\n";
		}

		System.out.println(cart);
			
			
	}

}
