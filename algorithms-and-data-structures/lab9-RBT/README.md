# Red-Black Tree
- RBT is a binary search tree (BST) which is self-balanced. It is not always perfectly balanced like AVL. It is approximately balanced and guarantees a tree height of O(logn), but allows some deviation from perfect balance. But it is more efficient than AVL, since it changes the tree structure less often for balance. Due to this, insertion and deletion operations are more efficient than in AVL.
- For balancing, an additional field is used for the node - color. Color can be Red or Black. There are special rules that we follow when painting the nodes, changing the structure of the tree and repainting the nodes again in order to balance the tree.
- Rules of Red-Black Tree:
  1) Root is always Black.
  2) Black node can have Black child and Red child. Red node can have only Black child, otherwise we detect collision of Red nodes that we have to fix.
  3) Each path from the root to a leaf must contain the same number of black nodes.
  4) NIL node (leaf, stub, null node) is Black.
## Add method
- Add method is the same as in BST but when we recursively returning to the root we check for red nodes' collision. If it appears we need to fix it. Depending on the case we need to repaint nodes or do changes in the structure of the tree and repaint nodes to fix the collision.
  1) If uncle node exists and it's Red, we can just repaint parent and uncle nodes to Black. Also if grandparent is not root, we repaint it to Red.
  - Then cases if uncle doesn't exist or its color is Black. Imagine as if it's right subtree. All cases work symmetrically for the left subtree.
  2) If the new node was added to the left (so left child exists and it's Red), it's "zigzag" type of structure and we first do right rotation at parent node to fix "zigzag" and then left rotation at grandparent node.
  3) If the new node was added to the right, we just do left rotation at grandparent node.
- I use boolean flags that tell about type of action to fix the collision and recursively returning back I fix collision and turn off the flags.
## Remove method
- Remove method is the same as in BST but when we delete the node we can break the rules of RBT. And then we have to fix the tree to follow the rules again.
  1) If we delete Red node we don't break any rule.
  2) If we delete Black node we definitely break third rule and we get Black nodes' collision.
- All 6 cases how to fix the tree after deletion if we break one of the rules: https://miro.medium.com/v2/resize:fit:720/format:webp/1*zlA3UhMzmHrN_QCmEj3s9A.jpeg
- I also studied the removal method on this resource (https://www.happycoders.eu/algorithms/red-black-tree-java/) and was inspired by it. But my implementation is a little different.
## TreeMap
- TreeMap is a structute that allows to store pairs of keys and values but it sorts the keys in ascending order and when we print pairs of TreeMap we get them in ascending order. We can impement TreeMap based on Red-Black tree. Because time complexity is O(logn) and due to BST behavior and inorder method we can get the elements in ascending order by keys.
## TreeSet
- TreeSet is based on TreeMap. TreeSet is such a data structure that contains unique values. In treeMap keys are unique so in treeSet we can use treeMap and store values as keys but for values use null objects as stub.
