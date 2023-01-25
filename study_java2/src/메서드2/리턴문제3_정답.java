package 메서드2;

import java.util.Arrays;

class Return3_1 {

	String changeNum(double avg) {
		String num = avg + ""; // "51.666666666666664";

		String avgNum = "";
		for (int i = 0; i < num.length(); i++) {
			avgNum += num.charAt(i);
			if (num.charAt(i) == '.') {
				avgNum += num.charAt(i + 1);
				int point = Integer.parseInt(num.charAt(i + 1) + "");
				if (point >= 5) {
					point++;
				}
				avgNum += point + "";
				break;
			}
		}

		return avgNum;
	}

	String[][] run(String[][] studentList, String[][] scoreList) {
		String[][] res = new String[studentList.length][8];

		int idx = 0;
		for (String[] stu : studentList) {
			res[idx][0] = stu[2];
			res[idx][1] = stu[0];
			res[idx][2] = stu[1];

			int sum = 0;
			for (String[] score : scoreList) {
				if (stu[2].equals(score[0])) {
					if (score[1].equals("국어")) {
						res[idx][3] = score[2];
					} else if (score[1].equals("수학")) {
						res[idx][4] = score[2];
					} else if (score[1].equals("영어")) {
						res[idx][5] = score[2];
					}
					sum += Integer.parseInt(score[2]);
				}
			}
			res[idx][6] = sum + "";
			res[idx][7] = changeNum(sum * 1.0 / 3);
			idx++;

		}

		return res;

	}
}

public class 리턴문제3_정답 {

	public static void main(String[] args) {

		/*
		 * [문제] 아래 main() 메서드 내의 student배열은 순서대로 이름, 지역, 번호를 의미한다. score배열은 번호 과목, 점수를
		 * 의미한다.
		 * 
		 * 이러한 데이터를 아래 순서대로 result배열에 저장하여 리턴해주는 run메서드를 구현하시오. // 0 1 2 3 4 5 6 7
		 * [학생번호] [이름] [지역] [국어] [수학] [영어] [총합] [평균]
		 * 
		 * [정답] String[][] result = { [1001, 김철만, 신촌, 20, 65, 43, 128, 42.67], [1002,
		 * 오상덕, 강남, 50, 15, 90, 155, 51.67], [1003, 민철이, 대치, 60, 80, 30, 170, 56.67],
		 * [1004, 유재석, 강동, 17, 70, 70, 157, 52.33] }
		 */

		Return3_1 re = new Return3_1();

		String[][] student = { { "김철만", "신촌", "1001" }, { "오상덕", "강남", "1002" }, { "민철이", "대치", "1003" },
				{ "유재석", "강동", "1004" } };
		String[][] score = { { "1001", "국어", "20" }, { "1002", "국어", "50" }, { "1003", "국어", "60" },
				{ "1004", "국어", "17" }, { "1001", "수학", "65" }, { "1002", "수학", "15" }, { "1003", "수학", "80" },
				{ "1004", "수학", "70" }, { "1001", "영어", "43" }, { "1002", "영어", "90" }, { "1003", "영어", "30" },
				{ "1004", "영어", "70" } };

		String[][] result = re.run(student, score);

		for (String data[] : result) {
			System.out.println(Arrays.toString(data));
		}

		/*
		 * 두 이차원 배열 합쳐서 result 이차원 배열에 넣기
		 * 
		 * [1001, 김철만, 신촌, 20, 65, 43, 128, 42.67], [1002, 오상덕, 강남, 50, 15, 90, 155,
		 * 51.67], [1003, 민철이, 대치, 60, 80, 30, 170, 56.67], [1004, 유재석, 강동, 17, 70, 70,
		 * 157, 52.33]
		 * 
		 */
	}

}