package 메서드2;

class Test {
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
}

public class 두자리소수점 {

	public static void main(String[] args) {

		int total = 155;
		int count = 3;
		double avg = total * 1.0 / count;
		System.out.println("avg = " + avg);
		double avg2 = Math.round(avg * 100) / 100.0;
		System.out.println("avg2 = " + avg2);

		String avg3 = String.format("%.2f", avg);
		System.out.println("avg3 = " + avg3);
		// System.out.printf("%.2f \n" , avg);

		Test t = new Test();
		String avg4 = t.changeNum(avg);
		System.out.println("avg4 = " + avg4);
	}

}