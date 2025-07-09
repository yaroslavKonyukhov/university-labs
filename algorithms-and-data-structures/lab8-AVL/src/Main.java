public class Main {
    public static void main(String[] args) {

        MyAVL<Integer> tree = new MyAVL<>();

        for(int i = 1; i < 8; i++)
        {
            tree.add(i);
        }

        System.out.println(tree);

        tree.add(8);
        tree.remove(4);
        System.out.println(tree);
    }
}