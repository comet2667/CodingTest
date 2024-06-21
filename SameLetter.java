import java.util.ArrayList;
import java.util.Arrays;

public class SameLetter {

    //프로그래머스 - 가장 가까운 같은 글자
    //https://school.programmers.co.kr/learn/courses/30/lessons/142086
    public static void main(String[] args){
        String banana = "banana";
        String foobar = "foobar";
        System.out.println(Arrays.toString(soloution1(banana)));
        System.out.println(Arrays.toString(soloution1(foobar)));
    }

    //한번에 성공!!
    public static int[] soloution1(String s){
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(-1); //첫번째 문자는 항상 -1
        char[] temp = s.toCharArray();
        for (int i = 1; i < temp.length; i++) {
            int j = 1;
            while(j <= i){
                if (temp[i] == temp[i-j]){
                    answer.add(j);
                    break;
                }
                j += 1;
            }
            if (j > i){
                answer.add(-1); //while 반복문을 전부 수행했을 경우 동일한 문자가 없다는 뜻이므로 -1 추가
            }
        }

        return answer.stream().mapToInt(value -> value).toArray();
    }
}
