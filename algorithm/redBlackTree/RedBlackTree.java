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
}
