import java.io.*;
import java.util.*;

// 우선순위 큐
public class Main {
    static class Task {
        int d, w;

        Task(int d, int w) {
            this.d = d; // 마감일까지 남은 일수
            this.w = w; // 과제 점수
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        Task[] arr = new Task[N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            arr[i] = new Task(d, w);
        }

        // 1) 마감일 오름차순 정렬
        // 2) 지금까지 선택한 과제들의 점수를 담는 최소힙
        // 선택된 과제들의 점수 합 (힙 변동과 함께 갱신)
        // 3) 과제들을 마감일 순서로 훑으며 선택/제거

        
        Arrays.sort(arr, (a, b) -> a.d - b.d);

        PriorityQueue<Integer> mh = new PriorityQueue<>();

        long sum = 0;

        for (Task t : arr) {
            mh.offer(t.w);
            sum += t.w;
            if (mh.size() > t.d) {
                sum -= mh.poll(); // 최소 점수 제거
            }
        }

        System.out.println(sum);
    }
}