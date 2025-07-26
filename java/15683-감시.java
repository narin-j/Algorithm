import java.io.*;
import java.util.*;

public class cctv {
    static int N, M;
    static int[][] office;
    static List<int[]> cctvs = new ArrayList<>(); // x, y, dir
    static int hidden = Integer.MAX_VALUE;

    static int[] dx = { 0, 1, 0, -1 };
    static int[] dy = { 1, 0, -1, 0 };

    static int[][][] dirs = {
            {},
            { { 0 }, { 1 }, { 2 }, { 3 } }, // 1
            { { 0, 2 }, { 1, 3 } }, // 2
            { { 0, 3 }, { 3, 2 }, { 2, 1 }, { 1, 0 } }, // 3
            { { 0, 1, 3 }, { 1, 2, 0 }, { 2, 3, 1 }, { 3, 0, 2 } }, // 4
            { { 0, 1, 2, 3 } } // 5
    };

    static int cntHidden(int[][] map) {
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j < M; j++)
                if (map[i][j] == 0)
                    cnt++;
        return cnt;
    }

    static int[][] copyMap(int[][] map) {
        int[][] newMap = new int[N][M];
        for (int i = 0; i < N; i++)
            newMap[i] = map[i].clone();
        return newMap;
    }

    static void dfs(int idx, int[][] map) {
        if (idx == cctvs.size()) {
            hidden = Math.min(hidden, cntHidden(map));
            return;
        }

        int[] c = cctvs.get(idx);
        int x = c[0], y = c[1], type = c[2];

        for (int[] dset : dirs[type]) {
            int[][] copy = copyMap(map);
            for (int d : dset) {
                watch(copy, x, y, d);
            }
            dfs(idx + 1, copy);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        office = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                office[i][j] = Integer.parseInt(st.nextToken());
                // cctv
                if (office[i][j] >= 1 && office[i][j] <= 5) {
                    cctvs.add(new int[] { i, j, office[i][j] });
                }
            }
        }

        dfs(0, office);
        System.out.println(hidden);
    }

    static void watch(int[][] map, int x, int y, int d) {
        int nx = x, ny = y;
        while (true) {
            nx += dx[d];
            ny += dy[d];
            if (nx < 0 || ny < 0 || nx >= N || ny >= M)
                break;
            if (map[nx][ny] == 6)
                break;
            if (map[nx][ny] == 0)
                map[nx][ny] = -1; 
        }
    }

}