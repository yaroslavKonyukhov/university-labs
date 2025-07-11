public class Main {
    public static void main(String[] args) {
        MyRBT<Integer> tree = new MyRBT<>();

        for(int i = 0; i < 26; i++)
            tree.add(i);

        tree.remove(16);
        System.out.println(tree);

        System.out.println();

        MyTreeMap<Integer, String> treeMap = new MyTreeMap<>();

        for(int i = 0; i < 26; i++)
            treeMap.add(i, "i" + i);


        System.out.println(treeMap.contains(16));
        System.out.println(treeMap.get(16));
        treeMap.remove(16);
        System.out.println(treeMap);
        System.out.println(treeMap.contains(16));

        treeMap.add(17, "Edited");

        System.out.println(treeMap);
        System.out.println();


        MyTreeSet<Integer> treeSet= new MyTreeSet<>();

        for(int i = 0; i < 26; i++)
            treeSet.add(i);

        System.out.println(treeSet.contains(16));
        treeSet.remove(16);
        System.out.println(treeSet);
        System.out.println(treeSet.contains(16));
    }
}