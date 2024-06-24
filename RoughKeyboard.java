import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.stream.Collectors;

public class RoughKeyboard {

    //프로그래머스 - 대충만든 자판
    //https://school.programmers.co.kr/learn/courses/30/lessons/160586

    public static void main(String[] args){
        String[][] input1 = {{"ABACD", "BCEFD"}, {"ABCD","AABB"}};
        String[][] input2 = {{"AA"}, {"B"}};
        String[][] input3 = {{"AGZ", "BSSS"}, {"ASA","BGZ"}};
        System.out.println(Arrays.toString(solution1(input1[0], input1[1])));
        System.out.println(Arrays.toString(solution1(input2[0], input2[1])));
        System.out.println(Arrays.toString(solution1(input3[0], input3[1])));
    }

    public static int[] solution1(String[] keymap, String[] targets){
        ArrayList<Integer> answer = new ArrayList<>();

        ArrayList<HashMap<Character, Integer>> keymapList = convertToMap(keymap);

        for (String s : targets){
            int cnt = 0;
            for (int i = 0; i < s.length(); i++) {
                //"ABACD", "BCEFD"
                for (int j = 0; j < keymapList.size(); j++){
                    if (keymapList.get(j).get(s.charAt(i)) != null){
                        cnt += keymapList.get(j).get(s.charAt(i));
                        break;
                    }
                }
            }
            int cntSum;
            if (cnt == 0){
                cnt = -1;
            }
            answer.add(cnt);
        }

        return answer.stream().mapToInt(value -> value).toArray();
    }

    public static ArrayList<HashMap<Character, Integer>> convertToMap(String[] keymap){

        ArrayList<HashMap<Character, Integer>> convertMap = new ArrayList<>();

        for (String s : keymap) {
            HashMap<Character, Integer> key = new HashMap<>();
            for (int j = 0; j < s.length(); j++) {
                if (key.get(s.charAt(j)) != null) {
                    key.put((char)j, j + 1);
                } else {
                    key.put(s.charAt(j), j + 1);
                }
            }
            convertMap.add(key);
        }

        return convertMap;
    }
}
