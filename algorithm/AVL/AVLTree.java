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

    //하향식 접근(재귀적 상향)을 통한 불균형 해결(제거)
    public BinaryTree remove(BinaryTree targetRootTree, BinaryTree parentTree, int data){
        if(targetRootTree.getData() > data && targetRootTree.getLeftSubTree() != null){
            //제거 후 해당 제거된 노드를 대체하는 자식노드를 리턴하여 이 노드를 서브트리로 구성해주는 재귀적 호출.
            targetRootTree.setLeftSubTree(this.remove(targetRootTree.getLeftSubTree(), targetRootTree, data));
        }else if(targetRootTree.getData() < data && targetRootTree.getRightSubTree() != null){
            //위와 마찬가지 원리
            targetRootTree.setRightSubTree(this.remove(targetRootTree.getRightSubTree(), targetRootTree, data));
        }else if(targetRootTree.getData() == data){
            //삭제할 노드를 찾은 경우
            targetRootTree = this.removeHelepr(targetRootTree, parentTree, data);

            //루트노드를 삭제하는 경우
            if(parentTree == null && targetRootTree != null){
                //높이 업데이트
                this.updateHeight(targetRootTree);

                //균형 복구
                BinaryTree unBalancedTree = this.getUnBalancedTree(targetRootTree);
                targetRootTree = this.rotate(targetRootTree, unBalancedTree.getData());
            }

            return targetRootTree;
        }

        //높이 업데이트
        this.updateHeight(targetRootTree);

        //균형 복구
        BinaryTree unBalancedTree = this.getUnBalancedTree(targetRootTree);
        targetRootTree = this.rotate(targetRootTree, unBalancedTree.getData());

        return targetRootTree;
    }

    //삭제한 노드를 대체하는 노드 리턴(=그의 자식노드)
    public BinaryTree removeHelepr(BinaryTree deletingTree, BinaryTree parentTree, int data){
        //root node 제거 시 필요한 임시부모노드
        BinaryTree tempParentTree = new BinaryTree(0);
        tempParentTree.setRightSubTree(deletingTree);

        if(parentTree == null){
            parentTree = tempParentTree;
        }

        BinaryTree deletingTreeChild = null;

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

            deletingTreeChild = replacingTree;

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

        return deletingTreeChild;
    }
}
