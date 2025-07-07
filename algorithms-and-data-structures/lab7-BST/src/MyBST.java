public class MyBST<T extends Comparable<T>> {

    private class Node {
        T data;
        Node left, right;

        public Node(T data) {
            this.data = data;
            left = right = null;
        }
    }

    private Node root;

    public MyBST() {
        root = null;
    }

    public Node insert(T data, Node node)
    {
        if(node == null)
            return new Node(data);

        if(data.compareTo(node.data) < 0) {
            node.left = insert(data, node.left);
        }else if(data.compareTo(node.data) > 0) {
            node.right = insert(data, node.right);
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
