package week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class homework2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        double no_match_prob = 1;
        for (int i = 1; i <= n-1; i++) {
            no_match_prob *= (double) (365 - i) / 365;
        }
        double match_prob = 1 - no_match_prob;

        System.out.println(match_prob * 100 + "%");
    }
}
