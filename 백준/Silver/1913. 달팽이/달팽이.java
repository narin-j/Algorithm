import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
        int M = Integer.parseInt(br.readLine().trim());

        int[] dx = { -1, 0, 1, 0 }; // 위, 오, 아, 왼
        int[] dy = { 0, 1, 0, -1 };

        int[][] dalpeng = new int[N][N];

        int curX = (N / 2) + 1;
        int curY = (N / 2) + 1;

        dalpeng[curX - 1][curY - 1] = 1;

        int ansX = curX;
        int ansY = curY;
        if (M == 1) {
            ansX = curX;
            ansY = curY;
        }

        int dir = 0;
        int move = 1;

        int cur = 1; // 현재 움직일 칸 수
        outer: while (cur < N * N) {
            for (int c = 0; c < 2; c++) {
                for (int m = 0; m < move; m++) {
                    if (cur == N * N)
                        break outer;
                    curX += dx[dir];
                    curY += dy[dir];
                    cur++;
                    dalpeng[curX - 1][curY - 1] = cur;

                    if (cur == M) {
                        ansX = curX;
                        ansY = curY;
                    }
                }
                dir = (dir + 1) % 4;
            }
            move++;
        }

        
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(dalpeng[i][j]);
                if (j < N - 1)
                    sb.append(' ');
            }
            sb.append('\n');
        }
        sb.append(ansX).append(' ').append(ansY).append('\n');
        System.out.print(sb.toString());
    }
}
