package ATM;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	static private Scanner sc = new Scanner(System.in);

	static int getSel(String msg, int min, int max) {
		System.out.println(msg + " >>");
		int sel = -1;
		try {
			sel = sc.nextInt();
			if (sel < min || sel > max) {
				throw new Exception("[에러 : 입력 범위를 벗어났습니다.]");
			}
		} catch (InputMismatchException e) {
			sc.nextLine();
			sel = -1;
			System.out.println("[에러 : 숫자만 입력가능합니다.]");
		} catch (Exception e) {
			sel = -1;
			System.out.println(e.getMessage());
		}

		return sel;
	}
}
