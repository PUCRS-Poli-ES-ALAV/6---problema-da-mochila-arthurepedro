
import java.util.Arrays;
import java.util.Collections;

public class Exercicio6 {
    static long its;
    public static int ED(String s, String t, int i, int j) {
        its++;

        if (i == -1 && j != -1) {
            return j;
        } else if (j == -1 && i != -1) {
            return i;
        } else if (i == -1 && j == -1) {
            return 0;
        }

        if (s.charAt(i) == t.charAt(j)) {
            return ED(s, t, i-1, j-1);
        } else {
            int subs = ED(s, t, i-1, j-1)+1;
            int ins = ED(s, t, i, j-1)+1;
            int rem = ED(s, t, i-1, j)+1;
            return Collections.min(Arrays.asList(subs,ins,rem));
        }
    }

    public static void main(String[] args) {
        its = 0;
        String s1 = "Casablanca";
        String s2 = "Portentoso";
        System.out.println(ED(s1, s2, s1.length()-1, s2.length()-1));
        System.out.println(its);
    }
}