package tree.binaryTree;

public class Test {
    public static void main(String[] args){
        BinaryTree bt1 = new BinaryTree("1");
        BinaryTree bt2 = new BinaryTree("2");
        BinaryTree bt3 = new BinaryTree("3");
        BinaryTree bt4 = new BinaryTree("4");
        BinaryTree bt5 = new BinaryTree("5");
        BinaryTree bt6 = new BinaryTree("6");
        BinaryTree bt7 = new BinaryTree("7");

        bt1.setLeftSubTree(bt2);
        bt1.setRightSubTree(bt3);
        bt2.setLeftSubTree(bt4);
        bt2.setRightSubTree(bt5);
        bt3.setLeftSubTree(bt6);
        bt3.setRightSubTree(bt7);

        System.out.println(bt1.getRightSubTree().getData());
        System.out.println(bt1.getLeftSubTree().getData());
        System.out.println(bt1.getRightSubTree().getLeftSubTree().getData());

        bt1.postOrderTraversal(bt1);
        //bt1.inOrderTraversal(bt1);
        //bt1.preOrderTraversal(bt1);
    }
}
