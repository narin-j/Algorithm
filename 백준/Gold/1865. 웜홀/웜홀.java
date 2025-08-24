import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, w;

        Edge(int f, int t, int w) {
            this.from = f;
            this.to = t;
            this.w = w;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine().trim());

        while (TC-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken()); // 지점수
            int M = Integer.parseInt(st.nextToken()); // 도로
            int W = Integer.parseInt(st.nextToken()); // 웜홀

            int totalEg = 2 * M + W;

            // 간선
            List<Edge> edges = new ArrayList<>(totalEg);
            
            int s, e, t;
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, t)); // from, to, w
                edges.add(new Edge(e, s, t));
            }

            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                e = Integer.parseInt(st.nextToken());
                t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, -t));
            }

            boolean cycle = ifTimeBackCycle(N, edges);
            sb.append(cycle ? "YES" : "NO").append('\n');
        }

        System.out.print(sb.toString());
    }

    
    static boolean ifTimeBackCycle(int N, List<Edge> edges) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, 0);

        for (int i = 1; i <= N - 1; i++) {
            boolean updated = false;
            for (Edge e : edges) {
                if (dist[e.to] > dist[e.from] + e.w) {
                    dist[e.to] = dist[e.from] + e.w;
                    updated = true;
                }
            }
            if (!updated)
                break;
        }

        for (Edge e : edges) {
            if (dist[e.to] > dist[e.from] + e.w)
                return true;
        }
        return false;
    }
}
