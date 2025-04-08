



public class Exercicio4 {

    static class Item {
        public int peso;
        public int valor;
        public Item(int peso, int valor) {
            this.peso = peso;
            this.valor = valor;
        }
    }

    static int its;

    static int backPackPD(int n, int c, Item[] itens) {
        int[][] maxTab = new int[n+1][c+1];
        /*for (int i = 0; i <= n; i++) {
            maxTab[i][0] = 0;
        }*/
        for (int i = 0; i <= c; i++) {
            maxTab[0][i] = 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < c; j++) {
                if (itens[i].peso <= j) {
                    maxTab[i][j] = Math.max(maxTab[i-1][j], itens[i].valor + maxTab[i-i][j-itens[i].peso]);
                } else {
                    maxTab[i][j] = maxTab[i-1][j];
                }
                its++;
            }
        }
        return maxTab[n][c];
    }

    public static void main(String[] args) {
        its = 0;
        Item[] itens = new Item[10];
        itens[0] = new Item(23,92);
        itens[1] = new Item(31,57);
        itens[2] = new Item(29,49);
        itens[3] = new Item(44,68);
        itens[4] = new Item(53,60);
        itens[5] = new Item(38,43);
        itens[6] = new Item(63,67);
        itens[7] = new Item(85,84);
        itens[8] = new Item(89,87);
        itens[9] = new Item(82,72);
        long begin = System.nanoTime();
        System.out.println(backPackPD(10, 165, itens));
        long end = System.nanoTime();
        System.out.println(its);
        System.out.println(end-begin);

        System.out.println();

        its = 0;
        itens = new Item[6];
        itens[0] = new Item(56,50);
        itens[1] = new Item(59,50);
        itens[2] = new Item(80,64);
        itens[3] = new Item(64,46);
        itens[4] = new Item(75,50);
        itens[5] = new Item(17,5);
        begin = System.nanoTime();
        System.out.println(backPackPD(6, 190, itens));
        end = System.nanoTime();
        System.out.println(its);
        System.out.println(end-begin);
    }
}