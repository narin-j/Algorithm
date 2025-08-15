import java.io.*;
import java.util.*;

public class Main {

    static int L, C;
    static StringBuilder sb = new StringBuilder();
    static char[] letters; // 입력 문자 C개
    static char[] arr; // 선택된 문자 L개

    static boolean aeiou(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }

    private static void dfs(int cnt, int start, int v, int c) {
        if (cnt == L) {
            if (v >= 1 && c >= 2) {
                for (int i = 0; i < L; i++) {
                    sb.append(arr[i]);
                }
                sb.append('\n');
            }
            return;
        }

        for (int i = start; i < C; i++) {
            arr[cnt] = letters[i];
            if (aeiou(letters[i])) {
                dfs(cnt + 1, i + 1, v + 1, c);
            } else {
                dfs(cnt + 1, i + 1, v, c + 1);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        letters = new char[C];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < C; i++) {
            letters[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(letters);
        arr = new char[L];

        dfs(0, 0, 0, 0);
        System.out.print(sb.toString());
    }
}
