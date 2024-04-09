import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	static int n, m, T;
	static char[][] map;
	static int ans;
	static int[] dx = {-1, 0, 1, 0};
	static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws IOException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			 BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))
		) {
			T = Integer.parseInt(br.readLine());
			while (T-- > 0){
				StringTokenizer st = new StringTokenizer(br.readLine());
				n = Integer.parseInt(st.nextToken());
				m = Integer.parseInt(st.nextToken());
				map = new char[n][m];
				for (int i = 0; i < n; i++) {
					String str = br.readLine();
					for (int j = 0; j < m; j++) {
						map[i][j] = str.charAt(j);
					}
				}
				Map<Character, Integer> keyMap = new HashMap<>();
				String str = br.readLine();
				if (!str.equals("0")){
					for (int i = 0; i < str.length(); i++) {
						keyMap.put((char)(str.charAt(i) - 32), 0);
					}
				}
				ans = 0;
				solution(keyMap);
				bw.write(ans + "\n");
			}

		}

	}

	private static void solution(Map<Character, Integer> keyMap) {
		//find key
		int prevSize, newSize;
		do{
			prevSize = keyMap.size();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
						if (map[i][j] == '.')
							findKey(keyMap, i, j, new boolean[n][m]);
						else if ('a' <= map[i][j] && map[i][j] <= 'z'){
							findKey(keyMap, i, j, new boolean[n][m]);
						}else if ('A' <= map[i][j] && map[i][j] <= 'Z' && keyMap.containsKey(map[i][j])){
							findKey(keyMap, i, j, new boolean[n][m]);
						}else if (map[i][j] == '$'){
							ans++;
							findKey(keyMap, i, j, new boolean[n][m]);
						}
					}
				}
			}
			newSize = keyMap.size();
		}while (prevSize != newSize);

		boolean[][] ch = new boolean[n][m];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if ((i == 0 || i == n - 1 || j == 0 || j == m - 1) && !ch[i][j]) {
					if (map[i][j] == '.')
						searchDocs(keyMap, i, j, ch);
					else if (keyMap.containsKey(map[i][j]))
						searchDocs(keyMap, i, j, ch);
				}
			}
		}
	}

	private static void searchDocs(Map<Character, Integer> keyMap, int x, int y, boolean[][] ch) {
		ch[x][y] = true;
		if(map[x][y] == '$')
			ans++;
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < m && !ch[nx][ny]){
				if (map[nx][ny] != '*'){
					if ('A' <= map[nx][ny] && map[nx][ny] <= 'Z'){
						if (keyMap.containsKey(map[nx][ny]))
							searchDocs(keyMap, nx, ny, ch);
					}else
						searchDocs(keyMap, nx, ny, ch);
				}
			}
		}
	}

	private static void findKey(Map<Character, Integer> keyMap, int x, int y, boolean[][] ch) {
		ch[x][y] = true;
		if (('a' <= map[x][y] && map[x][y] <= 'z') && !keyMap.containsKey(map[x][y])){
			keyMap.put((char)(map[x][y] - 32), 0);
		}
		map[x][y] = '.';
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (0 <= nx && nx < n && 0 <= ny && ny < m && !ch[nx][ny]){
				// .이라면? 이동
				if (map[nx][ny] == '.' || ('a' <= map[nx][ny] && map[nx][ny] <= 'z')){
					findKey(keyMap, nx, ny, ch);
				}
				else if ('A' <= map[nx][ny] && map[nx][ny] <= 'Z' && keyMap.containsKey(map[nx][ny])){
					findKey(keyMap, nx, ny, ch);
				}else if (map[nx][ny] == '$'){
					ans++;
					findKey(keyMap, nx, ny, ch);
				}
			}
		}
	}

}