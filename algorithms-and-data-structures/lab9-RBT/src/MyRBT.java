import java.util.ArrayList;
import java.util.List;

public class MyRBT<T extends Comparable<T>> {

    private class Node {
        T data;
        Node left, right, parent;
        char color;

        public Node(T data) {
            this.data = data;
            parent = left = right = null;
            color = 'R';
        }
    }

    private class Nil extends Node{
        public Nil() {
            super(null);
            this.color = 'B';
        }
    }

    private Node root;

    private boolean RR = false;

    private boolean L = false;
    private boolean R = false;
    private boolean RL = false;
    private boolean LR = false;

    public MyRBT() {
        root = null;
    }

    private Node rightRotation(Node node)
    {
        Node y = node.left;
        Node b = y.right;

        y.right = node;
        node.left = b;

        if(b != null)
            b.parent = node;

        node.parent = y;

        return y;
    }

    private Node leftRotation(Node node)
    {
        Node y = node.right;
        Node b = y.left;

        y.left = node;
        node.right = b;

        if(b != null)
            b.parent = node;

        node.parent = y;

        return y;
    }

    public Node insert(T data, Node node)
    {
        if(node == null)
            return new Node(data);

        if(data.compareTo(node.data) < 0) {
            node.left = insert(data, node.left);
            node.left.parent = node;

            if(node != root)
                if(node.color == 'R' && node.left.color == 'R')
                    RR = true;

        }else if(data.compareTo(node.data) > 0) {
            node.right = insert(data, node.right);
            node.right.parent = node;

            if(node != root)
                if(node.color == 'R' && node.right.color == 'R')
                    RR = true;

        }else {
            node.data = data; //To edit values with add method
            return node;
        }

        if(RR)
        {
            if(node == node.parent.right)
            {
                Node uncle = node.parent.left;

                if(uncle != null && uncle.color == 'R')
                {
                    node.color = 'B';
                    uncle.color = 'B';

                    if(node.parent != root)
                        node.parent.color = 'R';

                    RR = false;

                }else {

                    if(node.left != null && node.left.color == 'R')
                    {
                        RL = true;
                        RR = false;
                    }else {
                        L = true;
                        RR = false;
                    }
                    return node;
                }
            }
            else {
                Node uncle = node.parent.right;

                if(uncle != null && uncle.color == 'R')
                {
                    node.color = 'B';
                    uncle.color = 'B';

                    if(node.parent != root)
                        node.parent.color = 'R';

                    RR = false;

                }else {

                    if(node.right != null && node.right.color == 'R')
                    {
                        LR = true;
                        RR = false;
                    }else {
                        R = true;
                        RR = false;
                    }
                    return node;
                }
            }
        }

        if(L) {
            L = false;

            node.right.color = 'B';
            node.color = 'R';

            return leftRotation(node);
        }
        if(RL) {
            RL = false;
            node.right = rightRotation(node.right);
            node.right.parent = node;

            node.right.color = 'B';
            node.color = 'R';

            return leftRotation(node);
        }
        if(R) {
            R = false;

            node.left.color = 'B';
            node.color = 'R';

            return rightRotation(node);
        }
        if(LR) {
            LR = false;
            node.left = leftRotation(node.left);
            node.left.parent = node;

            node.left.color = 'B';
            node.color = 'R';

            return rightRotation(node);
        }

        return node;
    }

