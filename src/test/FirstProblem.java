package test;

public class FirstProblem {

	public static String solution(String s) {
		
		if(s == null || s.length() <= 1)
			return s;

		StringBuilder sb = new StringBuilder();
		boolean aFlag = true;
		boolean cFlag = true;
		for(int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == 'B')
				continue;
			if(s.charAt(i) == 'A' && aFlag) {
				sb.append(s.charAt(i));
				aFlag = false;
				cFlag = true;
			}
			
			if(s.charAt(i) == 'C' && cFlag) {
				sb.append(s.charAt(i));
				aFlag = true;
				cFlag = false;
			}
		}
		if(sb.length() == 0)  // if there is only 'B'
			return s;
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(solution("B"));
	}
}
