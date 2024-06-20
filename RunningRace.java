import java.util.HashMap;

public class RunningRace {
    //프로그래머스 - 달리기 경주
    //https://school.programmers.co.kr/learn/courses/30/lessons/178871
    public static void main(String[] args){

        String[] player = {"mumu", "soe", "poe", "kai", "mine"};
        String[] callings = {"kai", "kai", "mine", "mine"};
        String[] result = solution2(player,callings);
        for(int i = 0; i < result.length; i++){
            System.out.println(result[i]);
        }
    }

    //모범답안 풀이
    public static String[] solution2(String[] players, String[] callings) {
        int n = players.length;
        HashMap<String, Integer> indexMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            indexMap.put(players[i], i);
            //HashMap에 플레이어 이름을 key, index를 value로
        }

        for (String calling : callings) {
            int idx = indexMap.get(calling);
            if (idx > 0) {
                String temp = players[idx - 1]; //순위차감될 플레이어
                players[idx - 1] = players[idx];//순위상승될 플레이어
                players[idx] = temp;

                indexMap.put(players[idx - 1], idx - 1);//순위상승될 플레이어 재배치
                indexMap.put(players[idx], idx);//순위차감될 플레이어 재배치
            }
        }
        return players;
    }

    //1차 시도
    //시간 초과로 실패
    public static String[] solution1(String[] players, String[] callings) {
        String[] answer = {};
        int pSize = players.length;
        int cSize = callings.length;
        for (int i = 0; i < cSize ; i++) {
            for (int j = 1 ; j < pSize ; j++) {
                if (players[j].equals(callings[i])) {
                    players[j] = players[j-1];
                    players[j-1] = callings[i];
                    break;
                }
            }
        }
        answer = players.clone();
        return answer;
    }

}