    public void add(T data)
    {
        if(root == null)
        {
            root = new Node(data);
            root.color = 'B';
            return;
        }

        root = insert(data, root);
        root.parent = null;
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

    private T search(T data, Node node)
    {
        if(node == null)
            return null;

        if(data.compareTo(node.data) < 0)
            return search(data, node.left);
        if(data.compareTo(node.data) > 0)
            return search(data, node.right);

        return node.data;
    }

    public boolean contains(T data)
    {
        return search(data, root) != null;
    }

    public T getElement(T data)
    {
        return search(data, root);
    }

    private Node min(Node node)
    {
        while(node.left != null)
        {
            node = node.left;
        }

        return node;
    }

    private void transplant(Node parent, Node u, Node v)
    {
        if(parent == null) {
            root = v;
        }else if(u == parent.left) {
            parent.left = v;
        }else {
            parent.right = v;
        }

        if(v != null)
            v.parent = parent;
    }

    public void remove(T data)
    {
        delete(data);
    }

    private void delete(T data)
    {
        Node node = root;

        while(node != null && data.compareTo(node.data) != 0)
        {
            if(data.compareTo(node.data) < 0) {
                node = node.left;
            }else {
                node = node.right;
            }
        }

        if(node == null)
            return;

        Node movedUp;
        char deletedNodeColor;

        if(node.left == null || node.right == null)
        {
            movedUp = deleteNodeWithZeroOrOneChild(node);
            deletedNodeColor = node.color;
        }else {
            Node inOrderSuccessor = min(node.right);

            node.data = inOrderSuccessor.data;

            movedUp = deleteNodeWithZeroOrOneChild(inOrderSuccessor);
            deletedNodeColor = inOrderSuccessor.color;
        }

        if(deletedNodeColor == 'B')
        {
            fixDelete(movedUp);

            if(movedUp.getClass() == Nil.class)
                transplant(movedUp.parent, movedUp, null);
        }
    }

    private Node deleteNodeWithZeroOrOneChild(Node node)
    {
        if(node.left != null) {
            transplant(node.parent, node, node.left);
            return node.left;
        }else if(node.right != null) {
            transplant(node.parent, node, node.right);
            return node.right;
        }else {
            Node newNode = node.color == 'B' ? new Nil() : null;
            transplant(node.parent, node, newNode);
            return newNode;
        }
    }

    private Node getSibling(Node node)
    {
        Node parent = node.parent;

        if(node == parent.left) {
            return parent.right;
        }else {
            return parent.left;
        }
    }

    private boolean isBlack(Node node)
    {
        return node == null || node.color == 'B';
    }

    private void handleRedSibling(Node node, Node sibling)
    {
        sibling.color = 'B';
        node.parent.color = 'R';

        Node grand = node.parent.parent;

        if(node == node.parent.left) {
            Node temp = leftRotation(node.parent);
            transplant(grand, node.parent, temp);
        }else {
            Node temp = rightRotation(node.parent);
            transplant(grand, node.parent, temp);
        }
    }

    private void handleBlackSiblingWithAtLeastOneRedChild(Node node, Node sibling)
    {
        boolean nodeIsLeftChild = node == node.parent.left;

        if(nodeIsLeftChild && isBlack(sibling.right))
        {
            sibling.left.color = 'B';
            sibling.color = 'R';

            Node parent = sibling.parent;
            Node temp = rightRotation(sibling);
            transplant(parent, sibling, temp);
            sibling = node.parent.right;
        }else if(!nodeIsLeftChild && isBlack(sibling.left))
        {
            sibling.right.color = 'B';
            sibling.color = 'R';

            Node parent = sibling.parent;
            Node temp = leftRotation(sibling);
            transplant(parent, sibling, temp);
            sibling = node.parent.left;
        }

        sibling.color = node.parent.color;
        node.parent.color = 'B';

        Node grand = node.parent.parent;
        if(nodeIsLeftChild)
        {
            sibling.right.color = 'B';

            Node temp = leftRotation(node.parent);
            transplant(grand, node.parent, temp);
        }else {
            sibling.left.color = 'B';

            Node temp = rightRotation(node.parent);
            transplant(grand, node.parent, temp);
        }
    }

    private void fixDelete(Node node)
    {
        if(node == root)
        {
            node.color = 'B';
            return;
        }

        Node sibling = getSibling(node);

        if(sibling.color == 'R')
        {
            handleRedSibling(node, sibling);
            sibling = getSibling(node);
        }

        if(isBlack(sibling.left) && isBlack(sibling.right))
        {
            sibling.color = 'R';

            if(node.parent.color == 'R')
            {
                node.parent.color = 'B';
            }else {
                fixDelete(node.parent);
            }
        }else {
            handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
        }
    }

    @Override
    public String toString() {
        preorder(root);
        return "";
    }

    private void in0rderToList(Node node, List<T> list)
    {
        if(node == null)
            return;

        in0rderToList(node.left, list);
        list.add(node.data);
        in0rderToList(node.right, list);
    }

    public List<T> getElements()
    {
        List<T> list = new ArrayList<>();
        in0rderToList(root, list);
        return list;
    }
}


