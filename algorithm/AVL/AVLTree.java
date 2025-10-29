package algorithm.AVL;

public class AVLTree {
    private BinaryTree binaryTree;

    public AVLTree(Integer data) {
        this.binaryTree = new BinaryTree(data);
    }

    public BinaryTree getBinaryTree() {
        return this.binaryTree;
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

    public int getHeight(BinaryTree binaryTree){
        if(binaryTree == null){
            return 0;
        }else{
            return binaryTree.getHeight();
        }
    }

    //회전을 한 후 변경된 트리의 높이(최초 루트노드의 데이터를 기준으로)
    public void updateHeight(BinaryTree binaryTree){
        int leftChildHeight = this.getHeight(binaryTree.getLeftSubTree());
        int rightChildHeight = this.getHeight(binaryTree.getRightSubTree());
        int treeHeight = Math.max(leftChildHeight, rightChildHeight) + 1;
    }

    //왼쪽자식높이 - 오른쪽자식높이
    public int getBalanceFactor(BinaryTree binaryTree){
        return this.getHeight(binaryTree.getLeftSubTree()) - this.getHeight(binaryTree.getRightSubTree());
    }

    //LL
    public BinaryTree leftRotate(BinaryTree binaryTree){
        /*
        * 기존 루트노드의 오른쪽 자식 노드의 왼쪽 자식 노드를 루트노드의 오른쪽 자식 노드로 교체한 후
        * 오른쪽 자식 노드의 왼쪽 자식 노드를 루트 노드로 교체한다.
        * */
        BinaryTree childTree = binaryTree.getRightSubTree();
        binaryTree.setRightSubTree(childTree.getLeftSubTree());
        childTree.setLeftSubTree(binaryTree);

        this.updateHeight(binaryTree);
        this.updateHeight(childTree);

        return childTree;
    }

    //RR
    public BinaryTree rightRotate(BinaryTree binaryTree){
        /*
         * 기존 루트노드의 왼쪽 자식 노드의 왼쪽 자식 노드를 루트노드의 오른쪽 자식 노드로 교체한 후
         * 오른쪽 자식 노드의 왼쪽 자식 노드를 루트 노드로 교체한다.
         * */
        BinaryTree childTree = binaryTree.getLeftSubTree();
        binaryTree.setLeftSubTree(childTree.getRightSubTree());
        childTree.setRightSubTree(binaryTree);

        this.updateHeight(binaryTree);
        this.updateHeight(childTree);

        return childTree;
    }

    //rotate
    public BinaryTree rotate(BinaryTree targetTree, int data){
        int balanceFactor = this.getBalanceFactor(targetTree);
        boolean isRootNode = false;

        if(targetTree.getData() == this.binaryTree.getData()){
            isRootNode = true;
        }

        //LL
        if(balanceFactor < -1 && data > targetTree.getRightSubTree().getData()){
            targetTree = this.leftRotate(targetTree);
        }
        //RR
        else if(balanceFactor > 1 && data < targetTree.getLeftSubTree().getData() ){
            targetTree = this.rightRotate(targetTree);
        }
        //LR(LL > RR)
        else if(balanceFactor > 1 && data > targetTree.getLeftSubTree().getData()){
            targetTree.setLeftSubTree(this.leftRotate(targetTree.getLeftSubTree()));
            targetTree = this.rightRotate(targetTree);
        }
        //RL(RR > LL)
        else if(balanceFactor < -1 && data < targetTree.getRightSubTree().getData()){
            targetTree.setRightSubTree(this.rightRotate(targetTree.getRightSubTree()));
            targetTree = this.leftRotate(targetTree);
        }

        //루트노드부터 불균형이었다면 루트노드 교체 작업이 발생하므로 루트노드 변경필요하다.
        if(isRootNode){
            this.binaryTree.setData(targetTree.getData());
        }

        return targetTree;
    }

    public BinaryTree getUnBalancedTree(BinaryTree targetTree){
        BinaryTree unBalancedTree = null;

        if(targetTree.getLeftSubTree() == null && targetTree.getRightSubTree() == null){
            unBalancedTree = targetTree;
            return unBalancedTree;
        }

        int balanceFactor = this.getBalanceFactor(targetTree);

        /*
        * balanceFactor가 0보다 크다는 것 자체로 불균형 경로를 따라간다는 의미
        * balanceFactor가 0일 경우, 오른쪽 노드를 선택하여 임의로 처리해주는 것.
        * */
        if(balanceFactor > 0){
            unBalancedTree = this.getUnBalancedTree(targetTree.getLeftSubTree());
        }else if(balanceFactor < 0){
            unBalancedTree = this.getUnBalancedTree(targetTree.getRightSubTree());
        }else{
            unBalancedTree = targetTree.getRightSubTree();
        }

        return unBalancedTree;
    }

    //하향식 접근(재귀적 상향)을 통한 불균형 해결(삽입)
    public BinaryTree insert(BinaryTree targetRootTree, int data){
        if(targetRootTree == null){
            //삽입노드가 비어 있거나 터미널 노드로의 삽입(아래 끝까지 들어가서 삽입 위치 지정됨)
            targetRootTree = new BinaryTree(data);
        }

        //아무것도 없을때 최초 데이터 삽입
        if(this.binaryTree == null){
            this.binaryTree.setData(data);
        }
        //중복데이터 처리
        else if(targetRootTree.getData() == data){
            System.out.println("데이터가 중복됩니다.");
            return targetRootTree;
        }else if(targetRootTree.getData() > data){
            targetRootTree.setLeftSubTree(this.insert(targetRootTree.getLeftSubTree(), data));
        }else{
            targetRootTree.setRightSubTree(this.insert(targetRootTree.getLeftSubTree(), data));
        }

        //높이 업데이트
        this.updateHeight(targetRootTree);

        //회전
        targetRootTree = this.rotate(targetRootTree, data);

        return targetRootTree;
    }


}
