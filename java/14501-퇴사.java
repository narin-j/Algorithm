import java.util.Scanner;

public class ts {
    public static void main(String args[]) {
        // 시간, 메모리의 효율을 높일 수 있음
        // BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // StringTokenizer st = new StringTokenizer(br.readLine());
        // String s = st.nextToken();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] T = new int[N + 1]; // 상담
        int[] P = new int[N + 1]; // 페이
        int[] dp = new int[N + 2]; // dp

        for (int i = 1; i <= N; i++) {
            T[i] = sc.nextInt();
            P[i] = sc.nextInt();
        }

        for (int i = N; i >= 1; i--) {
            int endDay = i + T[i];
            if (endDay <= N + 1) {
                dp[i] = Math.max(P[i] + dp[endDay], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }

        }

        System.out.println(dp[1]);

        sc.close();

    }
}