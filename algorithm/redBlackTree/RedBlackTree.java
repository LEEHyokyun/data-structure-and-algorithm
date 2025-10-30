package algorithm.redBlackTree;

public class RedBlackTree {
    private BinaryTree binaryTree;

    public RedBlackTree(Integer data) {
        this.binaryTree = new BinaryTree(data);
    }

    public BinaryTree getBinaryTree() {
        return this.binaryTree;
    }

    public BinaryTree search(int data) {
        BinaryTree currentTree = this.binaryTree;

        while (currentTree != null) {
            if (currentTree.getData() == data) {
                System.out.println(String.format("%s 데이터 존재", data) + currentTree);
                return currentTree;
            } else if (currentTree.getData() > data) {
                currentTree = currentTree.getLeftSubTree();
            } else {
                currentTree = currentTree.getRightSubTree();
            }
        }

        System.out.println("해당 노드 데이터가 존재하지 않습니다.");
        return null;
    }

    public BinaryTree rotateLeft(BinaryTree rotatingTree){
        BinaryTree parentTree = rotatingTree.getParentTree();
        BinaryTree rightChildTree = rotatingTree.getRightSubTree();

        rotatingTree.setRightSubTree(rightChildTree.getLeftSubTree());

        if(rightChildTree.getLeftSubTree() != null){
            rightChildTree.getLeftSubTree().setParentTree(rotatingTree);
        }

        rightChildTree.setLeftSubTree(rotatingTree);
        rotatingTree.setParentTree(rightChildTree);

        //대체가 발생하는 지점에서 대체한 트리노드를 반환
        return this.replaceParentChild(parentTree, rotatingTree, rightChildTree);
    }

    public BinaryTree rotateRight(BinaryTree rotatingTree){
        BinaryTree parentTree = rotatingTree.getParentTree();
        BinaryTree leftChildTree = rotatingTree.getLeftSubTree();

        rotatingTree.setLeftSubTree(leftChildTree.getRightSubTree());

        if(leftChildTree.getRightSubTree() != null){
            leftChildTree.getRightSubTree().setParentTree(rotatingTree);
        }

        leftChildTree.setRightSubTree(rotatingTree);
        rotatingTree.setParentTree(leftChildTree);

        //대체가 발생하는 지점에서 대체한 트리노드를 반환
        return this.replaceParentChild(parentTree, rotatingTree, leftChildTree);
    }

    public BinaryTree insert(int data){
        BinaryTree currentTree = this.binaryTree;
        BinaryTree parentTree = null;

        //삽입
        while(currentTree != null){
            parentTree = currentTree;

            if(data < currentTree.getData()){
                currentTree = currentTree.getLeftSubTree();
            } else if (data > currentTree.getData()) {
                currentTree = currentTree.getRightSubTree();
            } else {
                System.out.println("데이터는 중복될 수 없습니다.");
                return null;
            }
        }

        BinaryTree newTree = new BinaryTree(data);

        if(parentTree == null){
            this.binaryTree = newTree;
        }else if(data < parentTree.getData()){
            parentTree.setLeftSubTree(newTree);
        }else {
            parentTree.setRightSubTree(newTree);
        }

        newTree.setParentTree(parentTree);

        //균형 맞추기(교체가 발생한 지점에서 교체한 노드를 반환)
        return this.rebalanceAfterInsertion(newTree);
    }

