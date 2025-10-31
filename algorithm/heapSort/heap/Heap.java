package algorithm.heapSort.heap;

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

    //제거(제거 후 그 다음 우선순위 = lastIndex)
    public BinaryTree remove(){
        BinaryTree deletingTree = null;

        //루트
        if(this.lastInsertedTree == this.rootTree){
            deletingTree = this.rootTree;
            this.rootTree = null;
            this.lastInsertedTree = null;

            return deletingTree;
        }

        //이외(제거 후 마지막 인덱스 위치를 그 이전 위치로 이동시켜야 한다)
        BinaryTree lastLastInsertedTree = this.getLastLastInsertedTree();

        //제거
        int tempData = this.rootTree.getData();
        this.rootTree.setData(this.lastInsertedTree.getData());
        this.lastInsertedTree.setData(tempData);

        if(this.lastInsertedTree.getParentTree().getLeftSubTree() == this.lastInsertedTree){
            this.lastInsertedTree.getParentTree().setLeftSubTree(null);
        }else{
            this.lastInsertedTree.getParentTree().setRightSubTree(null);
        }
        this.lastInsertedTree.setParentTree(null);

        //반환 및 위치변경
        deletingTree = this.lastInsertedTree;
        this.lastInsertedTree = lastLastInsertedTree;

        //우선순위 재배치
        BinaryTree currentTree = this.rootTree;
        do{
            //최초 실행 반드시 보장
            BinaryTree higherPriorityChildTree = this.getHigerPriorityChildTree(currentTree.getLeftSubTree(), currentTree.getRightSubTree());
            if(higherPriorityChildTree == null)
                break;
            else{
                if(!this.isPriorityBiggerXToY(currentTree.getData(), higherPriorityChildTree.getData())){
                    int tempCurrentData = currentTree.getData();
                    currentTree.setData(higherPriorityChildTree.getData());
                    higherPriorityChildTree.setData(tempCurrentData);
                    currentTree = higherPriorityChildTree;
                }else{
                    break;
                }
            }
        }while(
                currentTree.getLeftSubTree() != null || currentTree.getRightSubTree() != null
        );

        return deletingTree;
    }

    public BinaryTree getHigerPriorityChildTree(BinaryTree leftChildTree, BinaryTree rightChildTree){
        if(leftChildTree == null){
            return rightChildTree;
        }else if(rightChildTree == null){
            return leftChildTree;
        }else {
            if(this.isPriorityBiggerXToY(leftChildTree.getData(), rightChildTree.getData()))
                return leftChildTree;
            else
                return rightChildTree;
        }
    }

    public BinaryTree getLastLastInsertedTree(){
        BinaryTree lastLastInsertedTree = null;

        if(this.lastInsertedTree == this.lastInsertedTree.getParentTree().getLeftSubTree()){
            BinaryTree currentTree = this.lastInsertedTree;
            BinaryTree firstlyLeftLocatedSiblingTree = null;

            while(currentTree.getParentTree().getLeftSubTree() != null){
                currentTree = currentTree.getParentTree();
                firstlyLeftLocatedSiblingTree = this.getLeftSiblingTree(currentTree);
                if(firstlyLeftLocatedSiblingTree != null){
                    break;
                }
            }

            if(firstlyLeftLocatedSiblingTree != null){
                while(firstlyLeftLocatedSiblingTree.getRightSubTree() != null){
                    firstlyLeftLocatedSiblingTree = firstlyLeftLocatedSiblingTree.getRightSubTree();
                }
                lastLastInsertedTree = firstlyLeftLocatedSiblingTree;
            }else{
                currentTree = this.rootTree;
                while(currentTree.getRightSubTree() != null){
                    currentTree = currentTree.getRightSubTree();
                }
                lastLastInsertedTree = currentTree;
            }
        }else{
            lastLastInsertedTree = this.lastInsertedTree.getParentTree().getLeftSubTree();
        }

        return lastLastInsertedTree;
    }
}
