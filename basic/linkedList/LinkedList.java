package basic.linkedList;

public class LinkedList {
    // 시작노드
    private Node head;
    // 노드 수
    private Long count;

    public LinkedList(Node head){
        this.head = head;
        this.count = 0L;
    }

    public Node getHead() {
        return head;
    }

    public void setHead(Node head) {}

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {}

    //1
    public void insertAt(Long index, String data){
        //Exception
        if(index > this.count || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        //생성할 노드
        Node newNode = new Node(data,null);

        if(index == 0){
            //가장 앞부분
            newNode.setNextNode(this.head);
            this.head = newNode;
        }else{
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
            currentNode.setNextNode(newNode);
        }

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
        this.count = 0L;
    }

    //4
    public void insertLast(String data){
        this.insertAt(this.getCount(), data);
    }

    //5
    public void deleteAt(Long index){
        if(index > this.count || index < 0){
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node currentNode = this.head;

        if(index == 0){
            Node deleteNode = this.head;
            this.head = deleteNode;
            this.count--;
        }else{
            for(int i = 0; i < index -1 ; i++){
                currentNode = currentNode.getNextNode();
                currentNode.setNextNode(currentNode.getNextNode().getNextNode());
                this.count--;
            }
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
}
