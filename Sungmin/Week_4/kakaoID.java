class Solution {
    public String solution(String new_id) {
        String answer = "";
        String s = new_id;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')
               s = s.replace(s.charAt(i), (char) (s.charAt(i) + 32));
         }
         //System.out.println(s);
         for (int i = 0; i < s.length(); i++) {// 문자 제거
            if ((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= '0' && s.charAt(i) <= '9')
                  || s.charAt(i) == '-' || s.charAt(i) == '_' || s.charAt(i) == '.')
               continue;
            else {
               s = s.replace(String.valueOf(s.charAt(i)), "");
               i--;
            }
         }
         //System.out.println(s);
         StringBuffer temps = new StringBuffer(s);
         for (int i = 0; i < temps.length(); i++) {// 마침표 치환
            if (i == 0)
               continue;
            if (temps.charAt(i) == '.' && temps.charAt(i - 1) == '.') {
               temps.deleteCharAt(i);
               i--;
            }
         }
         //System.out.println(temps);
         if(temps.length() >= 1&&temps.charAt(0)=='.')
            temps.deleteCharAt(0);
         if (temps.length() >= 2 && temps.charAt(temps.length() - 1) == '.')
               temps.deleteCharAt(temps.length() - 1);
         //System.out.println(temps);
         if (temps.length() == 0)
            temps.append("a");
         //System.out.println(temps);
         if (temps.length() >= 16) {
            while (temps.length() != 15)
               temps.deleteCharAt(temps.length() - 1);
            if(temps.length()>=2&&temps.charAt(temps.length()-1)=='.')
               temps.deleteCharAt(temps.length() - 1);
         }
         //System.out.println(temps);
         if (temps.length() <= 2)
            while (temps.length() != 3)
               temps.append(temps.charAt(temps.length() - 1));
         //System.out.println(temps.substring(0));
                answer = temps.substring(0);
         return answer;

      }        

}