import java.util.*;

public class Exercicio3 {
    static List<Item> mochila(List<Item> opt) {
        List<Item> result = new ArrayList<>();
        Queue<Item> items = new PriorityQueue<>((i, j) -> ((Float)(j.price/j.weight)).compareTo(i.price/i.weight));

        items.addAll(opt);
        while (result.stream().mapToDouble(i -> i.weight).sum() < 5) {
            result.add(items.remove());
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(mochila(Arrays.asList(new Item(4,12), new Item(2,1), new Item(10,4), new Item(1,1), new Item(2,2))));
    }
}

class Item {
    public float price;
    public float weight;
    public Item(float price, float weight) {
        this.price = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(price=" + price + ",weight=" + weight + ")";
    }
}