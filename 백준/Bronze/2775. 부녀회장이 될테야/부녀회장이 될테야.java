import java.io.*;
import java.util.StringTokenizer;

public class Main {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++) {

            int k = Integer.parseInt(br.readLine()); // 층
            int n = Integer.parseInt(br.readLine()); // 호

            int[][] apt = new int[k + 1][n + 1];

            // 0층 초기화
            for (int i = 1; i <= n; i++) {
                apt[0][i] = i;
            }

            // 각 층 1호는 1명
            for (int i = 0; i <= k; i++) {
                apt[i][1] = 1;
            }

            // 점화식으로 채우기
            for (int i = 1; i <= k; i++) {
                for (int j = 2; j <= n; j++) {
                    apt[i][j] = apt[i - 1][j] + apt[i][j - 1];
                }
            }

            // 출력
            System.out.println(apt[k][n]);
        }
    }
}

