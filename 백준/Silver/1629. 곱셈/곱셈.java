import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());

        // 계산할 필요x
        if (c == 1) {
            System.out.println(0);
            return;
        }

        a %= c; // 값 줄여놓고 시작
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % c;
            }
            a = (a * a) % c;
            b >>= 1;
        }
        System.out.println(res);
    }
}