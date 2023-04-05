package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class chap01_34_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        double i = n;
        int l1_complex = 0;
        int l2_complex;
        while (i >= 1) {
            System.out.println("loop1 : " + ++l1_complex);
            l2_complex = 0;
            double j = i;
            while (j <= n) {
                System.out.println("+--loop2 : " + ++l2_complex);
                j = 2 * j;
            }
            i = Math.floor(i / 2);
        }
    }
}
