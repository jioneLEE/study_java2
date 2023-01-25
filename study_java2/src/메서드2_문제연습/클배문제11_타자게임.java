package 메서드2_문제연습;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class Word {
	String word;
	int ranPos;

	void setRandomWordPos(String sample, int rIdx) {
		word = sample;
		ranPos = rIdx;
	}

	void printWord() {
		for (int i = 0; i < word.length(); i++) {
			if (i == ranPos) {
				System.out.print("*");
			} else {
				System.out.print(word.charAt(i));
			}
		}
	}

	
}
class WordSample {
	Random ran = new Random();
	boolean[] checkList; 
	int size;
	Word[] list;
	
	void init() {
		String[] wordList = { "java", "jsp", "python", "android", "spring" };
		size = wordList.length;
		list = new Word[size];
		checkList = new boolean[size];
		for(int i =0; i < size;i++) {
			list[i] = new Word();
			list[i].setRandomWordPos(wordList[i], ran.nextInt(wordList[i].length()));
		
		}
//		System.out.println(Arrays.toString(wordList));
//		
//		for(Word w : list) {
//
//			w.printWord();
//			System.out.print(" ");
//		}
//		
	}
	
	Word getRandWord() {
		int r = ran.nextInt(size);
		if(checkList[r]== false) {
			checkList[r] = true;
		}else {
			return null;
		}
		return list[r];
	}
	
	boolean getInputWord(Word word) {
		Scanner sc = new Scanner(System.in);
		word.printWord();
		System.out.println("를 맞추세요 ");
		String inputWord = sc.next();
		if(inputWord.equals(word.word)) {
			System.out.println("정답입니다");
			return true;
		}
		System.out.println("오답 입니다");
		return false;
	}
	
	void run() {
		init();
		Word word = null;
		boolean check = true;
		int cnt=0;
		long beforeTime = System.currentTimeMillis();
		while(cnt < size) {
			if(check) {
				word = getRandWord();
				if(word == null) {
					continue;
				}
			}
			check =getInputWord(word);
			if(check) {
				cnt++;
			}
		}
		long afterTime = System.currentTimeMillis();
		double diffTime = (afterTime - beforeTime) / 1000.0;
		System.out.printf("기록 : %.2f 초 \n" , diffTime);
		System.out.println("게임 종료");
		
	}
}

public class 클배문제11_타자게임 {

	public static void main(String[] args) {
		
		WordSample ws = new WordSample();
		ws.run();
	}
}