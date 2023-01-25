package 메서드2_문제연습;

import java.util.Random;
import java.util.Scanner;

class WordGame1 {
	Scanner scan = new Scanner(System.in);

	String[] wordList = { "java", "spring", "jsp", "android", "php" };
	boolean[] checkList;
	int count;

	void printMenu() {
		System.out.println("타자연습게임");
		System.out.println("1)게임 0)종료");
	}

	int getValue(String msg, int start, int end) {
		int val = -1;
		System.out.println(msg + " >>");
		val = scan.nextInt();
		if (val < start || val > end) {
			System.out.println("입력 오류");
			val = -1;
		}
		scan.nextLine();
		return val;
	}

	String getValue(String msg) {
		System.out.println(msg + " ");
		String val = scan.next();
		return val;
	}

	void shuffleWord() {
		Random rd = new Random();
		for (int i = 0; i < 1000; i++) {
			int r1 = rd.nextInt(wordList.length);
			int r2 = rd.nextInt(wordList.length);

			String temp = wordList[r1];
			wordList[r1] = wordList[r2];
			wordList[r2] = temp;
		}
	}

	void reset() {
		count = 0;
		shuffleWord();
		checkList = new boolean[wordList.length];
	}

	String getWord() {
		return wordList[count];
	}

	void checkWord(String word) {
		if (word.equals(wordList[count])) {
			checkList[count] = true;
		}
		count += 1;
	}

	boolean getGameEnd() {
		if (count == wordList.length) {
			return true;
		}
		return false;

	}

	String setQuiz() {
		Random rd = new Random();
		String word = wordList[count];
		String quiz = "";
		int rdNum = 0;

		rdNum = rd.nextInt(word.length());
		for (int i = 0; i < word.length(); i++) {
			if (i == rdNum) {
				quiz += "*";
			} else {
				quiz += word.charAt(i);
			}
		}

		return quiz;
	}

	void printGameEnd() {
		System.out.println("------------------------------");
		for (int i = 0; i < wordList.length; i++) {
			System.out.printf("%-8s", wordList[i]);
		}
		System.out.println();
		for (int i = 0; i < checkList.length; i++) {
			System.out.printf("%-8s", checkList[i]);
		}
		System.out.println();
		System.out.println("------------------------------");
		System.out.println("[Game Over]");
	}

	void playGame(String quiz) {
		if (quiz.equals("")) {
			quiz = setQuiz();
		}
		String word = getValue(count + 1 + ") " + quiz + " 의 단어를 맞춰보세요.");

		checkWord(word);

	}

	void run() {
		printMenu();
		while (true) {

			if (getGameEnd()) {
				printGameEnd();
				return;
			}
			int sel = getValue("메뉴 선택", 0, 1);
			if (sel == -1) {
				continue;
			} else if (sel == 1) {
				reset();
				while (!getGameEnd()) {
					String quiz = "";
					playGame(quiz);
				}
			} else if (sel == 0) {
				return;
			}

		}
	}

}

public class 메서드문제03_타자게임_2 {
	public static void main(String[] args) {

		WordGame1 wordGame = new WordGame1();

		wordGame.run();

	}
}