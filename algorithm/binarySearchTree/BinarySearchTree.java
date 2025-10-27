package algorithm.binarySearchTree;

public class BinarySearchTree {
    private BinaryTree binaryTree;

    public BinarySearchTree(Integer data) {
        this.binaryTree = new BinaryTree(data);
    }

    public BinaryTree getBinaryTree() {
        return this.binaryTree;
    }

    public void insert(int data){
        //최초 삽입
        if(this.binaryTree.getData() == null){
            this.binaryTree.setData(data);
        }

        //그 이후
        BinaryTree currentTree = this.binaryTree;
        BinaryTree parentTree = null;

        while(currentTree != null){ //getData -> NPE
            parentTree = currentTree;

            if(currentTree.getData() > data){
                currentTree = currentTree.getLeftSubTree();
            }else if(currentTree.getData() < data){
                currentTree = currentTree.getRightSubTree();
            }else if(currentTree.getData() == data){
                System.out.println("이진트리의 데이터 삽입은 중복을 허용하지 않습니다.");
                return;
            }
        }

        BinaryTree insertTree = new BinaryTree(data);

        if(parentTree.getData() > data){
            parentTree.setLeftSubTree(insertTree);
        }else{
            parentTree.setRightSubTree(insertTree);
        }
    }

    public BinaryTree search(int data){
        BinaryTree currentTree = this.binaryTree;

        while(currentTree != null){
            if(currentTree.getData() == data){
                System.out.println(String.format("%s 데이터 존재", data ) + currentTree);
                return currentTree;
            }else if(currentTree.getData() > data){
                currentTree = currentTree.getLeftSubTree();
            }else{
                currentTree = currentTree.getRightSubTree();
            }
        }

        System.out.println("해당 노드 데이터가 존재하지 않습니다.");
        return null;
    }
}
