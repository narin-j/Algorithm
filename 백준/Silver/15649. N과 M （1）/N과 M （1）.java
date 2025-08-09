import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[] arr;
    static boolean[] isused;

    // I/O 시스템호출(System.out.println)보다 효율적
    static StringBuilder sb = new StringBuilder();

    
    static void dfs(int cnt) {
        if (cnt == M) {
            for (int i = 0; i < M; i++) {
                sb.append(arr[i]).append(' ');
            }
            sb.append('\n');
            return; 
        }
        for (int i = 1; i <= N; i++) { 
            if (!isused[i]) {
                arr[cnt] = i;
                isused[i] = true;
                dfs(cnt + 1);
                isused[i] = false; 
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[M];
        isused = new boolean[N + 1];

        dfs(0);
        System.out.print(sb.toString());
    }
}
