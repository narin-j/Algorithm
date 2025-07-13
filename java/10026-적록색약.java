import java.util.Scanner;

public class grsy {
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void dfs(int x, int y, char color, char[][] grid, int[][] visited, int N) {
        visited[x][y] = 1;

        int[] dx = { -1, 1, 0, 0 };
        int[] dy = { 0, 0, -1, 1 };

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (visited[nx][ny] == 0 && grid[nx][ny] == color) {
                    dfs(nx, ny, color, grid, visited, N);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = Integer.parseInt(sc.nextLine()); // N x N
        char[][] grid = new char[N][N];
        int[][] visited = new int[N][N];

        char[][] grid_rg = new char[N][N];
        int[][] visited_rg = new int[N][N];

        // N줄 입력 받기
        for (int i = 0; i < N; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < N; j++) {
                char c = line.charAt(j);
                grid[i][j] = c;
                grid_rg[i][j] = (c == 'G') ? 'R' : c;
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j] == 0) {
                    dfs(i, j, grid[i][j], grid, visited, N);
                    count++;
                }
            }
        }

        int count_rg = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (visited_rg[i][j] == 0) {
                    dfs(i, j, grid_rg[i][j], grid_rg, visited_rg, N);
                    count_rg++;
                }
            }
        }

        System.out.println(count + " " + count_rg);

        sc.close();
    }
}
