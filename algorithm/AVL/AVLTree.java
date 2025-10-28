package algorithm.AVL;

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

    public void remove(int data){
        //root node 제거 시 필요한 임시부모노드
        BinaryTree tempParentTree = new BinaryTree(0);
        BinaryTree parentTree = tempParentTree;
        BinaryTree currentTree = this.binaryTree;
        BinaryTree deletingTree = null;

        tempParentTree.setRightSubTree(this.binaryTree);

        while(currentTree != null && currentTree.getData() != data){
            parentTree = currentTree;

            if(currentTree.getData() > data){
                currentTree = currentTree.getLeftSubTree();
            }else{
                currentTree = currentTree.getRightSubTree();
            }
        }

        if(currentTree == null){
            System.out.println("제거할 노드가 존재하지 않습니다.");
            return;
        }

        deletingTree = currentTree;

        //case 1 : 자식 노드가 없는 터미널 노드 제거
        if(deletingTree.getLeftSubTree() == null && deletingTree.getRightSubTree() == null){
            if(parentTree.getLeftSubTree() == deletingTree){
                parentTree.removeLeftSubTree();
            }else{
                parentTree.removeRightSubTree();
            }
        }
        //case 2 : 자식 노드가 1개 존재하는 인터벌 노드 제거
        else if((deletingTree.getLeftSubTree() == null && deletingTree.getRightSubTree() != null)
                || (deletingTree.getLeftSubTree() != null && deletingTree.getRightSubTree() == null)){
            BinaryTree deletingTreeChild = null;

            if(deletingTree.getLeftSubTree() != null){
                deletingTreeChild = deletingTree.getLeftSubTree();
            }else{
                deletingTreeChild = deletingTree.getRightSubTree();
            }

            if(parentTree.getLeftSubTree() == deletingTree){
                parentTree.setLeftSubTree(deletingTreeChild);
            }else{
                parentTree.setRightSubTree(deletingTreeChild);
            }
        }
        //case 3 : 자식노드가 두개가 있을 경우
        else{
            BinaryTree replacingTree = deletingTree.getLeftSubTree();
            BinaryTree replacingParentTree = deletingTree;

            while(replacingTree.getRightSubTree() != null){
                replacingParentTree = replacingTree;
                replacingTree = replacingParentTree.getRightSubTree();

            }

            //데이터 교체
            BinaryTree result = deletingTree;
            System.out.println(result.getData() + " 노드를 제거합니다.");

            deletingTree.setData(replacingTree.getData());
            System.out.println(replacingTree.getData() + " 노드로 교체합니다.");


            //이진트리 교체(교체노드의 왼쪽자식노드를 교체노드의 부모노드와 연결 **교체노드가 가장 크다는 것을 알기에 오른쪽 자식노드는 없음)
            if(replacingParentTree.getLeftSubTree() == replacingTree){
                replacingParentTree.setLeftSubTree(replacingTree.getLeftSubTree());
            }else{
                replacingParentTree.setRightSubTree(replacingTree.getLeftSubTree());
            }

        }

        //루트노드를 제거하였을 경우 루토느도를 재설정
        if(tempParentTree.getRightSubTree() != this.binaryTree){
            this.binaryTree = tempParentTree.getRightSubTree();
        }

    }
}
