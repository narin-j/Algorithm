import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;

    static int[] A;
    static int[] op = new int[4];

    static void dfs(int result, int cur) {
        if (cur == N) {
            max = Math.max(max, result);
            min = Math.min(min, result);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (op[i] > 0) {
                op[i]--;
                int next = A[cur];
                int nextResult = result;

                if (i == 0)
                    nextResult += next;
                else if (i == 1)
                    nextResult -= next;
                else if (i == 2)
                    nextResult *= next;
                else
                    nextResult = (nextResult < 0) ? -(-nextResult / next) : nextResult / next;

                dfs(nextResult, cur + 1);
                op[i]++;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }

        dfs(A[0], 1);

        System.out.println(max);
        System.out.println(min);
    }
}