    public BinaryTree rebalanceAfterInsertion(BinaryTree binaryTree){
        //case 1. 루트노드의 교체 및 부모노드가 검은색
        BinaryTree parentTree = binaryTree.getParentTree();

        if(parentTree == null){
            binaryTree.setColor(Color.BLACK);
            return binaryTree;
        }

        //case 2 ~ case 4. 부모노드가 빨간색
        if(parentTree.getColor() == Color.BLACK){
            System.out.println("부모노드가 검은색이므로 균형을 맞추는 작업이 필요없습니다.");
            return null;
        }

        //case 2. 부모노드와 삼촌노드가 빨간색
        BinaryTree uncleTree = this.getUncleTree(parentTree);
        BinaryTree grandParentTree = parentTree.getParentTree();

        if(uncleTree != null && uncleTree.getColor() == Color.RED){
            parentTree.setColor(Color.BLACK);
            uncleTree.setColor(Color.BLACK);
            grandParentTree.setColor(Color.RED);
            //재귀적 상향하면서 루트노드를 만날때까지 Recoloring 작업 수행. 전형적인 상향식 해결.
            this.rebalanceAfterInsertion(grandParentTree);

            return grandParentTree;
        }
        else if(this.isBlack(uncleTree)){
            //case 3-1. 부모노드가 빨간색, 삼촌노드가 검은색, 새로운 노드가 안쪽 손자(할아버지/부모/손자가 오른쪽으로 볼록한 삼각형 도식)
            if(grandParentTree.getRightSubTree() == parentTree && parentTree.getLeftSubTree() == binaryTree){
                //부모노드 기준 RR
                this.rotateRight(parentTree);
                //할아버지노드 기준 LL
                this.rotateLeft(grandParentTree);
                //본인노드를 검은색
                this.binaryTree.setColor(Color.BLACK);
                //할아버지노드를 빨간색
                grandParentTree.setColor(Color.RED);

                return binaryTree;
            }
            //case 3-2. 부모노드가 빨간색, 삼촌노드가 검은색, 새로운 노드가 안쪽 손자(할아버지/부모/손자가 왼쪽으로 볼록한 삼각형 도식)
            else if(grandParentTree.getLeftSubTree() == parentTree && parentTree.getRightSubTree() == binaryTree){
                //부모노드 기준 LL
                this.rotateLeft(parentTree);
                //할아버지노드 기준 RR
                this.rotateRight(grandParentTree);
                //본인노드를 검은색
                this.binaryTree.setColor(Color.BLACK);
                //할아버지노드를 빨간색
                grandParentTree.setColor(Color.RED);

                return binaryTree;
            }
            //case 4-1. 부모노드가 빨간색, 삼촌노드가 검은색, 새로운 노드가 오른쪽 바깥쪽 손자
            else if(grandParentTree.getRightSubTree() == parentTree && parentTree.getRightSubTree() == binaryTree){
                //할아버지노드 LL
                this.rotateLeft(grandParentTree);
                //부모노드 검은색
                parentTree.setColor(Color.BLACK);
                //할아버지노드 빨간색
                grandParentTree.setColor(Color.RED);

                return parentTree;
            }
            //case 4-2. 부모노드가 빨간색, 삼촌노드가 검은색, 새로운 노드가 왼쪽 바깥쪽 손자
            else if(grandParentTree.getLeftSubTree() == parentTree && parentTree.getLeftSubTree() == binaryTree){
                //할아버지노드 RR
                this.rotateRight(grandParentTree);
                //부모노드 검은색
                parentTree.setColor(Color.BLACK);
                //할아버지노드 빨간색
                grandParentTree.setColor(Color.RED);

                return parentTree;
            }
        }

        System.out.println("균형을 더이상 맞출 수 없습니다.");
        return null;
    }

    public boolean isBlack(BinaryTree binaryTree){
        return binaryTree == null || binaryTree.getColor() == Color.BLACK;
    }

    public BinaryTree getUncleTree(BinaryTree parentTree){
        BinaryTree grandParentTree = parentTree.getParentTree();

        if(parentTree == grandParentTree.getLeftSubTree()){
            return grandParentTree.getRightSubTree();
        }else if(parentTree == grandParentTree.getRightSubTree()){
            return grandParentTree.getLeftSubTree();
        }else
            return null;
    }

