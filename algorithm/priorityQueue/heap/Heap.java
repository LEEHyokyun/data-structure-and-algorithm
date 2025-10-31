package algorithm.priorityQueue.heap;

public class Heap {
    private BinaryTree rootTree;
    private BinaryTree lastInsertedTree;

    public Heap(BinaryTree rootTree, BinaryTree lastInsertedTree){
        this.rootTree = rootTree;
        this.lastInsertedTree = lastInsertedTree;
    }

    public void insert(int data){
        //최초 삽입
        if(this.lastInsertedTree == null){
            this.lastInsertedTree = new BinaryTree(data);
            this.rootTree = this.lastInsertedTree;
        }

        //이후 삽입

        //노드를 새로 삽입할 위치의 부모노드
        BinaryTree insertingTreeParentTree = this.getInsertingTreeParentTree();
        BinaryTree newTree = new BinaryTree(data);

        if(insertingTreeParentTree.getLeftSubTree() == null){
            insertingTreeParentTree.setLeftSubTree(newTree);
        }else if(insertingTreeParentTree.getRightSubTree() == null){
            insertingTreeParentTree.setRightSubTree(newTree);
        }

        newTree.setParentTree(insertingTreeParentTree);
        this.lastInsertedTree = newTree;

        while(newTree.getParentTree() != null){
            if(this.isPriorityBiggerXToY(newTree.getData(), newTree.getParentTree().getData())){
                int tempData =  newTree.getParentTree().getData();
                newTree.getParentTree().setData(newTree.getData());
                newTree.setData(tempData);
                newTree =  newTree.getParentTree();
            }else{
                //우선순위 정렬 종료
                break;
            }
        }
    }

    public boolean isPriorityBiggerXToY(int x, int y){
        return x < y;
    }

    /*
    * 삽입할 위치의 부모노드 찾기
    * - 부모노드를 재귀상향하면서 오른쪽 형제노드 존재하는지 확인
    * - 존재할 경우 그 오른쪽 형제노드의 왼쪽자식 최하단에 삽입
    * - 존재하지 않을 경우 루트노드의 왼쪽자식 최하단에 삽입
    * */
    public BinaryTree getInsertingTreeParentTree(){
        //root
        if(this.lastInsertedTree == null)
            return this.lastInsertedTree;

        //not root
        else{
            if(this.lastInsertedTree == this.lastInsertedTree.getParentTree().getLeftSubTree()){
                return this.lastInsertedTree.getParentTree();
            }else{
                BinaryTree currentTree = this.lastInsertedTree;
                BinaryTree firstlyRightLocatedSiblingTree = null;

                //루트는 애초에 형제노드가 없다.
                while(currentTree.getParentTree().getParentTree() != null){ //기저조건 범위 + 2(조부모)
                    currentTree = currentTree.getParentTree(); //범위 + 1 (부모)

                    firstlyRightLocatedSiblingTree = this.getRightSiblingTree(currentTree);

                    if(firstlyRightLocatedSiblingTree != null){
                        break;
                    }
                }

                //형제노드 있다 = 루트노드의 왼쪽서브트리에 현재 위치
                //형제노드 없다 = 루트노드의 오른쪼서브트리에 현재 위치
                if(firstlyRightLocatedSiblingTree != null){
                    while(firstlyRightLocatedSiblingTree.getLeftSubTree() != null){
                        firstlyRightLocatedSiblingTree = firstlyRightLocatedSiblingTree.getLeftSubTree();
                    }
                    return firstlyRightLocatedSiblingTree;
                }else{
                    currentTree = this.rootTree;
                    while(currentTree.getLeftSubTree() != null){
                        currentTree = currentTree.getLeftSubTree();
                    }
                    return currentTree;
                }
            }
        }
    }

    public BinaryTree getRightSiblingTree(BinaryTree currentTree){
        //본인의 형제노드를 추출, 없으면 null로 반환
        if(currentTree.getParentTree().getRightSubTree() != currentTree){
            return currentTree.getParentTree().getRightSubTree();
        }else{
            return null;
        }
    }

    public BinaryTree getLeftSiblingTree(BinaryTree currentTree){
        //본인의 형제노드를 추출, 없으면 null로 반환
        if(currentTree.getParentTree().getLeftSubTree() != currentTree){
            return currentTree.getParentTree().getLeftSubTree();
        }else{
            return null;
        }
    }
}
