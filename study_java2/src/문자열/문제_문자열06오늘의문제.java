package 문자열;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class 문제_문자열06오늘의문제 {

	public static void main(String[] args) {
		
		/*
		 * # 당첨복권 1셋트
		 * 1. 3이 연속으로 3번 등장하면 당첨복권이다.
		 * 2. 랜덤으로 5개의 복권을 생성하되,
		 *    당첨복권은 한 개만 생성되도록 설정한다.

	    // 3030333 => 당첨 
	    // 0303030 => 꽝 
		 */

		int[][] lottoSet = new int[5][7];
		Random rd = new Random();
				
		for(int i =0; i<lottoSet.length; i++) {
			for(int k =0; k<lottoSet[i].length; ) {
				int rand = rd.nextInt(4);
				if(rand == 0) {
					lottoSet[i][k] = 0;
					k++;
				}
				else if(rand == 3) {
					lottoSet[i][k] = 3;
					k++;
				}
				
			}
			
			for(int k =0; k<lottoSet[i].length; k++) {
				
			}
		}
		
		for(int i =0; i<lottoSet.length; i++) {
			System.out.println(Arrays.toString(lottoSet[i]));
		}
		
	}

}
