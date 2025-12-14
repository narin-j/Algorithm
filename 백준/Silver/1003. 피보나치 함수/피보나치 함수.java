import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            
            int[][] dp = new int[Math.max(n + 1, 2)][2];

            dp[0][0] = 1; 
            dp[0][1] = 0;

            dp[1][0] = 0;
            dp[1][1] = 1; 

            for (int i = 2; i <= n; i++) {
                dp[i][0] = dp[i - 1][0] + dp[i - 2][0];
                dp[i][1] = dp[i - 1][1] + dp[i - 2][1];
            }

            System.out.println(dp[n][0] + " " + dp[n][1]);
        }
    }
}
