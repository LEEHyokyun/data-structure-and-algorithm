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
