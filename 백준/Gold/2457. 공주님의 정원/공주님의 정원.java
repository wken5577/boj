import java.io.*;
import java.util.*;

public class Main {
    static int n;

    public static void main(String[] args) throws IOException {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
        ) {
            n = Integer.parseInt(br.readLine());
            List<int[]> list = new ArrayList<>();
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int startMonth = Integer.parseInt(st.nextToken());
                int startDay = Integer.parseInt(st.nextToken());
                int endMonth = Integer.parseInt(st.nextToken());
                int endDay = Integer.parseInt(st.nextToken());
                list.add(convertToDay(new int[] {startMonth, startDay}, new int[] {endMonth, endDay}));
            }
            Collections.sort(list, (o1, o2) -> {
                if (o1[0] == o2[0])
                    return o2[2] - o1[2];
                return o1[0] - o2[0];
            });

            int[] start = convertToDay(new int[]{3, 1}, new int[]{11, 30});
            int last = start[0];

            int i = 0;
            int max = 0;
            int ans = 0;
            while(i < list.size()){
                int[] now = list.get(i);
                if (last > start[1])
                    break;
                if (last >= now[0]){
                    max = Math.max(max, now[1]);
                }
                else{
                    if (max == 0){
                        System.out.println(0);
                        return;
                    }
                    last = max;
                    max = 0;
                    ans++;
                    continue;
                }

                i++;
            }
            if (max != 0){
                last = max;
                ans++;
            }

            if (last > start[1])
                System.out.println(ans);
            else
                System.out.println(0);

        }
    }
    public static int[] convertToDay(int[] start, int[] end){
        int startMonth = start[0];
        int startDay = start[1];
        int endMonth = end[0];
        int endDay = end[1];

        int s = 0;
        for (int i = 1; i < startMonth; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i ==  10 || i ==  12)
                s += 31;
            else if (i == 2)
                s += 28;
            else
                s += 30;
        }
        s += startDay;

        int e = 0;
        for (int i = 1; i < endMonth; i++) {
            if (i == 1 || i == 3 || i == 5 || i == 7 || i == 8 || i ==  10 || i ==  12)
                e += 31;
            else if (i == 2)
                e += 28;
            else
                e += 30;
        }
        e += endDay;
        return new int[] {s, e, e - s};
    }
}
