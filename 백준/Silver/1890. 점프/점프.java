import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int[][] board = new int[N][N];

        for (int y = 0; y < N; y++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int x = 0; x < N; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        long[][] dp = new long[N][N];
        dp[0][0] = 1;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (dp[y][x] == 0) {
                    continue;
                }
                if (x == N - 1 && y == N - 1) {
                    continue;
                }

                int k = board[y][x]; // 점프 칸 수
                if (k == 0) {
                    continue;
                }
                
                // 점프
                int nx = x + k;
                int ny = y + k;

                // 누적 수 더하기 
                if (nx < N) {
                    dp[y][nx] += dp[y][x]; 
                }
                if (ny < N) {
                    dp[ny][x] += dp[y][x];
                }
            }
        }

        System.out.println(dp[N - 1][N - 1]);
    }
}
