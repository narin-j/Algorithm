import java.util.Scanner;

public class mg {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        int n = s.length();

        int a_cnt = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'a') {
                a_cnt++;
            }
        }

        String dbs = s + s; // 원형 처리 위해 2배로

        // 초기 윈도우에서 b 개수 세기
        int b_cnt = 0;
        for (int i = 0; i < a_cnt; i++) {
            if (dbs.charAt(i) == 'b') {
                b_cnt++;
            }
        }

        int min = b_cnt;

        // 슬라이딩 윈도우 시작
        for (int i = 1; i <= n; i++) {
            // 앞 문자 빠짐
            if (dbs.charAt(i - 1) == 'b')
                b_cnt--;
            // 새로 들어오는 문자 추가
            if (dbs.charAt(i + a_cnt - 1) == 'b')
                b_cnt++;

            min = Math.min(min, b_cnt);
        }

        System.out.println(min);
        sc.close();
    }
}
