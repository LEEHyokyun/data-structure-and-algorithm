package algorithm.heapSort.heap;

public class BinaryTree {
    private Integer data;
    private BinaryTree leftSubTree;
    private BinaryTree rightSubTree;
    private BinaryTree parentTree;

    public BinaryTree(Integer data) {
        this.data = data;
        this.leftSubTree = null;
        this.rightSubTree = null;
    }

    public BinaryTree(Integer data, BinaryTree leftSubTree, BinaryTree rightSubTree, BinaryTree parentTree, boolean color) {
        this.data = data;
        this.leftSubTree = leftSubTree;
        this.rightSubTree = rightSubTree;
        this.parentTree = parentTree;
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

    public BinaryTree getParentTree(){ return this.parentTree; }

    public void setParentTree(BinaryTree parentTree){ this.parentTree = parentTree; }


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
