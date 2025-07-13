import java.io.*;
import java.util.*;

public class Main {
    static int[] dice = new int[6];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); 
        int m = Integer.parseInt(st.nextToken()); 
        int x = Integer.parseInt(st.nextToken()); 
        int y = Integer.parseInt(st.nextToken()); 
        int k = Integer.parseInt(st.nextToken()); 

        int[][] map = new int[n][m];


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());

        int[] dx = {0, 0, 0, -1, 1};
        int[] dy = {0, 1, -1, 0, 0};

        for (int i = 0; i < k; i++) {
            int dir = Integer.parseInt(st.nextToken());

            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

            moveDice(dir);

            if (map[nx][ny] == 0) {
                map[nx][ny] = dice[1];
            } else {
                dice[1] = map[nx][ny];
                map[nx][ny] = 0;
            }

            System.out.println(dice[0]);

            x = nx;
            y = ny;
        }
    }

    static void moveDice(int dir) {
        int temp;
        if (dir == 1) { // 동쪽
            temp = dice[0];
            dice[0] = dice[4];
            dice[4] = dice[1];
            dice[1] = dice[5];
            dice[5] = temp;
        } else if (dir == 2) { // 서쪽
            temp = dice[0];
            dice[0] = dice[5];
            dice[5] = dice[1];
            dice[1] = dice[4];
            dice[4] = temp;
        } else if (dir == 3) { // 북쪽
            temp = dice[0];
            dice[0] = dice[3];
            dice[3] = dice[1];
            dice[1] = dice[2];
            dice[2] = temp;
        } else if (dir == 4) { // 남쪽
            temp = dice[0];
            dice[0] = dice[2];
            dice[2] = dice[1];
            dice[1] = dice[3];
            dice[3] = temp;
        }
    }
}
