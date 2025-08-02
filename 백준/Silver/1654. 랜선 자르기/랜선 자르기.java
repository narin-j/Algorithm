import java.io.*;
import java.util.*;

public class Main {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        int[] len = new int[K];

        int max = 0;
        for (int i = 0; i < K; i++) {
            len[i] = Integer.parseInt(br.readLine());
            if (len[i] > max) {
                max = len[i];
            }
        }

        long start = 1;
        long end = max;
        long ans = 0;

        while (start <= end) {
            long mid = (start + end) / 2;
            long cnt = 0;
            for (int i = 0; i < K; i++) {
                cnt += len[i] / mid;
            }

            if(cnt >= N){
                ans = mid;
                start = mid +1;
            }
            else{
                end = mid -1;
            }
        }

        System.out.println(ans);

    }

}