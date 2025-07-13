import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] meet = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            meet[i][0] = Integer.parseInt(st.nextToken());
            meet[i][1] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(meet, (a, b)->{
            if(a[1] == b[1]) return a[0]-b[0];
            return a[1]-b[1];
        });

        int cnt = 0;
        int end = 0;
        for(int i=0; i<n; i++){
            if(meet[i][0] >= end){
                cnt ++;
                end = meet[i][1];
            }
        }
        System.out.println(cnt);
    }
}
