import java.io.*;
import java.util.*;

public class Main {
    static int[][] arr;
    // 종이개수
    static int[] count = new int[3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        arr = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        cutting(0, 0, N);

        System.out.println(count[0]); // -1
        System.out.println(count[1]); // 0
        System.out.println(count[2]); // 1
    }

    static void cutting(int x, int y, int size) {
        int type = arr[x][y];
        // 같으면 종이 개수 세고 return
        if (check(x, y, size, type)) {
            count[type + 1]++;
            return;
        }

        // 다르면 9등분
        // 분할정복
        int ns = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cutting(x + i * ns, y + j * ns, ns);
            }
        }
    }

    static boolean check(int x, int y, int size, int type) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != type) {
                    return false;
                }
            }
        }
        return true;
    }
}
