import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class night {
    static int[][] dirs = {
            { -2, -1 }, { -1, -2 }, { 1, -2 }, { 2, -1 },
            { 2, 1 }, { 1, 2 }, { -1, 2 }, { -2, 1 }
    };

    private static int bfs(int l, int x, int y, int toX, int toY) {
        boolean[][] visited = new boolean[l][l];
        int[][] board = new int[l][l];

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { x, y }); // q.push
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll(); // q.pop()
            int curX = cur[0];
            int curY = cur[1];

            // 도착
            if(curX == toX && curY == toY){
                return board[curX][curY];
            }

            for(int[] dir: dirs){
                int nx = curX + dir[0];
                int ny = curY + dir[1];

                if(nx>=0 && nx <l && ny>=0 && ny<l && !visited[nx][ny]){
                    visited[nx][ny] = true;
                    board[nx][ny] = board[curX][curY]+1;
                    q.offer(new int[]{nx, ny});
                }
            }

        }
        return -1;

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for (int i = 0; i < T; i++) {
            int l = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int toX = Integer.parseInt(st.nextToken());
            int toY = Integer.parseInt(st.nextToken());

            System.out.println(bfs(l, x, y, toX, toY));

        }

    }
}
