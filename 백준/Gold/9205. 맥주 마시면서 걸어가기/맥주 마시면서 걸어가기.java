import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] map;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine()); 

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            map = new int[n + 2][2];
            visited = new boolean[n + 2];

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                map[i][0] = Integer.parseInt(st.nextToken());
                map[i][1] = Integer.parseInt(st.nextToken());
            }

            System.out.println(bfs() ? "happy" : "sad");
        }
    }

    static boolean bfs() {
        Queue<Integer> q = new LinkedList<>();
        // 출발
        q.offer(0);
        visited[0] = true;

        while (!q.isEmpty()) {
            int cur = q.poll();

            if (cur == n + 1) {
                return true;
            }

            for (int i = 0; i < n + 2; i++) {
                if (!visited[i] && calc(map[cur], map[i])) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }

        return false;
    }

    static boolean calc(int[] from, int[] to) {
        int dist = Math.abs(from[0] - to[0]) + Math.abs(from[1] - to[1]);
        return dist <= 1000;
    }
}
