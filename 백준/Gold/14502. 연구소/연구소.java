import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int ans = 0;
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int wall){
        // 3개 다 세움 
        if(wall == 3){
            check();
            return;
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(wall + 1);
                    map[i][j]=0;
                }
            }
        }
    }

    static void check(){

        boolean[][] visited = new boolean[N][M];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 2){
                    // 바이러스 위치
                    q.add(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                    // 바이러스 퍼뜨림
                    if (map[nx][ny] == 0 && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        q.add(new int[]{nx, ny});
                    }
                }
            }
        }

        int safe = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    safe++;
                }
            }
        }

        ans = Math.max(ans, safe);
    }
    
}

