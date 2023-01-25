package 문자열심화;

import java.util.Arrays;
import java.util.Scanner;

public class 문제08_콘솔게시판1단계 {

	public static void main(String[] args) {
			
		Scanner sc = new Scanner(System.in);

		int count = 14; // 전체 게시글 수
		int pageSize = 3; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = 0; // 전체 페이지 개수
		int startRow = 0; // 현재 페이지의 게시글 시작 번호
		int endRow = 0; // 현재 페이지의 게시글 마지막 번호

		System.out.println("한 페이지에 보여줄 게시글 숫자");
		int in =sc.nextInt();
		System.out.println("전체 게시글 수 >> ");
		
		
		while(true){
	    	System.out.println("[이전 1]"); // 페이지 이동
				System.out.println("[이후 2]");
				System.out.println("선택 >> ");
				int choice = sc.nextInt();
		}
			
			
	}

}
