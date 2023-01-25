package 문자열심화;

import java.util.Arrays;
import java.util.Scanner;

public class 문제04_장바구니삭제 {

	public static void main(String[] args) {
			
		/*
		 * [문제] cart데이터는 현재 장바구니 상황이다.
		 * 
		 * input데이터는 삭제를 요청한 데이터이다. qwer은 아이디이고, 3은 삭제할 위치이다. qwer 입장에서는 본인 아이템은 3개 밖에
		 * 없으니 칸쵸를 지우기 위해 3을 선택했지만 전체 데이터에서는 5번째 아이템이다.
		 * 
		 * 마찬가지로 abcd는 콜라와 사이다를 구입했고, 콜라를 지우기 위해 1번을 선택했지만 실제로는 3번 아이템이 삭제되어야 한다.
		 * 
		 * 삭제 후 cart배열의 정보를 출력하시오. [정답] qwer/고래밥 qwer/새우깡 java/칸쵸 java/고래밥 abcd/사이다
		 */

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

		String[] itemList = item.split("/");

		System.out.println("===== 아 이 템 =====");
		System.out.println(Arrays.toString(itemList));

		String[] idList = id.split("/");

		System.out.println("===== 아 이 디 =====");
		System.out.println(Arrays.toString(idList));

		String[] cartList = cart.split("\n");
		String[][] cartL = new String[cartList.length][];

		int cnt = 0;
		for (String s : cartList) {
			cartL[cnt] = cartList[cnt].split(",");
			cartL[cnt] = cartL[cnt][0].split("/");
			cnt++;
		}

		System.out.println("====== 구 매 목 록 ========");
		cnt = 0;
		for (String[] s : cartL) {
			System.out.println(Arrays.toString(cartL[cnt]));
			cnt++;
		}

		int idx = 0;
		System.out.println("=======================");
		for (String[] in : input) {
			cnt = 0;
			idx = 0;
			for (String[] car : cartL) {
				if (in[0].equals(car[0])) {
					cnt++;
				}
				if (cnt == Integer.valueOf(in[1])) {
					break;
				}
				idx++;
			}
			System.out.println(idx);

			String[][] tempcart = new String[cartL.length - 1][];
			int idx1 = 0;

			for (int i = 0; i < cartL.length; i++) {
				if (i != idx) {
					tempcart[idx1] = cartL[i];
					idx1++;
				}
			}
			cartL = tempcart;
			tempcart = null;

		}

//			for(int i =0; i<cartL.length; i++) {
//				System.out.println(Arrays.toString(cartL[i]));			
//			}

		cart = "";
		int i = 0;
		for (String[] s : cartL) {
			cart += s[0] + "/" + s[1] + "\n";
			i++;
		}
		System.out.println(cart);
			
	}

}
