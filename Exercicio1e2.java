public class Exercicio1e2 {

    // Contador de iterações para a versão recursiva
    private static int fiboRecContador = 0;
    private static int instruçõesfiboRec = 0;

    // FIBO-REC
    public static int fiboRec(int n) {
        fiboRecContador++; // Incrementa o contador a cada chamada
        if(n <= 1) {
            return n;
        } else {
            int a = fiboRec(n - 1); instruçõesfiboRec++;
            int b = fiboRec(n - 2); instruçõesfiboRec++;
            return (a + b);
        }
    }

    // Contador de iterações para a versão iterativa
    private static int iterativoContador = 0;
    private static int instruçõesfibo = 0;

    // FIBO
    public static int fibo(int n) {
        iterativoContador = 0; // Reseta o contador
        if(n == 0) {
            return 0;
        }
        if(n == 1) {
            return 1;
        }

        int[] f = new int[n + 1]; instruçõesfibo++;
        f[0] = 0; instruçõesfibo++;
        f[1] = 1; instruçõesfibo++;
        iterativoContador++; // Conta a inicialização
        for(int i = 2; i <= n; i++) {
            f[i] = f[i - 1] + f[i - 2]; instruçõesfibo++;
            iterativoContador++; // Conta cada iteração do loop
        }
        return f[n];
    }

    // Contador de iterações para a versão com memoização
    private static int memoizacaoContador = 0;
    private static int instruçõesmemoizedFibo = 0;

    // MEMOIZED FIBO
    public static int memoizedFibo(int n) {
        memoizacaoContador = 0; // Reseta o contador
        int[] f = new int[n + 1]; instruçõesmemoizedFibo++;
        for(int i = 0; i <= n; i++) {
            f[i] = -1; instruçõesmemoizedFibo++;
        }
        return lookupFibo(f, n);
    }

    // LOOKUPFIBO
    public static int lookupFibo(int[] f, int n) {
        memoizacaoContador++; // Conta cada chamada
        if(f[n] >= 0) {
            return f[n];
        }
        if(n <= 1) {
            f[n] = n; instruçõesmemoizedFibo++;
        } else {
            f[n] = lookupFibo(f, n - 1) + lookupFibo(f, n - 2); instruçõesmemoizedFibo++;
        }
        return f[n];
    }

    // Métodos para obter as iterações
    public static int getfiboRecContador() {
        return fiboRecContador;
    }

    public static int getIterativoContador() {
        return iterativoContador;
    }

    public static int getMemoizacaoContador() {
        return memoizacaoContador;
    }


    public static void main(String[] args) {
        int[] testValues = {4, 8, 16, 32};

        for(int n : testValues) {
            System.out.println("-----------------------------------------------------------");
            System.out.println("n = " + n);

            //FiboRec
            long startTime = System.nanoTime();
            int resultFiboRec = fiboRec(n);
            long endTime = System.nanoTime();
            long totalTime = endTime - startTime;
            System.out.println(" FIBO-REC: Valor = " + resultFiboRec + " Iteracoes= " + getfiboRecContador() + " Tempo = " + totalTime);
            
            //Fibo
            long startTime2 = System.nanoTime();
            int resultFibo = fibo(n);
            long endTime2 = System.nanoTime();
            long totalTime2 = endTime2 - startTime2;
            System.out.println(" FIBO: Valor = " + resultFibo + " Iteracoes= " + getIterativoContador() + " Tempo = " + totalTime2);
            
            //MemoizedFibo
            long startTime3 = System.nanoTime();
            int resultMemoFibo = memoizedFibo(n);
            long endTime3 = System.nanoTime();
            long totalTime3 = endTime3 - startTime3;
            System.out.println(" MEMOIZED-FIBO: Valor = " + resultMemoFibo + " Iteracoes= " + getMemoizacaoContador() + " Tempo = " + totalTime3);
            
            System.out.println();
        }

        // int[] testValuesMax = {128, 1000, 10000};
        // for(int n : testValuesMax) {
        //     System.out.println("-----------------------------------------------------------");
        //     System.out.println("n = " + n);

        //     //Fibo
        //     long startTimeFibo = System.nanoTime();
        //     int resultFibo = fibo(n);
        //     long endTimeFibo = System.nanoTime();
        //     long totalTimeFibo = endTimeFibo - startTimeFibo;
        //     System.out.println(" FIBO: Valor = " + resultFibo + " Iteracoes= " + getIterativoContador() + " Tempo = " + totalTimeFibo);
            
        //     //MemoizedFibo
        //     long startTimeMemo = System.nanoTime();
        //     int resultMemoFibo = memoizedFibo(n);
        //     long endTimeMemo = System.nanoTime();
        //     long totalTimeMemo = endTimeMemo - startTimeMemo;
        //     System.out.println(" MEMOIZED-FIBO: Valor = " + resultMemoFibo + " Iteracoes= " + getMemoizacaoContador() + " Tempo = " + totalTimeMemo);
        // }
    }
}