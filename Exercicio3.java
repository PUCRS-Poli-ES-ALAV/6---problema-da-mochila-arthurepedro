import java.util.*;

public class Exercicio3 {
    static List<Item> mochila(List<Item> opt, int cap) {
        List<Item> result = new ArrayList<>();
        Queue<Item> items = new PriorityQueue<>((i, j) -> ((Float)(j.value/j.weight)).compareTo(i.value/i.weight));

        items.addAll(opt);
        while (result.stream().mapToDouble(i -> i.weight).sum() <= cap) {
            result.add(items.remove());
        }

        return result;
    }

    public static void main(String[] args) {
        /*System.out.println(mochila(Arrays.asList(
            new Item(92, 23),
            new Item(57, 31),
            new Item(49, 29),
            new Item(68, 44),
            new Item(60, 53),
            new Item(43, 38),
            new Item(67, 63),
            new Item(84, 85),
            new Item(87, 89),
            new Item(72, 82))
            ,165)));*/
        System.out.println(mochila(Arrays.asList(
            new Item(50, 56),
            new Item(50, 59),
            new Item(64, 80),
            new Item(46, 64),
            new Item(50, 75),
            new Item(5, 17)
        ), 190));
    }
}

class Item {
    public float value;
    public float weight;
    public Item(float price, float weight) {
        this.value = price;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "(price=" + value + ",weight=" + weight + ")";
    }
}