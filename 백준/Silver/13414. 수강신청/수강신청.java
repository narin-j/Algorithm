import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        LinkedHashSet<String> lh = new LinkedHashSet<>();

        String stuNo = "";
        for (int i = 0; i < L; i++) {
            stuNo = br.readLine();

            lh.remove(stuNo); // 이미 있으면 지움
            lh.add(stuNo);
        }

        // HashSet은 Set 계열이라 인덱스 개념 x
        int cnt = 0;
        for (String s : lh) {
            System.out.println(s);
            cnt++;
            if (cnt == K) {
                break;
            }
        }
    }
}
