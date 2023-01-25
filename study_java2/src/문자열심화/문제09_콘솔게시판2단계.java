package 문자열심화;

import java.util.Arrays;
import java.util.Scanner;

public class 문제09_콘솔게시판2단계 {

	public static void main(String[] args) {
			
		/*
		 * # 콘솔 게시판
		 *  1. [이전] 또는 [이후] 버튼을 누르면 페이지 번호가 변경된다. 
		 *    // 이전 버튼은 이전페이지가 있을때만 보여주고 
		 *    // 이후 버튼은 이후페이지가 있을때만 보여준다 
		 *  2. 현재 페이지 번호에 해당되는 게시글만 볼 수있다.
		 *  3. 2차원 배열 board에 0열에는 제목을 1열에는 게시글의 내용을 저장한다. 
		 *  4. 게시글을 추가하고 삭제할 때마다 실제 배열의 길이가 변한다 
		 *  
		 */
		
		Scanner scan = new Scanner(System.in);

		String[][] board = null;
		int count = 0; // 전체 게시글 수
		int pageSize = 3; // 한 페이지에 보여줄 게시글 수
		int curPageNum = 1; // 현재 페이지 번호
		int pageCount = 0; // 전체 페이지 개수
		int startRow = 0; // 현재 페이지의 게시글 시작 번호
		int endRow = 0; // 현재 페이지의 게시글 마지막 번호	
			
			
	}

}
