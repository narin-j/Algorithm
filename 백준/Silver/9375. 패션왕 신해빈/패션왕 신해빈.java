import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            // 의상종류, 수
            Map<String, Integer> cnt = new HashMap<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                st.nextToken(); // 의상은 저장할 필요 x
                String type = st.nextToken(); // 종류
                // Map 매서드
                // key(type)를 보고 있으면 기존값+1 => sum, 없으면 1
                // ex: { headgear=2, eyewear=1 }
                cnt.merge(type, 1, Integer::sum);
            }

            // 조합 계산
            int ans = 1;
            for (int c : cnt.values()) {
                ans *= (c + 1); // 안 입는 경우
            }
            ans -= 1;

            // 출력효율
            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
