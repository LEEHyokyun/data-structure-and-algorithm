package tree.binaryTree;

public class BinaryTree {
    private String data;
    private BinaryTree leftSubTree;
    private BinaryTree rightSubTree;

    public BinaryTree(String data) {
        this.data = data;
        this.leftSubTree = null;
        this.rightSubTree = null;
    }

    public BinaryTree(String data,  BinaryTree leftSubTree, BinaryTree rightSubTree) {
        this.data = data;
        this.leftSubTree = leftSubTree;
        this.rightSubTree = rightSubTree;
    }

    public String getData(){
        return this.data;
    }

    public void setData(String data){
        this.data = data;
    }

    public BinaryTree getLeftSubTree(){
        return this.leftSubTree;
    }

    public BinaryTree getRightSubTree(){
        return this.rightSubTree;
    }

    public void setLeftSubTree(BinaryTree leftSubTree){
        this.leftSubTree = leftSubTree;
    }

    public void setRightSubTree(BinaryTree rightSubTree){
        this.rightSubTree = rightSubTree;
    }

    /*
    * 전위순회
    * */
    public void preOrderTraversal(BinaryTree tree){
        if(tree == null) return;
        //while (tree != null) {
            System.out.print(tree.getData());
            preOrderTraversal(tree.getLeftSubTree());
            preOrderTraversal(tree.getRightSubTree());

    }

    /*
    * 중위순회
    * */
    public void inOrderTraversal(BinaryTree tree){
        if(tree == null) return;
        //while(tree != null) {
            inOrderTraversal(tree.getLeftSubTree());
            System.out.print(tree.getData());
            inOrderTraversal(tree.getRightSubTree());

    }

    /*
    * 후위순회
    * */
    public void postOrderTraversal(BinaryTree tree){
        if(tree == null) return;
        //while(tree != null) {
            postOrderTraversal(tree.getLeftSubTree());
            postOrderTraversal(tree.getRightSubTree());
            System.out.print(tree.getData());

    }
}
