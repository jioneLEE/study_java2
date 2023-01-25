package 메서드2;

import java.util.Arrays;

class Return2_1{
	
	int[] run(String[][] data) {
		int[] res = null;
		
		int cnt =0;
		for(String[] val : data) {
			int num = Integer.parseInt(val[1]);
			if(num >= 60) {
				if(cnt == 0) {
					res = new int[1];
				}else {
					int[] temp = res;
					res = new int[cnt+1];
					for(int i =0; i < temp.length; i++) {
						res[i] = temp[i];
					}
				}
				res[cnt] = Integer.parseInt(val[0]);
				cnt++;
			}
		}
	
		return res;
		
	}
	
}

public class 리턴문제2가변배열 {

	public static void main(String[] args) {
		/*
		[문제]
			아래 main() 메서드 안에 data배열은
			학생의 번호와 점수를 문자열 타입으로 저장한 것이다.
			번호는 1001부터 1004까지 있고
			점수는 0~100점 사이이며, 60점 이상이면 합격이다.
			오로지 합격생의 번호만 result배열에 담아서 리턴해주는
			run 메서드를 구현하시오.
	 */
		Return2_1 re = new Return2_1();
		
		String data[][] = {
				{"1001","34"},
				{"1002","46"},
				{"1003","81"},
				{"1004","100"},
		};
		int result[] = re.run(data);
		// 완성된 result 출력 // [1003,1004] 
		System.out.println(Arrays.toString(result));
		
	}

}