    public BinaryTree remove(int data){
        BinaryTree currentTree = this.binaryTree;

        while(currentTree != null && currentTree.getData() != data){
            if(data < currentTree.getData()){
                currentTree = currentTree.getLeftSubTree();
            }else if(data > currentTree.getData()){
                currentTree = currentTree.getRightSubTree();
            }
        }

        if(currentTree == null){
            System.out.println("제거할 노드가 없습니다.");
            return null;
        }

        BinaryTree replaceTree = null; //대체대상을 대체할 값
        Boolean deletingTreeColor = Color.RED; //대체대상의 색

        //제거할 노드의 자식 노드에 따라 제거 진행

        //case 1 : 자식노드가 0 ~ 1개
        if(currentTree.getLeftSubTree() == null || currentTree.getRightSubTree() == null){
            replaceTree = this.removeWithZeroOrOneChild(currentTree);
            deletingTreeColor = currentTree.getColor();
        }
        //case 2 : 자식노드가 2개
        else {
            BinaryTree replacingTreeWhenTreeHas2ChildTrees = this.getBiggestTree(currentTree.getLeftSubTree());
            currentTree.setData(replacingTreeWhenTreeHas2ChildTrees.getData());
            replaceTree = this.removeWithZeroOrOneChild(replacingTreeWhenTreeHas2ChildTrees);
            deletingTreeColor = currentTree.getColor();
        }

        //Recoloring
        if(deletingTreeColor == Color.BLACK){
            this.rebalanceAfterDeletion(replaceTree);

            //최종적으로 대체할 값이 닐노드(null)일 경우 대체값(NillNode)의 부모노드를 null로 교체.
            if(replaceTree.getData() == 0){
                this.replaceParentChild(replaceTree.getParentTree(), replaceTree, null);
            }
        }

        //대체하는 값을 반환
        return replaceTree;
    }

    public BinaryTree removeWithZeroOrOneChild(BinaryTree binaryTree){
        //매개변수 : 대체대상 , 반환값 : 이를 대체할 값
        if(binaryTree.getLeftSubTree() != null){
            this.replaceParentChild(binaryTree.getParentTree(), binaryTree, binaryTree.getLeftSubTree());
            return binaryTree.getLeftSubTree();
        }else if(binaryTree.getRightSubTree() != null){
            this.replaceParentChild(binaryTree.getParentTree(), binaryTree, binaryTree.getRightSubTree());
            return  binaryTree.getRightSubTree();
        }else{
            //제거하는데 제거노드가 검은색일 경우
            BinaryTree nillTree = binaryTree.getColor() == Color.BLACK ? new BinaryTree(0, null, null, null, Color.BLACK) : null;
            this.replaceParentChild(binaryTree.getParentTree(), binaryTree, nillTree);
            return nillTree;
        }
    }

    public BinaryTree getBiggestTree(BinaryTree leftSubTree){
        BinaryTree biggestTree = null;

        while(leftSubTree != null){
            biggestTree = leftSubTree.getRightSubTree();
        }

        return biggestTree;
    }

    public BinaryTree replaceParentChild(BinaryTree parentTree, BinaryTree oldChildTree, BinaryTree newChildTree){
        if(parentTree == null){
            this.binaryTree = newChildTree;
        }
        else if(parentTree.getLeftSubTree() == oldChildTree){
            parentTree.setLeftSubTree(newChildTree);
        }
        else if(parentTree.getRightSubTree() == oldChildTree){
            parentTree.setRightSubTree(newChildTree);
        }

        if(newChildTree != null){
            newChildTree.setParentTree(parentTree);
        }

        return newChildTree;
    }

