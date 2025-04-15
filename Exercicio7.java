public class Exercicio7 {
    static int its = 0;
    static int I = 0;
    static int R = 0;
    static int S = 0;
    static int M = 0;
    static int distEdProgDina(String a, String b) {
        int m = a.length()+1;
        int n = b.length()+1;
        int[][] matrix = new int[m][n];
        for (int i = 1; i < m; i++) {
            matrix[i][0] = matrix[i-1][0]+1;
            its++;
            I++;
        }
        for (int j = 1; j < n; j++) {
            matrix[0][j] = matrix[0][j-1]+1;
            R++;
            its++;
        }
        for (int i = 1; i < m; i++) {
            its++;
            for (int j = 1; j < n; j++) {
                int custoExtra;
                if (a.charAt(i-1) == b.charAt(j-1)) {
                    custoExtra = 0;
                    M++;
                } else {
                    custoExtra = 1;
                    S++;
                }
                matrix[i][j] = Math.min(matrix[i-1][j-1]+custoExtra, Math.min(matrix[i-1][j]+1, matrix[i][j-1]+1));
                its++;
            }
        }
        return matrix[m-1][n-1];
    }

    public static void main(String[] args) {
        String a = "Casablanca";
        String b = "Portentoso";
        System.out.printf("%d %d\n", distEdProgDina(a, b), its);
    }
}
