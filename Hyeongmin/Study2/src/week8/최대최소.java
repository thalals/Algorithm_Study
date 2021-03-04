package week8;

public class 최대최소 {

	public static void main(String[] args) {
		String s = "-1 -2 -3 -4";
		System.out.println(solution(s));
	}

	public static String solution(String s) {
		String answer = "";

		String temp[] = s.split(" ");

		int min = Integer.parseInt(temp[0]);
		int max = Integer.parseInt(temp[0]);

		for (int i = 0; i < temp.length; i++) {
			int number = Integer.parseInt(temp[i]);

			if (min > number)
				min = number;
			if (max < number);
			
			max = number;
		}

		answer = min + " " + max;
		return answer;
	}

}