    public void rebalanceAfterDeletion(BinaryTree replaceTree){
        //replaceTree = 대체할 노드
        if(this.binaryTree == binaryTree){
            replaceTree.setColor(Color.BLACK);
        }

        //형제노드
        BinaryTree siblingTreeOfReplacingTree = this.getSibling(replaceTree);

        //case 1 : 형제노드가 빨간색
        if(siblingTreeOfReplacingTree.getColor() == Color.RED){
            this.handleWhenSiblingColorIsRed(replaceTree, siblingTreeOfReplacingTree);

            //case 1을 거친 후 형제노드를 재추출
            siblingTreeOfReplacingTree = this.getSibling(replaceTree);
        }

        //case 1 진행 후 형제노드를 다시 확인하여 Recoloring 조치.
        if(this.isBlack(siblingTreeOfReplacingTree)){
            //case 2 : 형제노드 검은색 + 형제노드의 두 자식이 검은색 + 부모노드가 빨간색
            if(this.isBlack(siblingTreeOfReplacingTree.getLeftSubTree()) && this.isBlack(siblingTreeOfReplacingTree.getRightSubTree())){
                if(replaceTree.getParentTree().getColor() == Color.RED){
                    siblingTreeOfReplacingTree.setColor(Color.RED);
                    replaceTree.getParentTree().setColor(Color.BLACK);
            //case 3 : 형제노드 검은색 + 형제노드의 두 자식이 검은색 + 부모노드가 검은색
                }else{
                    siblingTreeOfReplacingTree.setColor(Color.RED);
                    this.rebalanceAfterDeletion(replaceTree.getParentTree());
                }
            //case 4 : 형제노드 검은색 + 형제노드의 두 자식 노드 중 하나라도 빨간색 + 바깥쪽 조카노드가 검은색
            // case 5 : 형제노드 검은색 + 형제노드의 두 자식 노드 중 하나라도 빨간색 + 바깥쪽 조카노드가 빨간색
            }else{
                this.handleWhenAtLeastOneOfSiblingChildColorIsRed(replaceTree, siblingTreeOfReplacingTree);
            }
        }
    }

    //대체할 노드의 형제노드를 구하는 함수
    public BinaryTree getSibling(BinaryTree replaceTree){
        BinaryTree parentTree = replaceTree.getParentTree();

        if(replaceTree == parentTree.getLeftSubTree()){
            return parentTree.getRightSubTree();
        }else{
            return parentTree.getLeftSubTree();
        }

    }

    //형제노드가 빨간색일 경우
    public void handleWhenSiblingColorIsRed(BinaryTree replaceTree, BinaryTree siblingTree){
        siblingTree.setColor(Color.BLACK);
        replaceTree.getParentTree().setColor(Color.RED);

        if(replaceTree.getParentTree().getLeftSubTree() == replaceTree){
            this.rotateLeft(replaceTree.getParentTree());
        }else{
            this.rotateRight(replaceTree.getParentTree());
        }
    }

    //형제노드의 자식노드 중 하나라도 빨간색일 경우
    public void handleWhenAtLeastOneOfSiblingChildColorIsRed(BinaryTree replaceTree, BinaryTree siblingTree){
        //바깥조카가 검은색
        //대체노드가 부모노드의 왼쪽서브트리노드
        if(replaceTree.getParentTree().getLeftSubTree() == siblingTree && this.isBlack(siblingTree.getRightSubTree())){
            siblingTree.getLeftSubTree().setColor(Color.BLACK);
            siblingTree.setColor(Color.RED);
            this.rotateRight(siblingTree);

            siblingTree = siblingTree.getParentTree().getRightSubTree();
        }
        //대체노드가 부모노드의 오른쪽서브트리노드
        else if(replaceTree.getParentTree().getRightSubTree() == siblingTree && this.isBlack(siblingTree.getLeftSubTree())){
            siblingTree.getRightSubTree().setColor(Color.BLACK);
            siblingTree.setColor(Color.RED);
            this.rotateLeft(siblingTree);
            this.rotateLeft(siblingTree);

            siblingTree = siblingTree.getParentTree().getLeftSubTree();
        }

        siblingTree.setColor(replaceTree.getParentTree().getColor());
        replaceTree.getParentTree().setColor(Color.BLACK);

        if(replaceTree.getParentTree().getLeftSubTree() == replaceTree){
            //대체노드가 부모노드의 왼쪽에 위치
            siblingTree.getRightSubTree().setColor(Color.BLACK);
            this.rotateLeft(replaceTree.getParentTree());
        }else{
            //대체노드가 부모노드의 오른쪽에 위치
            siblingTree.getLeftSubTree().setColor(Color.BLACK);
            this.rotateRight(replaceTree.getParentTree());
        }
    }
}
