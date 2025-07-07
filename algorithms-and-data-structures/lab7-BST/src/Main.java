public class Main {
    public static void main(String[] args) {
        MyBST<Integer> tree = new MyBST<>();
        tree.add(5);
        tree.add(6);
        tree.add(5);
        tree.add(10);
        tree.add(2);
        tree.add(1);
        tree.add(3);

        System.out.println(tree);
        System.out.println(tree.contains(3));
        tree.remove(3);
        System.out.println(tree);
        System.out.println(tree.contains(3));
    }
}