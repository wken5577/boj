import java.util.*;

class Solution {
    static int answer = 1;
    static boolean flag = false;

    public static int[] pm;

    public int solution(int coin, int[] cards) {
        int n = cards.length;
        int cost = n + 1;
        int startSize = n / 3;

        // cards에서 statSize만큼 뽑아서 시작
        List<Integer> myCards = new ArrayList<>();
        for (int i = 0; i < startSize; i++) {
            myCards.add(cards[i]);
        }

        List<Integer> keep = new ArrayList<>();
        int maxRound = (n - startSize) / 2 + 1;
        for (int round = 1; round <= maxRound; round++) {
            answer = round;
            if (round == maxRound) break;

            int idx = startSize + (round - 1) * 2;
            int peek1 = cards[idx];
            int peek2 = cards[idx + 1];
            keep.add(peek1);
            keep.add(peek2);

            // myCards 로만 진행 가능한지
            if (checkCanContinue(myCards, cost)) continue;

            // myCards 로만 안되면 keep 에서 1개만 추가해보기
            boolean costOne = false;
            if (coin >= 1) {
                for (int i = 0; i < keep.size(); i++) {
                    List<Integer> list = new ArrayList<>(myCards);
                    list.add(keep.get(i));
                    if (checkCanContinue(list, cost)) {
                        myCards = list;
                        coin--;
                        costOne = true;
                        break;
                    }
                }
            }
            if (costOne) continue;

            // 1개 넣는것도 안되면 2개 넣어보기
            if (coin >= 2) {
                List<Integer> list = new ArrayList<>(keep);
                if (checkCanContinue(list, cost)) {
                    keep = list;
                    coin -= 2;
                    continue;
                }
            }

            break;
        }


        return answer;
    }

    private boolean checkCanContinue(List<Integer> list, int cost) {
        flag = false;
        if (list.size() < 2) return flag;

        pm = new int[2];
        combination(list, cost, 0, 0);

        return flag;
    }

    void combination(List<Integer> list, int cost, int L, int S) {
        if (flag) return;
        if (L == 2) {
            Integer obj1 = list.get(pm[0]);
            Integer obj2 = list.get(pm[1]);

            if (obj1 + obj2 == cost) {
                flag = true;
                list.remove(obj1);
                list.remove(obj2);
            }
        } else {
            for (int i = S; i < list.size(); i++) {
                pm[L] = i;
                combination(list, cost, L + 1, i + 1);
            }
        }

    }
}