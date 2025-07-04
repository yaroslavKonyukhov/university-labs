public class Main {
    public static void main(String[] args) {
        MyHashMap<String, Integer> map = new MyHashMap<>();

        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);

        System.out.println(map);

        map.put("three", 333);
        System.out.println(map);

        System.out.println(map.contains("two"));
        int two = map.get("two");
        map.remove("two");
        System.out.println("Is there key for " + two + "? - " + map.contains("two"));

        System.out.println();
        System.out.println("HashSet");
        System.out.println();

        MyHashSet<Integer> set = new MyHashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(set);
        System.out.println(set.contains(2));
        set.remove(2);
        System.out.println(set);
        System.out.println(set.contains(2));

        System.out.println();
        System.out.println();

    }
}