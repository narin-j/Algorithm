import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class stk {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[][] stk = new int[2][100001];
        int[][] dp = new int[3][100001];

        int N;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());

            // 스티커 입력받기
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                stk[0][j] = Integer.parseInt(s[j]);
            }
            s = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                stk[1][j] = Integer.parseInt(s[j]);
            }

            dp[0][0] = stk[0][0]; // 1 선택
            dp[1][0] = stk[1][0]; // 2 선택
            dp[2][0] = 0; // 선택x

            for (int k = 1; k < N; k++) {
                dp[0][k] = stk[0][k] + Math.max(dp[1][k - 1], dp[2][k - 1]); // 이전에 2선택, 선택x
                dp[1][k] = stk[1][k] + Math.max(dp[0][k - 1], dp[2][k - 1]); // 이전에 1선택, 선택x
                dp[2][k] = Math.max(dp[0][k - 1], dp[1][k - 1]); // 1선택, 2선택
            }

            System.out.println(Math.max(Math.max(dp[0][N - 1], dp[1][N - 1]), dp[2][N - 1]));

        }

    }
}
