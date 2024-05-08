import java.io.*;
import java.util.*;

public class Main {
	static int n;
	static int ans = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			Scanner sc = new Scanner(System.in);
			long[] p1 = new long[] {sc.nextLong(), sc.nextLong()};
			long[] p2 = new long[] {sc.nextLong(), sc.nextLong()};
			sc.nextLine();
			long[] p3 = new long[] {sc.nextLong(), sc.nextLong()};
			long[] p4 = new long[] {sc.nextLong(), sc.nextLong()};

			if (solution(p1, p2, p3, p4))
				System.out.println(1);
			else
				System.out.println(0);

		}

	}

	private static boolean solution(long[] p1, long[] p2, long[] p3, long[] p4) {
		long a = ccw(p1, p2, p3);
		long b = ccw(p1, p2, p4);
		long c = ccw(p3, p4, p2);
		long d = ccw(p3, p4, p1);
		long ccw1 = calcCcw(a, b);
		long ccw2 = calcCcw(c, d);
		if (ccw1 == 0 && ccw2 == 0){
			if (isPointInLine(p1, p3, p4) || isPointInLine(p2, p3, p4) ||
				isPointInLine(p3, p1, p2) || isPointInLine(p4, p1, p2)) {
				return true;
			}else
				return false;
		}
		return ccw1 <= 0 && ccw2 <= 0;
	}

	private static long calcCcw(long a, long b) {
		if (a == 0 || b == 0)
			return 0;
		if ((a < 0 && b < 0) || (a > 0 && b > 0))
			return 1;
		else
			return -1;
	}

	//  (x2 - x1) * (y3 - y1) - (x3 - x1) * (y2 - y1);
	public static long ccw(long[] p1, long[] p2, long[] p3) {
		return (p2[0] - p1[0]) * (p3[1] - p1[1]) - (p3[0] - p1[0]) * (p2[1] - p1[1]);
	}

	public static boolean isPointInLine(long[] point, long[] l1, long[] l2) {
		long a = l2[1] - l1[1];
		long b = l1[0] - l2[0];
		long c = l2[0] * l1[1] - l1[0] * l2[1];
		return a * point[0] + b * point[1] + c == 0 &&
			point[0] >= Math.min(l1[0], l2[0]) &&
			point[0] <= Math.max(l1[0], l2[0]) &&
			point[1] >= Math.min(l1[1], l2[1]) &&
			point[1] <= Math.max(l1[1], l2[1]);

	}

}

