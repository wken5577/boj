import java.util.*;

class Solution {
     static boolean[] combi;
    static int[] pm;
    static int n, m, maxWin;

    static List<Integer> a, b;
    static List<int[]> diceA, diceB;


    public int[] solution(int[][] dice) {
        n = dice.length;
        m = n / 2;
        combi = new boolean[n];
        pm = new int[m];
        int[] answer = new int[m];
        maxWin = Integer.MIN_VALUE;

        combination(dice, 0, 0, answer);

        return Arrays.stream(answer).sorted().toArray();
    }

    private void combination(int[][] dice, int L, int s, int[] ans) {
        if (L == m) {
            diceA = new ArrayList<>();
            diceB = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if(combi[i]) diceA.add(dice[i]);
                else diceB.add(dice[i]);
            }
            a = new ArrayList<>();
            b = new ArrayList<>();
            rollDice(a, b, 0, 0, 0);
            b.sort(Comparator.comparingInt(a -> a));

            int winCnt = calcWinRate();
            if (winCnt > maxWin) {
                maxWin = winCnt;
                for(int i = 0; i < m; i++) {
                    ans[i] = pm[i] + 1;
                }
            }
        }else {
            for (int i = s; i < n; i++) {
                combi[i] = true;
                pm[L] = i;
                combination(dice, L + 1, i + 1, ans);
                combi[i] = false;
            }
        }

    }

    private int calcWinRate() {
        int cnt = 0;
        int mid;

        for(int sa: a) {

            int index = Integer.MIN_VALUE;
            int lt = 0, rt = b.size() - 1;

            while(lt <= rt) {
                mid = (lt + rt) / 2;
                if (sa > b.get(mid)) {
                    lt = mid + 1;
                    index = Math.max(index, mid);
                }else {
                    rt = mid - 1;
                }
            }
            if (index != Integer.MIN_VALUE) {
                cnt += index + 1;
            }
        }
        return cnt;
    }

    private void rollDice(List<Integer> a, List<Integer> b, int d, int sumA, int sumB) {
        if(d == m) {
            a.add(sumA);
            b.add(sumB);
            return;
        }

        for (int i = 0; i < 6; i++) {
            rollDice(a, b, d + 1, sumA + diceA.get(d)[i], sumB + diceB.get(d)[i]);
        }
    }
}
