import java.io.*;

public class Main {
    static int N;
    static char[][] board;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine().trim());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j);
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                
                // 오른쪽 교환
                if (j + 1 < N) {
                    swap(i, j, i, j + 1);
                    result = Math.max(result, check());
                    swap(i, j, i, j + 1); 
                }

                // 아래 교환
                if (i + 1 < N) {
                    swap(i, j, i + 1, j);
                    result = Math.max(result, check());
                    swap(i, j, i + 1, j);
                }
            }
        }

        System.out.println(result);
    }

    private static void swap(int x1, int y1, int x2, int y2) {
        char tmp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = tmp;
    }

    // 가장 긴 부분 check
    private static int check() {
        int max = 1;

        for (int i = 0; i < N; i++) {
            int count = 1;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == board[i][j - 1]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }
        for (int j = 0; j < N; j++) {
            int count = 1;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == board[i - 1][j]) {
                    count++;
                } else {
                    count = 1;
                }
                max = Math.max(max, count);
            }
        }

        return max;
    }
}
