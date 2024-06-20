public class SecretCode {
    //프로그래머스 - 둘만의 암호
    //https://school.programmers.co.kr/learn/courses/30/lessons/155652?language=java
    public static void main(String[] args){
        String s = "aukks";
        String skip = "wbqd";
        int index = 5;
        String result = solution2(s, skip, index);
        System.out.println(result);
    }

    //모범 답안 풀이
    public static String solution2(String s, String skip, int index){
        StringBuilder answer = new StringBuilder();

        for (char sChar : s.toCharArray()){
            char temp = sChar;
            int idx = 0;
            while (idx < index){
                temp = temp == 'z' ? 'a' : (char) (temp + 1); //z를 넘어가는지 확인
                if (!skip.contains(String.valueOf(temp))){ //skip 문자열에 해당 문자가 포함되지 않을 경우
                    idx += 1;   //idx에 1 추가
                }
            }
            answer.append(temp);
        }

        return answer.toString();
    }

    //1차 시도
    //그냥 대실패
    public static String solution1(String s, String skip, int index) {
        String answer = "";
        for (int i = 0; i < s.length(); i++){
            int skipCount = 0;
            for (int j = 0; j < skip.length(); j++){
                if (s.charAt(i) + 5 >= skip.charAt(j) && s.charAt(i) <= skip.charAt(j)){
                    skipCount += 1;
                }
            }
            int sChar = s.charAt(i) + index + skipCount;
            if (sChar > 'z'){
                sChar = 'a' + ((sChar-1) - 'z');
            }
            answer += (char)sChar;
        }
        return answer;
    }
}
