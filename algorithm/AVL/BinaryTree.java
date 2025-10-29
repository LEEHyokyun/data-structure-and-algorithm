package algorithm.AVL;

public class BinaryTree {
    private Integer data;
    private BinaryTree leftSubTree;
    private BinaryTree rightSubTree;
    private int height;

    public BinaryTree(Integer data) {
        this.data = data;
        this.leftSubTree = null;
        this.rightSubTree = null;
    }

    public BinaryTree(Integer data, BinaryTree leftSubTree, BinaryTree rightSubTree) {
        this.data = data;
        this.leftSubTree = leftSubTree;
        this.rightSubTree = rightSubTree;
        this.height = 1;
    }

    public Integer getData(){
        return this.data;
    }

    public void setData(Integer data){
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

    public int getHeight() {return this.height;}

    public void setHeight(int height) {this.height = height;}
    /*
    * 전위순회
    * */
    public void preOrderTraversal(BinaryTree tree){
        if(tree == null) return;
        //while (tree != null) {
            System.out.println(tree.getData());
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
            System.out.println(tree.getData());
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
            System.out.println(tree.getData());

    }

    public BinaryTree removeLeftSubTree(){
        BinaryTree leftSubTree = this.leftSubTree;
        this.leftSubTree = null;

        return leftSubTree;
    }

    public BinaryTree removeRightSubTree(){
        BinaryTree rightSubTree = this.rightSubTree;
        this.rightSubTree = null;

        return rightSubTree;
    }
}
