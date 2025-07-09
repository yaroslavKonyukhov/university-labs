public class MyAVL<T extends Comparable<T>> {

    private class Node {
        T data;
        Node left, right;
        int height;

        public Node(T data) {
            this.data = data;
            left = right = null;
            height = 1;
        }
    }

    private Node root;

    public MyAVL() {
        root = null;
    }

    private int height(Node node)
    {
        if(node == null)
            return 0;
        return node.height;
    }

    private int getBalanceFactor(Node node)
    {
        if(node == null)
            return 0;
        return height(node.left) - height(node.right);
    }

    private Node rightRotation(Node node)
    {
        Node y = node.left;
        Node b = y.right;

        y.right = node;
        node.left = b;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    private Node leftRotation(Node node)
    {
        Node y = node.right;
        Node b = y.left;

        y.left = node;
        node.right = b;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        y.height = 1 + Math.max(height(y.left), height(y.right));

        return y;
    }

    public Node insert(T data, Node node)
    {
        if(node == null)
            return new Node(data);

        if(data.compareTo(node.data) < 0) {
            node.left = insert(data, node.left);
        }else if(data.compareTo(node.data) > 0) {
            node.right = insert(data, node.right);
        }else {
            return node;
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bf = getBalanceFactor(node);

        if(bf > 1 && data.compareTo(node.left.data) < 0)
            return rightRotation(node);
        if(bf < -1 && data.compareTo(node.right.data) > 0)
            return leftRotation(node);
        if(bf > 1 && data.compareTo(node.left.data) > 0)
        {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }
        if(bf < -1 && data.compareTo(node.right.data) < 0)
        {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        return node;
    }

    public void add(T data)
    {
        root = insert(data, root);
    }

    private void preorder(Node node)
    {
        if(node == null)
            return;

        System.out.println(node.data);
        preorder(node.left);
        preorder(node.right);
    }

    private void inorder(Node node)
    {
        if(node == null)
            return;

        inorder(node.left);
        System.out.println(node.data);
        inorder(node.right);
    }

    private void postorder(Node node)
    {
        if(node == null)
            return;

        postorder(node.left);
        postorder(node.right);
        System.out.println(node.data);
    }

    private boolean search(T data, Node node)
    {
        if(node == null)
            return false;

        if(data.compareTo(node.data) < 0)
            return search(data, node.left);
        if(data.compareTo(node.data) > 0)
            return search(data, node.right);

        return true;
    }

    public boolean contains(T data)
    {
        return search(data, root);
    }

    private T min(Node node)
    {
        while(node.left != null)
        {
            node = node.left;
        }

        return node.data;
    }


    private Node delete(T data, Node node)
    {
        if(node == null)
            return null;

        if(data.compareTo(node.data) < 0) {
            node.left = delete(data, node.left);
        }else if (data.compareTo(node.data) > 0) {
            node.right = delete(data, node.right);
        }else{
            if(node.left == null)
                return node.right;
            if(node.right == null)
                return node.left;

            node.data = min(node.right);
            node.right = delete(node.data, node.right);
        }

        node.height = 1 + Math.max(height(node.left), height(node.right));
        int bf = getBalanceFactor(node);

        if(bf > 1 && getBalanceFactor(node.left) >= 0)
            return rightRotation(node);
        if(bf < -1 && getBalanceFactor(node.right) <= 0)
            return leftRotation(node);
        if(bf > 1 && getBalanceFactor(node.left) < 0)
        {
            node.left = leftRotation(node.left);
            return rightRotation(node);
        }
        if(bf < -1 && getBalanceFactor(node.right) > 0)
        {
            node.right = rightRotation(node.right);
            return leftRotation(node);
        }

        return node;
    }

    public void remove(T data)
    {
        root = delete(data, root);
    }

    @Override
    public String toString() {
        preorder(root);
        return "";
    }
}

