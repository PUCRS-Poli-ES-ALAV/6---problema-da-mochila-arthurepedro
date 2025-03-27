public class Exercicio1 {
    // FIBO-REC
    public static int fiboRec(int n) {
        if(n <= 1) {
            return n;
        } else {
            int a = fiboRec(n - 1);
            int b = fiboRec(n - 2);
            return (a + b);
        }
    }

    // FIBO
    public static int fibo(int n) {
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        int[] f = new int[n + 1];
        f[0] = 0;
        f[1] = 1;
        for(int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f[n];
    }

    // MEMOIZED FIBO
    public static int memoizedFibo(int n) {
        int[] f = new int[n + 1];
        for(int i = 0; i <= n; i++) {
            f[i] = -1;
        }
        return lookupFibo(f, n);
    }

    // LOOKUPFIBO
    public static int lookupFibo(int[] f, int n) {
        if(f[n] >= 0) {
            return f[n];
        }
        if(n <= 1) {
            f[n] = n;
        } else {
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2);
        }
        return f[n];
    }


    public static void main(String[] args) {
        int[] testValues = {4, 8, 16, 32};

        for(int n : testValues) {
            System.out.println("n = " + n);
            int resultFiboRec = fiboRec(n);
            int resultFibo = fibo(n);
            int resultMemoFibo = memoizedFibo(n);
            System.out.println(" FIBO-REC: " + resultFiboRec);
            System.out.println(" FIBO: " + resultFibo);
            System.out.println(" MEMOIZED-FIBO: " + resultMemoFibo);
            System.out.println();
        }
    }
}