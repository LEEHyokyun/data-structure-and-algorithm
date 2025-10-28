package algorithm.binarySearchTree;

public class Test {
    public static void main(String[] args){
        BinarySearchTree bst = new BinarySearchTree(18);

        bst.insert(15);
        bst.insert(10);
        bst.insert(6);
        bst.insert(3);
        bst.insert(8);
        bst.insert(12);
        bst.insert(11);
        bst.insert(31);
        bst.insert(27);
        bst.insert(24);
        bst.insert(20);
        bst.insert(33);
        bst.insert(35);
        bst.insert(37);
        bst.getBinaryTree().inOrderTraversal(bst.getBinaryTree());

        //bst.search(6);
        //bst.search(1);

        System.out.println("이진탐색트리 제거");
        bst.remove(10);
        bst.remove(55);
        bst.getBinaryTree().inOrderTraversal(bst.getBinaryTree());
    }
}
