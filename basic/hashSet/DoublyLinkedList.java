package basic.hashSet;

public class DoublyLinkedList {
    // 시작노드
    private Node head;
    // 끝노드
    private Node tail;
    // 노드 수
    private int count;

    public DoublyLinkedList(Node head, Node tail){
        this.head = head;
        this.tail = tail;
        this.count = 0;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {}

    public int getCount() {
        return count;
    }

    public void setCount(Long count) {}

    //1
    public void insertAt(int index, HashData data){
        //Exception
        if(index > this.count || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        //생성할 노드(양방향 모두 일단 null로 초기화)
        Node newNode = new Node(data,null, null);

        if(index == 0){
            //가장 앞부분
            newNode.setNextNode(this.head);
            //this head가 null인 경우는 최초 삽입의 상황일때
            if(this.head != null) {
                this.head.setPrevNode(newNode);
            }
            this.head = newNode;
        }else if(index == this.getCount()){
            newNode.setNextNode(null);
            newNode.setPrevNode(this.tail);
            this.tail.setNextNode(newNode);
        }else {
            //이외
            //head -> currentNode
            Node currentNode = this.head;
            for(int i = 0; i < index - 1; i++){ //삽입할 인덱스 전까지
                // 0 -> current = 다음
                // index - 2 -> current = index - 1자리(삽입하기 위한 옆 자리)
                // 그 옆자리와 current 사이에 지금의 노드 위치해야 한다.
                currentNode = currentNode.getNextNode();
            }

            newNode.setNextNode(currentNode.getNextNode());
            newNode.setPrevNode(currentNode);
            currentNode.setNextNode(newNode);
            currentNode.getNextNode().setPrevNode(newNode);
        }

        //공통처리 : 삽입노드가 마지막 인덱스일 경우 tail 재설정
        if(this.tail.getNextNode() == null)
            this.tail = newNode;

        this.count++;
    }

    //2
    public void printAll(){
        Node currentNode = this.head;

        while(currentNode != null){
            System.out.println(currentNode.getData());
            currentNode = currentNode.getNextNode();
        }
    }

    //3
    public void clear(){
        this.head = null;
        this.count = 0;
    }

    //4
    public void insertLast(HashData data){
        this.insertAt(this.getCount(), data);
    }

    //5
    public void deleteAt(int index){
        if(index > this.count || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node currentNode = this.head;

        if(index == 0){
            Node deleteNode = this.head;

            if(this.head.getNextNode() == null){
                //데이터가 1개
                this.head = null;
                this.tail = null;
            }else{
                //데이터가 여러개
                this.head = this.head.getNextNode();
                this.head.setNextNode(null);
            }
            this.count--;
        }else if(index == this.getCount()){
            Node deleteNode = this.tail;
            this.tail.getPrevNode().setNextNode(null);
            this.tail = this.tail.getPrevNode();
            this.count --;
        }else{
            for(int i = 0; i < index -1 ; i++){
                //헷갈린다면 변수설정도 하나의 방법
                currentNode = currentNode.getNextNode();
            }
            Node deleteNode = currentNode.getNextNode();
            currentNode.setNextNode(currentNode.getNextNode().getNextNode()); //이미 설정!
            currentNode.getNextNode().setPrevNode(currentNode);
            this.count--;
        }
    }

    //6
    public void deleteLast(){
        this.deleteAt(this.getCount() - 1);
    }

    //7
    public Node getNodeAt(Long index){
        if(index > this.count || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node currentNode = this.head;

        for(int i = 0 ; i < index ; i ++){
            currentNode = currentNode.getNextNode();
        }

        return currentNode;
    }

    //8
    public Node getTail(){
        return this.tail;
    }

}
