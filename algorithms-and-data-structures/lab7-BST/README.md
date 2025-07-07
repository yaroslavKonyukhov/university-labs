# Binary Search Tree
- A tree is a special type of graph that has a main node, the root, which has no parent. Every node except the root has one parent. There is only one path between any two nodes.
- A binary tree is a tree in which a node can have a maximum of two child nodes.
- A binary search tree - an ordered binary tree. There is a rule: all values ​​in the left subtree are strictly less than the value of the node; all values ​​in the right subtree are strictly greater than the value of the node.
- The rules of BST force operations such as add, remove, and search to be performed with O(logn) time complexity. But O(logn) time complexity preserves if tree is balanced. BST is not self-balanced. Self-balanced data structures are AVL and Red-Black Tree. So BST could become a simple list by adding values in ascending order (for example, 1, 2, 3, 4, ...). And so time complexity becomes O(n).
## Adding
- Following the rules of BST we recursively go through the tree nodes finding a suitable place for a new node. BST doesn't contain duplicates. If the value is already exists we don't change the structure.
## Removing
- Three cases are possible:
  1) node to be deleted doesn't have any child node - just make this node equal null.
  2) node to be deleted has one child node - make this node equal child node.
  3) node to be deleted has two child node - then we need to find min value in right subtree (my implementation) or max value in left subtree, update the value of current node with this max/min value and delete the node from which we take this max/min value.
## PreOrder, InOrder, PostOrder
- preOrder: print node - leftChild - rightChild.
- inOrder: print leftChild - node - rightChild. Let us print the values of tree in ascending order due to the rules of BST.
- postOrder: print leftChild - rightChild - node.
