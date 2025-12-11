import java.io.*;

public class Main {
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[12]; // 문제 조건 < 11

        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for(int i=4; i<=11; i++){
            dp[i] = dp[i-1]+dp[i-2]+dp[i-3]; // ex. 5를 만들기 위해서는 2+3, 3+2, 4+1
        }

        StringBuilder sb = new StringBuilder();
        while(T-- >0){
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append("\n");
        }
        
        System.out.println(sb.toString());
    }
}

